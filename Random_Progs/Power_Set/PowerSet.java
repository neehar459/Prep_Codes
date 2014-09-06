public class PowerSet{
	public static void main(String[] args){
		int[] iArray = {5,3,7};
		//displayPowerSet(iArray);
		powerSetRecursive(iArray);
	}
	public static void displayPowerSet(int[] iArray){
		if(iArray == null || iArray.length == 0){
			throw new IllegalArgumentException("Array is Empty");
		}else{
			double size = Math.pow(2,iArray.length);
			int setSize = iArray.length;
			for(int i=0; i< size; i++){
				String binString = intToBinary(i,setSize);
				for(int j=0; j<binString.length(); j++){
					if(binString.charAt(j) == '1'){
						System.out.print(iArray[j] + " , ");
					}
				}
				System.out.println();
			}
		}
	}
	public static String intToBinary(int number, int size){
		String binary = Integer.toBinaryString(number);
		int presentDigits = binary.length();
		String toReturn = binary;
		for(int i= presentDigits; i<size; i++){
			toReturn = "0" + toReturn;
		}
		return toReturn;
	}
	public static void powerSetRecursive (int[] iArray){
		if(iArray == null || iArray.length == 0) {
			return ;
		} else {
			String s = "";
			for(int i=0; i < iArray.length; i++) {
				s = s + iArray[i];
			}
			displayPowerSetRecursive("", s);
		}
	}
	public static void displayPowerSetRecursive (String soFar, String rest) {
		if(rest == null || rest.length() == 0) {
			System.out.println(soFar);
		} else {
			String first = soFar+rest.charAt(0);
			String rem = rest.substring(1);
			displayPowerSetRecursive(first,rem);
			displayPowerSetRecursive(soFar, rem);
		}
	}
}