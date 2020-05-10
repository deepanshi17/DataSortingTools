// SortTools.java 
/*
 * EE422C Project 1 submission by
 * Replace <...> with your actual data.
 * <Deepanshi Sharma>
 * <ds52384>
 * Spring 2020
 * Slip days used: 
 */

package assignment1;
public class SortTools {
	/**
	  * This method tests to see if the given array is sorted.
	  * @param x is the array
	  * @param n is the size of the input to be checked
	  * @return true if array is sorted
	  */
	public static boolean isSorted(int[] x, int n) {
		// stub only, you write this!
		// TODO: complete it
		int i = 0;
		if(n == 0) return false;
		if(x.length == 0) return false;
		while(i<(n-1)) {
			if(x[i] > x[i+1]) {
				return false;
			}
			i++;
		}
		return true;
	}

	/**
	 * This method returns the index of value v within array x.
	 * @param x is the array
	 * @param n is the size of the input to be checked
	 * @param v is the value to be searched for within x
	 * @return index of v if v is contained within x. -1 if v is not contained within x
	 */
	public static int find(int[] x, int n, int v) {
//		for(int i=0; i<n; i++) {
//			if(x[i] == v) {
//				return i;
//			}
//		}
		int mid = (n-1)/2;
		int i = 0;
		int last = n-1;
		while(i <= last) {
			if(x[mid] < v) {
				i = mid+1;
			}
			else if(x[mid] == v) {
				return mid;
			}
			else {
				last = mid-1;
			}
			mid = (i+last)/2;
		}
        return -1;
    }

	/**
	 * This method returns a newly created array containing the first n elements of x, and v.
	 * @param x is the array
	 * @param n is the number of elements to be copied from x
	 * @param v is the value to be added to the new array
	 * @return a new array containing the first n elements of x, and v
	 */
	public static int[] insertGeneral(int[] x, int n, int v){
		if(find(x, n, v) != -1) {
			int[] y = new int[n];
			for(int i=0; i<n; i++) {
				y[i] = x[i];
			}
			return y;
		}
		int i = 0;
		int j = 0;
		int[] y = new int[n+1];
		while (i <= n) {
			if (j<n && x[j] < v) {
				y[i] = x[j];
				i++; j++;
			}
			else {
				y[i] = v; i++;
				while(j < n) {
					y[i] = x[j];
					i++; j++;
				}
			}
		}

		
//		while(j < n) {
//			if(x[j] > v) {
//				y[i] = v;
//				i++;
//			}else {
//				y[i] = x[j];
//				i++; j++;
//			}
//		}
        return y;
    }

	/**
	 * This method inserts a value into the array and ensures it's still sorted
	 * @param x is the array
	 * @param n is the number of elements in the array
	 * @param v is the value to be added
	 * @return n if v is already in x, otherwise returns n+1
	 */
	public static int insertInPlace(int[] x, int n, int v){
		// stub only, you write this!
		int[] y = insertGeneral(x, n, v);
		if(y.length == n) {
			return n;
		}
		for(int i = 0; i <= n; i++) {
			x[i] = y[i];
		}
        return n+1;
    }

	/**
	 * This method sorts a given array using insertion sort
	 * @param x is the array to be sorted
	 * @param n is the number of elements of the array to be sorted
	 */
	public static void insertSort(int[] x, int n){
		int j = 0; int key;
		for(int i = 1; i < n; i++) {
			key = x[i];
			j = i-1;
			while(j >= 0 && key < x[j]) {
				x[j+1] = x[j];
				j -= 1;
			}
			x[j+1] = key;
		}
    }
}
