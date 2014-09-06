public class StringCompressionNew{
	public static void main(String[] args){
		String toCompress = "aabccccc";
		String compressedString = compressString(toCompress);
		System.out.println("Compressed String : "+compressedString);
	}
	public static String compressString(String inputString){
		String toReturn = null;
		int compressedSize = countCompression(inputString);
		if(compressedSize >= inputString.length()){
			toReturn = inputString;
		}else{
			StringBuffer sBuffer = new StringBuffer();
			int count =1;
			char prevChar = inputString.charAt(0);
			for(int i=1; i < inputString.length(); i++){
				if(inputString.charAt(i) == prevChar){
					count++;
				}else{
					sBuffer.append(prevChar);
					sBuffer.append(count);
					prevChar = inputString.charAt(i);
					count=1;
					
				}
				if(i == inputString.length()-1){
						sBuffer.append(prevChar);
						sBuffer.append(count);
					}
			}

			toReturn = sBuffer.toString();
		}
		return toReturn;
	}
	public static int countCompression(String inputString){
		if(null == inputString || inputString.isEmpty()){
			return 0;
		}
		char prevChar = inputString.charAt(0);
		int size = 0;
		int count = 1;
		for(int i=1; i <inputString.length(); i++){
			if(inputString.charAt(i) == prevChar){
				count++;
			}else{
				prevChar = inputString.charAt(i);
				size+= 1+String.valueOf(count).length();
				count=1;
			}
		}
		size+= 1+String.valueOf(count).length();
		System.out.println("Size : "+size);
		return size;
	}
}