import java.util.ArrayList;

/**
 * The class defines the word class which extends OrderedThing and implements SequentiallyOrdered.
 * This class defines the word class takes a string and a position. The string is broken up and added
 * into a Character array. Get sequence returns an arraylist with all character objects in the word. The
 * class can also return the position of the word along with the first and last characters of the word.
 * @author emirh
 * @version 1.0.0
 */
public class Word extends OrderedThing implements SequentiallyOrdered {
	private ArrayList<Character> charList = new ArrayList<Character>();
	private int pos;
	
	/**
	 * A constructor that takes a string and an integer and sets that to the position of the word
	 * and the string that the Character array is based off of.
	 * @param str the string to be converted to a Character array
	 * @param pos the position of the word
	 */
	public Word(String str, int pos) {
		for(int i = 0; i < str.length(); i++) {
			Character cha = Character.valueOf(str.charAt(i));
			charList.add(cha);
		}
		
		this.pos = pos;
	}
	
	/**
	 * Returns an arraylist created which has all character objects from the word.
	 * @return temp the arraylist of characters
	 */
	public ArrayList<OrderedThing> getSequence() {
		ArrayList<OrderedThing> temp = new ArrayList<OrderedThing>();
		
		for (Character cha: charList) {
			temp.add(cha);
		}
		
		return temp;
	}
	
	/**
	 * A getter method which returns the position of the word.
	 * @return pos the position of the word
	 */
	public int getPosition() {
		return pos;
	}
	
	/**
	 * A getter method which returns the position of the first character of the word.
	 * @return the first character
	 */
	public Character getFirst() {
		Character temp = charList.get(0);
		return temp;
	}
	
	/**
	 * A getter method which returns the position of the last character of the word.
	 * @return the last character
	 */
	public Character getLast() {
		Character temp = charList.get(charList.size() - 1);
		return temp;
	}
	
	/**
	 * An overridden tostring method that returns the word object as a string.
	 * @return a string that is the word object in string form
	 */
	public String toString() {
		String str = "";
		for (Character cha : this.charList) {
			str = str + cha.getCha();
		}
		return str;
	}
}
