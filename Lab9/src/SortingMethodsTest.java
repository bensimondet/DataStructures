import static org.junit.Assert.*;

import org.junit.Test;


public class SortingMethodsTest {

	@Test
	public void testEmpty() {
		String[] someStrings = {};
		String[] sorted = {};
		SortingMethods.quickSort(someStrings);
		assertArrayEquals(sorted, someStrings);
	}
	
	@Test
	public void testStrings() {
		String[] someStrings = {"Elephant", "Cat", "Dinosaur", "Arrays", "Bouyancy"};
		String[] sorted = {"Arrays", "Bouyancy", "Cat", "Dinosaur", "Elephant"};
		SortingMethods.quickSort(someStrings);
		assertArrayEquals(sorted, someStrings);
	}
	
	@Test
	public void testAlreadySorted() {
		String[] someStrings = {"Arrays", "Bouyancy", "Cat", "Dinosaur", "Elephant"};
		String[] sorted = {"Arrays", "Bouyancy", "Cat", "Dinosaur", "Elephant"};
		SortingMethods.quickSort(someStrings);
		assertArrayEquals(sorted, someStrings);
	}

	@Test
	public void testInts() {
		Integer[] someInts = {3, 5, 1, 0, -4, -10};
		Integer[] sortedInts = {-10, -4, 0, 1, 3, 5};
		SortingMethods.quickSort(someInts);
		assertArrayEquals(sortedInts, someInts);
	}
	
	@Test
	public void testOneElement() {
		Integer[] someInts = {3};
		Integer[] sortedInts = {3};
		SortingMethods.quickSort(someInts);
		assertArrayEquals(sortedInts, someInts);
	}
	
	@Test
	public void testReverse() {
		Integer[] someInts = {5, 3, 1, 0, -4, -10};
		Integer[] sortedInts = {-10, -4, 0, 1, 3, 5};
		SortingMethods.quickSort(someInts);
		assertArrayEquals(sortedInts, someInts);
	}
	
	@Test
	public void testAllSameValue() {
		Integer[] someInts = {5, 5, 5, 5, 5};
		Integer[] sortedInts = {5, 5, 5, 5, 5};
		SortingMethods.quickSort(someInts);
		assertArrayEquals(sortedInts, someInts);
	}
}
