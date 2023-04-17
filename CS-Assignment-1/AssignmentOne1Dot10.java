public class AssignmentOne1Dot10 {
    public static void main(String[] args) {
    	// This program takes the speed of a runner, which is 14 kilometers in 45 minutes and 30 seconds, and converts it into miles per hour.
	    double kilometersPerMinutes = ( 14.0 / ( 45.0 + ( 30.0 / 60.0 ) ) );
	    double milesPerHour = ( kilometersPerMinutes * ( 60.0 / 1.6 ) ) ;
	    System.out.println("The Average Speed of the Runner is " + milesPerHour + " in Miles per Hour.");
    }
} 
