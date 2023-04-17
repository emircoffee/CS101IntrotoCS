/**
 * The class defines the TestSequence class which tests out the various classes and their functions.
 * @author emirh
 * @version 1.0.0
 */
public class TestSequence {
	
	/**
	 * The main method
	 * @param args 
	 */
	public static void main(String[] args) {
		Sentence sen = new Sentence("The Computer Science lecture room is located on 60 5th Avenue.");
		Word first = sen.getFirst();
		String firstStr = first.toString();
		System.out.println("The first word is: " + firstStr + ".");
		Word last = sen.getLast();
		String lastStr = last.toString();
		System.out.println("The last word in the sentence is: " + lastStr + ".");
		System.out.println("The words in the sentence are: " + sen.getSequence() + ".");
		Word word = new Word("Homework", 0);
		System.out.println("The first character of the word is: " + word.getFirst().toString() + ".");
		System.out.println("The last character of the word is: " + word.getLast().toString() + ".");
		System.out.println("The characters in the word are: " + word.getSequence().toString() + ".");
		System.out.println("The position of the character in the word is: " + word.getPosition() + ".");
	}

}