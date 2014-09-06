// Find element which occurs more than n/2 times in an array
public class MajorityCountNum {
	public static void main (String[] args) {
		int[] iArray = {5,2,2,4,2,8,2,7,2,9,2,4,3};
		System.out.println("Majority Count number : " + findMajority(iArray));
	}
	public static int findMajority (int[] iArray) {
		if(iArray == null || iArray.length == 0){
			return Integer.MIN_VALUE;
		} else {
			int count = 0;
			int ele = -1;
			for (int i=0; i < iArray.length; i++) {
				if(count == 0) {
					ele = iArray[i];
					count = 1;
				} else if (ele == iArray[i]) {
					count ++;
				} else {
					count -- ;
				}
			}
			return ele;
		}
	}
}