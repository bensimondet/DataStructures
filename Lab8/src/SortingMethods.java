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
		Comparable[] leftHalf = new Comparable[arr.length / 2];
		Comparable[] rightHalf = new Comparable[arr.length - leftHalf.length];
		
	}
}