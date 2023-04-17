import java.util.Scanner;

/**
 * The class has the main method which creates one moped object and allows the user to control it
 * with console commands.
 * @author Emir Hamzaogullari
 * @version 1.0.0
 */
public class TestDrive {
/**
 * The main method which creates one moped object and a scanner object to read user input and allow the user
 * to control the moped.
 * @param args String array of any arguments supplied when running the program.
 * @return void this is the main function which doesn't have a reuturn value as it's set to void
 */
	public static void main(String[] args) {
		Moped car = new Moped();
		Scanner scn = new Scanner(System.in);
		String userInput = "";
		
		while(scn.hasNextLine()) {
			userInput = scn.nextLine();
			car.setUserInput(userInput);
			car.controlCenter();
		}
	}

}
