public class ConcatenateInt{
	public static void main(String[] args){
		int a = 12345;
		int b = 0945;
		int temp =b;
		while(temp > 0){
			temp = temp / 10;
			a = a * 10;
		}
		a = a +b;
		System.out.println("a :"+a);
	}
}