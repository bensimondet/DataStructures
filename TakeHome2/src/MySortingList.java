import java.util.Iterator;
import java.util.NoSuchElementException;
/*
 * No I Would Not Like To Import Countdown Latch
 * (A Short Story by Ben Simondet)
 * Building MySortingList was quite the struggle. Every modification I made to make the list work closer to the 
 * given specifications made everything stop working. Eclipse didn't help much with anything, thus the title. I actually used all 8 hours of the given time
 * and more testing could be done, but I believe this to be the most challenging, and rewarding, assignment so far.
 */


public class MySortingList<E extends Comparable<E>> implements SortingList<E>, Iterable<E> {
	int listCount = 0;
	int valueCount = 0;
	Node head = null;
	

	@Override
	public boolean isEmpty() {
		return listCount == 0;
	}

	@Override
	public int size() {
		return listCount;
	}

	@Override
	public int uniqueValueCount() {
		return valueCount;
	}

	@Override
	public void add(E item) {
		//adding to an empty Sorting List
		if(head == null){
			head = new Node(head, null, item, 0);
			listCount++;
			valueCount++;
			return;
		}else {
			Node next = findPlacement(item);
			if(greaterOrEquals(next,item)==true){
				next.nextEquals = new Node(null, next.nextEquals, item, next.subcount++);
				listCount++;
			}else{
				next.nextGreater = new Node(next.nextGreater, next.nextEquals, item, 0);
				listCount++;
				valueCount++;
			}
		}
	}

	public boolean greaterOrEquals(Node placement, E item) {
		boolean toReturn;
		if(placement.value.compareTo(item)== 0){
			toReturn = true;
		}else{
			toReturn = false;
		}
		return toReturn;
	}
	
	@Override
	public int frequencyOf(E item) {
		int frequencyCount = 0;
		for(int i = 0; i < valueCount; i++){
			try {
				if(item.compareTo(get(i)) == 0){
					frequencyCount++;
				}
			} catch (ListIndexOutOfBoundsException e) {
				//Should never get here
			}
		}
		return frequencyCount;
	}

	@Override
	public E get(int index) throws ListIndexOutOfBoundsException {
		if(index < 0){
			throw new ListIndexOutOfBoundsException("The index " + index + " is not within the boundaries of the list.");
		}
		if(index >= listCount){
			throw new ListIndexOutOfBoundsException("The index " + index + " is not within the boundaries of the list.");
		}
		Node current = head;
		for (int i = 0; i < index; i++) {
			if (current.subcount == 0){
				current = current.nextGreater;
			}else{
				current = current.nextEquals;
			}
		}
		return current.value;
	}

	@Override
	public void remove(int index) throws ListIndexOutOfBoundsException {
		if(index < 0){
			throw new ListIndexOutOfBoundsException("The index " + index + " is not within the boundaries of the list.");
		}
		if(index >= listCount){
			throw new ListIndexOutOfBoundsException("The index " + index + " is not within the boundaries of the list.");
		}
		Node toRemove = findNode(index);
		toRemove.nextGreater = toRemove.nextGreater.nextGreater;
	}
	
	private Node findPlacement(E item){
		Node placement = head;
		while(placement.nextGreater != null && placement.value.compareTo(item) <=0){
			placement = placement.nextGreater;
		}
		if(placement.value != null && placement.value.compareTo(item) == 0){
			while(placement.nextEquals != null){
				placement = placement.nextEquals;
			}
		}
		return placement;
	}
	
	private Node findNode(int index) {
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.nextGreater;
		}
		return current;
	}
	@Override
	public void clear() {
		head = null;
		listCount = 0;
		valueCount = 0;

	}
	private class Node {
		Node nextGreater;
		Node nextEquals;
		E value;
		int subcount;
		
		public Node(Node nextGreater, Node nextEquals, E value, int subcount){
			this.nextGreater = nextGreater;
			this.nextEquals = nextEquals;
			this.value = value;
			this.subcount = subcount;
		}
	}
	
	@Override
	public Iterator<E> iterator() {
		return new SortingListIterator();
	}
	
	private class SortingListIterator implements Iterator<E>{
		private Node main = head;
		private Node current = head;
		
		@Override
		public boolean hasNext() {
			return current.nextEquals != null && main.nextEquals != null;
			}

		@Override
		public E next() {
			if (hasNext()){
				if(current.nextEquals != null){
					current = current.nextEquals;
				
				}else{
					main = main.nextGreater;
				}
				return current.value;
			}else{
				throw new NoSuchElementException();
			}
		}
		
		@Override
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}
}
