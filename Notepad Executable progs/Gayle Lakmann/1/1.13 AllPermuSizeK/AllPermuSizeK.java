import java.util.*;
public class AllPermuSizeK{
	public static void main(String[] args){
		System.out.println("Enter the value of k ");
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		System.out.println("Enter the string to be permuted");
		String toPermute = scanner.next();
		System.out.println("k : "+k +", String : "+toPermute);
		permuteLenK(toPermute, k);
	}
	
	public static void permuteLenK(String input, int k){
		permuteRec(input, "", k);
	}
	
	private static void permuteRec(String input, String start, int k){
		if(k == 0){ // base case
			System.out.println(start);
			return ;
		}
		for(int i =0; i< input.length(); i++){
			permuteRec(input, (start+(input.charAt(i))),k-1);
		}
	}
}