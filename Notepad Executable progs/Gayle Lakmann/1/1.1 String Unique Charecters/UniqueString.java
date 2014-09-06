public class UniqueString{
	public static void main(String[] args){
		String inputString = "abcdeffde";
		System.out.println("Inputted String : "+inputString);
		int[] testArray = new int[122];
		int counter=0;
		for(int i=0;i<inputString.length()-1;i++){
			//System.out.println(i);
			int position = inputString.charAt(i);
			if(testArray[position]!=0){
				System.out.println("Not unique String");
				System.exit(0);
			}
			testArray[position]=1;
			counter++;
		}
		if(counter==inputString.length()-1){
			System.out.println("Unique String");
		}
	}
	
}