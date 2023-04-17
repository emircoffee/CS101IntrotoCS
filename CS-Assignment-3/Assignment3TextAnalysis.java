import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

// This program takes an input from the user in the form of a string containing the name of the file the user wants to open and a string
// containing what tick's the user wants to analyze in the file. The output will be the total number of ticks, the density of ticks per
// words in the file, the number of each tick, and the percentage they make up.
public class Assignment3TextAnalysis{
	public static void main(String[] args) throws FileNotFoundException {
		// Creates scanner to read user inputed filename and ticklist
		System.out.println("");
		Scanner tickReader = new Scanner(System.in);

		// Creates string for user inputed filename
		System.out.print("What file would you like to open?");
		String fileName = tickReader.nextLine();

		// Creates scanners for the methods that use the user inputed filename
		Scanner txtFile = new Scanner(new File(fileName));
		Scanner wordRead = new Scanner(new File(fileName));

		// Sets array if strings to user inputed tick list.
		System.out.print("What words would you like to search for?");
		String tickInput = tickReader.nextLine().toLowerCase();
		String[] tickList = tickArray(tickInput);

		// Prints the analysis for the total number of ticks and the density of ticks
		System.out.println("");
		System.out.println("...............................Analyzing text.................................");
		System.out.println("");
		int tickCount = tickCounter(txtFile, tickList);
		int wordCount = wordCounter(wordRead);
		DecimalFormat density = new DecimalFormat("0.00");
		System.out.println("Total number of tics: " + tickCount);
		System.out.println("Density of tics: " + (density.format(((double)tickCount/wordCount))));

		// Starts the printing for the breakdown of each tick that the user inputed
		System.out.println("");
		System.out.println("...............................Tic breakdown..................................");
		System.out.println("");

		// Prints each tick and how many occurences the ticks have and how much percentage of total ticks they make up.
		printEachTick(tickList, tickCount, fileName);
	}

	// A string array method that takes the string of ticks from the user and turns it into an array of the ticks. It uses a for
	// loop with if statements to differentiate between single words and ticks with spaces within them
	public static String[] tickArray(String input){
		String[] stringArray = input.split(",");

		for(int i = 0; i < stringArray.length; i++){

			if (stringArray[i].indexOf(" ") == 0){
				stringArray[i] = stringArray[i].substring(1);
				if(stringArray[i].lastIndexOf(" ") == stringArray[i].length() - 1){

					stringArray[i] = stringArray[i].substring(0, stringArray[i].length() - 1);
				}
			}
		}

		return stringArray;
	}


	// A int method that calculates the total number of words in the text file using a scanner that goes through each line in the
	// text file with a while loop and counts the total number of words.
	public static int wordCounter(Scanner txtFile){
		int count = 0;

		while(txtFile.hasNextLine()){
			String tempString = txtFile.nextLine();
			String[] tempWords = tempString.split("[ ,.?\\s+]");
			count = count + tempWords.length;
		}

		return count;
	}

	// A int method that calculates the total number of ticks in the text file using a scanner that by using a while loop nested in
	// a for loop to find the count of ticks using the indexOf method
	public static int tickCounter(Scanner txtFile, String[] ticks){
		
		int count = 0;
		String tempString = "";
		
		while(txtFile.hasNextLine()){
			tempString += " " + txtFile.nextLine() + " ";
		}
			
		for (int i = 0; i < ticks.length; i++){
			int n = 0;
				
			while(n > -1) {
				n = tempString.indexOf(ticks[i], n + 1);
				if (n > -1)
					count++;
			}
		}

		return count;
	}

	// A void method that loops through each tick in the tick array and creates a new scanner to scan through the file and count the number
	// of each kind of tick specified by the user. A for each loop is used to loop through the format is printed for the user
	public static void printEachTick(String[] ticks, int tickCount, String fileName) throws FileNotFoundException{
		
		for (String tick: ticks){
			Scanner finalScanner = new Scanner(new File(fileName));
			String printLine = tick;

			while(printLine.length() <= 10){
				printLine = printLine + " ";
			}

			System.out.print(printLine + "/  ");
			double numberOfTheCurrentTick = numberOfTheCurrentTick(finalScanner, tick);
			System.out.print((int)(numberOfTheCurrentTick) + " occurrences  /  ");
			int tickPercent = (int)(numberOfTheCurrentTick/tickCount*100);
			System.out.print(tickPercent + "% of all tics");
			System.out.println("");
		}
	} 

	// A double method that returns the total number of the specified tick using a nested while loop and indexOf method
	public static double numberOfTheCurrentTick(Scanner finalScan, String tick){
		int count = 0;
		String tempString = "";

		while(finalScan.hasNextLine()){
			tempString = finalScan.nextLine();

			while(tempString.indexOf(tick) > -1){
					count++;
					tempString = tempString.substring(tempString.indexOf(tick) + 1);
			}
		}

		return count;
	}
}