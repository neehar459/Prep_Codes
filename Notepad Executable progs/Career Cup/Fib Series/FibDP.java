import java.util.*;
public class FibDP{
	static double[] iArray;
	public static void main(String [] args){
		System.out.println(" Enter the number till you want to see fib series ");
		Scanner scanner = new Scanner(System.in);
		double number = scanner.nextDouble();
		iArray = new double[(int)(number+1)];
		System.out.println("Number Entered : "+number);
		double startTime = System.currentTimeMillis();
		displayFibDP(number);
		double endTime = System.currentTimeMillis();
		System.out.println(" Time taken : "+(startTime - endTime));
		for(double i : iArray){
			System.out.print(i+",");
		}
	}
	
	// Based on Recursion. Use Book keeping to store results and don't calculate unnecessarily.
	public static double displayFibDP(double number){
		// Base Case
		if(number ==0){
			iArray[(int)number] =0;
			return iArray[(int)number];
		}
		if(number ==1){
			iArray[(int)number] =1;
			return iArray[(int)number];
		}
		if(iArray[(int)number]!=0){
			return iArray[(int)number];
		}else{
			iArray[(int)number] = displayFibDP(number - 1) + displayFibDP(number - 2);
			return iArray[(int)number];
		}
	}
}