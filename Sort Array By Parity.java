import java.util.Comparator;

class Solution {
    public int[] sortArrayByParity(int[] A) {
        //Linked list practice
        insertionSort(A, new ParityComparator());

        return A;
    }
	/**
     * Sorts the input array using insertion sort and the input Comparator.
     * 
     * @param a                Array to be sorted
     * @param parityComparator Comparator used to compare.
     */
    public static void insertionSort(int[] a, ParityComparator parityComparator) {

        for (int i = 1; i < a.length; i++) {
            int inputI = a[i];
            int j;

            for (j = i; j > 0; j--) {
                int tCompare = parityComparator.compare(inputI, a[j - 1]);
                if (tCompare >= 0) {
                    break;
                }
                a[j] = a[j - 1];
            }
            a[j] = inputI;
		}
    }
}
    //Integer Comparator
class ParityComparator implements Comparator<Integer> {

	/**
	 * 2 input integers. Compares them. Returns returns 1 if
	 * even, and 0 if they odd.
	 */
	@Override
	public int compare(Integer o1, Integer o2) {
        if(o1 % 2 == 0) {
            return -1;
        } else {
            return 1;
        }
	}
}
