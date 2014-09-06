public class SelectionSort {
	public static void main(String[] args) {
		int[] unSorted = {4,-1,3,-2,5};
		int[] sorted = selectionSort(unSorted);
		for (int i : sorted) {
			System.out.print(i + " , ");
		}
		System.out.println();
	}
	public static int[] selectionSort (int[] iArray) {
		if(iArray == null || iArray.length == 0) {
			return null;
		} else {
			int size = iArray.length;
			int min = 0;
			int outerCounter;
			int innerCounter;
			int temp;
			for(outerCounter=0; outerCounter < size; outerCounter++) {
				min = outerCounter;
				// Find min index in this iteration
				for (innerCounter =outerCounter+1; innerCounter < size -1; innerCounter ++) {
					if(iArray[innerCounter] < iArray[min]) {
						min = innerCounter;
					}
				}
				// Swap min element and outerCounter element
				temp = iArray[min];
				iArray[min] = iArray[outerCounter];
				iArray[outerCounter] = temp;
			}
			return iArray;
		}
	}
}