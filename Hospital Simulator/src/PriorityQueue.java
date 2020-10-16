//Author: Maik De Leon Lopez
public class PriorityQueue {	//Implemented using myHeap
	private myHeap minHeap;
	private int capacity;
	private int size;
	
	// Constructor
	public PriorityQueue(int capacity) {
		this.capacity = capacity;
		minHeap = new myHeap(capacity+1);	
		this.size = 0;
	}
	
	// Method adds a patient into the minHeap
	public boolean offer(Patients item) {
		if(size >= capacity) {				// If the size is outside of the bounds display error
			System.out.println("Invalid Index");
			return false;
		}
		else {
			minHeap.add(item);		// We can add and increment size
			size++;
			return true;
		}
	}
	
	// Method removes a patient from the minHeap (the one with highest priority)
	public Patients poll() {
		if(minHeap.isEmpty()) {		// If the Queue is empty display an error
			System.out.println("Queue is Empty");
			return null;
		}
		else {
			Patients temp = minHeap.remove();
			size--;					// We can remove and decrement size
			return temp;
		}
	}
	
	public Patients peek() {
		return minHeap.peek();	// Can directly use the minHeap's peak method
	}
	
	public String toString() {
		return minHeap.toString();	
	}
	
	public boolean isEmpty() {
		return size == 0;		//if the size is 0 then it is empty
	}
}
