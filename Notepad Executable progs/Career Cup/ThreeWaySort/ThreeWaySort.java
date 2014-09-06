// http://www.careercup.com/question?id=21037663
public class ThreeWaySort{
	public static void main(String[] args){
		int[] toSort = {0,-1,-2,2,0,3,5};
		int key = 0;
		threeWaySort(toSort, key);
		for(int i : toSort){
			System.out.print(i+" , ");
		}
		System.out.print("  ");
	}
	public static void threeWaySort(int[] array, int key){
		int low =0;
		int high = array.length -1;
		int currentIndex =0;
		while(currentIndex <= high){
			if(array[currentIndex] < key){
				swap(array, currentIndex++, low++);
			}else if (array[currentIndex] > key ){
				swap(array, currentIndex, high --);
			}else{
				currentIndex++;
			}
		}
	}
	public static void swap(int[] array, int pos1, int pos2){
		int temp = array[pos1];
		array[pos1] = array[pos2]; 
		array[pos2] = temp;
	}
}