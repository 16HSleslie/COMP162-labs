import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class FractalPanel extends JPanel {

    // Screen size constants. ADJUST FOR YOUR MACHINE AS NEEDED
    public static int screenWidth = 1500;
    public static int screenHeight = 1000;
    public static int startRadius = 400;

    // This method controls the drawing of the screen
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        // COMMENT OUT ONE OF THESE TO CHOOSE THE DISPLAY
        // ADJUST ARGUMENT VALUES TO EXPLORE

        //circles(5, screenWidth/2, screenHeight/2, startRadius, g);
        //carpet(3, 0, 0, 300, g);
        //fixedTree(6, screenWidth/2, screenHeight - 50, -90, 250, g); 
        //tree(6, screenWidth/2, screenHeight - 50, -90, 250, g); 
        forest(5, g);    
    }

    // The main method sets up the graphic surface for drawing.
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("Fractals");
        frame.setSize(screenWidth, screenHeight);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Container contentPane = frame.getContentPane();
        contentPane.add(new FractalPanel());

        frame.setVisible(true);
    } // end main


    //===================================================================================
    // Fractal Routines
    //===================================================================================


    // Carpet. The base pattern is eight squares arranged in a donut. Recurse by replacing
    // each square with the complete pattern.
    public static void carpet(int depth, int xOrigin, int yOrigin, int side, Graphics g) {

        int x;
        int y;
        int rowStep;
        int colStep;

        // Cast to Graphics 2D so that we can control the stroke (the border) thickness
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));

        // The 8 squares can be managed like traversing a 2D array with three rows and three columns.
        // We will move across the columns and down the rows, drawing a square at each location
        // *except* the center one (i.e. row and col both equal to 1).
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                // Figure out where the upper left corner of the square should be
                rowStep = row * side;
                colStep = col * side;
                x = xOrigin + rowStep;
                y = yOrigin + colStep;

                // Here we skip the center square....
                if (col != 1 || row != 1) {
                    // Base case - just draw the square
                    if (depth == 1) {
                        g2d.setColor(Color.decode("#bacaba"));
                        g2d.fillRect(x, y, side, side);

                        g2d.setColor(Color.decode("#ff0000"));
                        g2d.drawRect(x, y, side, side);
                    } // end base case
                    else {
                        // ADD YOUR CODE HERE
                        // MAKE A RECURSIVE CALL AT THIS X,Y LOCATION.
                        // REMEMBER TO REDUCE THE DEPTH PARAMETER AND THE SIZE OF THE SQUARE (PARAMETER side)

                        //---------------------------------------------------------------------//
                        
                        carpet(depth - 1, x, y, side / 3, g);
                    }

                } // if not center square
            } // for rows
        } // for cols

    } // end carpet

    public static void circles(int depth, int xCenter, int yCenter, int radius, Graphics g) {

        int x = xCenter - radius;
        int y = yCenter - radius;

        // Base case -- draw a circle
        g.setColor(Color.decode("#ff0000"));
        g.drawOval(x, y, radius * 2, radius * 2);

        if (depth > 1) {
            // ADD YOUR CODE HERE
            // MAKE FOUR RECURSIVE CALLS AT THIS LOCATION, ONE AT EACH OF THE FOUR NEW POSITIONS
            // REMEMBER TO REDUCE THE DEPTH PARAMETER AND THE SIZE OF THE CIRCLE (PARAMETER radius)
            circles(depth - 1, x + radius, y + (radius / 2), radius / 2, g); // top
            circles(depth - 1, x + (radius / 2), y + radius, radius / 2, g); // left
            circles(depth - 1, x + radius, yCenter + (radius / 2), radius / 2, g); // bottom
            circles(depth - 1, xCenter + (radius / 2), y + radius, radius / 2, g); // right
            
        }

    } // end circles

    public static void fixedTree(int depth, int xBase, int yBase, int branchAngle, int branchLength, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(4));

        // Always draw "trunk"                             	
        double radians = branchAngle * 0.01745;
        int xTop = (int)(xBase + (Math.cos(radians) * branchLength));
        int yTop = (int)(yBase + (Math.sin(radians) * branchLength));
        g2d.drawLine(xBase, yBase, xTop, yTop);

        // if depth = 0, you're done, so drop out. Empty base case
        // If not, recurse left and right
        int newAngle;
        if (depth > 0) {
            int newBranchLength = (int)(branchLength * .7);

            // Recurse to left at 45 degrees
            newAngle = branchAngle - 45;
            fixedTree(depth - 1, xTop, yTop, newAngle, newBranchLength, g);

            // Recurse to right at 45 degrees
            newAngle = branchAngle + 45;
            fixedTree(depth - 1, xTop, yTop, newAngle, newBranchLength, g);
        } // if recursing
    } // end fixedTree

    public static void tree(int depth, int xBase, int yBase, int branchAngle, int branchLength, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(4));


        // Make leaves green
        if (depth == 0) {
            g2d.setColor(Color.decode("#228B22"));
        } else {
            g2d.setColor(Color.decode("#000000"));
        }

        double radians = branchAngle * 0.01745;
        int xTop = (int)(xBase + (Math.cos(radians) * branchLength));
        int yTop = (int)(yBase + (Math.sin(radians) * branchLength));
        g2d.drawLine(xBase, yBase, xTop, yTop);

        int newAngle;
        int newBranchLength;
        double branchFactor;
        int nBranches;

        // if depth = 0, you're done. Empty base case
        // If not, recurse left and right
        if (depth > 0) {
            
            Random random = new Random();
            
            newAngle = branchAngle - (30 + random.nextInt(55 - 30 + 1));

            // Left branches

            // ADD YOUR CODE HERE
            // USE A RANDOM NUMBER GENERATOR TO SELECT THE NUMBER
            // OF BRANCHES AND THE REDUCTION FACTOR FOR BRANCH LENGTH
            // USE A FOR LOOP TO CONTROL THE NUMBER OF RECURSIVE BRANCHES YOU
            // DRAW.
            // RECURSE PASSING IN YOUR PARAMETER VALUES AND REDUCING 
            // THE DEPTH ARGUMENT
            
            nBranches = (1 + random.nextInt(5));
            branchFactor = (0.5 + random.nextDouble(0.75 - 0.5));
            
            newBranchLength = (int)(branchLength * branchFactor);
            
            for (int i = 0; i < nBranches; i++) {
                tree(depth - 1, xTop, yTop, newAngle, newBranchLength, g);
            }

            newAngle = branchAngle + (30 + random.nextInt(55 - 30 + 1));

            // Right branches

            // ADD YOUR CODE HERE
            // USE A RANDOM NUMBER GENERATOR TO SELECT THE NUMBER
            // OF BRANCHES AND THE REDUCTION FACTOR FOR BRANCH LENGTH
            // USE A FOR LOOP TO CONTROL THE NUMBER OF RECURSIVE BRANCHES YOU
            // DRAW.
            // RECURSE PASSING IN YOUR PARAMETER VALUES AND REDUCING 
            // THE DEPTH ARGUMENT
            nBranches = (1 + random.nextInt(5));
            branchFactor = (0.5 + random.nextDouble(0.75 - 0.5));
            
            newBranchLength = (int)(branchLength * branchFactor);
            
            for (int i = 0; i < nBranches; i++) {
                tree(depth - 1, xTop, yTop, newAngle, newBranchLength, g);
            }
        } // if recursing

    } // end tree

    public static void forest(int maxTrees, Graphics g) {
        // ADD YOUR CODE HERE

        // USE A RANDOM NUMBER GENERATOR TO SELECT THE NUMBER OF TREE
        // TO DRAW. USE A FOR LOOP TO DRAW THEM. SPREAD THE TREES
        // RANDOMLY ACROSS THE SCREEN AND CHOOSE THEIR STARTING PARAMETER VALUES
        // RANDOMLY AS WELL (WITHIN SENSIBLE LIMITS) TO GET THE MOST REALISTIC
        // FOREST
        
        Random random = new Random();
            
        //int nTrees = 5 + random.nextInt(15 - 5 + 1);
        int yBase = screenHeight - 50;
        int branchAngle = -90;
        
        for (int i = 0; i < maxTrees; i++) {
            boolean leftOrRight = random.nextBoolean();
            int xOffset = 50 + random.nextInt(500 - 50 + 1);
            int xBase = (leftOrRight) ? (screenWidth/2) - xOffset : (screenWidth/2) + xOffset;
            int branchLength = 100 + random.nextInt(250 - 100 + 1);
            tree(6, xBase, yBase, branchAngle, branchLength, g);
        }
    }


}