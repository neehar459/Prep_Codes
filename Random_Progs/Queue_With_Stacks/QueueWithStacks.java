public class QueueWithStacks{
	MyStack eStack = new MyStack();
	MyStack dStack = new MyStack();
	public static void main(String[] args){
		QueueWithStacks q = new QueueWithStacks();
		for(int i=1; i <= 10; i++){
			q.enQueue(i);
		}
		for(int i=0; i<=10; i++){
			System.out.println("Deque Element : "+q.deQueue());
		}
		
	}
	public  void enQueue(int data){
		try{
			eStack.push(data);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public  int deQueue(){
		if(!dStack.isEmpty()){
			return dStack.pop();
		}else{
			if(!eStack.isEmpty()){
				while(!eStack.isEmpty()){
					dStack.push(eStack.pop());
				}
			}
			return dStack.pop();
		}
	}
	public  void displayQueueWithStacks(){
		if(dStack.isEmpty()){
			while(!eStack.isEmpty()){
				dStack.push(eStack.pop());
			}
		}else{
			while(!dStack.isEmpty()){
				System.out.print("--> "+dStack.pop());
			}
			while(!eStack.isEmpty()){
				dStack.push(eStack.pop());
			}
			while(!dStack.isEmpty()){
				System.out.print("--> "+dStack.pop());
			}
			System.out.println();
		}
	}
}
class MyStack{
	
	int capacity = 10;
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
	
	// This method displays the stack
	public void displayStack(){
		if(topOfStack==-1){
			throw new IllegalArgumentException("Stack does not have elements");
		}else{
			for(int i=topOfStack; i>=0;i--){
				System.out.print("---> " + iArray[i]);
			}
			System.out.println(" ");
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
