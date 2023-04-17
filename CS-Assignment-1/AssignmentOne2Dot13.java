import java.util.Scanner;

public class AssignmentOne2Dot13 {
    public static void main(String[] args) {
    	// This program takes the monthy savings of the user and then outputs the account value after six months with an annual intrest rate of 5%
       	Scanner userInput = new Scanner(System.in);
	    System.out.print("Please enter the monthly saving amount:");
	    double monthlySaving = userInput.nextDouble();
	    double monthOne = ( monthlySaving * (1 + ( 0.05 / 12 ) ) );
	    double monthTwo = ( ( monthlySaving + monthOne ) * (1 + ( 0.05 / 12 ) ) );
	    double monthThree = ( ( monthlySaving + monthTwo ) * (1 + ( 0.05 / 12 ) ) );
	    double monthFour = ( ( monthlySaving + monthThree ) * (1 + ( 0.05 / 12 ) ) );
	    double monthFive = ( ( monthlySaving + monthFour ) * (1 + ( 0.05 / 12 ) ) );
	    double monthSix = ( (double) ( (int) ( ( monthlySaving + monthFive ) * (1 + ( 0.05 / 12 ) ) * 100 ) ) / 100 );
	    System.out.println("After the sixth month the account value is " + monthSix);
    }
}
