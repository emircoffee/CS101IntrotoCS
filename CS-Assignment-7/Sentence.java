import java.util.ArrayList;

/**
 * The class defines the sentence class which extends OrderedThing.
 * This class defines the sentence class takes a string. The string is broken up and added
 * into a Word array. Get sequence returns an arraylist with all word objects in the sentence. The
 * class can also return the first and last words of the sentence.
 * @author emirh
 * @version 1.0.0
 */
public class Sentence extends OrderedThing {
	ArrayList<Word> wordList = new ArrayList<Word>();	
	
	/**
	 * A constructor that takes a string and splits the sentence string into word objects.
	 * @param sen the string to be converted to a Word array
	 */
	public Sentence(String sen) {
		String[] words = sen.split("[^\\w']+");
		
		for (int i = 0; i < words.length; i++) {
			Word word = new Word(words[i], i);
			wordList.add(word);
		}	
	}
	
	/**
	 * Returns an arraylist created which has all word objects from the sentence.
	 * @return end the arraylist of characters
	 */
	public ArrayList<OrderedThing> getSequence() {
		ArrayList<OrderedThing> end = new ArrayList<OrderedThing>();
		for (Word wor: wordList) {
			end.add(wor);
		}
		
		return end;
	}
	
	/**
	 * A getter method which returns the position of the first word of the sentence.
	 * @return the first word
	 */
	public Word getFirst() {
		Word temp = wordList.get(0);
		return temp;
	}
	
	/**
	 * A getter method which returns the position of the last word of the sentence.
	 * @return the last word
	 */
	public Word getLast() {
		Word temp = wordList.get(wordList.size() - 1);
		return temp;
	}
}
