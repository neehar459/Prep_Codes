import java.util.Scanner;
public class XPowNModP{
	public static void main(String[] args){
		System.out.println ("Enter the number X ");
		Scanner scanner = new Scanner(System.in);
		long x = scanner.nextLong();
		System.out.println ("X entered value is : "+x);
		System.out.println ("Enter the number N ");
		long n = scanner.nextLong();
		System.out.println ("X entered value is : "+n);
		System.out.println ("Enter the number P ");
		long p = scanner.nextLong();
		System.out.println ("X entered value is : "+p);
		long result = new XPowNModP().findRem(x,n,p);
		System.out.println("Remainder : " +result);
	}
	
	public long findRem (long x, long n, long p){
		// Approach : x ^ n can be written as (x^n/2)^2. By this means we can reduce the number of multiplications by half.
		// If n is odd number, x^n = x* (x^(n-1)/2)^2.
		if(x<0){
			throw new IllegalArgumentException("X cannot be < 0");
		}
		if(n < 0){
			throw new IllegalArgumentException("N cannot be < 0");
		}
		if(p <=0){
			throw new IllegalArgumentException("P cannot be <= 0");	
		}
		if(n == 0){
			return 1;
		}
		long temp = findRem((x * x) % p, n/2, p);
		if(n%2 !=0){ // in case of odd number we will multiply with x%p to accommodate for that extra x.
			temp = (temp * x) %p;
		}
		return temp;
	}
}