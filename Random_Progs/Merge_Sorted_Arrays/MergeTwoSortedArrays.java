public class MergeTwoSortedArrays {
	public static void main (String[] args) {
		int[] iArray = {1,3,5,7,10};
		int[] jArray = {2,4,6,8,10,12};
		int[] mergedArray = mergeArrays(iArray,jArray);
		for(int k : mergedArray) {
			System.out.print( k + " , ");
		}
		System.out.println();
	}
	public static int[] mergeArrays (int[] iArray, int[] jArray) {
		if(iArray == null || iArray.length == 0 && jArray == null || jArray.length == 0) {
			return null;
		} else if (iArray == null || iArray.length == 0) {
			return jArray;
		} else if (jArray == null || jArray.length == 0) {
			return iArray;
		} else {
			int[] newArray = new int[iArray.length + jArray.length];
			int i = 0;
			int j = 0;
			int k = 0;
			while ( i < iArray.length && j< jArray.length) {
				if ( iArray[i] <= jArray[j]) {
					newArray[k++] = iArray[i++];
				} else {
					newArray[k++] = jArray[j++];
				}
			}
			while(i < iArray.length) {
				newArray[k++] = iArray[i++];
			}
			while(j < jArray.length) {
				newArray[k++] = jArray[j++];
			}			
			return newArray;
		}
	}
}