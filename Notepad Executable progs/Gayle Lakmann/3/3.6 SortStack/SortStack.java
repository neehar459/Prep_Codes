public class SortStack{
	public static void main(String[] args){
		SortStack sStack = new SortStack();
		MyStack unSortedStack = new MyStack();
		unSortedStack.push(1);
		unSortedStack.push(4);
		unSortedStack.push(2);
		unSortedStack.push(5);
		unSortedStack.push(3);
		unSortedStack.displayStack();
		System.out.println(" ");
		MyStack sortedStack = sStack.sortStack(unSortedStack);
		sortedStack.displayStack();
	}
	
	// This method sorts the original Stack by using the helperStack. First we take the topElement of unsortedArray and insert in to helperStack.
	// The subsequent topElement is then compared with the topelement of helper stack. If the helperstack topEle is greater than unsorted topele,
	// we insert in to helperStack directly. But if the element is less than helperstack topele, we store that element in a temp var. Copy helper stack
	// elements one by one till we get an element that is lesser than helperStack topele. We repeat this process till we get sorted HelperStack.
	public MyStack sortStack(MyStack unSortedStack){
		MyStack helperStack = new MyStack();
		while(!unSortedStack.isEmpty()){
			int tempVar = unSortedStack.pop();
			while(!helperStack.isEmpty() && helperStack.peek()>tempVar){
				unSortedStack.push(helperStack.pop());
			}
			helperStack.push(tempVar);
		}
		return helperStack;
	}
}
class MyStack{
	
	int capacity =  10;
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
				// Implicit array will be doubled in size and all the initial elements will be copied on to the new array.
				doubleArraySize();
				iArray[topOfStack+1] = element;
				topOfStack++;
				return element;
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
			for(int i=topOfStack; i>=0;i--){
				System.out.print("---> " + iArray[i]);
			}
		}
	}
	
	// This method displays stack in reverse order
	public void displayStackReverse(){
		if(topOfStack==-1){
			throw new IllegalArgumentException("Stack does not have elements");
		}else{
			for(int i=0; i<=topOfStack; i++){
				System.out.print("---> "+iArray[i]);
			}
			System.out.println(" ");
		}
	}
}