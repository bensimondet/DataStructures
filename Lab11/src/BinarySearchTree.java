/*
 * Binary search tree stores values indexed by keys. Keys must be Comparable and
 * are organized based on their natural ordering (i.e. the ordering given by
 * their compareTo). Values can be of any object type. This tree implementation
 * is not balanced, i.e. it may behave as a linked list in the worst case. Keys
 * may not be repeated, but values can.
 */

public class BinarySearchTree<K extends Comparable<K>, V> {
	private BSTNode root = null;

	/*
	 * true if the tree is empty, false otherwise
	 */
	public boolean isEmpty() {
		return true;
	}


	/*
	 * Adds a given value indexed with a given key to the tree according to the
	 * binary search structure.  If the key is already present, this method throws
	 * a DuplicateKeyException.
	 */
	public void add(K key, V value) {

	}

	/*
	 * Returns the value associated with the given key in this binary search tree.
	 * If there is no element associated with this key, null is returned.
	 */
	public V get(K key) {
		return null;
	}

	/*
	 * Removes an element with the given key. The resulting tree is a binary
	 * search tree. If there is no such key, the tree is unchanged. Returns
	 * the value associated with this key or null if there is no such value. 
	 */
	public V remove(K key) {
		return null;
	}
	
	/*
	 * Clears all elements from the tree.
	 */
	public void clear() {
		
	}

	private class BSTNode {
		public K key;
		public V value;
		public BSTNode leftChild = null;
		public BSTNode rightChild = null;

		// null key will generate a null pointer exception when 
		// a method (such as compareTo) is called on it. 
		// This is matches the Java Collections Framework specification.
		public BSTNode(K key, V value) {
			this.key = key;
			this.value = value;
		}

	}
}