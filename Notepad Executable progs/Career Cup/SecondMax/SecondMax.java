import java.util.*;
public class SecondMax{
	public static void main(String[] args){
		int[] iArray = {3,5,1,1,2,4,34,6,7,34,65,8};
		findSecondMax(iArray);
		findSecondMaxOther(iArray);
	}
	
	public static int findSecondMax(int[] iArray){
	
		if(iArray.length == 0){
			return Integer.MIN_VALUE;
		}else{
			int firstMax = Integer.MIN_VALUE;
			for(int i=0; i < iArray.length; i++){
				if(firstMax < iArray[i]){
					firstMax = iArray[i];
				}
			}
			System.out.println("firstMax : "+firstMax);
			int secondMax = Integer.MIN_VALUE;
			for(int i=0; i < iArray.length; i++){
				if(secondMax < iArray[i]){
					if(iArray[i]!= firstMax){
						secondMax = iArray[i]; 
					}
				}
			}
			System.out.println("secondMax : "+secondMax);
			return secondMax;
		}
	}
	
	public static int findSecondMaxOther(int[] iArray){
		int firstMax = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		List<Integer> intList = new ArrayList<Integer>();
		for(int i : iArray){
			if(!intList.contains(i)){
				intList.add(i);
			}
		}
		for(int i : intList){
			if(firstMax < i){
				secondMax = firstMax;
				firstMax = i;
			}else if(secondMax < i){
				secondMax = i;
			}
		}
		System.out.println("Second Max : "+secondMax);
		return secondMax;
	}
}