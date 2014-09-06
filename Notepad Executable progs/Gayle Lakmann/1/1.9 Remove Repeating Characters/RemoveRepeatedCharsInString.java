import java.lang.*;
import java.util.*;
public class RemoveRepeatedCharsInString{
	public static void main(String[] args){
		String repeatString = "neehar mandaram";
		String deletedString = removeRepeatChars(repeatString);
		System.out.println("Deleted Chars String : "+deletedString);
	}
	public static String removeRepeatChars(String input){
		// O(n) solution
		boolean[] bArray = new boolean[256];
		StringBuffer sBuffer = new StringBuffer();
		for(int i=0;i < input.length()-1; i++){
			if(bArray[input.charAt(i)] == false){
				sBuffer.append(input.charAt(i));
				bArray[input.charAt(i)] = true;
			}
		}
		return sBuffer.toString();
		/*
		 // O(n)
		StringBuilder sBuilder = new StringBuilder();
		char[] cArray = input.toCharArray();
		Set<Character> s = new LinkedHashSet<Character>();
		for(Character c : cArray){
			s.add(c);
		}
		for(Character c : s){
			sBuilder.append(c);
		}*/
		
		/*
		 // O(n^2)
        String s2 = "";
        for (int i = 0; i < input.length(); i++) {
            int count = 0;
            for (int j = 0; j < s2.length(); j++) {
                if (input.charAt(i) == s2.charAt(j)) {
                    count++;
                }
            }
            if (count == 0) {
                s2 = s2.concat(String.valueOf(input.charAt(i)));
            }
        }
        return s2;
		*/
		// Inherently StringBuilder.indexOf has a worst case of O(n) again.
/* 		StringBuilder sBuilder = new StringBuilder();
		for(int i=0;i<input.length()-1;i++){
			if(sBuilder.indexOf(String.valueOf(input.charAt(i))) == -1){
				sBuilder.append(input.charAt(i));
			}
		}
		return sBuilder.toString(); */
	}
}