// Imports the Color class which allows for color changes of the fractal tree.
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * The program when run uses Java's graphics library to generate a fractal tree image. This image is
 * shown on a new window that pop's up and is displayed in green on a black background. The image is
 * a fractal tree which is a pattern that repeats itself over and over and infinite amount of times as
 * it gets smaller and smaller with each repetition. The tree generated is made up of this pattern.
 * @author Foo Barstein with comments by Emir Hamzaogullari (eth271)
 *
 */
// FractalTree extends JPanel which is a container class. It provides a space for which the application
// can attach any other component. The container is the window which opens to display the fractal tree.
public class FractalTree extends JPanel {
    /**
     * Graphics2D is a class which extends Graphics to provide sophisticated control over geometry,
     * coordinate transformations, color management and text layout. It allows the user to take full control
     * of the graphics library offered by Java to work with in their projects.
     */
	public Graphics2D g1;
	/**
	 * maxAngle is a class variable which is a constant and is used through all instances which sets the
	 * highest degree that the tree can branch out from.
	 */
    public static final int maxAngle = 360;
    /**
	 * startX is a class variable which is a constant and is used to declare the x coordinate where the
	 * tree start and will branch off from.
	 */
    public static final int startX = 600;
    /**
	 * startY is a class variable which is a constant and is used to declare the Y coordinate where the
	 * tree start and will branch off from.
	 */
    public static final int startY = 800;
    /**
	 * numOfRecusions is a class variable which is a constant and is used to declare the amount of times the
	 * program will recursively loop to create each new branch of the tree.
	 */
    public static final int numOfRecursions = 9;
    /**
	 * startAngle is a class variable which is a constant and is used to declare the angle that the trunk
	 * of the tree will be facing and branch off of from.
	 */
    public static final int startAngle = 0;
    /**
	 * treeSize is a class variable which is a constant and is used to declare the multiplier of the length
	 * of the tree.
	 */
    public static final double treeSize = 2;
    /**
	 * Detail is a class variable which is a constant and is used to declare the amount of leaves each branch
	 * will have, making the detail be how detailed the tree is with 1 being the most.
	 */
    public static final int Detail = 3;
    /**
	 * randFact is a class variable which is a constant and is used to declare how much randomness will
	 * the branches of the tree have.
	 */
    public static final int randFact = 30;
    /**
	 * constFact is a class variable which is a constant and is used to declare the the angles of the four
	 * generated branches of the tree.
	 */
    public static final int[] constFact = {-60, 05, -50, 45};
     
    /**
	 * red is a class variable and is used to declare the possible red values for the color class for a
	 * branch of the tree.
	 */
    public static int[] red =   {0, 0, 0, 0, 7, 15, 23, 31, 39, 47, 55, 43};
    /**
	 * green is a class variable and is used to declare the possible green values for the color class for a
	 * branch of the tree.
	 */
    public static int[] green = {171, 159, 147, 135, 123, 111, 99, 87, 75, 63, 51, 43};
    /**
	 * blue is a class variable and is used to declare the possible blue values for the color class for a
	 * branch of the tree.
	 */
    public static int[] blue =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};   
     
    /**
	 * degToRad is a class method and is used to return the inputed angle in degrees into radiant.
	 * @return deg an integer of the angle in radians.
	 * @param deg an integer of the angle in degrees.
	 */
    public static double degToRad(int deg) {
        return deg * Math.PI / 180;
    }
     
    /**
	 * drawFractal is a class method and is used to draw the fractal tree using the properties provided.
	 * @return nothing as it's a void function
	 * @param g1, a Graphics2D object which sets the color and draws the shape based on the class and instance
	 * properties. x, the x coordinate where the drawing starts from. y, the y coordinate the drawing starts
	 * from. n is the tree size initially and it decreases to accommodate the size of each branch. angle is the
	 * angle of the branch/trunk.
	 */
    public static void drawFractal(Graphics2D g1, int x, int y, int n, int angle) {
        // Statement to break out of recursive loop that occurs when the variable n is equal to detail
    	if (n == Detail) return;
   
    	/**
         * len is an instance variable and is used to declare the length of the tree based on treeSize to the
         * power of n-1 and then rounded to be an integer.
         */
    	// n is being decremented by 1 to decrease the length of the branches with each loop.
    	int len = (int) Math.round(Math.pow(treeSize, n - 1));
        
    	/**
         * xn1 is an instance variable and is used to declare the x-coordinate of the end point of the line
         * being drawn.
         */
        int xn1 = (int) Math.round(x - (2 * len * Math.sin(degToRad(angle))));
        /**
         * yn1 is an instance variable and is used to declare the y-coordinate of the end point of the line
         * being drawn.
         */
        int yn1 = (int) Math.round(y - (2 * len * Math.cos(degToRad(angle))));
        /**
         * mid1x is an instance variable and is used to declare the x-coordinate of the start point of the line
         * being drawn for the first branch.
         */
        int mid1x = (x + xn1) / 2;
        /**
         * mid1y is an instance variable and is used to declare the y-coordinate of the start point of the line
         * being drawn for the first branch.
         */
        int mid1y = (y + yn1) / 2;
        /**
         * mid2x is an instance variable and is used to declare the x-coordinate of the start point of the line
         * being drawn for the second branch.
         */
        int mid2x = (mid1x + xn1) / 2;
        /**
         * mid2y is an instance variable and is used to declare the y-coordinate of the start point of the line
         * being drawn for the second branch.
         */
        int mid2y = (mid1y + yn1) / 2;
        /**
         * mid3x is an instance variable and is used to declare the x-coordinate of the start point of the line
         * being drawn for the third branch.
         */
        int mid3x = (x + mid1x) / 2;
        /**
         * mid3y is an instance variable and is used to declare the y-coordinate of the start point of the line
         * being drawn for the third branch.
         */
        int mid3y = (y + mid1y) / 2;
        /**
         * mid4x is an instance variable and is used to declare the x-coordinate of the start point of the line
         * being drawn for the fourth branch.
         */
        int mid4x = (mid3x + mid1x) / 2;
        /**
         * mid4y is an instance variable and is used to declare the y-coordinate of the start point of the line
         * being drawn for the fourth branch.
         */
        int mid4y = (mid3y + mid1y) / 2;
         
        // Calls the .Random class from Java.util
        java.util.Random r = new java.util.Random();
        // Causes recursion as drawFractal is being called within drawFractal in order to create the
        // first branch. n is being decremented by 1 to decrease the length of the branches with each loop.
        // nextInt from r is called to take the next int of the random number to randomize.
        drawFractal(g1, mid1x, mid1y, n - 1, (angle + r.nextInt(randFact) + constFact[0]) % maxAngle);
        // Causes recursion as drawFractal is being called within drawFractal in order to create the
        // second branch. n is being decremented by 1 to decrease the length of the branches with each loop.
        // nextInt from r is called to take the next int of the random number to randomize.
        drawFractal(g1, mid2x, mid2y, n - 1, (angle + r.nextInt(randFact) + constFact[1]) % maxAngle);
        // Causes recursion as drawFractal is being called within drawFractal in order to create the
        // third branch. n is being decremented by 1 to decrease the length of the branches with each loop.
        // nextInt from r is called to take the next int of the random number to randomize.
        drawFractal(g1, mid3x, mid3y, n - 1, (angle + r.nextInt(randFact) + constFact[2]) % maxAngle);
        // Causes recursion as drawFractal is being called within drawFractal in order to create the
        // fourth branch. n is being decremented by 1 to decrease the length of the branches with each loop.
        // nextInt from r is called to take the next int of the random number to randomize.
        drawFractal(g1, mid4x, mid4y, n - 1, (angle + r.nextInt(randFact) + constFact[3]) % maxAngle);
         
        // Calls the Color class and creates new color object using random picker and the int arrays for red
        // blue and green values. nextInt from r is called to take the next int of the random number to randomize.
        Color c = new Color(red[(r.nextInt() % 3) + n], green[(r.nextInt() % 3) + n], blue[(r.nextInt() % 3) + n]);
        // Calls setColor method in order to set color of drawn tree.
        g1.setColor(c);
        // Creates a Line2D object to be drawn using the x, y, xn1, yn1 coordinates from earlier. This line object
        // is what makes up the drawn fractal tree.
        Line2D L1 = new Line2D.Double(x, y, xn1, yn1);
        // Calls draw to draw the created line object.
        g1.draw(L1);
        // returns out of method, helpful to escape method once end flag of recursion is hit.
        return;
    }
     
    /**
   	 * paint is a class method and is used to draw the fractal tree using the drawFractal method and Graphics2D
   	 * class.
   	 * @return nothing as it's a void function
   	 * @param g a Graphics object which is final to be drawn once the entire tree can be drawn.
   	 */
    public void paint(final Graphics g) {
    	// g1 is set to the Graphics object g which was been casted to a Graphics2D object.
        g1 = (Graphics2D) g;
        // Calls drawFractal method which uses the class variables in order to draw the initial line of the 
        // fractal tree and start the recurssion.
        drawFractal(g1, startX, startY, numOfRecursions, startAngle);
    }
    
    /**
     * The main method which creates and calls the Fractal tree class.
     * @author Foo Barstein with comments by Emir Hamzaogullari (eth271)
     *
     */
    public static void main(String args[]) {
    	// Creates JFrame object to be able to render Graphics2D object created in FractalTree class.
    	// Sends the message that it is drawing a recursive tree.
        JFrame FF = new JFrame("Drawing a recursive tree");
        // Calls the setDefaultCloseOperation method which closes the JFrame once the fractal tree is done
        // drawing.
        FF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Creates FractalTree object named F
        FractalTree F = new FractalTree();
        FF.setBackground(Color.BLACK);
        // Calls setBackground method which sets the color of the background to black for which the fractal
        // tree will be displayed.
        FF.add(F);
        // Calls the add method which adds the FractalTree object to be drawn.
        FF.pack();
        // Calls pack which sets all the content to be displayed relative to the created window and the
        // preferred sizes.
        FF.setVisible(true);
        // Calls setVisible which displays the drawing.
        FF.setSize(1200, 1000);
        // Calls the setSize function which resizes the window to the selected size in pixels.
    }
}