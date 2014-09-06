public class StringReversal{
	public static void main(String[] args){
		String toReverseString = "madam";
		String reversedString = reverseString(toReverseString);
		System.out.println("Reversed String : "+reversedString);
	}
	public static String reverseString(String inputString){
		String reverseString = "";
		for(int i=inputString.length()-1; i >=0 ;i--){
			reverseString = reverseString.concat(String.valueOf(inputString.charAt(i)));
		}
		return reverseString;
	}
}