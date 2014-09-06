import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
public class TripletSumK {
	public static void main(String[] args) {
		int[] iArray = { 1, 3 , 2 , 5 , 4, 6, 8};
		/* List<Pair> sumPairs = sumPairs(iArray, 9);
		for(Pair p : sumPairs) {
			System.out.println(p.toString());
		} 
		System.out.println("-------------------------------------------------------"); */
		List<Pair> sumPairs1 = sumPairsHash(iArray, 9);
		for(Pair p1 : sumPairs1) {
			System.out.println(p1.toString());
		}
	}
	public static List<Pair> sumPairsHash(int[] iArray, int k) {
		if(iArray == null || iArray.length == 0) {
			return null;
		} else {
			Arrays.sort(iArray);
			List<Pair> sumPairsList = new ArrayList<Pair>();
			for(int i=0; i< iArray.length; i++) {
				sumPairs(iArray, k, i, sumPairsList, iArray[i]);
			}
			return sumPairsList;
		}
	}
	public static List<Pair> sumPairs (int[] iArray, int sum, int startIndex, List<Pair> iList, int firstInt) {
		if(iArray == null || iArray.length == 0) {
			return null;
		} else {
			int i = startIndex+1;
			int j = iArray.length -1;
			while (i < j) {
				if (firstInt + iArray[i] + iArray[j] == sum) {
					iList.add(new Pair(firstInt, iArray[i], iArray[j]));
					j--;
				} else if (firstInt + iArray[i] + iArray[j] < sum) {
					i++;
				} else {
					j--;
				}
			}
			return iList;
		}
	}
}
class Pair {
	int a;
	int b;
	int c;
	public Pair(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public Pair() {
		
	}
	public String toString() {
		return this.a + " ,  " + this.b + " , " + this.c;
	}
}