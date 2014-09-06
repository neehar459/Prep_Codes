import java.util.Arrays;
public class FindNextHighest {
	public static void main (String[] args) {
		int i = 1986;
		System.out.println("Next Bigger Number for 1986 : " +findNextHighest(1986));
	}
	public static int findNextHighest (int i) {
		if(i < 10){
			return i;
		} else if (i > 9 && i <= 99) {
			String s = String.valueOf(i);
			char[] c = s.toCharArray();
			char c1 = c[0];
			c[0] = c[1];
			c[1] = c1;
			return new Integer(new String(c)).intValue();
		} else {
			// Check if the number is a proper descending number
			String integer = String.valueOf(i);
			char[] cInt = integer.toCharArray();
			boolean isAscending = false;
			boolean isDescending = false;
			for(int i1=0; i1< cInt.length-1; i1++) {
				if(cInt[i1] < cInt[i1+1]) {
					isDescending = false;
					break;
				} else {
					isDescending = true;
				}
			}
			for(int j=0; j< cInt.length-1; j++) {
				if(cInt[j] > cInt[j+1]) {
					isAscending = false;
					break;
				} else {
					isAscending = true;
				}
			}
			if(isDescending) {
				return -1;
			}
			if(isAscending) {
				int i1 =cInt.length -1;
				int j1 = cInt.length -2;
				char ctemp = cInt[i1];
				// swap last 2 elements
				cInt[i1] = cInt[j1];
				cInt[j1] = ctemp;
				return new Integer(new String(cInt)).intValue();
			}
			if(!isAscending && !isDescending){
				// First from the last find the number which is less than the next number
				int pos = -1;
				int element = -1;
				for(int k = cInt.length-1; k>0; k--) {
					if(cInt[k-1] < cInt[k]){
						element = cInt[k-1];
						pos = k-1;
						break;
					} 
				}
				//System.out.println("Small element from right to left : "+cInt[pos] +" and position :  "+pos);
				// Find the next biggest number greater than element in the numbers right to the element
				int intMax = Integer.MAX_VALUE;
				int nextBigPos = -1;
				for(int l = pos; l < cInt.length; l++) {
					if(cInt[l] > element && cInt[l] < intMax) {
						intMax = cInt[l];
						nextBigPos = l;
					}
				}
				//System.out.println("Small element from right to left1 : "+cInt[nextBigPos] +" and position :  "+nextBigPos);
				// Swap pos and nextBigPos elements
				char c3 = cInt[pos];
				cInt[pos] = cInt[nextBigPos];
				cInt[nextBigPos] = c3;
				// Now sort all the next elements from pos
				String tempSearch = new String(cInt);
				String subStr = tempSearch.substring(pos+1);
				String firstPart = tempSearch.substring(0,pos+1);
				char [] cSub = subStr.toCharArray();
				Arrays.sort(cSub);
				subStr = new String(cSub);
				String returnString = firstPart+subStr;
				return new Integer(returnString).intValue();
			}
			return -1;
		}
	}
}