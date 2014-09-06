public class FindPointofChange {
	public static void main(String[] args) {
		int[] iArray = {1,2,3,4,5,4,2,1};
		int pos = findTurn(iArray);
		System.out.println("Element Position of Change : "+ pos + " and element : " + iArray[pos] );
	}
	public static int findTurn(int[] iArray) {
		if(iArray == null || iArray.length == 0) {
			return -1;
		} else {
			int start = 0;
			int end = iArray.length;
			int mid = -1;
			if(iArray.length == 1 || iArray.length == 2) {
				return Integer.MIN_VALUE;
			} 
			while (start <= end) {
				mid = start + (end- start)/2;
				if (mid == (iArray.length)){
					return -1;
				} else if (iArray[mid -1] < iArray[mid] && iArray[mid] > iArray[mid+1] ) {
					return mid;
				} else if (iArray[mid -1] < iArray[mid] && iArray[mid] < iArray[mid+1] ) {
					start = mid + 1;
				} else if (iArray[mid -1] > iArray[mid] && iArray[mid] > iArray[mid+1] ) {
					end = mid -1 ;
				}
			}
			return -1;
		}
	}
	
}
