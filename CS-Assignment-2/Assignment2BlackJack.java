// Imports the Scanner object and Math functions
import java.util.Scanner;
import java.lang.Math;

public class Assignment2BlackJack {

	public static void main(String[] args) {

		// This program is a version of Blackjack that is played against the dealer. You are given two cards and the dealer is given two cards.
		// The user can then choose to hit for another card or stand with the current amount he has. Like normal Blackjack, the player's goal is
		// to get to as close to 21 as possible without going over. The dealer will be trying to acheive the same goal. If the player busts, he/she
		// automatically looses, but if they get to 21 or close to it after hitting as many times possible then standing or just standing, his card
		// total will be compared with the dealer's card total. The dealer is designed to only hit if he is below 17, if not, he stand automatically
		// at 17 or more. Whoever is closer to 21 wins, if the dealer and player both have the same card total, it is a tie. The card is then shown
		// and the end result if printed.

		Scanner userInput = new Scanner(System.in);
		// Creates new scanner object to read user input.

		boolean isGame = true;
		boolean isDealerGame = true;
		//  Creates two boolean's for the player and dealer's while loops's conditions.

		int cardOne = ( (int)( (11 - 2 + 1) * Math.random() ) + 2 );
		int cardTwo = ( (int)( (11 - 2 + 1) * Math.random() ) + 2 );
		// Creates the starting two cards for the player by mutlitplying the possible integer value of the cards by Math.Random to randomize a given
		// card between 2 and 11. The reason the math 11 - 2 + 1 is done is to get the range of intergers to multiply by Math.random and then add 2 
		// to shift from 0 to 9 to 2 to 11.

		int dealerCardOne = ( (int)( (11 - 2 + 1) * Math.random() ) + 2 );
		int dealerCardTwo = ( (int)( (11 - 2 + 1) * Math.random() ) + 2 );
		// Creates the starting two cards for the dealer by mutlitplying the possible integer value of the cards by Math.Random to randomize a given
		// card between 2 and 11. The reason the math 11 - 2 + 1 is done is to get the range of intergers to multiply by Math.random and then add 2 
		// to shift from 0 to 9 to 2 to 11.

		int cardTotal = cardOne + cardTwo;
		int dealerCardTotal = dealerCardOne + dealerCardTwo;
		// Initializes vaiables for the intital cards totals of the player and dealer.

		String playerCards = "Your cards were: " + cardOne + ", " + cardTwo;
		String dealerCards = "The dealer's cards were: " + dealerCardOne + ", " + dealerCardTwo;
		// Initializes strings that state what is the player's and dealer's cards.

		System.out.println ("Welcome to Blackjack!");
		// Prints welcome message for Blackjack game beginning.

		while (isGame == true) {
		// While loop that loops body until isGame boolean is not true.

			System.out.println(playerCards);
			System.out.print("Would you like to hit or stand? ");
			// Prints out the current cards the player has and asks him to hit or stand.

			String decision = userInput.nextLine();
			// Gets users response to hit or stand.

			if ( decision.toLowerCase().equals("hit") ) {
				// If condition that gets triggered when the user types hit.

				int cardNext = ( (int)( (11 - 2 + 1) * Math.random() ) + 2 );
				cardTotal = cardTotal + cardNext;
				playerCards = playerCards + ", " + cardNext;
				// Creates a new card for the player, adds it to the card total and adds it to the sentence that prints the
				// cards the user has.

				if (cardTotal > 21) {
					isGame = false;
					// If condition that gets triggered when user's cards' total got above 21. Sets boolean isGame to
					// false and ends looping of while loop.

				}
			}
			
			else if (decision.toLowerCase().equals("stand")) {
				isGame = false;
				// If condition that gets triggered when user's responds with stand. Sets boolean isGame to
				// false and ends looping of while loop.

			}

			else {
				System.out.println("Unrecognized input, please try typing your input again.");
				// Prints message to user to retype response if he didn't type hit or stand.

			}
		}

		while (isDealerGame == true) {
			// While loop that loops body until isDealerGame boolean is not true.

			if (dealerCardTotal < 17) {
				// If condition that gets triggered when dealer's card total is less than 17.

				int dealerCardNext = ( (int)( (11 - 2 + 1) * Math.random() ) + 2 );
				dealerCardTotal = dealerCardTotal + dealerCardNext;
				dealerCards = dealerCards + ", " + dealerCardNext;
				// Adds a new card which is added to the dealer's card total and the sentence that shows what cards he has.

				if (dealerCardTotal > 21) {
					isDealerGame = false;
					// If condition that gets triggered when dealer's cards' total got above 21. Sets boolean isDealerGame to
					// false and ends looping of while loop.

				}
			}

			else if(dealerCardTotal >= 17) {
				isDealerGame = false;
				// If condition that gets triggered when dealer's card total is 17 or higher. Sets boolean isGame to
				// false and ends looping of while loop.

			}
		}

		System.out.println(playerCards);
		System.out.println(dealerCards);
		// Statements that prints player's and dealer's cards.

		if(cardTotal > 21) {
			System.out.println("Your hand was a bust, sorry, better luck next time.");
			// Prints out when the user busts.

		}

		else if(dealerCardTotal > 21){
			System.out.println("The dealer's hand was a bust, congrats, you won!");
			// Prints out when the dealer busts.

		}
		
		else if(dealerCardTotal > cardTotal){
			System.out.println("The dealer got closer to 21 than you without busting, sorry, better luck next time.");
			// Prints out when the dealer beats the user.

		}

		else if(cardTotal > dealerCardTotal) {
			System.out.println("You got closer to 21 than the dealer without busting, congrats, you won!");
			// Prints out when the user beats the dealer.

		}

		else if(cardTotal == dealerCardTotal){
			System.out.println("You and the dealer have matching hands, you tied!");
			// Prints out when the user ties with the dealer.

		}
	}
}