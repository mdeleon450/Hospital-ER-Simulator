//Author: Maik De Leon Lopez
public class myHeap {
	/* Got inspiration from various sources http://www.algolist.net/Data_structures/Binary_heap/Remove_minimum
		https://www.geeksforgeeks.org/min-heap-in-java/
		not directly copied
	*/
	private Patients[] nodeList;	// An array of Patients instead of integers
	private int capacity;			// Max capacity of the array
	private int size;				// How many Elements are in the array
	
	public myHeap(int capacity) {
		this.capacity = capacity;
		nodeList =  new Patients[this.capacity];
		this.size = 0;
	}
	
	// Method that prints out the parent followed by their children
	public String toString() {
		int i = 0;
		String s = "";
		while((hasLeftChild(i) || hasRightChild(i))  && (i*2+1) < size) {	// if the current node has a left child or right and their indexes dont go out of bounds
			if(hasLeftChild(i) && !hasRightChild(i)) {	//We check if it only has a left child
				s += ("|Parent "+nodeList[i]+" |Left Child "+nodeList[leftChild(i)]+"\n");	//if so print only the left
			}
			else if(hasRightChild(i) && !hasLeftChild(i)) {					//If it only has right child print only the right
				s += ("|Parent "+nodeList[i]+" |Right Child "+nodeList[rightChild(i)]+"\n");
			}
			else {	//Otherwise print both left and right
				s += ("|Parent "+nodeList[i]+" |Left Child "+nodeList[leftChild(i)]+" |Right Child "+nodeList[rightChild(i)]+"\n");
			}
			i++;
		}
		return s;
	}
	
	// Method that adds a patient to the minHeap based on priority
	public void add(Patients data) {
		if(size > capacity) {	// if the size is larger than capacity then display error
			System.out.println("Invalid Index!");
			return;
		}
		int current = size;		// Otherwise we add the data to the end of the array (at size)
		nodeList[current] = data;
		size++;		//Increment the size
		
		while(nodeList[current].getUrgency() < nodeList[parent(current)].getUrgency()) {	
				swap(current, parent(current));	//Check if the priority of the node we added is higher than the parents
				current = parent(current);		//If so swap and swap until the root if necessary
		}
	}
	
	// Method that removes a patient from the minHeap
	public Patients remove() {
		if(size == 0) {	// If the size is 0 then it is empty
			System.out.println("Heap is Empty");
			return null;
		}
		int current = 0;	// Otherwise we remove the root 
		Patients temp = nodeList[current];
		nodeList[current] = nodeList[--size];	// Move the last node added to the root 
		while(hasLeftChild(current) || hasRightChild(current)) {	//While the root has a left or right child
			if(hasLeftChild(current) && hasRightChild(current)) {	// if it has both left and right
				if(nodeList[leftChild(current)].getUrgency() < nodeList[rightChild(current)].getUrgency()) {
					swap(current,leftChild(current));		//if the left urgency is lower(meaning higher priority)
					current = leftChild(current);			//then swap the root with the left child 
				}
				else {										//if the right urgency is lower
					swap(current,rightChild(current));		//then swap the root with the right
					current = rightChild(current);
				}
			}
			else if(hasLeftChild(current)) {			//If the root only has a left child swap with it
				swap(current,leftChild(current));
				current = leftChild(current);
			}
			else if(hasRightChild(current)) {			//If the root only has a right child swap with it
				swap(current, rightChild(current));
				current = rightChild(current);
			}
		}
		return temp;
	}
	
	public Patients peek() {
		return nodeList[0];			//The root is the min value
	}
	
	public boolean isEmpty() {
		return this.size == 0;		//if the size is 0 then it is empty
	}
	
	private int parent(int pos) {
		return (pos-1)/ 2;			//parent index is calculated by (pos-1)/2
	}
	
	private int leftChild(int pos) {
		return (2*pos)+1;			//how left child index is calculated
	}
	
	private int rightChild(int pos) {
		return (2*pos)+2;			//how right child index is calculated
	}
	
	private boolean hasRightChild(int pos) {
		return rightChild(pos) <= size;		//if the index is a valid one(meanin less than or equal to size
	}
	private boolean hasLeftChild(int pos) {
		return leftChild(pos) <= size;		//if left child index is valid
	}
	
	//Helper Method that swaps the contents of two positions
	private void swap(int fpos, int spos) {
		Patients temp = nodeList[fpos];
		nodeList[fpos] = nodeList[spos];
		nodeList[spos] = temp;
	}
	
}
