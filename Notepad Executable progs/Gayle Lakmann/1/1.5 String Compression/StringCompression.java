public class StringCompression{
	public static void main(String[] args){
		//aaabbbcccdddaabccdc
		String inputString = "ABCDEF";
		String compressedString = getCompressedString(inputString);
		System.out.println(compressedString);
		//String compressedString1 = getCompressed(inputString);
		//System.out.println(compressedString1);
		//String inputString1= "abca";
		//String compressedString2 = getCompressed(inputString1);
		//System.out.println(compressedString2);
	}

	// my code
	public static String getCompressedString(String inputString){
		String compressedString = null;
		int[] freqArray = new int[256];
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<inputString.length();i++){
			int position = inputString.charAt(i);
			if(freqArray[position]==0){
				sb.append(inputString.charAt(i));
			}
			freqArray[position]++;
		}
		StringBuffer sBufferNew = new StringBuffer();
		for(int i=0;i<sb.length();i++){
			char c = sb.toString().charAt(i);
			sBufferNew.append(c);
			int position = c;
			sBufferNew.append(freqArray[position]);
		}
		compressedString = sBufferNew.toString();
		return compressedString;
	}
}