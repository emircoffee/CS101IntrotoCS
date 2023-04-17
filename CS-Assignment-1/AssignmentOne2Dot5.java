import java.util.Scanner;

public class AssignmentOne2Dot5 {
    public static void main(String[] args) {
    	// This program takes the user's input of the subtotal of their meal, and then the percent gratuity they would like to leave.
    	// It then outputs how much the gratuity cost is and how much the total cost will be.
       	Scanner userInput = new Scanner(System.in);
	    System.out.print("Please enter the subtotal and percent of gratuity you would like to leave:");
	    double subTotal = userInput.nextDouble();
	    double gratuity = userInput.nextDouble();
	    double gratuityCost =  ( (int) ( subTotal * gratuity ) / 100.0 ) ;
	    double total = ( subTotal + gratuityCost );
	    System.out.println("The gratuity is $" + gratuityCost + " and the total is $" + total);
    }
}
