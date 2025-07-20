let button = document.getElementById("record");

let isRecording = false;

let canvas = document.querySelector(".visualizer");
let canvasContext = canvas.getContext("2d");
let WIDTH;
let HEIGHT;

let analyser;

let smoothingThreshold = 10;
let smoothingCountThreshold = 5;

let decibalMin = -100;
let decibalMax = -10;
let rmsThreshold = 0.1;
let voice_band_freqs = [0, 95, 110, 120, 150];
let voice_band_labels = [
  "Your voice is very deep, certified chad",
  "Your voice is deep, certified chad",
  "mid",
  "You're a certified voicecel",
  "I'm so sorry...",
];

let sampled_freqs = [];

var source;
var audioContext = new (window.AudioContext || window.webkitAudioContext)();

var show_median = () => {
  var noSignal = false;
  var median;
  isRecording = false;
  audioContext.suspend();
  sampled_freqs.sort();
  sampled_freqs = sampled_freqs.filter((elem) => elem <= 300 && elem >= 30);
  if (sampled_freqs.length == 0) {
    median = NaN;
  } else {
    if (sampled_freqs.length % 2 == 0)
      median =
        (sampled_freqs[sampled_freqs.length / 2] +
          sampled_freqs[sampled_freqs.length / 2 + 1]) /
        2;
    else median = sampled_freqs[(sampled_freqs.length + 1) / 2];
  }
  document.getElementById("record").innerText = "Repeat Test";
  if (isNaN(median)) {
    document.getElementById("readout").innerText =
      "Not enough signal - try again or switch to a microphone of higher fidelity";
  } else {
    document.getElementById("readout").innerText = "";
    document
      .querySelector(".certificate")
      .setAttribute("style", "display: flex;");
    document.querySelector(".score").innerText = Math.round(median) + " Hz";
    var label;
    for (i = 0; i < voice_band_freqs.length; i++)
      if (median > voice_band_freqs[i]) {
        label = voice_band_labels[i];
      }
    document.querySelector(".clarification").innerText = label;
  }
};

button.addEventListener("mousedown", () => {
  init();
  setTimeout(show_median, 10000);
});

function init() {
  isRecording = true;
  sampled_freqs = [];
  document.getElementById("record").innerText = "Speak...";
  document.getElementById("readout").innerText =
    "Waiting for high-quality data...";
  document
    .querySelector(".certificate")
    .setAttribute("style", "display: none;");

  audioContext.resume();
  analyser = audioContext.createAnalyser();
  analyser.minDecibels = decibalMin;
  analyser.maxDecibels = decibalMax;
  analyser.smoothingTimeConstant = 0.85;
  if (!navigator?.mediaDevices?.getUserMedia) {
    // No audio allowed
    alert("Sorry, getUserMedia is required for the app.");
    return;
  } else {
    var constraints = { audio: true };
    navigator.mediaDevices
      .getUserMedia(constraints)
      .then(function (stream) {
        // Initialize the SourceNode
        source = audioContext.createMediaStreamSource(stream);
        console.log("source initialized");
        // Connect the source node to the analyzer
        source.connect(analyser);
        console.log("analyzer connected");
        visualize();
      })
      .catch(function (err) {
        alert("Sorry, microphone permissions are required for the app.");
      });
  }
}

//spaghetti inherited from Ellis, needs to be cleaned up

function visualize() {
  WIDTH = canvas.width;
  HEIGHT = canvas.height;

  var drawVisual;
  var drawNoteVisual;

  var previousValueToDisplay = 0;
  var smoothingCount = 0;

  var drawNote = function () {
    drawNoteVisual = requestAnimationFrame(drawNote);
    var bufferLength = analyser.fftSize;
    var buffer = new Float32Array(bufferLength);
    analyser.getFloatTimeDomainData(buffer);
    var autoCorrelateValue = autoCorrelate(buffer, audioContext.sampleRate);

    var valueToDisplay = Math.round(autoCorrelateValue);

    if (isRecording) {
      if (autoCorrelateValue === -1) {
        //document.getElementById('readout').innerText = 'Too quiet...';
        console.log("Not enough signal...");
        return;
      }

      sampled_freqs.push(autoCorrelateValue);
    }

    function noteIsSimilarEnough() {
      // Check threshold for number, or just difference for notes.
      if (typeof valueToDisplay == "number") {
        return (
          Math.abs(valueToDisplay - previousValueToDisplay) < smoothingThreshold
        );
      } else {
        return valueToDisplay === previousValueToDisplay;
      }
    }
    // Check if this value has been within the given range for n iterations
    if (noteIsSimilarEnough()) {
      if (smoothingCount < smoothingCountThreshold) {
        smoothingCount++;
        return;
      } else {
        previousValueToDisplay = valueToDisplay;
        smoothingCount = 0;
      }
    } else {
      previousValueToDisplay = valueToDisplay;
      smoothingCount = 0;
      return;
    }
    if (typeof valueToDisplay == "number") {
      valueToDisplay += " Hz";
    }
    if (isRecording)
      document.getElementById("readout").innerText = valueToDisplay;
  };

  var drawFrequency = function () {
    var bufferLengthAlt = analyser.frequencyBinCount;
    var dataArrayAlt = new Uint8Array(bufferLengthAlt);

    canvasContext.clearRect(0, 0, WIDTH, HEIGHT);

    var drawAlt = function () {
      drawVisual = requestAnimationFrame(drawAlt);

      analyser.getByteFrequencyData(dataArrayAlt);

      canvasContext.fillStyle = "rgb(0, 0, 0)";
      canvasContext.fillRect(0, 0, WIDTH, HEIGHT);

      var barWidth = (WIDTH / bufferLengthAlt) * 2.5;
      var barHeight;
      var x = 0;

      for (var i = 0; i < bufferLengthAlt; i++) {
        barHeight = dataArrayAlt[i];

        canvasContext.fillStyle = "rgb(" + (barHeight + 100) + ",50,50)";
        canvasContext.fillRect(
          x,
          HEIGHT - barHeight / 2,
          barWidth,
          barHeight / 2
        );

        x += barWidth + 1;
      }
    };

    drawAlt();
  };

  drawFrequency();
  drawNote();
}

// Must be called on analyser.getFloatTimeDomainData and audioContext.sampleRate
// From https://github.com/cwilso/PitchDetect/pull/23
function autoCorrelate(buffer, sampleRate) {
  // Perform a quick root-mean-square to see if we have enough signal
  var SIZE = buffer.length;
  var sumOfSquares = 0;
  for (var i = 0; i < SIZE; i++) {
    var val = buffer[i];
    sumOfSquares += val * val;
  }
  var rootMeanSquare = Math.sqrt(sumOfSquares / SIZE);
  if (rootMeanSquare < rmsThreshold) {
    return -1;
  }

  // Find a range in the buffer where the values are below a given threshold.
  var r1 = 0;
  var r2 = SIZE - 1;
  var threshold = 0.2;

  // Walk up for r1
  for (var i = 0; i < SIZE / 2; i++) {
    if (Math.abs(buffer[i]) < threshold) {
      r1 = i;
      break;
    }
  }

  // Walk down for r2
  for (var i = 1; i < SIZE / 2; i++) {
    if (Math.abs(buffer[SIZE - i]) < threshold) {
      r2 = SIZE - i;
      break;
    }
  }

  // Trim the buffer to these ranges and update SIZE.
  buffer = buffer.slice(r1, r2);
  SIZE = buffer.length;

  // Create a new array of the sums of offsets to do the autocorrelation
  var c = new Array(SIZE).fill(0);
  // For each potential offset, calculate the sum of each buffer value times its offset value
  for (let i = 0; i < SIZE; i++) {
    for (let j = 0; j < SIZE - i; j++) {
      c[i] = c[i] + buffer[j] * buffer[j + i];
    }
  }

  // Find the last index where that value is greater than the next one (the dip)
  var d = 0;
  while (c[d] > c[d + 1]) {
    d++;
  }

  // Iterate from that index through the end and find the maximum sum
  var maxValue = -1;
  var maxIndex = -1;
  for (var i = d; i < SIZE; i++) {
    if (c[i] > maxValue) {
      maxValue = c[i];
      maxIndex = i;
    }
  }

  var T0 = maxIndex;

  // Not as sure about this part, don't @ me
  // From the original author:
  // interpolation is parabolic interpolation. It helps with precision. We suppose that a parabola pass through the
  // three points that comprise the peak. 'a' and 'b' are the unknowns from the linear equation system and b/(2a) is
  // the "error" in the abscissa. Well x1,x2,x3 should be y1,y2,y3 because they are the ordinates.
  var x1 = c[T0 - 1];
  var x2 = c[T0];
  var x3 = c[T0 + 1];

  var a = (x1 + x3 - 2 * x2) / 2;
  var b = (x3 - x1) / 2;
  if (a) {
    T0 = T0 - b / (2 * a);
  }

  return sampleRate / T0;
}
