import java.util.Scanner;

public class AssignmentOne2Dot9 {
    public static void main(String[] args) {
    	// This program takes the user's input of the starting velocity in meters per second, the ending velocity in
    	// meters per second, and the time span in seconds and outputs the average acceleration in meters per seconds squared.
       	Scanner userInput = new Scanner(System.in);
	    System.out.print("Please enter v0, v1 and t:");
	    double vZero = userInput.nextDouble();
	    double vOne = userInput.nextDouble();
	    double time = userInput.nextDouble();
	    double acceleration = ( ( vOne - vZero ) / time );
	    System.out.println("The average acceleration is " + acceleration);
    }
}
