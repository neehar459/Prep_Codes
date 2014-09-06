public class KthLast{
	public static void main(String[] args){
		KthLast kLast  = new KthLast();
		SLL list = kLast.generateRandomLL(1,20,15);
		kLast.displaySLL(list);
		SLLNode kthNode = kLast.findKthLast(list,15);
		System.out.println("Required Node : "+kthNode.data);
		SLLNode kthNode1 = kLast.findKthLast2(list,15);
		System.out.println("Required Node 1: "+kthNode1.data);
	}
	// This method returns nth element from the last of a SLL
	// approach 1: iterate once and find the number of elements and then find the n-k element
	public SLLNode findKthLast(SLL list, int position){
		
		SLLNode kthLastNode = new SLLNode();
		// iterating over the linked list and finding the number of elements
		int listSize =0;
		SLLNode temp = list.head;
		if(list.size==0){ // if list size is known
			throw new IllegalArgumentException("List is Empty"); // check if the list size is zero
		}
		if(null==list.head){ // if list size is not known
			throw new IllegalArgumentException("List Head is null"); // check if the list head is null
		}else{
			while(null!=temp){
				listSize++;
				temp = temp.next;
			}
		}
		// iterating over to find the n-k the element
		int nodePosToReturn = listSize-position+1;
		int loopCounter=0;
		if(nodePosToReturn<0){
			return null;
		}
		if(nodePosToReturn==0){
			return list.head;
		}
		temp= list.head;
		while(null!=temp){
			loopCounter++;
			if(loopCounter==nodePosToReturn){
				kthLastNode = temp;
				break;
			}
			temp=temp.next;
		}
		return kthLastNode;
	}
	
	// approach 2 : Use 2 pointers and make second pointer start at kth position. By the time the second pointer.next goes to null, first 
	// will be at the n-k th position and kth position from the end; In this case k=0 has no meaning. k =1 implies last element.
	public SLLNode findKthLast2(SLL list, int position){
		if(position<=0){
			return null;
		}
		SLLNode toReturn = new SLLNode();
		SLLNode helperNode = new SLLNode();
		// placing helperNode at kth position
		toReturn = list.head;
		helperNode = list.head;
		for(int i=0;i<position-1;i++){
			helperNode = helperNode.next;
		}
		if(null==helperNode){
			return null;
		}
		while(null!=helperNode){
			if(null==helperNode.next){
				return toReturn;
			}
			toReturn = toReturn.next;
			helperNode = helperNode.next;
		}
		return toReturn;
	}
	
	
	public SLL generateRandomLL(int min, int max, int nodes){
		SLLNode[] nodeList = new SLLNode[nodes];
		for(int i=0;i<nodes;i++){
			nodeList[i] = new SLLNode(min + (int)(Math.random() * ((max - min) + 1)));
		}
		SLL randomLL = new SLL(nodeList[0]);
		for(int i=0;i<nodeList.length;i++){
			if(i==nodeList.length-1){
			nodeList[i].next = null;	
			}else{
			nodeList[i].next = nodeList[i+1];
			}
			randomLL.size++;
		}
		return randomLL;
	}
	
	public void displaySLL(SLL list){
		if(list.size==0){
			throw new IllegalArgumentException("List is Empty");
		}else if(null==list.head){
			throw new IllegalArgumentException("List Head is null");
		}else{
			// temp pointer to copy head node
			SLLNode temp = list.head;
			System.out.println("Displaying Linked List");
			
			while(temp!=null){
				System.out.print("--> " +temp.data);
				temp=temp.next;
			}
			System.out.println(" ");
		}
	}
}


class SLLNode{
		int data;
		SLLNode next;
		public SLLNode(){
		}
		public SLLNode(int data){
			this.data=data;
		}
}

class SLL{
	int size;
	SLLNode head;
	public SLL(){
		
	}
	public SLL(SLLNode n){
	head = n;
	}
}