public class Queue{
	public static void main(String[] args){
		Queue q = new Queue(7);
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		q.enQueue(5);
		q.enQueue(6);
		q.enQueue(7);
		displayQueue(q);
	}
	int capacity;
	int front;
	int rear;
	int[] cirArray;
	public Queue(int size){
		capacity = size;
		front = -1;
		rear = -1;
		cirArray = new int[size];
	}
	public boolean isEmpty(){
		return (front == -1);
	}
	public boolean isFull(){
		return ((rear+1)%capacity == front);
	}
	public int size(){
		if(front == -1){
			return 0;
		}
		int size = (capacity - front + rear + 1)%capacity;
		if(size == 0){
			return capacity;
		}else{
			return size;
		}
	}
	public void enQueue(int data){
		if(isFull()){
			throw new IllegalArgumentException("Queue is already full");
		}else{
			rear = (rear + 1) % capacity;
			cirArray[rear] = data;
			if(front == -1){
				front = rear;
			}
		}
	}
	public int deQueue(){
		if(isEmpty()){
			throw new IllegalArgumentException("Queue is already empty");
		}else{
			int data = -1;
			data = cirArray[front];
			if(front == rear){
				front = rear - 1;
			}else{
				front = (front + 1) % capacity;
			}
			return data;
		}
	}
	public static void displayQueue(Queue q){
		if(q.isEmpty()){
			throw new IllegalArgumentException("Queue is already empty");
		}else{
			for(int i=0; i < q.size(); i++){
				System.out.print("--> "+q.cirArray[i]);
			}
			System.out.println();
		}
	}
}
