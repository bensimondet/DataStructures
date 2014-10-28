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
			Comparable[] leftHalf = new Comparable[arr.length / 2];
			for (int i = 0; i < arr.length / 2; i++) {
				leftHalf[i] = arr[i];
			}
			Comparable[] rightHalf = new Comparable[arr.length - leftHalf.length];
			for (int i = arr.length/2; i < arr.length; i++) {
				rightHalf[i - arr.length/2] = arr[i];
			}
			mergeSort(leftHalf);
			mergeSort(rightHalf);
			merge(arr, leftHalf, rightHalf);
		}
		
	}


	private static void merge(Comparable[] arr, Comparable[] leftHalf, Comparable[] rightHalf) {
		int nextIndex = 0;
		int leftIndex = 0;
		int rightIndex = 0;
		while(leftIndex < leftHalf.length && rightIndex < rightHalf.length){
			if (leftHalf[leftIndex].compareTo(rightHalf[rightIndex]) <= 0) {
				arr[nextIndex++] = leftHalf[leftIndex++];
				
			} else {
				arr[nextIndex++] = rightHalf[rightIndex++];
			}
		}
		if(leftIndex > leftHalf.length){
			for(int i = rightIndex; i < rightHalf.length; i++){
				arr[nextIndex++] = rightHalf[i]; 
			}
		}
		else{
			for(int i = leftIndex; i < leftHalf.length; i++){
				arr[nextIndex++] = leftHalf[i];
			}
		}
	}
}