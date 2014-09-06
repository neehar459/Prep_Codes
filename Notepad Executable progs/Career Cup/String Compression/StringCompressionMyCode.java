public class StringCompressionMyCode{
	public static void main(String[] args){
		String toCompress = "aabcccccaaaddddddd";
		String compressed = toCompressString(toCompress);
		System.out.println("Compressed String : "+compressed);
	}
	public static String toCompressString(String input){
		if(null == input){
			throw new IllegalArgumentException("String is null");
		}else{
			getCompressedStringLength(input);
			String toReturn = null;
			StringBuffer sBuffer = new StringBuffer();
			int count =1;
			char prevChar = input.charAt(0);
			for(int i=1; i < input.length(); i++){
				if(input.charAt(i) == prevChar){
					count++;
				}else{
					sBuffer.append(prevChar);
					sBuffer.append(count);
					prevChar = input.charAt(i);
					count=1;
				}
					if(i == input.length()-1){
						sBuffer.append(prevChar);
						sBuffer.append(count);
					}
			}

			toReturn = sBuffer.toString();
			return toReturn;
		}
	}
	private static int getCompressedStringLength(String input){
		int lengthOfCompressedString = 0;
		int count =1;
		for(int i=0; i< input.length()-1;i++){
			System.out.println("char : "+input.charAt(i));
			if(input.charAt(i) == input.charAt(i+1)){
				count++;
				continue;
			}else{
				if(count < 10)
				lengthOfCompressedString+= 2;
				else{
				lengthOfCompressedString+= (int)Math.log10(count)+1;	
				}
				count = 1;
				//continue;				
			}
			
		}
		System.out.println("Length of Compressed String : "+lengthOfCompressedString);
		return lengthOfCompressedString;
	}
}