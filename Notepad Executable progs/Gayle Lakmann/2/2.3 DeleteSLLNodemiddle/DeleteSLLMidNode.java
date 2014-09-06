public class DeleteSLLMidNode{

	public static void main(String[] args){
		
	}

	public void deleteSLLMidNode(SLLNode toDelNode){
		// Given a middle node (not root node), we need to delete that node.
		// Use idea from ADS class of deleting node from binomial tree given by Sahni Sir.
		// Approach : Copy the next node data in to the node we need to delete. Then delete the next node.
		// check if the node is null
		if(null==toDelNode || null ==toDelNode.next){
			return null;
		}
		SLLNode temp = toDelNode.next;
		temp.data = toDelNode.next.data;
		temp.next = toDelNode.next.next;
		toDelNode = temp;
		
		// But what if the node to delete is the last node.the next to last node will be null;
		// In this case we need to have some dummy node as the last node.
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