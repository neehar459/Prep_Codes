import java.util.Stack;
public class SortStack{
	public static void main(String[] args){
		Stack<Integer> myStack = new Stack<Integer>();
		myStack.push(6);
		myStack.push(3);
		myStack.push(4);
		myStack.push(2);
		myStack.push(5);
		myStack.push(1);
		System.out.println("Stack Size : "+myStack.size());
		System.out.println("Stack before sorting : ");
		sortStack(myStack);
		
	}
	public static Stack<Integer> sortStack(Stack<Integer> myStack){
		if(myStack.isEmpty()){
			return null;
		}else{
			if(myStack.size() == 1){
				return myStack;
			}else{
				System.out.println("Else Block");
				Stack<Integer> tempStack = new Stack<Integer>();
				int temp = Integer.MIN_VALUE;
				while(!myStack.isEmpty()){
				temp = myStack.pop();
					while(!tempStack.isEmpty() && temp < tempStack.peek()){
						myStack.push(tempStack.pop());
					}
					tempStack.push(temp);
				}
				while(!tempStack.isEmpty()){
					myStack.push(tempStack.pop());
				}	
				displayStack(myStack);
				return myStack;
			}
		}
	}
	public static void displayStack(Stack<Integer> myStack){
		if(myStack.isEmpty()){
			throw new IllegalArgumentException("Stack is empty");
		}else{
			while(!myStack.isEmpty()){
				System.out.print("--> "+myStack.pop());
			}
			System.out.println();
		}
	}
}
