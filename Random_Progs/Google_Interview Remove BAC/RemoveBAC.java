// http://www.geeksforgeeks.org/remove-a-and-bc-from-a-given-string/
public class RemoveBAC {
	public static void main (String[] args) {
		String s = "abcbca";
		String cutString = removeBAC(s);
		if(cutString != null) {
			System.out.println(cutString);
		} else {
			System.out.println("");
		}
	}
	public static String removeBAC(String s) {
		if(s == null || s.length() == 0) {
			return null;
		} else {
			int i =0; 
			int j = i + 1;
			char[] cArray = s.toCharArray();
			while (i < s.length()-1) {
				if(cArray[i] == 'b') {
					cArray[i] = ' ';
					i++;
					j++;
				} else if (cArray[i] == 'a' && cArray[j] == 'c') {
					cArray[i] = ' ';
					cArray[j] = ' ';
					i+= 2;
					j+= 2;
				} else {
					i++;
					j++;
				} 
			}
			s = new String(cArray);
			s = s.replace(" ", "");
			return s; 
		}
	}
}