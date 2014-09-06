public class TestMergeSort{ // We need third array to store the sorted array
	public static void main(String[] args){
		int[] unSortedArray = {3,4,1,2,55,13,22,7,676,34};
		TestMergeSort tMSort = new TestMergeSort();
		tMSort.displayArray(unSortedArray);
		tMSort.mergeSort(unSortedArray);
		System.out.println("After Sorting");
		tMSort.displayArray(unSortedArray);
	}
	
	public void displayArray(int[] array){
		for(int i : array){
			System.out.print("--> "+i);
		}
		System.out.println(" ");
	}
	
	// Places the elements of the given array into sorted order
    // using the merge sort algorithm.
    // post: array is in sorted (nondecreasing) order
    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            // split array into two halves
            int[] left = leftHalf(array);
            int[] right = rightHalf(array);
            
            // recursively sort the two halves
            mergeSort(left);
            mergeSort(right);
            
            // merge the sorted halves into a sorted whole
            merge(array, left, right);
        }
    }
    
    // Returns the first half of the given array.
    public static int[] leftHalf(int[] array) {
        int lASize = array.length / 2;
        int[] leftArray = new int[lASize];
        for (int i = 0; i < lASize; i++) {
            leftArray[i] = array[i];
        }
        return leftArray;
    }
    
    // Returns the second half of the given array.
    public static int[] rightHalf(int[] array) {
        int mid = array.length / 2;
        int rASize = array.length - mid;
        int[] rightArray = new int[rASize];
        for (int i = 0; i < rASize; i++) {
            rightArray[i] = array[i + mid];
        }
        return rightArray;
    }
    
	
    public static void merge(int[] result, 
                             int[] left, int[] right) {
        int i = 0;   // index into left array
        int j = 0;   // index into right array
        
        for (int k = 0; k < result.length; k++) {
            if (j >= right.length || (i < left.length && 
                    left[i] <= right[j])) {
				result[k] = left[i];    // take from left
                i++;
            } else {
                result[k] = right[j];   // take from right
                j++;
            }
        }
    }	
}