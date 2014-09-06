public class StringRotation{
	public static void main(String[] args){
		String s1 = "waterbottle";
		String s2 = "terbottlewa";
		if(isRotation(s2,s1)){
			System.out.println("Yes Valid Rotation");
		}else{
			System.out.println("Not a Valid Rotation");		
		}
	}
	public static boolean isSubString(String s1, String s2){
		if(s1.contains(s2)){
		return true;
		}
		return false;
	}
	public static boolean isRotation(String s1, String s2){
		// if string s1 is rotated and made in to 2 sub strings a,b. Then ba is a substring of abba.
		if(s1.length()==s2.length() && s1.length()>0){
			String abba = s1+s1;
			return isSubString(abba,s2);
		}
		return false;
	}
}