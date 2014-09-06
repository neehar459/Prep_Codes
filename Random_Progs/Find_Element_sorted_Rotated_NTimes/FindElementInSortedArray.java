// Find Element in an array rotated n times
public class FindElementInSortedArray{
	public static void main (String[] args) {
		int[] iArray = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		System.out.println("Position of 21 : "+findPos(iArray,21));
	}
	public static int findPos(int[] iArray, int data) {
		if(iArray == null || iArray.length == 0) {
			return -1;
		} else {
			int low = 0;
			int high = iArray.length-1;
			int mid = -1;
			while(low < high) {
				mid = low + ((high - low) / 2);
				if(iArray[mid] == data) {
					return mid;
				}
				if(iArray[low] <= iArray[mid]) {
					if(iArray[low] <= data && data < iArray[mid]) {
						high = mid - 1;
					} else {
						low = mid + 1;
					}
				} else {
					if(iArray[mid] < data && data <= iArray[high]) {
						low = mid + 1;
					} else {
						high = mid - 1;
					}
				}
				
			}
			return -1;
		}
	}
}