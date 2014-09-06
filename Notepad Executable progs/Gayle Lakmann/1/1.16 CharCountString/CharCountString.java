public class CharCountString{
	public static void main(String[] args){
		String toCountString = "charcountstring";
		int[] countArray = new int[256];
		for(int i=0; i < toCountString.length()-1; i++){
			char iterChar = toCountString.charAt(i);
			
			countArray[(int)iterChar]++;
		}
		for(int j=0; j < countArray.length; j++){
			if(countArray[j] != 0){
				char c = (char)j;
				//System.out.println("char : "+c);
				System.out.println("count of : "+c+" is : "+countArray[j]);
			}
		}
	}
}