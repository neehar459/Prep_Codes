//Given n. Generate all numbers with number of digits equal to n, 
//such that the digit to the right is greater than the left digit (ai+1 > ai).
//E.g. if n=3 (123,124,125,……129,234,…..789)

public class GenerateNum{
	public static void main(String[] args){
		GenerateNum gen = new GenerateNum();
		gen.genNumbers(3,0);
	}	
	public void genNumbers(int n, int base){
		int lastDigitUsed = (base/(int)Math.pow(10,n))%10;
		for(int i = lastDigitUsed+1; i<10;i++){
			int temp = base + (i * (int)Math.pow(10, n-1));
			if(n == 1){
				System.out.print(temp+",");
			}else{
				genNumbers(n-1, temp);
			}
		}
		System.out.println(" ");
	}
}