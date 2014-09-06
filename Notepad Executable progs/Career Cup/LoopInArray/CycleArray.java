//http://www.careercup.com/question?id=6211133350346752
public class CycleArray{
	public static void main(String[] args){
		int[] iArray= {2,3,1,0,3,1,0};
		int cycleElement = getCycleElement(iArray);
		System.out.println("Cycle Element : "+cycleElement);
	}
	public static int getCycleElement(int[] array){
		if(array.length == 0){
			return Integer.MIN_VALUE;
		}else{
			int slow = 0;
			int fast = 0;
			int start =0;
			do{
				fast = array[fast];
				fast = array[fast];
				slow = array[slow];
			}while(fast != slow);
			System.out.println("index of loop cycle 1: " + fast);
			start = slow;
			fast = 0;
			int count = 0;
			while(slow!=fast){
				slow = array[slow];
				fast = array[fast];
			}
			while(slow!=start){
				count++;
				start = array[start];
				//slow = array[slow];
			}
			System.out.println("Nodes in loop : "+count);
			System.out.println("index of loop cycle : " + fast);
			return array[fast];
		}
	}
}