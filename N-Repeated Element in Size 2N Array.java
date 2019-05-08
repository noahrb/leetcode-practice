/**
 * In a arry "A" size "2N", there are N+1 Unique elements, and exactly one of these elemtns is repeated N times.
 * 
 * Return the element repeated N Times
 */


class Solution {
    public int repeatedNTimes(int[] A) {
        Integer

        return 0;
    }

    	/**
	 * Sorts the input array using Shellsort and a provided comparator.
	 * 
	 * @param input Generic type array to be sorted.
	 * @param cmp   Comparator passed in to determine the sort.
	 */
	public static <T> void shellSort(T[] input, Comparator<? super T> cmp) {
		for (int gapSize = input.length / 2; gapSize > 0; gapSize /= 2) {
			for (int i = gapSize; i < input.length; i++) {
				T inputI = input[i];
				int j;

				for (j = i - gapSize; j >= 0 && cmp.compare(input[j], inputI) > 0; j -= gapSize) {
					input[j + gapSize] = input[j];
				}
				input[j + gapSize] = inputI;
			}
		}
    }
    
    //Integer Comparator
class IntegerComparator implements Comparator<Integer> {

	/**
	 * 2 input integers. Compares them. Returns -1 if left < right, returns 1 if
	 * left > right, and 0 if they equal.
	 */
	@Override
	public int compare(Integer o1, Integer o2) {
		return o1.compareTo(o2);
	}
}
}