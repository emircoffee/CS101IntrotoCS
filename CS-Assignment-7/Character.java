/**
 * The class defines character class which extends OrderedThing.
 * This class takes a character and turns it into a character object. The char can be retrieved with the 
 * getter and setter methods.
 * @author emirh
 * @version 1.0.0
 */
public class Character extends OrderedThing {
	private char cha;
	
	/**
	 * A constructor that takes a char and sets the value to the private char.
	 * @param cha the char that is taken as an input value
	 */
	public Character(char cha) {
		this.cha = cha;
	}
	
	/**
	 * A constructor that creates a character object using the char from the first constructor.
	 * @param cha the char that is taken as an input value
	 */
	public static Character valueOf(char c) {
		Character temp = new Character(c);
		return temp;
	}
	
	/**
	 * A getter method which returns the char of the object.
	 * @return the char
	 */
	public char getCha() {
		return this.cha;
	}
	
	/**
	 * A setter method which sets the char of the object.
	 * @param the char
	 */
	public void setCha(char cha) {
		this.cha = cha;
	}
	
	/**
	 * An overridden tostring method that returns the character object as a string.
	 * @return a string that is the character object in string form
	 */
	public String toString() {
		return "" + this.getCha();
	}
}
