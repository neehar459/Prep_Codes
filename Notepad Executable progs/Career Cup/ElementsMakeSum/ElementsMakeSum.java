import java.util.Map;
import java.util.HashMap;
public class ElementsMakeSum{
	public static void main(String[] args){
		int[] iArray = {1,7,2,4,5,2,3,9,1,6};
		int kSum = 7;
		displayPairs(iArray,kSum);
	}
	public static void displayPairs(int[] iArray, int kSum){
		// Using extra space complexity O(n) for using HashMap
		Map<Integer,Integer> iMap = new HashMap<Integer,Integer>();
		Map<Integer,Integer> solMap = new HashMap<Integer,Integer>();
		for(int i : iArray){
			if(!iMap.containsKey(i)){
				iMap.put(i,i);
			}
		}
		for(int i : iMap.keySet()){
			if(iMap.containsKey(kSum-i)){
				if(!solMap.containsKey(kSum - i)){
					solMap.put(i,kSum-i);
					System.out.println("Pair : (" + i +", "+(kSum - i)+")");
				}
			}
		}
	}
	
	
}