// Remove Consecutive Same elements recursively in String
public class RemoveConsecutiveEqualCharsRecurse {
	public static void main(String[] args) {
		String s = "BB";
		System.out.println("String after removing consecutive equal chars recursively : " +removeConsecutiveRecurse(s));
	}
	public static String removeConsecutiveRecurse (String s) {
		if(s == null || s.length() ==0) {
			return null;
		} else {
			if(s.length() == 1) {
				return s;
			} else {
				int i = 0;
				int j = i+1;
				int length = s.length();
				StringBuilder sBuilder = new StringBuilder(s);
				while(j < length) {
					if(sBuilder.charAt(i) == sBuilder.charAt(j)) {
						sBuilder.deleteCharAt(i);
						sBuilder.deleteCharAt(j-1);
						i--;
						j++;
						length = sBuilder.length();
					} else {
						i++;
						j++;
					}
				}
				return sBuilder.toString();
			}
		}
	}
}