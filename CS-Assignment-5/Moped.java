/**
 * The class defines the Moped object and what it can do. The moped can be told to drive around a
 * 10x200 grid city by using commands such as turning left and right, and moving forward and backward.
 * It keeps track of its orientation to prevent it from going out of bounds and to mimic realistic driving.
 * The moped also has a gas meter which needs to be watched and refilled periodically. Some locations have
 * Advertising which is given out when entering the block of a location. There is also a function that allows
 * the moped to autodrive to Petite Abellie, a location in the map.
 * @author Emir Hamzaogullari
 * @version 1.0.0
 */
public class Moped {
	private double gas = 1.0;
	private int currentStreet = 9;
	private int currentAvenue = 4;
	private String orientation = "South";
	private String userInput = "";
	private boolean canTurnLeft = false;
	private boolean canTurnRight = false;
	private boolean canGoForward = false;
	private boolean canGoBack = false;
	
	/**
	 * A constructor that outputs the current location of a newly created moped to the console.
	 * @param none
	 * @return none
	 */
	public Moped() {
		System.out.println("Thanks for jumping in the moped. We're currently parked outside Dr. Rossinsky"
				+ " DDS's office at 10th Street and 5th Avenue, facing South. Please input help if you"
				+ " need a list of commands.");
	}
	/**
	 * A method which takes the integer of the avenue and turns it into a string for
	 * the console to output, it changes what it outputs depending on what number it is.
	 * @param ave the current avenue the moped is on as an integer
	 * @return String which contains avenue for cleaner output
	 */
	private String returnAvenue(int ave) {
		String returnString = "";
		if(ave + 1 == 1){
			returnString = "1st Avenue";
		}
		else if(ave + 1 == 2) {
			returnString = "2nd Avenue";
		}
		else if(ave + 1 == 3) {
			returnString = "3rd Avenue";
		}
		else{
			returnString = (ave + 1) + "th Avenue";
		}
		return returnString;
	}
	
	/**
	 *A method which takes the integer of the street and turns it into a string for
	 * the console to output, it changes what it outputs depending on what number it is.
	 * @param street the current street the moped is on as an integer
	 * @return String which contains street for cleaner output
	 */
	private String returnStreet(int street) {
		String returnString = "";
		if(street + 1 == 1){
			returnString = "1st Street";
		}
		else if(street + 1 == 2) {
			returnString = "2nd Street";
		}
		else if(street + 1 == 3) {
			returnString = "3rd Street";
		}
		else{
			returnString = (street + 1) + "th Street";
		}
		return returnString;
	}
	
	/**
	 * A method which outlines if a car can go left for the user and then changes
	 * orientation to the left of what it currently is and moves forward in that direction.
	 * @param none
	 * @return nothing since it is a void method
	 */
	private void goLeft() {
		if(getOrientation().equals("East") && getCurrentStreet() < 199) {
			 setOrientation("North");
			 setCurrentStreet(getCurrentStreet() + 1);
			 setGas(getGas()-(0.05));
			 System.out.println("Now at " + returnStreet(getCurrentStreet()) + " and " + returnAvenue(getCurrentAvenue())
			 + ", facing " + getOrientation() + ".");
			 checkAd();
			 if(getGas() <= 0.0) {
				 System.out.println("The moped has run out of gas and can no longer drive.");
				 System.exit(0);
			 }
				 
		}
		else if(getOrientation().equals("South") && getCurrentAvenue() > 0) {
			setOrientation("East");
			 setCurrentAvenue(getCurrentAvenue() - 1);
			 setGas(getGas()-(0.05));
			 System.out.println("Now at " + returnStreet(getCurrentStreet()) + " and " + returnAvenue(getCurrentAvenue())
			 + ", facing " + getOrientation() + ".");
			 checkAd();
			 if(getGas() <= 0.0) {
				 System.out.println("The moped has run out of gas and can no longer drive.");
				 System.exit(0);
			 }
		}
		else if(getOrientation().equals("West") && getCurrentStreet() > 0) {
			setOrientation("South");
			 setCurrentStreet(getCurrentStreet() - 1);
			// setLocation(map[getCurrentStreet() - 1][getCurrentAvenue()]);
			 setGas(getGas()-(0.05));
			 System.out.println("Now at " + returnStreet(getCurrentStreet()) + " and " + returnAvenue(getCurrentAvenue())
			 + ", facing " + getOrientation() + ".");
			 checkAd();
			 if(getGas() <= 0.0) {
				 System.out.println("The moped has run out of gas and can no longer drive.");
				 System.exit(0);
			 }
		}
		else if(getOrientation().equals("North") && getCurrentAvenue() < 9) {
			setOrientation("West");
			 setCurrentAvenue(getCurrentAvenue() + 1);
			 setGas(getGas()-(0.05));
			 System.out.println("Now at " + returnStreet(getCurrentStreet()) + " and " + returnAvenue(getCurrentAvenue())
			 + ", facing " + getOrientation() + ".");
			 checkAd();
			 if(getGas() <= 0.0) {
				 System.out.println("The moped has run out of gas and can no longer drive.");
				 System.exit(0);
			 }
		}
		else{
			System.out.println("Sorry, you can't turn left.");
		}
	}
	
	/**
	 * A method which outlines if a car can go right for the user and then changes
	 * orientation to the right of what it currently is and moves forward in that direction.
	 * @param none
	 * @return nothing since it is a void method
	 */
	private void goRight() {
		if(getOrientation().equals("West") && getCurrentStreet() < 199) {
			setOrientation("North");
			 setCurrentStreet(getCurrentStreet() + 1);
			 setGas(getGas()-(0.05));
			 System.out.println("Now at " + returnStreet(getCurrentStreet()) + " and " + returnAvenue(getCurrentAvenue())
			 + ", facing " + getOrientation() + ".");
			 checkAd();
			 if(getGas() <= 0.0) {
				 System.out.println("The moped has run out of gas and can no longer drive.");
				 System.exit(0);
			 }
				 
		}
		else if(getOrientation().equals("North") && getCurrentAvenue() > 0) {  
			setOrientation("East");
			 setCurrentAvenue(getCurrentAvenue() - 1);
			 setGas(getGas()-(0.05));
			 System.out.println("Now at " + returnStreet(getCurrentStreet()) + " and " + returnAvenue(getCurrentAvenue())
			 + ", facing " + getOrientation() + ".");
			 checkAd();
			 if(getGas() <= 0.0) {
				 System.out.println("The moped has run out of gas and can no longer drive.");
				 System.exit(0);
			 }
		}
		else if(getOrientation().equals("East") && getCurrentStreet() > 0) { 
			setOrientation("South");
			 setCurrentStreet(getCurrentStreet() - 1);
			 setGas(getGas()-(0.05));
			 System.out.println("Now at " + returnStreet(getCurrentStreet()) + " and " + returnAvenue(getCurrentAvenue())
			 + ", facing " + getOrientation() + ".");
			 checkAd();
			 if(getGas() <= 0.0) {
				 System.out.println("The moped has run out of gas and can no longer drive.");
				 System.exit(0);
			 }
		}
		else if(getOrientation().equals("South") && getCurrentAvenue() < 9) {
			setOrientation("West");
			 setCurrentAvenue(getCurrentAvenue() + 1);
			 setGas(getGas()-(0.05));
			 System.out.println("Now at " + returnStreet(getCurrentStreet()) + " and " + returnAvenue(getCurrentAvenue())
			 + ", facing " + getOrientation() + ".");
			 checkAd();
			 if(getGas() <= 0.0) {
				 System.out.println("The moped has run out of gas and can no longer drive.");
				 System.exit(0);
			 }
		}
		else{
			System.out.println("Sorry, you can't turn right.");
		}
	}
	
	/**
	 * A method which outlines if a car can go forward and moves forward in that direction.
	 * @param none
	 * @return nothing since it is a void method
	 */
	private void goFor() {
		if(getOrientation().equals("North") && getCurrentStreet() < 199) {
			setCanGoForward(true); 
			setCurrentStreet(getCurrentStreet() + 1);
			 setGas(getGas()-(0.05));
			 System.out.println("Now at " + returnStreet(getCurrentStreet()) + " and " + returnAvenue(getCurrentAvenue())
			 + ", facing " + getOrientation() + ".");
			 checkAd();
			 if(getGas() <= 0.0) {
				 System.out.println("The moped has run out of gas and can no longer drive.");
				 System.exit(0);
			 }
				 
		}
		else if(getOrientation().equals("East") && getCurrentAvenue() > 0) {
			setCanGoForward(true); 
			setCurrentAvenue(getCurrentAvenue() - 1);
			 setGas(getGas()-(0.05));
			 System.out.println("Now at " + returnStreet(getCurrentStreet()) + " and " + returnAvenue(getCurrentAvenue())
			 + ", facing " + getOrientation() + ".");
			 checkAd();
			 if(getGas() <= 0.0) {
				 System.out.println("The moped has run out of gas and can no longer drive.");
				 System.exit(0);
			 }
		}
		else if(getOrientation().equals("South") && getCurrentStreet() > 0) {
			setCanGoForward(true); 
			setCurrentStreet(getCurrentStreet() - 1);
			 setGas(getGas()-(0.05));
			 System.out.println("Now at " + returnStreet(getCurrentStreet()) + " and " + returnAvenue(getCurrentAvenue())
			 + ", facing " + getOrientation() + ".");
			 checkAd();
			 if(getGas() == 0.0) {
				 System.out.println("The moped has run out of gas and can no longer drive.");
				 System.exit(0);
			 }
		}
		else if(getOrientation().equals("West") && getCurrentAvenue() < 9) {
			setCanGoForward(true);  
			setCurrentAvenue(getCurrentAvenue() + 1);
			 setGas(getGas()-(0.05));
			 System.out.println("Now at " + returnStreet(getCurrentStreet()) + " and " + returnAvenue(getCurrentAvenue())
			 + ", facing " + getOrientation() + ".");
			 checkAd();
			 if(getGas() <= 0.0) {
				 System.out.println("The moped has run out of gas and can no longer drive.");
				 System.exit(0);
			 }
		}
		else{
			System.out.println("Sorry, you can't go straight on.");
		}
	}
	
	/**
	 * A method which outlines if a car can go backwards and moves backwards in that direction.
	 * @param none
	 * @return nothing since it is a void method
	 */
	private void goBack() {
		if(getOrientation().equals("South") && getCurrentStreet() < 199) {
			setCanGoBack(true); 
			setCurrentStreet(getCurrentStreet() + 1);
			 setGas(getGas()-(0.05));
			 System.out.println("Now at " + returnStreet(getCurrentStreet()) + " and " + returnAvenue(getCurrentAvenue())
			 + ", facing " + getOrientation() + ".");
			 checkAd();
			 if(getGas() <= 0.0) {
				 System.out.println("The moped has run out of gas and can no longer drive.");
				 System.exit(0);
			 }
		}
		else if(getOrientation().equals("West") && getCurrentAvenue() > 0) {
			setCanGoBack(true);  
			setCurrentAvenue(getCurrentAvenue() - 1);
			 setGas(getGas()-(0.05));
			 System.out.println("Now at " + returnStreet(getCurrentStreet()) + " and " + returnAvenue(getCurrentAvenue())
			 + ", facing " + getOrientation() + ".");
			 checkAd();
			 if(getGas() <= 0.0) {
				 System.out.println("The moped has run out of gas and can no longer drive.");
				 System.exit(0);
			 }
		}
		else if(getOrientation().equals("North") && getCurrentStreet() > 0) {
			setCanGoBack(true);  
			setCurrentStreet(getCurrentStreet() - 1);
			 setGas(getGas()-(0.05));
			 System.out.println("Now at " + returnStreet(getCurrentStreet()) + " and " + returnAvenue(getCurrentAvenue())
			 + ", facing " + getOrientation() + ".");
			 checkAd();
			 if(getGas() <= 0.0) {
				 System.out.println("The moped has run out of gas and can no longer drive.");
				 System.exit(0);
			 }
		}
		else if(getOrientation().equals("East") && getCurrentAvenue() < 9) {
			setCanGoBack(true); 
			setCurrentAvenue(getCurrentAvenue() + 1);
			 setGas(getGas()-(0.05));
			 System.out.println("Now at " + returnStreet(getCurrentStreet()) + " and " + returnAvenue(getCurrentAvenue())
			 + ", facing " + getOrientation() + ".");
			 checkAd();
			 if(getGas() <= 0.0) {
				 System.out.println("The moped has run out of gas and can no longer drive.");
				 System.exit(0);
			 }
		}
		else{
			System.out.println("Sorry, you can't back up.");
		}
	}
	
	/**
	 * A method which when called, sets booleans of directions the car can go in and changes the
	 * Corresponding booleans accordingly.
	 * @param none
	 * @return nothing since it is a void method
	 */
	private void pathSetter() {
			 if((getOrientation().equals("East") && getCurrentStreet() < 199) ||
				(getOrientation().equals("South") && getCurrentAvenue() > 0) ||
				(getOrientation().equals("West") && getCurrentStreet() > 0) ||
				(getOrientation().equals("North") && getCurrentAvenue() < 9)) setCanTurnLeft(true);
			 if((getOrientation().equals("West") && getCurrentStreet() < 199)||
				(getOrientation().equals("North") && getCurrentAvenue() > 0)||
				(getOrientation().equals("East") && getCurrentStreet() > 0)||
				(getOrientation().equals("South") && getCurrentAvenue() < 9)) setCanTurnRight(true);
			 if((getOrientation().equals("North") && getCurrentStreet() < 199)||
				(getOrientation().equals("East") && getCurrentAvenue() > 0) ||
				(getOrientation().equals("South") && getCurrentStreet() > 0) ||
				(getOrientation().equals("West") && getCurrentAvenue() < 9)) setCanGoBack(true);
			 if((getOrientation().equals("South") && getCurrentStreet() < 199)||
				(getOrientation().equals("West") && getCurrentAvenue() > 0) ||
				(getOrientation().equals("North") && getCurrentStreet() > 0) ||
				(getOrientation().equals("East") && getCurrentAvenue() < 9)) setCanGoForward(true);
	}
	
	/**
	 * A method which when called, sets the booleans for directions to false, acting as a reset.
	 * @param none
	 * @return nothing since it is a void method
	 */
	private void pathSetterReset() {
		setCanTurnLeft(false);
		setCanTurnRight(false);
		setCanGoForward(false);
		setCanGoBack(false);
	}
	
	/**
	 * A method which automatically routes the car to Petite Abeille based
	 * on where it currently is on the grid.
	 * @param none
	 * @return nothing since it is a void method
	 */
	private void goToPA() {
		if(getCurrentAvenue() > 5) {
			while(!getOrientation().equals("East")) {
				pathSetter();
				if(isCanTurnLeft()) {
					goLeft();
				}
				else {
					goRight();
				}
				pathSetterReset();
			}
			while(getCurrentAvenue() != 5) {
				goFor();
			}
			if(getCurrentStreet() > 16) {
				while(!getOrientation().equals("South")) {
					pathSetter();
					if(isCanTurnLeft()) {
						goLeft();
					}
					else {
						goRight();
					}
					pathSetterReset();
				}
				while(getCurrentStreet() != 16) {
					goFor();
				}
				System.out.println("We have reached the Petite Abeille. Enjoy your moules-frites.");
			}
			else if(getCurrentStreet() < 16) {
				while(!getOrientation().equals("North")) {
					pathSetter();
					if(isCanTurnLeft()) {
						goLeft();
					}
					else {
						goRight();
					}
					pathSetterReset();
				}
				while(getCurrentStreet() != 16) {
					goFor();
				}
				System.out.println("We have reached the Petite Abeille. Enjoy your moules-frites.");
			}
			else if(getCurrentStreet() == 16) {
				System.out.println("We have reached the Petite Abeille. Enjoy your moules-frites.");
			}
		}
		else if(getCurrentAvenue() < 5) {
			while(!getOrientation().equals("West")) {
				pathSetter();
				if(isCanTurnLeft()) {
					goLeft();
				}
				else {
					goRight();
				}
				pathSetterReset();
			}
			while(getCurrentAvenue() != 5) {
				goFor();
			}
			if(getCurrentStreet() > 16) {
				while(!getOrientation().equals("South")) {
					pathSetter();
					if(isCanTurnLeft()) {
						goLeft();
					}
					else {
						goRight();
					}
					pathSetterReset();
				}
				while(getCurrentStreet() != 16) {
					goFor();
				}
				System.out.println("We have reached the Petite Abeille. Enjoy your moules-frites.");
			}
			else if(getCurrentStreet() < 16) {
				while(!getOrientation().equals("North")) {
					pathSetter();
					if(isCanTurnLeft()) {
						goLeft();
					}
					else {
						goRight();
					}
					pathSetterReset();
				}
				while(getCurrentStreet() != 16) {
					goFor();
				}
				System.out.println("We have reached the Petite Abeille. Enjoy your moules-frites.");
			}
			else if(getCurrentStreet() == 16) {
				System.out.println("We have reached the Petite Abeille. Enjoy your moules-frites.");
			}
		}
		else if(getCurrentAvenue() == 5) {
			if(getCurrentStreet() > 16) {
				while(!getOrientation().equals("South")) {
					pathSetter();
					if(isCanTurnLeft()) {
						goLeft();
					}
					else {
						goRight();
					}
					pathSetterReset();
				}
				while(getCurrentStreet() != 16) {
					goFor();
				}
				System.out.println("We have reached the Petite Abeille. Enjoy your moules-frites.");
			}
			else if(getCurrentStreet() < 16) {
				while(!getOrientation().equals("North")) {
					pathSetter();
					if(isCanTurnLeft()) {
						goLeft();
					}
					else {
						goRight();
					}
					pathSetterReset();
				}
				while(getCurrentStreet() != 16) {
					goFor();
				}
				System.out.println("We have reached the Petite Abeille. Enjoy your moules-frites.");
			}
			else if(getCurrentStreet() == 16) {
				System.out.println("You are already at Petite Abeille.");
			}
		}
	}
	
	/**
	 * A method which checks if it is in a block that has advertising and outputs to the console if it does.
	 * @param none
	 * @return nothing since it is a void method
	 */
	private void checkAd() {
		if(getCurrentStreet() == 78 && getCurrentAvenue() == 7) {
			System.out.println("The American Museum of Natural History was founded in 1869 and is renowned"
					+ " for its exhbitions and scientific collections.");
		}
		else if(getCurrentStreet() == 73 && getCurrentAvenue() == 0) {
			System.out.println("The Memorial Sloan Kettering Cancer Center is the world's largest and oldest"
					+ " private cancer center, with over 130 years of exceptional care.");
		}
		else if(getCurrentStreet() == 11 && getCurrentAvenue() == 3) {
			System.out.println("The Strand bookstore was founded in 1927 and carries over 2.5 million used,"
					+ " new, and rare books.");
		}
		else if(getCurrentStreet() == 2 && getCurrentAvenue() == 5) {
			System.out.println("Fay Da Bakery was opened in 1991, which serves baked goods based on recipies"
					+ " the owner learned when he lived in Taiwan.");
		}
	}
	
	/**
	 * A method which outlines the commands the user can use with the moped in the console.
	 * @param none
	 * @return nothing since it is a void method
	 */
	private void getHelp() {
		System.out.println("Here is the list of commands that the program understands: 'go left', 'go right'," +
	" 'straight on', 'back up', 'how we doin'?', 'fill 'er up', 'park', and 'go to Petite Abeille'.");
	}
	
	/**
	 * A method which calles the cooresponding method to the user's console command.
	 * @param none
	 * @return nothing since it is a void method
	 */
	public void controlCenter() {
		if(getUserInput().equals("go left")) {
			goLeft();
		}
		else if(getUserInput().equals("go right")) {
			goRight();
		}
		else if(getUserInput().equals("straight on")) {
			goFor();
		}
		else if(getUserInput().equals("back up")) {
			goBack();
		}
		else if(getUserInput().equals("how we doin'?")) {
			gasCheck();
		}
		else if(getUserInput().equals("fill 'er up")) {
			gasFill();
		}
		else if(getUserInput().equals("park")) {
			parkCar();
		}
		else if(getUserInput().equals("go to Petite Abeille")) {
			goToPA();
		}
		else if(getUserInput().equals("help")) {
			getHelp();
		}
		else {
			System.out.println("Sorry, the program didn't recognize that command.");
		}
	}
	
	/**
	 * A method which outputs to the console how much gas is left in the car.
	 * @param none
	 * @return nothing since it is a void method
	 */
	private void gasCheck() {
		System.out.println("The gas tank is currently " + (int)(getGas() * 100) +"% full.");
	}
	
	/**
	 * A method which refills the gas tank to 100% for the user when called.
	 * @param none
	 * @return nothing since it is a void method
	 */
	private void gasFill() {
		setGas(1.0);
		gasCheck();
	}
	
	/**
	 * A method which parks the moped, tells the user, and shuts the program down.
	 * @param none
	 * @return nothing since it is a void method
	 */
	private void parkCar(){
		System.out.println("You have parked the moped near the sidewalk, thank you for riding with us.");
		System.exit(0);
	}

	/**
	 * @return
	 */
	public double getGas() {
		return gas;
	}
	/**
	 * @param gas
	 */
	public void setGas(double gas) {
		this.gas = gas;
	}

	/**
	 * @return
	 */
	public int getCurrentStreet() {
		return currentStreet;
	}

	/**
	 * @param currentStreet
	 */
	public void setCurrentStreet(int currentStreet) {
		this.currentStreet = currentStreet;
	}

	/**
	 * @return
	 */
	public int getCurrentAvenue() {
		return currentAvenue;
	}

	/**
	 * @param currentAvenue
	 */
	public void setCurrentAvenue(int currentAvenue) {
		this.currentAvenue = currentAvenue;
	}

	/**
	 * @return
	 */
	public String getOrientation() {
		return orientation;
	}

	/**
	 * @param orientation
	 */
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	/**
	 * @return
	 */
	public String getUserInput() {
		return userInput;
	}

	/**
	 * @param userInput
	 */
	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}

	/**
	 * @return
	 */
	public boolean isCanTurnLeft() {
		return canTurnLeft;
	}

	/**
	 * @param canTurnLeft
	 */
	public void setCanTurnLeft(boolean canTurnLeft) {
		this.canTurnLeft = canTurnLeft;
	}

	/**
	 * @return
	 */
	public boolean isCanTurnRight() {
		return canTurnRight;
	}

	/**
	 * @param canTurnRight
	 */
	public void setCanTurnRight(boolean canTurnRight) {
		this.canTurnRight = canTurnRight;
	}

	/**
	 * @return
	 */
	public boolean isCanGoForward() {
		return canGoForward;
	}

	/**
	 * @param canGoForward
	 */
	public void setCanGoForward(boolean canGoForward) {
		this.canGoForward = canGoForward;
	}

	/**
	 * @return
	 */
	public boolean isCanGoBack() {
		return canGoBack;
	}

	/**
	 * @param canGoBack
	 */
	public void setCanGoBack(boolean canGoBack) {
		this.canGoBack = canGoBack;
	}

	
}
