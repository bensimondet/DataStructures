import java.util.Random;

/*
***Testing Integer Arrays of 100,000 Integers***
For Insertion Sort the comparisonCount is 2495592099 and the timeElapsed is 14507 ms.
For Merge Sort     the comparisonCount is 1536595 and the timeElapsed is 54 ms.
For Quick Sort     the comparisonCount is 1999964 and the timeElapsed is 45 ms.
***Testing String Arrays of 100,000 Strings***
For Insertion Sort the comparisonCount is 2506330666 and the timeElapsed is 92258 ms.
For Merge Sort     the comparisonCount is 1536498 and the timeElapsed is 140 ms.
For Quick Sort     the comparisonCount is 1963923 and the timeElapsed is 68 ms.
 */

public class CompareSortingMethods {
	
	public static void main(String[] args) {
		/*
		 *  for the first argument of testTime, sort type:
		 *  1 = insertion sort
		 *  2 = merge sort
		 *  3 = quick sort
		 */
		System.out.println("***Testing Integer Arrays of 100,000 Integers***");
		Integer[] randomInts1 = randomIntArray(100000);
		Integer[] randomInts2 = randomInts1.clone();
		Integer[] randomInts3 = randomInts1.clone();
		
//		testTime(1, randomInts1);
//		testTime(2, randomInts2);
//		testTime(3, randomInts3);
		
		System.out.println("***Testing String Arrays of 100,000 Strings***");
		String[] randomStrings1 = randomStringArray(100000);
		String[] randomStrings2 = randomStrings1.clone();
		String[] randomStrings3 = randomStrings1.clone();
		
//		testTime(1, randomStrings1);
//		testTime(2, randomStrings2);
//		testTime(3, randomStrings3);
		
		System.out.println("***Testing Integer Arrays of 1,000,000 Integers***");
		randomInts1 = randomIntArray(1000000);
		randomInts2 = randomInts1.clone();
		randomInts3 = randomInts1.clone();
		
		testTime(1, randomInts1);
		testTime(2, randomInts2);
		testTime(3, randomInts3);
		
		System.out.println("***Testing String Arrays of 1,000,000 Strings***");
		randomStrings1 = randomStringArray(1000000);
		randomStrings2 = randomStrings1.clone();
		randomStrings3 = randomStrings1.clone();
		
//		testTime(1, randomStrings1);
		testTime(2, randomStrings2);
		testTime(3, randomStrings3);
	}

	private static <T extends Comparable<T>> void testTime(int sortType, T[] arr ) {
		SortingMethods.comparisonCount = 0;
		
		if (sortType == 1) {
			long startTime = System.currentTimeMillis();
			SortingMethods.insertionSort(arr);
			long timeElapsed = System.currentTimeMillis() - startTime;
			System.out.println("For Insertion Sort the comparisonCount is " + SortingMethods.comparisonCount + " and the timeElapsed is " + timeElapsed + " ms.");
		} 
		else if (sortType == 2) {
			long startTime = System.currentTimeMillis();
			SortingMethods.mergeSort(arr);
			long timeElapsed = System.currentTimeMillis() - startTime;
			System.out.println("For Merge Sort     the comparisonCount is " + SortingMethods.comparisonCount + " and the timeElapsed is " + timeElapsed + " ms.");
		}
		else if (sortType == 3) {
			long startTime = System.currentTimeMillis();
			SortingMethods.quickSort(arr);
			long timeElapsed = System.currentTimeMillis() - startTime;
			System.out.println("For Quick Sort     the comparisonCount is " + SortingMethods.comparisonCount + " and the timeElapsed is " + timeElapsed + " ms.");
		}
		else {
			System.out.println("@JoeBeaverWeBrokeIt");
		}
		
		
	}
	
	public static Integer[] randomIntArray(int arrayLength) {
		Random rand = new Random();
		Integer[] randomInts = new Integer[arrayLength];
		
		for (int i = 0; i < arrayLength; i++) {
			randomInts[i] = rand.nextInt();
		}
		
		return randomInts;
	}
	
	public static String[] randomStringArray(int arrayLength) {
		Random rand = new Random();
		String[] randomStrings = new String[arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			StringBuilder makeString = new StringBuilder();
			for(int j = 0; j < rand.nextInt(100) + 1; j++){
				char nextChar = (char)(rand.nextInt('z' - 'A' + 1) + 'A');
				makeString.append(nextChar);
			}
			randomStrings[i] = makeString.toString(); //('z' - 'A');
		}
		return randomStrings;
	}
}