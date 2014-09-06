public class ReverseSLLRecursive{
	public static void main(String [] args){
		ReverseSLLRecursive sLL = new ReverseSLLRecursive();
		SLL randList1 = sLL.generateRandomLL(0,5,5);
		System.out.println("UnSorted Linked List1 ");
		sLL.displaySLL(randList1);	
		SLLNode revHead = sLL.reverseSLLRecursive(randList1.head);
		System.out.println("Reversed list size : "+randList1.size);
		sLL.displayList(revHead);
		}
	
	public SLLNode reverseSLLRecursive(SLLNode currentNode){
		
		if(null == currentNode){
			return null;
		}
		if(null == currentNode.next){
			return currentNode;
		}
		SLLNode restList = currentNode.next;
		SLLNode revList = reverseSLLRecursive(restList);
		restList.next = currentNode;
		currentNode.next = null;
		return revList;
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
	
	public static void displayList(SLLNode head){
		if(null==head){
			throw new IllegalArgumentException("List Head is null");
		}else{
			SLLNode temp = head;
			while(null!=temp){
				System.out.print("--> "+temp.data);
				temp = temp.next;
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