public class AssignmentOne1Dot7 {
    public static void main(String[] args) {
    	// This programs uses two variations of the same formula to calculate pi. The program then prints the results.
        double resultOne = ( 4.0 * ( 1.0 - ( 1.0 / 3.0 ) + ( 1.0 / 5.0 ) - ( 1.0 / 7.0 ) + ( 1.0 / 9.0 ) - ( 1.0 / 11.0 ) ) );
		double resultTwo = ( 4.0 * ( 1.0 - ( 1.0 / 3.0 ) + ( 1.0 / 5.0 ) - ( 1.0 / 7.0 ) + ( 1.0 / 9.0 ) - ( 1.0 / 11.0 ) + ( 1.0 / 13.0 ) ) );
	    System.out.println(resultOne + " and " + resultTwo + " are two results of pi calculated by two variations of the same formula.");
    }
}
