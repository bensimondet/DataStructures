import java.util.Iterator;

public class MySortingList<E extends Comparable<E>> implements SortingList<E>, Iterable<E> {
	int listCount = 0;
	int valueCount = 0;
	Node head = null;
	
	@Override
	public Iterator<E> iterator() {
		return new SortingListIterator();
	}

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
		Node current = head;
		for(int i = 0; i < size(); i++){
			if(item.compareTo(current.value()) < 0){
				current = nextNode;
			}
		}

	}

	@Override
	public int frequencyOf(E item) {
		int frequencyCount = 0;
		for(int i = 0; i < size(); i++){
			try {
				if(item.compareTo(get(i)) == 0){
					frequencyCount ++;
					frequencyCount = frequencyCount + Current.matches();
				}
			} catch (ListIndexOutOfBoundsException e) {
				//Should never get here
			}
		}
		return frequencyCount;
	}

	@Override
	public E get(int index) throws ListIndexOutOfBoundsException {
		checkIndex(index,  false);
		Node current = findNode(index);
		return current.value;
	}

	@Override
	public void remove(int index) throws ListIndexOutOfBoundsException {
		// TODO Auto-generated method stub

	}
	
	private void checkIndex(int index, boolean adding) throws ListIndexOutOfBoundsException {
		if (((index >= listCount && !adding) || (index > listCount && adding)) || index < 0) {
			throw new ListIndexOutOfBoundsException("The index " + index + " is outside the range of the list.");
		}
	}
	private Node findNode(int index) {
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.nextNode;
		}
		return current;
	}
	@Override
	public void clear() {
		head = null;

	}
	private class Node {
		Node nextNode;
		E value;
		int matches;
		
		public Node(Node next, E value, int matches){
			this.nextNode = next;
			this.value = value;
			this.matches = matches;
		}
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
			next = next.nextNode;
			return toReturn;
		}
		@Override
		public void remove(){
			throw new UnsupportedOperationException();
		}
		
	}

}
