public class WordReversalInString{
	public static void main(String[] args){
		String toReverse = "Welcome to the Algorithms";
		String reversedWordString = reverseWordsInString(toReverse);
		System.out.println("Reversed Words in String :"+reversedWordString);
	}
	public static String reverseWordsInString(String inputString){
		if(inputString == null){
			return null;
		}else if(inputString.length() == 1){
			return inputString;
		}else{
			return reverseWords(inputString.toCharArray(),0,inputString.length()-1);
		}
	}
	private static String reverseWords(char[] array, int startPos, int endPos){
		reverse(array,startPos,endPos);
		int spaceStart = 0;
		int spaceEnd = 0;
		for(int i=0;i< array.length; i++){
			if(array[i] == ' '){
				spaceEnd = i-1;
				reverse(array,spaceStart,spaceEnd);
				spaceStart = i+1;
			}
		}
		spaceEnd = array.length-1;
		reverse(array,spaceStart,spaceEnd);
		return new String(array);
	}
	private static void reverse(char[] array, int startPos, int endPos){
		int midPos = (startPos+endPos)/2;
		while(startPos <= midPos){
			char temp = array[endPos];
			array[endPos] = array[startPos];
			array[startPos] = temp;
			startPos++;
			endPos--;
		}
	}
}