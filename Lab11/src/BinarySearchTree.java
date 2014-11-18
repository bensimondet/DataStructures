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
		return root == null;
	}


	/*
	 * Adds a given value indexed with a given key to the tree according to the
	 * binary search structure.  If the key is already present, this method throws
	 * a DuplicateKeyException.
	 */
	public void add(K key, V value) {
		if (root == null){
			root = new BSTNode(key, value);
		}
		BSTNode current = root;
		boolean done = false;
		while(!done){
			if(key.compareTo(current.key) < 0){
				if(current.leftChild == null){
					current.leftChild = new BSTNode(key, value);
					done = true;
				}else if(key.compareTo(current.key) == 0){
					throw new DuplicateKeyException(key);
				}else{
					current = current.leftChild;
				}
			}
			else{
				if(current.rightChild == null){
					current.rightChild = new BSTNode(key, value);
					done = true;
				}else if(key.compareTo(current.key) == 0){
					throw new DuplicateKeyException(key);
				}else{
					current = current.rightChild;
				}
			}
		}
	}

	/*
	 * Returns the value associated with the given key in this binary search tree.
	 * If there is no element associated with this key, null is returned.
	 */
	public V get(K key) {
		if (root == null){
			return null;
		}
		BSTNode current = root;
		while(current.key != null && current.key.compareTo(key) != 0){
			if(key.compareTo(current.key) < 0){
				current = current.leftChild;
			}else{
				current = current.rightChild;
			}
		}if(current.key == null){
			return null;		
		}else{	
			return current.value;
		}
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
		root = null;
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