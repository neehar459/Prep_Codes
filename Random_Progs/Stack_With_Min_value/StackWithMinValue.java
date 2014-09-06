import java.util.Stack;
public class StackWithMinValue{
	Stack<Integer> mainStack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	public static void main(String[] args){
		StackWithMinValue sNew = new StackWithMinValue();
		sNew.push(5);
		sNew.push(3);
		System.out.println("min val : "+sNew.getMinimum());
		sNew.push(4);
		System.out.println("min val after 4 : "+sNew.getMinimum());
		sNew.push(1);
		System.out.println("min val after 1 : "+sNew.getMinimum());
		sNew.push(2);
		System.out.println("Popped value : "+sNew.pop());
		System.out.println("min val after delete : "+sNew.getMinimum());
	}
	public void push(int val){
		mainStack.push(val);
		if(minStack.isEmpty() || minStack.peek() >= val){
			minStack.push(val);
		}
	}
	public Integer getMinimum(){
		return minStack.peek();
	}
	public int pop(){
		Integer minTopValue = minStack.peek();
		Integer mainStackPeek = mainStack.peek();
		if(mainStack.isEmpty()){
			return -1;
		}else{
			if(minTopValue == mainStackPeek){
				minStack.pop();
			}
			return mainStack.pop();
		}
	}
}
