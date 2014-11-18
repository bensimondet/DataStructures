import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestBST {
	private BinarySearchTree<Integer,String> emptyTree;
	private BinarySearchTree<Integer,String> eightNodesTree;
	
	@Before
	public void setUp() {
		emptyTree = new BinarySearchTree<Integer,String>();
		eightNodesTree = new BinarySearchTree<Integer,String>();
		eightNodesTree.add(4, "apple");
		eightNodesTree.add(6, "banana");
		eightNodesTree.add(1, "strawberry");
		eightNodesTree.add(3, "kiwi");
		eightNodesTree.add(7, "lemon");
		eightNodesTree.add(10, "lime");
		eightNodesTree.add(5, "mango");
		eightNodesTree.add(8, "pear");
	}
	

	@Test
	public void TestEmpty() {
		assertTrue(emptyTree.isEmpty());
	}
	
	@Test
	public void TestNonEmpty() {
		emptyTree.add(4, "apple");
		assertFalse(emptyTree.isEmpty());
	}
	
	@Test (expected=DuplicateKeyException.class)
	public void TestDuplicateKey() {
		eightNodesTree.add(7, "guava");
	}

	@Test
	public void TestAddGetRoot() {
		emptyTree.add(4, "apple");
		assertEquals("apple", emptyTree.get(4));
	}
	
	@Test
	public void TestGetFromEmpty() {
		assertNull(emptyTree.get(4));
	}
	
	@Test
	public void TestGet() {
		assertEquals("strawberry", eightNodesTree.get(1));
		assertEquals("lemon", eightNodesTree.get(7));
	}	
	
	@Test
	public void TestGetNotThere() {
		assertNull(eightNodesTree.get(11));
	}	
	
	@Test (expected=NullPointerException.class)
	public void TestNullKey() {
		assertNull(eightNodesTree.get(null));
	}
	
	
	@Test
	public void TestClear() {
		eightNodesTree.clear();
		assertTrue(eightNodesTree.isEmpty());
		assertNull(eightNodesTree.get(4));
	}	
	
	@Test
	public void TestRemove(){
		eightNodesTree.remove(1);
		assertNull(eightNodesTree.get(1));
		eightNodesTree.remove(3);
		assertNull(eightNodesTree.get(3));
		eightNodesTree.remove(8);
		assertNull(eightNodesTree.get(8));
	}
}