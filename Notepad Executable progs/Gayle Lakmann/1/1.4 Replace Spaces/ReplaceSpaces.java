public class ReplaceSpaces{
	public static void main(String [] args){
		String inputString = "Mr John Smith";
		char[] cArray = inputString.toCharArray();
		int oldLength = cArray.length;
		int noOfSpaces =0;
		for(int i=0;i<cArray.length;i++){
			if(cArray[i] == ' '){
				noOfSpaces++;
			}
		}
		int newLength = oldLength + 2*noOfSpaces;
		char[] cArray1 = new char[newLength];
		for(int i = oldLength-1;i>=0;i--){
			if(cArray[i]!=' '){
				cArray1[newLength-1]=cArray[i];
				newLength--;
			}else{
				cArray1[newLength-1]='0';
				cArray1[newLength-2]='2';
				cArray1[newLength-3]='%';
				newLength=newLength-3;
			}
		}
		String newString = new String(cArray1);
		System.out.println("replaced string : "+newString);
	}
}