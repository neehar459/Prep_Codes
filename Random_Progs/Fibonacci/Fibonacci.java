
public class Fibonacci{
	static int[] dpArray;
	public static void main(String[] args){
		System.out.println(fibIterative(10));
		System.out.println(fibRecursive(10));
		fibonacciDP(10);
		fibonacciDPBottomUp(10);
	}
	public static int fibIterative(int n){
		if(n == 0){
			return 0;
		}
		int a = 1;
		int b = 1;
		for(int i=3; i<= n; i++){
			int c = a + b;
			a = b;
			b = c;
			System.out.print(b + " , ");
		}
		return b;
	}
	public static int fibRecursive(int n){
		if(n <= 1){
			return n;
		}else{
			int result = (fibRecursive(n-1) + fibRecursive(n-2));
			//System.out.print(result + " , ");
			return result;
		}
	}
	public static void fibonacciDP(int n){
		dpArray = new int[1000];
		System.out.println("Fibonacci DP : " +fibDP(n));
	}
	public static int fibDP(int n){
		if(n <=1){
			if(dpArray[n] == 0){
				dpArray[n] = n;
			}
			return dpArray[n];
		}else{
			if(dpArray[n] ==0 ){
				dpArray[n] = fibDP(n-1) + fibDP(n-2);
				return dpArray[n];
			}else{
				return dpArray[n];
			}
		}
	}
	public static void fibonacciDPBottomUp(int n){
		dpArray = new int[1000];
		dpArray[0] = 0;
		dpArray[1] = 1;
		for(int i=2; i<= n; i++){
			dpArray[i] = dpArray[i-1] + dpArray[i-2];
		}
		System.out.println("Fib Iterative DP : "+ dpArray[n]);
	}
}