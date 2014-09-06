public class FindElement{
	public static void main(String[] args){
		int[] iArray = {1,3,5,6,7,8,4,3,2,1,0};
		System.out.println("Position of 1 : "+findElement(0, iArray));
	}
	public static int findElement(int toFind, int[] iArray){
		if(iArray == null || iArray.length == 0){
			return -1;
		}else{
			int low = 0;
			int high = iArray.length-1;
			int mid = -1;
			while(low <= high){
				mid = low + ((high - low)/2);
				if(toFind == iArray[mid]){
					return mid;
				}else if(iArray[mid] < toFind){
					high = mid - 1;
				}else{
					low = mid + 1;
				}
			}
			return -1; 
		}
	}
}
