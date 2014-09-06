public class StringReversal{
	public static void main(String[] args){
		String revString = revString("This is from Notepad");
		System.out.println("Rev String : "+revString);
		System.out.println("Rev String in words : "+revEachWord("This is from Notepad"));
		
	}
	public static String revString(String s){
		if(s == null || s.length() == 0){
			return null;
		}else{
			char[] cArray = s.toCharArray();
			int start = 0;
			int end = cArray.length -1;
			char temp;
			while(start < end){
				temp = cArray[start];
				cArray[start] = cArray[end];
				cArray[end] = temp;
				start++;
				end--;
			}
			return new String(cArray);
		}
	}
	public static String revEachWord(String s){
		if(s == null){
			return null;
		}else{
			char[] totalRev = revCharArray(s.toCharArray(),0,s.length()-1);
			int spaceStart = 0;
			int spaceEnd = 0;
			for(int i=0; i< totalRev.length; i++){
				if(totalRev[i] == ' '){
					spaceEnd = i;
					totalRev = revCharArray(totalRev, spaceStart, spaceEnd-1);
					spaceStart = i+1;
				}
			}
			totalRev = revCharArray(totalRev, spaceStart, totalRev.length-1);
			String toReturn = new String(totalRev);
			return toReturn;
		}
	}
	public static char[] revCharArray(char[] cArray, int start, int end){
		if(cArray == null || cArray.length == 0){
			return null;
		}else{
			char temp;
			while(start < end){
				temp = cArray[start];
				cArray[start] = cArray[end];
				cArray[end] = temp;
				start ++;
				end --;
			}
			return cArray;
		}
	}
}