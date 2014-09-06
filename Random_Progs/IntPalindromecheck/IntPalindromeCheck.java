public class IntPalindromeCheck{
	public static void main(String[] args){
		System.out.println("Is -121 Palindrome : " + isPalindromeIntIter(32123));
		System.out.println("Is -121 Palindrome No Space : " + isPalindromeIntNoSpace(32123));
	}
	public static boolean isPalindromeIntIter(int i){
		if ( i < 0) {
			return false;
		} else {
			int rem = 0;
			int rev = 0;
			int oldNum = i;
			while ( i > 0) {
				rem = i % 10;
				rev = rev * 10 + rem;
				i = i / 10 ;
			}
			if (rev != oldNum) {
				return false;
			} else { 
				return true;
			}
		}
	}
	public static boolean isPalindromeIntNoSpace ( int i) {
		if ( i < 0) {
			return false;
		} else {
			// First find number of zeroes in the number
			int zero = 1;
			while ( i / zero >= 10) { 
				zero = zero * 100;
			}
			int left = 0;
			int right = 0;
			while ( i != 0) {
				left = i / zero;
				right = i % 10 ;
				if (left != right) {
					return false;
				}
				i = (i % zero ) / 10;
				zero = zero / 100 ;
			}
			return true;
		}
	}
}