public class TestMySortingList{
	
	public static void main(String[] args) throws ListIndexOutOfBoundsException{
		testIsEmpty();
		testSize();
		testUniqueValueCount();
		testAdd();
		testGetAndAdd();
		testFrequencyOf();
		testRemove();
		testClear();
	}
	public static void testIsEmpty(){
		System.out.println("Testing isEmpty method...");
		MySortingList<Integer> test = new MySortingList<Integer>(); 
		System.out.println(test.isEmpty());
		test.add(1);
		test.add(2);
		System.out.println(!test.isEmpty());
	}
	public static void testSize(){
		System.out.println("Testing size method...");
		MySortingList<Integer> test = new MySortingList<Integer>(); 
		System.out.println(test.size() == 0);
		test.add(1);
		test.add(2);
		System.out.println(test.size() == 2);
	}
	public static void testUniqueValueCount(){
		System.out.println("Testing uniqueValueCount method...");
		MySortingList<Integer> test = new MySortingList<Integer>();
		System.out.println(test.uniqueValueCount()==0);
		test.add(1);
		test.add(1);
		test.add(1);
		System.out.println(test.uniqueValueCount()==1);
	}
	private static void testGetAndAdd() throws ListIndexOutOfBoundsException {
		System.out.println("Testing get and add methods...");
		MySortingList<Integer> test = new MySortingList<Integer>();
		test.add(2);
		test.add(1);
		test.add(1);
		test.add(1);
		System.out.println(test.get(1)==2);
		System.out.println(test.size()==4);
		
	}
	public static void testAdd(){
		System.out.println("Testing add method...");
		MySortingList<Integer> test = new MySortingList<Integer>();
		test.add(2);
		test.add(4);
		test.add(1);
		test.add(1);
		System.out.println(test.size()==4);
	}
	private static void testFrequencyOf() throws ListIndexOutOfBoundsException {
		System.out.println("Testing frequencyOf method...");
		MySortingList<Integer> test = new MySortingList<Integer>();
		test.add(2);
		test.add(1);
		test.add(1);
		test.add(1);
		System.out.println(test.get(0));
		System.out.println(test.frequencyOf(1) == 3);
	}
	private static void testRemove() throws ListIndexOutOfBoundsException{
		System.out.println("Testing remove method...");
		MySortingList<Integer> test = new MySortingList<Integer>();
		test.add(2);
		test.add(1);
		test.add(1);
		test.add(1);
		System.out.println(test.size() == 4);
		test.remove(0);
		System.out.println(test.size() == 3);
	}
	private static void testClear() {
		System.out.println("Testing clear method...");
		MySortingList<Integer> test = new MySortingList<Integer>();
		test.clear();
		test.add(1);
		test.add(2);
		test.add(1);
		test.clear();
		System.out.println(test.size()==0);
	}
}