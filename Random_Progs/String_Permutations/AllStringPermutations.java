public class AllStringPermutations {
	public static void main (String[] args) {
		String toPermute = "aca";
		permuteString(toPermute);
		System.out.println("----------------------");
		permuteStringStf(toPermute);
		System.out.println("----------------------");
	}
	public static void permuteString(String str) {
		if(str != null) {
			allParts(str.toCharArray(), str.length());
		}
	}
	public static void allParts (char[] cArray, int n) {
		if( n == 1) {
			System.out.print(new String(cArray) + " , ");
			return ;
		}
		for (int i=0; i < n; i++) { 
			swap(cArray, i, n-1);
			allParts(cArray, n-1);
			swap(cArray, i, n-1);
		}
	}
	public static void swap(char[] cArray, int i, int j){
		char c = cArray[i];
		cArray[i] = cArray[j];
		cArray[j] = c;
	}
	public static void permuteStringStf (String str) {
		doPermute("", str);
	}
	public static void doPermute (String  soFar, String rest) {
		if(rest == null || rest.length() == 0) {
			System.out.print(soFar + " , ");
		} else {
			for(int i=0; i<rest.length(); i++) {
				// The below code checks if there are charecters duplicated. In case skip them to consider again for permutations.
				String nextStr = rest.substring(i+1);
				if(contains(nextStr, rest.charAt(i))){
					continue;
				}
				// till here
				String first = soFar + rest.charAt(i);
				String rem =  rest.substring(0,i) +  rest.substring(i+1);
				doPermute(first, rem);
			}
		}
	}
	public static boolean contains(String s, char c) {
		if(s == null || s.length() == 0){
			return false;
		} else {
			char[] c1 = s.toCharArray();
			for(int i=0; i < c1.length; i++) {
				if(c1[i] == c){
					return true;
				}
			}
			return false;
		}
	}
}