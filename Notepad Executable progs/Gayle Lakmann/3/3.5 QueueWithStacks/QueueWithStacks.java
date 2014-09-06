public class QueueWithStacks{
	
	MyStack enqueueStack;
	MyStack dequeueStack;
	
	public QueueWithStacks(){
		enqueueStack = new MyStack();
		dequeueStack = new MyStack();
	}
	
	public static void main(String[] args){
		QueueWithStacks queue = new QueueWithStacks();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		System.out.println("Dequeued Element : "+queue.dequeue());
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.displayQueue();
		System.out.println("Peeked Element : "+queue.peek());
	}
	
	// This method enqueues elements on to queue. We push elements on to enqueueStack.
	public void enqueue(int element){
		enqueueStack.push(element);
	}
	
	// This method pops elements from the dequeueStack.
	public int dequeue(){
		if(!dequeueStack.isEmpty()){
			return dequeueStack.pop();
		}else{
			while(!enqueueStack.isEmpty()){
				dequeueStack.push(enqueueStack.pop());
			}
			return dequeueStack.pop();
		}
	}
	
	// This method displays the first element of the queue
	public int peek(){
		if(!dequeueStack.isEmpty()){
			return dequeueStack.pop();
		}else{
			while(!enqueueStack.isEmpty()){
				dequeueStack.push(enqueueStack.pop());
			}
			return dequeueStack.peek();
		}
	}
	
	// This method displays Queue/ It displays dequeueStack in reverse order and enqueueStack in normal order
	public void displayQueue(){
		if(dequeueStack.isEmpty() && enqueueStack.isEmpty()){
			throw new IllegalArgumentException("Queue is Empty");
		}else if (dequeueStack.isEmpty()){
			enqueueStack.displayStackReverse();
		}else if (enqueueStack.isEmpty()){
			dequeueStack.displayStack();
		}else{
			System.out.println("Queue display :");
			dequeueStack.displayStack();
			enqueueStack.displayStackReverse();
		}
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