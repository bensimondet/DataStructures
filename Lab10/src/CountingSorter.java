public class CountingSorter{

	public static <T extends CountingSortable> void countingSort(T[] array) {

		

		/* Count frequencies of different Integers */
		int[] frequency = new int[T.keyMax-T.keyMin+1];
		for(int i = 0; i < array.length;i++){
			frequency[array[i].key() - T.keyMin]++;
		}

		/* Convert frequencies to indices */
		frequency[0]--;
		for(int i = 1; i < frequency.length; i++){
			frequency[i] += frequency[i-1];
		}

		/* Move values into a new array, using the indices calculated
		 * above to determine the proper locations */
		T[] sorted = (T[])(new CountingSortable[array.length]);
		for(int i = array.length-1; i > -1; i--){
			sorted[frequency[array[i].key() - T.keyMin]--] = array[i];
			// 			long form that we rewrote into single line above:			
			//			Integer value = array[i];
			//			int index = frequency[value - lowest]--;
			//			sorted[index] = value;
		}

		/* Copy back to the original array */
		System.arraycopy(sorted, 0, array, 0, array.length);

	}


}

