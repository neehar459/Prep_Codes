import java.util.LinkedList;
public class QueueUsingLL{
	
	LinkedList<Animal> animalLL = new LinkedList<Animal>();
	int arrivalOrder =0;
	public static void main(String[] args){
		QueueUsingLL animalQueue = new QueueUsingLL();
		animalQueue.enqueue(new Cat("meow"));
		animalQueue.enqueue(new Dog("Rambo"));
		animalQueue.enqueue(new Dog("Jimmie"));
		animalQueue.enqueue(new Cat("meowBig"));
		animalQueue.enqueue(new Dog("caeser"));
		System.out.println("Dequeued animal : "+animalQueue.dequeueAny().animalName);
		System.out.println("Dequeued Dog : "+animalQueue.dequeueDog().animalName);
		System.out.println("Dequeued Cat : "+animalQueue.dequeueCat().animalName);
	}
	
	public void enqueue(Animal animal){
		if(null!=animal){
			animal.arrivalTime = arrivalOrder;
			arrivalOrder++;
			animalLL.addLast(animal);
		}
	}
	
	public Animal dequeueAny(){
		if(animalLL.size()==0){
			return null;
		}else{
			Dog dogInstance = null;
			Cat catInstance = null;
			for(int i=0; i < animalLL.size();i++){
				if(null!= dogInstance && null!= catInstance){
					break;
				}else{
					Animal iterAnimal = animalLL.get(i);
					if(iterAnimal instanceof Dog){
						if(null==dogInstance){
						dogInstance = (Dog)iterAnimal;
						}
					}else{
						if(null==catInstance){
						catInstance = (Cat)iterAnimal;
						}
					}
				}
			}
			if(dogInstance.arrivalTime < catInstance.arrivalTime){
				animalLL.remove(dogInstance);
				return dogInstance;
			}else{
				animalLL.remove(catInstance);
				return catInstance;
			}
		}
	}
	
	public Dog dequeueDog(){
		if(animalLL.size()==0){
			return null;
		}else{
			for(int i=0;i<animalLL.size();i++){
				Animal iterAnimal = animalLL.get(i);
				if(iterAnimal instanceof Dog){
					animalLL.remove(animalLL.get(i));
					return (Dog)iterAnimal;
				}
			}
			return null;
		}
	}
	
	public Cat dequeueCat(){
		if(animalLL.size()==0){
			return null;
		}else{
			for(int i=0;i<animalLL.size();i++){
				Animal iterAnimal = animalLL.get(i);
				if(iterAnimal instanceof Cat){
					animalLL.remove(animalLL.get(i));
					return (Cat)iterAnimal;
				}
			}
			return null;
		}
	}
	
}

class Animal{
	int arrivalTime;
	String animalName;
	public boolean isOlder(Animal newAnimal){
		if(this.arrivalTime < newAnimal.arrivalTime){
			return true;
		}else{
			return false;
		}
	}
}

class Dog extends Animal{
	public Dog(){
	}
	public Dog(String animalName){
		this.animalName = animalName;
	}
}

class Cat extends Animal{
	public Cat(){
	}
	public Cat(String animalName){
		this.animalName = animalName;
	}
}

class DoubleLinkedList{

	 int size;
	 DLLNode head;
	 DLLNode tail;
	
	public  DLLNode addLast(int data){
			DLLNode newNode = new DLLNode(data);
			if(size==0){
				newNode.next=null;
				newNode.prev=null;
				head=newNode;
				tail=newNode;
				size++;
			}else{
				DLLNode oldHead = head;
				DLLNode oldTail = tail;
				oldTail.next=newNode;
				newNode.prev=oldTail;
				newNode.next=null;
				tail=newNode;
				size++;
			}
			return newNode;
	}
	
	public DLLNode add(int data){
		return (addLast(data));
	}
	
	public DLLNode addFirst(int data){
		DLLNode newNode = new DLLNode(data);
		if(size==0){
			return (addLast(data));
		}else{
			DLLNode oldHead = head;
			DLLNode oldTail = tail;
			oldHead.prev = newNode;
			newNode.next = oldHead;
			newNode.prev=null;
			head=newNode;
			size++;
		}
		return newNode;
	}
	
	//Add Element at a position
	public void add(int position, int data){
		if(position<0){
			throw new IllegalArgumentException("Position cannot be less than zero");
		}
		if(size==0){
			add(data);
		}if(position==0){
			addFirst(data);
		}else if(position==size-1){
			addLast(data);
		}
		else{
			int loopCounter=0;
			DLLNode newNode = new DLLNode(data);
			DLLNode listIter = head;
			while(null!=listIter){
				if(loopCounter==position){ // add at this position
					DLLNode current = listIter;
					DLLNode oldPrev = listIter.prev;
					oldPrev.next = newNode;
					newNode.next = current;
					current.prev = newNode;
					newNode.prev = oldPrev;
					size++;
				} 
				loopCounter++;
				listIter = listIter.next;
			}
		}
	}
	
	public void replace(int position, int data){
		if(position<0){
			throw new IllegalArgumentException("Position cannot be less than zero");
		}
		if(size==0){
			throw new IllegalArgumentException("Size cannot be zero");
		}if(position==0){ // just replacing data.... Is this fine ?????
			DLLNode oldHead = head;
			head = new DLLNode(data);
			head.next = oldHead.next;
			oldHead.next.prev = head;
			oldHead = null;
			// alternate head.data = data;
		}else if(position==size-1){
			tail.data = data;
		}
		else{
			int loopCounter=0;
			DLLNode newNode = new DLLNode(data);
			DLLNode listIter = head;
			while(null!=listIter){
				if(loopCounter==position){ // add at this position
					DLLNode oldPrev = listIter.prev;
					DLLNode oldNext = listIter.next;
					oldPrev.next = newNode;
					newNode.prev = oldPrev;
					newNode.next = oldNext;
					oldNext.prev = newNode;
					size++;
				} 
				loopCounter++;
				listIter = listIter.next;
			}
		}
	}
	
	// Delete a node from the beginning
	public DLLNode deleteFirst(){
		if(size==0){
			return null;
		}else if(size==1){
			DLLNode toDelete = head;
			head=null;
			tail=null;
			size--;
			return toDelete;
		}
		else{
			DLLNode toDelete = head;
			DLLNode newHead = toDelete.next;
			head = newHead;
			toDelete.next=null;
			head.prev=null;
			size--;
			return toDelete;
		}
	}
	
	// Delete a node from the last
	public DLLNode deleteLast(){
		if(size==0){
			return null;
		}else{
			DLLNode toDelete = tail;
			DLLNode newTail = toDelete.prev;
			tail = newTail;
			toDelete.next=null;
			tail.next=null;
			size--;
			return toDelete;
		}
	}
	
	// Delete a node at a beginning of the list
	public DLLNode delete(){
		return deleteFirst();
	}
	
	// this removed the element present in the given index
	public DLLNode delete(int position){
		if(position==0){
			return deleteFirst();
		}else if(position == size-1){
			return deleteLast();
		}else{
			int loopCounter=0;
			DLLNode toReturn =new DLLNode();
			DLLNode listHead = head;
			while(null!=listHead){
				if(loopCounter==position){
					DLLNode oldNext = listHead.next;
					DLLNode oldPrev = listHead.prev;
					oldNext.prev = oldPrev;
					oldPrev.next = oldNext;
					size--;
					toReturn = listHead;
				}
				loopCounter++;
				listHead = listHead.next;
			}
			return toReturn;
		}
	}
	
	
	// this method returns the index of element
	public int indexOf(int element){
		if(size==0){
			return -1;
		}else if(null==head){
			return -1;
		}else{
			DLLNode toIter = head;
			int loopCounter=0;
			while(null!=toIter){
				if(toIter.data==element){
					return loopCounter;
				}
				loopCounter++;
				toIter = toIter.next;
			}
			return -1;
		}
	}
	
	
	// this method returns the last occurence index of element
	public int lastIndexOf(int element){
		if(size==0){
			return -1;
		}else if(null==head){
			return -1;
		}else{
			DLLNode toIter = tail;
			int loopCounter=size-1;
			while(null!=toIter){
				if(toIter.data==element){
					return loopCounter;
				}
				loopCounter--;
				toIter = toIter.prev;
			}
			return -1;
		}
	}
	
	// this method removes the first Occurence of the element
	public boolean removeFirstOccurence(int element){
		if(size==0){
			return false;
		}else{
			int index = indexOf(element);
			if(index==-1){
				return false;
			}else{
				if(null!=delete(index)){
					return true;
				}else{
					return false;
				}
			}
		}
	}
	
	// this method removes the last Occurence of the element
	public boolean removeLastOccurence(int element){
		if(size==0){
			return false;
		}else{
			int index = lastIndexOf(element);
			if(index==-1){
				return false;
			}else{
				if(null!=delete(index)){
					return true;
				}else{
					return false;
				}
			}
		}
	}
	
	// This method returns first element of the list
	public int getFirst(){
		if(size==0){
			throw new IllegalArgumentException(" List is empty");
		}else{
			return head.data;
		}
	}
	
	// This method returns first element of the list
	public int getLast(){
		if(size==0){
			throw new IllegalArgumentException(" List is empty");
		}else{
			return tail.data;
		}
	}
	
	// this method returns the element at the index entered
	public int get(int index){
		if(size==0){
			throw new IllegalArgumentException("List is Empty");
		}else if(index<0){
			throw new IllegalArgumentException("Index cannot be negative");
		}else{
			int loopCounter=0;
			DLLNode toIter = head;
			while(null!=toIter){
				if(loopCounter==index){
					return toIter.data;
				}
				toIter = toIter.next;
				loopCounter++;
			}
			throw new IllegalArgumentException("Not found");
		}
	}
	
	// this method removes all the elements from the list
	public void clear(){
		if(size==0){
			throw new IllegalArgumentException("List is Empty");
		}else{
			System.out.println("size: "+size);
			int listSize = size;
			while(listSize!=0){
				delete(0);
				listSize = size;
			}
		}
	}
	
	// this method returns if an element is present or not
	public boolean contains(int element){
		if(size==0){
			return false;
		}else{
			DLLNode toIter = head;
			while(null!=toIter){
				if(element==toIter.data){
					return true;
				}
				toIter = toIter.next;
			}
			return false;
		}
	}
	
	// this method is to display the list
	public  void displayListForward(){
		if(size==0 || null==head || null == tail){
			throw new IllegalArgumentException("List is Empty");
		}else{
			DLLNode tempIter = head;
			System.out.print("List in Forward  direction ");
			while(null!=tempIter){
				System.out.print("---> " +tempIter.data);
				tempIter = tempIter.next;
			}
			System.out.println(" ");
		}
	}
	
	// this method is to display the list in the backward direction
	public  void displayListBackward(){
		if(size==0 || null==head || null == tail){
			throw new IllegalArgumentException("List is Empty");
		}else{
			DLLNode tempIter = tail;
			System.out.print("List in Backward direction ");
			while(null!=tempIter){
				System.out.print("---> " +tempIter.data);
				tempIter = tempIter.prev;
			}
			System.out.println(" ");
		}
	}
	
	
}
class DLLNode{
	 int data;
	 DLLNode next;
	 DLLNode prev;
	
	public DLLNode(){
	
	}
	
	public DLLNode(int data){
		this.data  = data;
	}
}