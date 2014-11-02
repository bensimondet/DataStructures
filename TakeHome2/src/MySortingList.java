import java.util.Iterator;

public class MySortingList<E extends Comparable<E>> implements SortingList<E>, Iterable<E> {
	int listCount = 0;
	int valueCount = 0;
	Node head = null;
	

	@Override
	public boolean isEmpty() {
		return head == null;
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
		if(size()==0){
			head = new Node(null, null, item);
			listCount++;
			valueCount++;
			return;
		}
		//adding anywhere else
		Node placement = findPlacement(item);
		//if they are the same, add to minor section of list
		if(placement.value.compareTo(item) == 0 && placement.value != null){
			placement.nextMinor = new Node(null, null, item);
			listCount ++;
		}
		//if there are no matches, add a new value to the list
		else{
			placement.nextMajor = new Node(placement.nextMajor,null, item);
			listCount++;
			valueCount++;
		}
	}

	@Override
	public int frequencyOf(E item) {
		int frequencyCount = 0;
		for(int i = 0; i < size(); i++){
			try {
				if(item.compareTo(get(i)) == 0){
					frequencyCount ++;
				}
			} catch (ListIndexOutOfBoundsException e) {
				//Should never get here
			}
		}
		return frequencyCount;
	}

	@Override
	public E get(int index) throws ListIndexOutOfBoundsException {
		Node current = findNode(index);
		return current.value;
	}

	@Override
	public void remove(int index) throws ListIndexOutOfBoundsException {
		// TODO Auto-generated method stub

	}
	private Node findPlacement(E item){
		Node placement = head;
		while(placement.nextMajor != null && placement.value.compareTo(item) <=0){
			placement = placement.nextMajor;
		}
		if(placement.value != null && placement.value.compareTo(item) == 0){
			while(placement.nextMinor != null){
				placement = placement.nextMinor;
			}
		}
		return placement;
	}
	
	private Node findNode(int index) {
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.nextMajor;
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
		Node nextMajor;
		Node nextMinor;
		E value;
		
		public Node(Node nextMajor, Node nextMinor, E value){
			this.nextMajor = nextMajor;
			this.nextMinor = nextMinor;
			this.value = value;
		}
	}
	
	@Override
	public Iterator<E> iterator() {
		return new SortingListIterator();
	}
	
	private class SortingListIterator implements Iterator<E>{
		Node next = head;
		
		@Override
		public boolean hasNext() {
			return next != null;
			}

		@Override
		public E next() {
			E toReturn = next.value;
			next = next.nextMajor;
			return toReturn;
		}
		
		@Override
		public void remove(){
			throw new UnsupportedOperationException();
		}
		
	}

}
