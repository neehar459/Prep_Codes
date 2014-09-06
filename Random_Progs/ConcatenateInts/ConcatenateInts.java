public class ConcatenateInts	{
	public static void main (String[] args) {
		System.out.println("Concatenate value of inputs is : " + concatenateInts(93, -125));
	}
	public static int concatenateInts (int a, int b) {
		boolean isNegative = false;
		if ( a < 0 && b < 0) {
			return -1;
		}
		if ( a < 0 || b < 0) {
			isNegative = true;
			if ( a < 0 ) { 
				a = a * -1;
			}
			if ( b < 0 ) { 
				b = b * -1;
			}			
		} 
		int temp = b;
		while (temp > 0) {
			temp = temp / 10;
			a = a * 10;
		}
		a = a + b;
		if ( isNegative ) {
			a = a * -1;
		}		
		return a;
	}
}