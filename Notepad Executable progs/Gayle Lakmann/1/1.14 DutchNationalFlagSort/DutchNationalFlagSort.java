//http://www.csse.monash.edu.au/~lloyd/tildeAlgDS/Sort/Flag/
public class DutchNationalFlagSort{
	public static void main(String[] args){
		int[] unSortedArray = {0,1,1,0,1,2,1,2,0,0,1,2};
		threeWaySort(unSortedArray);
		for(int i : unSortedArray){
			System.out.print(i+", ");
		}
		System.out.println(" ");
	}
	public static void threeWaySort(int[] iArray){
		int low = 0;
		int current = 0;
		int high = iArray.length-1;
		while(current <= high){
			if(iArray[current] == 0){
				swap(iArray, low, current);
				low++;
				current++;
			}else if(iArray[current] == 2){
				swap (iArray, current, high);
				high--;
				
			}else{
				current++;
			}
		}
	}
	public static void swap (int[] iArray, int pos1, int pos2){
		int temp = iArray[pos1];
		iArray[pos1] = iArray[pos2];
		iArray[pos2] = temp;
	}
}