public class Countdown {
    public static void main(String[] args) {
        countdown(3);
    }
    public static void countdown(int i) {
        if (i <= 0) {
            return; // Base case
        } else {
            if (i % 2 == 0) {
                System.out.println(i + " is an Even Number");
            } else {
                System.out.println(i + " is an Odd Number");
            }
            countdown(--i); // Recursive case -- Line 11
        }
    }
}