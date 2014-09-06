public class StringReversal{
	public static void main(String[] args){
		String toReverse = "Welcome to Algorithms";
		String reversedString = reverseString(toReverse);
		System.out.println("reversedString : "+reversedString);
	}
	
	public static String reverseString(String inputString){
		if(null == inputString){
			return null;
		}else{
			return reverse(inputString.toCharArray(), 0, inputString.length()-1);
		}
	}
	
	private static String reverse(char[] array, int startPos, int endPos){
		int midPos = array.length/2;
		while(startPos <= midPos){
			char temp = array[endPos];
			array[endPos] = array[startPos];
			array[startPos] = temp;
			startPos++;
			endPos--;
		}
		return new String(array);
	}
}