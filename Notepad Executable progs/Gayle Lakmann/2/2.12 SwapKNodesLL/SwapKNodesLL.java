public class SwapKNodesLL{
	public static void main(String[] args){
		SLL list = new SLL();
		SLLNode node1 = new SLLNode(1);
		SLLNode node2 = new SLLNode(2);
		SLLNode node3 = new SLLNode(3);
		SLLNode node4 = new SLLNode(4);
		SLLNode node5 = new SLLNode(5);
		SLLNode node6 = new SLLNode(6);
		SLLNode node7 = new SLLNode(7);
		SLLNode node8 = new SLLNode(8);
		SLLNode node9 = new SLLNode(9);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = null;
		list.head = node1;
		list.size = 9;
		System.out.println("Before reversing list :");
		displayList(list.head);
		swapK(list.head, 4);
		System.out.println("After reversing list :");
		displayList(list.head);
	}
	
	public static SLLNode swapK(SLLNode node, int k){
		if(k == 1){
			return node;
		}else{
			SLLNode temp = node;
			SLLNode prev = null;
			for(int i=1; i < k; i++){
				if(null == temp){
					return node;
				}
				prev = temp;
				temp = temp.next;
			}
			if(null == temp){
				return node;
			}
			SLLNode qNode = swapK(temp.next, k);
			if(temp!= node.next){
				temp.next = node.next;
				prev.next = node;
			}else{ // k =2; avoid infinite loop
				//temp.next = node;
			}
			node.next = qNode;
			return temp;
		}
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