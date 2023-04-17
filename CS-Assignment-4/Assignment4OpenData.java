import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Assignment4OpenData{
	public static void main(String[] args) throws FileNotFoundException{
		System.out.println("Welcome to the New York City: Schools that have Computer Science Courses Finder Application.");
		System.out.println("This app mines data from"
		 + " https://data.cityofnewyork.us/Education/2016-2017-Computer-Science-Report/2bef-phhy");
		System.out.println("We show the the names of schools that offer the specifed amount of Comptuer Science courses, "
			+ "\nalong with a breakdown of the courses being full CS courses, partial CS courses, or AP CS courses.");
		System.out.println("");
		System.out.print("Please enter the number of Computer Science coures you want the school you're looking for to have: ");
		// Prints out the instructions for the user and where the data comes from
		
		
		Scanner school = new Scanner(System.in);
		int numCour = school.nextInt();
		String[][] dataTable = createTable();
		int resultCount = resultTotal(dataTable, numCour);
		// Creates scanner class to get user input and creates 2d array from data and gets total number of user's result
		
		System.out.println("");
		
		printTable(dataTable, resultCount, numCour);
		//Prints request information for user and prints next 10 when user hits enter
	}

	// Method that creates the 2d array that has strings which contain the school's name, number of total
	// cs courses, ap cs courses, full cs courses, and partial cs courses
	public static String[][] createTable() throws FileNotFoundException{
		Scanner fileRead = new Scanner(new File(System.getProperty("user.dir")+"/src/edu/nyu/cs/eth271/2016_2017_CS_Report.csv"));
		// Data comes from https://data.cityofnewyork.us/Education/2016-2017-Computer-Science-Report/2bef-phhy with all columns but column
		// number one, which lists DBNs, being used.
		String tempString = fileRead.nextLine();
		int itemsPerRow = 0;
		int itemsPerColumn = 0;
		
		tempString = fileRead.nextLine();
		tempString = tempString.substring(tempString.indexOf(",") + 1);
		
		while(tempString.indexOf(",") != -1){
			itemsPerRow++;
			tempString = tempString.substring(tempString.indexOf(",") + 1);
		}

		itemsPerRow++;

		while(fileRead.hasNextLine()){
			tempString = fileRead.nextLine();
			itemsPerColumn++;
		}

		String[][] fullTable = new String[itemsPerColumn][itemsPerRow];
		Scanner fileReadAgain = new Scanner(new File(System.getProperty("user.dir")+"/src/edu/nyu/cs/eth271/2016_2017_CS_Report.csv"));
		tempString = fileReadAgain.nextLine();
		tempString = fileReadAgain.nextLine();
		tempString = tempString.substring(tempString.indexOf(",") + 1);
		
		while(tempString.indexOf(",") > tempString.indexOf("\"") && tempString.indexOf(",") < tempString.lastIndexOf("\"") ){
				tempString = tempString.substring(0, tempString.indexOf(",")) + tempString.substring(tempString.indexOf(",") + 1);
		}

		for(int i = 0; i < itemsPerColumn; i++){
			for(int j = 0; j < itemsPerRow; j++){
				if(tempString.indexOf(",") != - 1){
					fullTable[i][j] = tempString.substring(0, tempString.indexOf(","));
					tempString = tempString.substring(tempString.indexOf(",") + 1);
				}

				else{
					fullTable[i][j] = tempString;
				}
			}
			tempString = fileReadAgain.nextLine();
			tempString = tempString.substring(tempString.indexOf(",") + 1);
			
			while(tempString.indexOf(",") > tempString.indexOf("\"") && tempString.indexOf(",") < tempString.lastIndexOf("\"") ){
				tempString = tempString.substring(0, tempString.indexOf(",")) + tempString.substring(tempString.indexOf(",") + 1);
			}
		}

		return fullTable;
	}

	public static int resultTotal(String[][] dataTab, int useNum){
		int count = 0;

		for(int i = 0; i < dataTab.length; i++){
			int compare = Integer.parseInt(dataTab[i][1]);
			if(useNum == compare){
				count++;
			}
		}
		return count;
	}

	// Void method that goes through and prints first 10 of user requested data and will continue to run
	// until user hits enter which it will print next 10 until it runs through whole array
	public static void printTable(String[][] dataTab, int resultCount, int numCour){
		System.out.print("Found " + resultCount + " schools that offer " + numCour + " computer science courses.");
		Scanner enterTracker = new Scanner(System.in);
		int tracker = 0;
		int resultOne = 0;
		int resultTwo = 9;
		int tenTracker = resultCount;
		int i = 0;
		while(tenTracker != 0){
			if(tenTracker >= 10){
				System.out.print(" Showing results " + (resultOne + 1) + "-" + (resultTwo + 1) + ":");
				System.out.println("");
				System.out.printf("\t%-52s, %-10s, %-10s, %s%n", "Name:", "#APCS:", "#FullCS:", "#PartialCS:");
				for(; tracker < resultTwo + 1; i++){
					int compare = Integer.parseInt(dataTab[i][1]);
					if(numCour == compare){
						System.out.printf("\t%-52s, %-10s, %-10s, %s%n", dataTab[i][0], dataTab[i][2], dataTab[i][3], dataTab[i][4]);
						tracker++;
					}
				}
				resultOne = resultOne + 10;
				resultTwo = resultTwo + 10;
				tenTracker = tenTracker - 10;
				System.out.println("...hit enter to see the next 10...");
				// Empty while loop used to pause program until user hits enter
				while(!enterTracker.nextLine().equals("")){

				}
			}

			else{
				System.out.print(" Showing results " + (resultTwo - 8) + "-" + (resultTwo + tenTracker - 9) + ":");
				System.out.println("");
				System.out.printf("\t%-52s, %-10s, %-10s, %s%n", "Name:", "#APCS:", "#FullCS:", "#PartialCS:");
				for(int notNeeded = 0; tracker < resultTwo + tenTracker; i++){
					if(i < 412){
						int compare = Integer.parseInt(dataTab[i][1]);
						if(numCour == compare){
							System.out.printf("\t%-52s, %-10s, %-10s, %s%n", dataTab[i][0], dataTab[i][2], dataTab[i][3], dataTab[i][4]);
							tracker++;
						}
					}
					else{
						break;
					}
				}
				tenTracker = 0;
			}
		}

	}

}