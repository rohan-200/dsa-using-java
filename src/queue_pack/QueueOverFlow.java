package queue_pack;

@SuppressWarnings("serial")
public class QueueOverFlow extends Exception { // Queue Overflow Exception
	@Override
	public String toString() {
		return "Queue Full\n";
	}
}