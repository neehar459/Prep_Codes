public class StringPermutation{
// This gets the unique characters from both strings and then checks those unique string chars if they have same content or not
	public static void main(String[] args){
		String s1 = "abcabcabcabc";
		String s2 = "bcaabcabcccb";
		if(s1.length()!=s2.length()){
			System.out.println("Not Permutation");
			System.exit(0);
		}
		String s3 = "fdedbeafbacebdefd";
		String uniqString1 = getUniqueCharString(s1);
		String uniqString2 = getUniqueCharString(s2);
		//System.out.println(uniqString1);
		//System.out.println(uniqString2);
		// Both strings should have same length to be exact permutation
		if(uniqString1.length()!=uniqString2.length()){
			System.out.println("Not Permutation");
			System.exit(0);
		}else{
			if(isSubString(uniqString1,uniqString2)){
				System.out.println("Strings are permutation of each other");
			}
		}
	}
	public static boolean isSubString(String inputString1, String inputString2){
		int counter=0;
		for(int i =0; i < inputString1.length() ; i++){
			if(inputString2.indexOf(inputString1.charAt(i))!=-1){
				counter++;
			}else{
				return false;
			}
		}
		System.out.println(counter);
		if(counter==inputString1.length()){
			return true;
		}
		return false;
	}
	
	public static String getUniqueCharString(String inputString){
		String uniqueCharString = null;
		StringBuffer sBuffer = new StringBuffer();
		int[] testArray = new int[256];
		for(int i=0;i<inputString.length();i++){
			int position = inputString.charAt(i);
			if(testArray[position]!=0){
			continue;
			}else{
			sBuffer.append(inputString.charAt(i));
			testArray[position]=1;
			}
		}
		uniqueCharString = sBuffer.toString();
		return uniqueCharString;
	}
}