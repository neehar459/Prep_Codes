import java.util.Stack;

// WE maintain a new stack as part of the main Stack where we keep a stack of min values of all additions to main Stack.
// The top pointer of this minStack will point to the lowest element of the entire collection.
public class StackWithMin extends Stack<Integer>{
	
	Stack <Integer> minStack;
	
	public  StackWithMin(){
		minStack = new Stack<Integer>();
	}
	
	public static void main(String[] args){
		StackWithMin sMin = new StackWithMin();
		sMin.push(5);
		sMin.push(4);
		sMin.push(1);
		sMin.push(3);
		System.out.println("Min Element in Stack : "+sMin.getMin());
		sMin.pop();
		sMin.pop();
		System.out.println("Min Element in Stack : "+sMin.getMin());
	}
	
	// This method pushes the data on to the main Stack. But performs a check if the new element to be added is <= already present min element 
	// in the minStack. If it is smaller, then that element is pushed on to minStack first and then on to the main stack.
	public void push (int data){
		if(data <= getMin()){
			minStack.push(data);
		}
		super.push(data);
	}
	
	// This method returns the top element from the main stack. But before it pops out the element, it checks if the element being popped out is 
	// min element of the minSTack. In that case it pops out that element from the min Stack so that both stacks have a synced min element.
	public Integer pop(){
		int valueToPop = super.pop();
		if(valueToPop == getMin()){
			minStack.pop();
		}
		return valueToPop;
	}
	
	// This method returns the minimum element present in the minStack.
	public int getMin(){
		if(minStack.isEmpty()){
			return Integer.MAX_VALUE;
		}else{
			return minStack.peek();
		}
	}
	
}