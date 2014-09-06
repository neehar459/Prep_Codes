public class MergeMPlusNSize {
		int[] iArray = {1, 3, 5, 7, 0, 0 , 0 ,0, 0 };
	public static void main(String[] args) {
		int[] jArray = {2,4,6,8,10};
		iArray = mergeSortedArrays(iArray,jArray);
		for(int i : iArray) {
			System.out.print(i + " , ");
		}
		System.out.println();
	}
	public static int[] mergeSortedArrays (int[] iArray, int[] jArray) {
		if(iArray == null || iArray.length == 0) {
			return jArray;
		} else if (jArray == null || jArray.length == 0) {
			return iArray;
		} else {
			int i = iArray.length - jArray.length - 1;
			int j = jArray.length - 1;
			int k = iArray.length -1;
			for(; k >=0; k--) {
				if(iArray[i] <= jArray[j]) {
					iArray[k] = jArray[j];
					j--;
					if(j < 0) {
						break;
					}
				} else {
					iArray[k] = iArray[i];
					i--;
				}
			}
			return iArray;
		}
	}
}

