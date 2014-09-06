public class StringPermutationNew{
	public static void main(String[] args){
	String s1 = "abcabcabcabc";
	String s2 = "bcaabcabcacb";
	int[] freqArray = new int[256];
	if(s1.length()!=s2.length()){
		System.out.println("Not Permutation");
		System.exit(0);
	}else{
		for(int i=0;i<s1.length();i++){
			int position = s1.charAt(i);
			freqArray[position]++;
		}
		for(int j=0;j<s2.length();j++){
			int position1 = s2.charAt(j);
			if(--freqArray[position1]<0){
				System.out.println("Not Permutation.");
				System.exit(0);
			}
		}
		System.out.println("Both are Permutations of each other");
	}
	}
}