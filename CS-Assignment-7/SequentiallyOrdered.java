import java.util.ArrayList;

/**
 * An interface that sets up the abstract methods required to be implemented by cearting classes in the program.
 * @author Professor Bloomberg
 * @version 1.0.0
 */
public interface SequentiallyOrdered {
	public abstract OrderedThing getFirst();
	public abstract OrderedThing getLast();
	public abstract ArrayList<OrderedThing> getSequence();
}
