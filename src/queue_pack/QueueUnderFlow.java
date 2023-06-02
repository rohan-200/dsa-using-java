package queue_pack;


@SuppressWarnings("serial")
public class QueueUnderFlow extends Exception { // Queue Overflow Exception
	@Override
	public String toString() {
		return "Queue Empty\n";
	}
}