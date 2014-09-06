public class MedianOfTwoSortedArrays {
	public static void main (String[] args) {
		int[] a = {1,12,15,26,38};
		int[] b = {2,13,17,30,45};
		System.out.println("Median of Two Sorted Arrays : " + findMedian(a,b));
	}
	public static int findMedian(int[] a, int[] b) {
		if(a == null || b == null){
			return -1;
		} else {
			int med1Pos = a.length/2;
			int med2Pos = b.length/2;
			if(a[med1Pos] == b[med2Pos]) {
				return a[med1Pos];
			} else {
				if(a[med1Pos] < b[med2Pos]) {
					
				} else {
					
				}
			}
		}
	}
}