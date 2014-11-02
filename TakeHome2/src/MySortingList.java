import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySortingList<E extends Comparable<E>> implements SortingList<E>, Iterable<E> {
	int listCount = 0;
	int valueCount = 0;
	Node head = new Node(null, null, null);
	

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
			head = new Node(null, null, item);
			listCount++;
			valueCount++;
			return;
		}
		//adding anywhere else
		Node placement = findPlacement(item);
		//if they are the same, add to minor section of list
		if(placement.value.compareTo(item) == 0 && placement.value != null){
			placement = new Node(placement.nextEquals, null, item);
			listCount ++;
		}
		//if there are no matches, add a new value to the list
		//first need to find placement if it should be first
		else if(placement.value.compareTo(item)>0){
			head = new Node(head.nextGreater, null, item);
			listCount++;
			valueCount++;
		}
		else{
			placement.nextGreater = new Node(placement.nextGreater,null, item);
			listCount++;
			valueCount++;
		}
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
		Iterator<E> iterator = iterator();  
		for(int i=0; i<index; i++){
			iterator.next();
		}
		return iterator.next();
	}

	@Override
	public void remove(int index) throws ListIndexOutOfBoundsException {
		// TODO Auto-generated method stub

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
		
		public Node(Node nextGreater, Node nextEquals, E value){
			this.nextGreater = nextGreater;
			this.nextEquals = nextEquals;
			this.value = value;
		}
	}
	
	@Override
	public Iterator<E> iterator() {
		return new SortingListIterator();
	}
	
	private class SortingListIterator implements Iterator<E>{
		private Node currentGreater = head;
		private Node currentEquals = head;
		
		@Override
		public boolean hasNext() {
			return currentGreater != null && currentEquals != null;
			}

		@Override
		public E next() {
			if (hasNext()){
				if(currentEquals.nextEquals != null){
					currentGreater = currentGreater.nextEquals;
				
				}else{
					currentGreater = currentGreater.nextGreater;
				}
				return currentGreater.value;
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
