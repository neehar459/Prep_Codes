import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
public class SumEqualsK {
	public static void main (String[] args) {
		int[] iArray = { 1, 3 , 2 , 5 , 4, 6, 8};
		List<Pair> sumPairs = sumPairs(iArray, 7);
		for(Pair p : sumPairs) {
			System.out.println(p.toString());
		}
		System.out.println("-------------------------------------------------------");
		List<Pair> sumPairs1 = sumPairsHash(iArray, 7);
		for(Pair p1 : sumPairs1) {
			System.out.println(p1.toString());
		}
	}
	// Time = O(nlogn), Space = O(1)
	public static List<Pair> sumPairs (int[] iArray, int sum) {
		if(iArray == null || iArray.length == 0) {
			return null;
		} else {
			List<Pair> sumPairs = new ArrayList<Pair> ();
			Arrays.sort(iArray);
			int i = 0;
			int j = iArray.length -1;
			while (i < j) {
				if (iArray[i] + iArray[j] == sum) {
					sumPairs.add(new Pair(iArray[i], iArray[j]));
					j--;
				} else if (iArray[i] + iArray[j] < sum) {
					i++;
				} else {
					j--;
				}
			}
			return sumPairs;
		}
	}
	// Time = O(n) Space = O(n)
	public static List<Pair> sumPairsHash(int[] iArray, int sum) {
		if(iArray == null || iArray.length == 0) {
			return null;
		} else {
			List<Pair> sumPairs = new ArrayList<Pair> ();
			Map<Integer, Integer> hMap = new HashMap<Integer, Integer>();
			// First construct Map with Key as int value in the array and Value as (sum - int value)
			for(int i : iArray){
				hMap.put(i, i);
			}
			for(int i: iArray) {
				if(hMap.containsKey(sum - i)) {
					sumPairs.add(new Pair(i, (sum - i)));
				}
			}
			return sumPairs;
		}
	}
}
class Pair {
	int a;
	int b;
	public Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public Pair() {
		
	}
	public String toString() {
		return this.a + " ,  " + this.b;
	}
}