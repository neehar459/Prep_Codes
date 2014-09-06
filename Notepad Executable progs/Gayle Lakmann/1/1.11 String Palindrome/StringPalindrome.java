public class StringPalindrome{
	public static void main(String[] args){
		String toReverseString = "madam";
		System.out.println("Is string palindrome : "+isPalindrome(toReverseString));
	}
	
	public static boolean isPalindrome(String input){
		if(null == input){
			return false;
		}else if(input.length() == 1){
			return true;
		}else{
			String reverseString = "";
			for(int i=input.length()-1; i >=0 ;i--){
				reverseString = reverseString.concat(String.valueOf(input.charAt(i)));
			}
			if(reverseString.equalsIgnoreCase(input)){
				return true;
			}else{
				return false;
			}
		}
	}
}