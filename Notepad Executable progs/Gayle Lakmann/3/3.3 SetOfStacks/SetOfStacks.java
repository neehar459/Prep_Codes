import java.util.List;
import java.util.ArrayList;
public class SetOfStacks{
	
	List setOfStacks = new ArrayList();
	
	public SetOfStacks(){
		setOfStacks.add(new MyStack());
	}
	
	public static void main(String[] args){
		SetOfStacks sStacks = new SetOfStacks();
		sStacks.push(1);
		sStacks.push(2);
		sStacks.push(3);
		sStacks.push(4);
		sStacks.push(5);
		sStacks.push(6);
		sStacks.displayAllStacks();
		System.out.println("Element popped at stack position 1 : "+sStacks.popAt(0));
		System.out.println("Element popped at stack position 1 : "+sStacks.popAt(1));
		System.out.println("Element popped at stack position 1 : "+sStacks.popAt(2));
	}
	
	// This method pushes elements on to the Stacks. If the stack is already filled. Then a new Stack is added to the list of Stacks.
	public void push(int data){
		MyStack lastStack = getLastStack();
		if(null==lastStack){
			throw new IllegalArgumentException("No Last Stack");
		}else{
			if(!(lastStack.isFull())){
				lastStack.push(data);
			}else{ // create a new stack and add element to the stack
				 MyStack newStack = new MyStack();
				 newStack.push(data);
				 setOfStacks.add(newStack);
			}
		}
	}
	
	// This method returns the top element from the last Stack present in the setOfStacks. If the lastStack is empty, it is removed 
	// from the set of stacks.
	public int pop(){
		MyStack lastStack = getLastStack();
		if(null==lastStack){
			throw new IllegalArgumentException("No Last Stack");
		}else{
			int poppedElement = lastStack.pop();
			if(lastStack.isEmpty()){
				setOfStacks.remove(lastStack);
			}
			return poppedElement;
		}
	}
	
	// This method pops the top element from the stack present at the given index
	public int popAt(int index){
		if(index<0){
			throw new IllegalArgumentException("Index cannot be less than zero");
		}else{
			MyStack stackAtPos = (MyStack)setOfStacks.get(index);
			return stackAtPos.pop();
		}
	}
	
	// This method returns the last stack present in the list of Stacks.
	public MyStack getLastStack(){
		if(setOfStacks.size()==0){
			return null;
		}else{
			return (MyStack)setOfStacks.get(setOfStacks.size()-1);
		}
	}
	
	// This method displays all Stacks 
	public void displayAllStacks(){
		if(setOfStacks.size()==0){
			throw new IllegalArgumentException("Set of Stack has no elements ");
		}else{
			for(int i=0;i< setOfStacks.size();i++){
				((MyStack)setOfStacks.get(i)).displayStack();
			}
		}
	}
}
class MyStack{
	
	int capacity = 2 ;
	int[] iArray = new int[capacity];
	int topOfStack = -1;
	
	
	// this method allows to push elements on to stack
	public int push(int element){
		if(topOfStack==-1){
			iArray[topOfStack+1] = element;
			topOfStack++;
			return element;
		}else{
			if(topOfStack == iArray.length-1){
				return Integer.MAX_VALUE;
			}else{
				iArray[topOfStack+1] = element;
				topOfStack++;
				return element;
			}
		}
	}
	
	// This method doubles the size of the Array and copies old elements of array in to a new array which will be returned
	public void doubleArraySize(){
		int[] newArray = new int[2*iArray.length];
		for(int i=0;i<iArray.length;i++){
			newArray[i] = iArray[i];
		}
		iArray = newArray;
	}
	
	// This method removes the top element from stack and returns that element
	public int pop(){
		if(isEmpty()){
			return -1;
		}else{
			int toReturn = iArray[topOfStack];
			iArray[topOfStack]=-1;
			topOfStack--;
			return toReturn;
		}
	}
	
	// This method checks if the stack is empty or not.
	public boolean isEmpty(){
		if(topOfStack==-1){
			return true;
		}else{
			return false;
		}
	}
	
	// This method returns the top element of the stack with out removing
	public int peek(){
		if(isEmpty()){
			throw new IllegalArgumentException("Stack is already empty");
		}else{
			return iArray[topOfStack];
		}
	}
	
	// This method tells if a stack is already full.
	public boolean isFull(){
		if(topOfStack == iArray.length-1){
			return true;
		}else{
			return false;
		}
	}
	
	// This method displays the stack
	public void displayStack(){
		if(topOfStack==-1){
			throw new IllegalArgumentException("Stack does not have elements");
		}else{
			for(int i=0; i<=topOfStack; i++){
				System.out.print("---> " + iArray[i]);
			}
			System.out.println(" ");
		}
	}
}