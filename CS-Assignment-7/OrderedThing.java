import java.util.ArrayList;

/**
 * The class defines the abstract class orderedThing which is what both character, sentence, and word are
 * based off of.
 * This class the public int pos, which is the position of something, and the orderedthing arraylist
 * which can be used to organize the character, sentence, and word objects into an arraylist.
 * @author emirh
 * @version 1.0.0
 */
public abstract class OrderedThing {

	public int pos = 0;
	
	ArrayList<OrderedThing> orderedThings = new ArrayList<OrderedThing>();
}