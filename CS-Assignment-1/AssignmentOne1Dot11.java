public class AssignmentOne1Dot11 {
    public static void main(String[] args) {
    	// This program calculates the predicted population of the U.S. after 1, 2, 3, 4, and 5 years respectivly by taking an inital population
    	// of 312,032,486 and accounting for the fact that a baby is born every 7 seconds, and immigrants moves into the U.S. every 45 seconds
    	// and someone dies every 13 seconds.
	    int yearOne = ( 312032486 + ( ( int ) ( 31536000.0 / 7 ) + ( int ) ( 31536000.0 / 45 ) - ( int ) ( 31536000.0 / 13 ) ) );
	    int yearTwo = ( 312032486 + ( 2 * ( int ) ( 31536000.0 / 7 ) + 2 * ( int ) ( 31536000.0 / 45 ) - 2 * ( int ) ( 31536000.0 / 13 ) ) );
        int yearThree = ( 312032486 + ( 3 * ( int ) ( 31536000.0 / 7 ) + 3 * ( int ) ( 31536000.0 / 45 ) - 3 * ( int ) ( 31536000.0 / 13 ) ) );
	    int yearFour = ( 312032486 + ( 4 * ( int ) ( 31536000.0 / 7 ) + 4 * ( int ) ( 31536000.0 / 45 ) - 4 * ( int ) ( 31536000.0 / 13 ) ) );
	    int yearFive = ( 312032486 + ( 5 * ( int ) ( 31536000.0 / 7 ) + 5 * ( int ) ( 31536000.0 / 45 ) - 5 * ( int ) ( 31536000.0 / 13 ) ) );
	    System.out.println("The Predicted Population of the U.S. after 1, 2, 3, 4, and 5 years respectivly is " + yearOne + ", " + yearTwo + ", " + yearThree + ", " + yearFour + ", and " + yearFive);
    }
} 

