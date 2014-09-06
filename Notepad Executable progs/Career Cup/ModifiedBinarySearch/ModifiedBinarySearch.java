// http://www.careercup.com/question?id=5152384183435264
public class ModifiedBinarySearch{
	public static void main(String [] args){
		int[] rotSortArray = {6,7,8,9,1,2,3,4,5};
		int result = findElementNew(rotSortArray, 5);
		//int result = findElement(rotSortArray, 5);
		System.out.println("position of  5 : "+result);
		int arr[] = {7,8,9,10,11,13,24,2,3,4,5,6};
		int min = findMin(arr,0,arr.length-1);
		System.out.println("min : "+arr[min]);
		//int arr1[] = {1,3,5,7,9,11};
		//int nextBig = findNextBig(arr1,8);
		//System.out.println("nextBig index: "+nextBig);
	}
	public static int findElementNew(int[] array, int key){
		if(array.length == 0){
			 throw new IllegalArgumentException("Array is of length 0");
		}else{
			int low = 0;
			int high = array.length -1;
			while(low <= high){
				int mid = low + ((high - low)/2);
				if(key == array[mid]){
					return mid;
				}
				if(array[low] < array[mid]){
					if(key < array[mid] && array[low] <= key){
						high = mid-1;
					}else{
						low = mid+1;
					} 
				}
				if(array[mid] < array[high]){
					if(key <= array[high] && array[mid] < key){
						low = mid+1;
					} else{
						high = mid-1;
					} 
				}
			}
			return -1;
		}
	}
	
	public static int findElement(int[] array, int key){
		int low = 0;
		int high = array.length-1;
		while(low <=high){
			int mid = low + (high - low)/2;
			if(array[mid] == key){
				return mid;
			}
			if(array[low] < array[high]){
				if(array[low] <= key && key < array[mid]){
					high = mid -1;
				}else{
					low = mid +1;
				}
			}else{
				if(array[mid]<key && key <= array[high]){
					low = mid +1;
				}else{
					high = mid -1;
				}
			}
		}
		return -1;
	}
	// http://www.confusedcoders.com/data-structures/find-minimum-element-in-rotated-sorted-array-modified-binary-search
	public static int findMin(int[] array, int low, int high){
		if(low > high){
			return-1;
		}
		if(array[low] > array[high]){
			int mid = (low + high)/2;
			if(array[mid] > array[high]){
				return findMin(array, mid+1, high);
			}else{
				return findMin(array, low, mid);
			}
		}
		return low;
	}
	
	//http://stackoverflow.com/questions/16219998/modify-binary-search-to-find-the-next-bigger-item-than-the-key
	public static int findNextBig(int[] array,int goal){
		return binSearchNext(array,goal);
	}
	private static int binSearch(int[] array, int key){
		int low = 0;
		int high = array.length-1;
		int mid =0;
		while(low <= high){
			mid = low +(high - low) /2;
			if(array[mid] == key){
				return mid;
			}else if(array[mid] < key){
				low = mid+1;
			}else{
				high = mid-1;
			}
		}
		return mid;
	}
	private static int binSearchNext(int[] array, int key){
		int pos = binSearch(array,key);
		System.out.println("pos : "+pos);// +", element : "+array[pos]);
		if(pos > 0){
			return pos+1;
		}else{
			if(key < array[0]){
				return 0;
			}else if(key > array[array.length -1]){
				return array.length+1;
			}else{
				return pos+1;
			}
		}
	}
}