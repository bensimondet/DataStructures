//Aaron Lemmon and Ben Simondet
public class SortingMethods {
	/*
	 * sorts an array using insertion sort
	 */
	public static void insertionSort(Comparable[] arr) {

		for (int i = 1; i < arr.length; i++) {
			Comparable nextItem = arr[i];

			int j = i;
			while (j > 0 && nextItem.compareTo(arr[j - 1]) < 0) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = nextItem; 
		}
	}


	/*
	 * sorts an array using merge sort. The method is recursive. 
	 */
	public static void mergeSort(Comparable[] arr) {
		/* This creates the two new arrays that are needed at each call of mergeSort.
		 * Creating Comparable arrays and then casting them to T arrays is a bit of a 
		 * hack, but it works.
		 */
		if (arr.length > 1) {

			int leftArrayLength = arr.length / 2;
			Comparable[] leftHalf = new Comparable[leftArrayLength];
			Comparable[] rightHalf = new Comparable[arr.length - leftHalf.length];

			// Fill leftHalf
			for (int i = 0; i < leftArrayLength; i++) {
				leftHalf[i] = arr[i];
			}

			// Fill rightHalf
			for (int i = leftArrayLength; i < arr.length; i++) {
				rightHalf[i - leftArrayLength] = arr[i];
			}

			mergeSort(leftHalf);
			mergeSort(rightHalf);
			merge(arr, leftHalf, rightHalf);
		}
	}

	/*
	 * Merges two sorted arrays (leftHalf and rightHalf) together into a larger sorted array.
	 */
	private static void merge(Comparable[] arr, Comparable[] leftHalf, Comparable[] rightHalf) {
		
		int nextIndex = 0;
		int leftIndex = 0;
		int rightIndex = 0;
		/*
		 * Rebuilds the array until there is nothing left to sort
		 */
		while (leftIndex < leftHalf.length && rightIndex < rightHalf.length) {
			if (leftHalf[leftIndex].compareTo(rightHalf[rightIndex]) <= 0) {
				arr[nextIndex++] = leftHalf[leftIndex++];
			} else {
				arr[nextIndex++] = rightHalf[rightIndex++];
			}
		}
		/*
		 * Copy over the remaining portion of the array
		 */
		if (leftIndex == leftHalf.length) {
			for (int i = rightIndex; i < rightHalf.length; i++) {
				arr[nextIndex++] = rightHalf[i]; 
			}
		}
		else {
			for (int i = leftIndex; i < leftHalf.length; i++) {
				arr[nextIndex++] = leftHalf[i];
			}
		}
	} 
	
	/* Public method that can be called with just an array */
	public static <T extends Comparable<T>> void quickSort(T[] arr) {
			quickSortRecursive(arr, 0, arr.length - 1) ;
	}

	//Private method that can be called recursively
	private static <T extends Comparable<T>> void quickSortRecursive(T[] arr, int left, int right) {
		
		// Step 1: set up swap pointer index

		// Step 2: swap pivot with the last value in the subarray */
			
		// Step 3: partition (hint: you'll need a loop)

		// Step 4: Make the recursive calls
			
	}

	
}