public class GCD{
	public static void main(String[] args){
		GCD gcd = new GCD();
		long result = gcd.findGCD(75L,20L);
		System.out.println("Result : "+result);
	}
	
	public long findGCD(long a, long b){
		if(b == 0){
			return a;
		}else{
			return findGCD(b, a%b);
		}
	}
}