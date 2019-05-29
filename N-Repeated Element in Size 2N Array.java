/**
 * In a arry "A" size "2N", there are N+1 Unique elements, and exactly one of these elemtns is repeated N times.
 * 
 * Return the element repeated N Times
 */
import java.util.Comparator;
import java.util.HashMap;

class Solution {
    public int repeatedNTimes(int[] A) {
        shellSort(A, new IntegerComparator());
		// mergeSort(A, 0, A.length-1);
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < A.length; i++) {
            if(map.containsKey(A[i])) {
                int val = map.get(A[i]);
                map.put(A[i], val);
            } else {
                map.put(A[i], 1);
            }
        }
        int length = A.length;
        for(int i = 0; i < A.length; i++) {
            if(map.get(A[i]).equals(length/2))
                return A[i];
        }
        return 0;
    }

    // Main function that sorts arr[l..r] using 
    // merge() 
    void mergeSort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            mergeSort(arr, l, m); 
            mergeSort(arr , m+1, r); 
  
            // Merge the sorted halves 
            sort(arr, l, m, r); 
        } 
	} 
	
	public void sort(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
    	/**
	 * Sorts the input array using Shellsort and a provided comparator.
	 * 
	 * @param input Generic type array to be sorted.
	 * @param cmp   Comparator passed in to determine the sort.
	 */
	public static void shellSort(int[] input, IntegerComparator cmp) {
		for (int gapSize = input.length / 2; gapSize > 0; gapSize /= 2) {
			for (int i = gapSize; i < input.length; i++) {
				int inputI = input[i];
				int j;

				for (j = i - gapSize; j >= 0 && cmp.compare(input[j], inputI) > 0; j -= gapSize) {
					input[j + gapSize] = input[j];
				}
				input[j + gapSize] = inputI;
			}
		}
    }
    
	/* A utility function to print array of size n */
	static void printArray(int arr[]) 
	  { 
		  int n = arr.length; 
		  for (int i=0; i<n; ++i) 
			  System.out.print(arr[i] + " "); 
		  System.out.println(); 
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
