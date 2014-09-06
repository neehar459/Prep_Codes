public class DeleteNodeWithGivenAddress{
	public static void main(String[] args){
		SLLNode node1 = new SLLNode(1);
		SLLNode node2 = new SLLNode(2);
		SLLNode node3 = new SLLNode(3);
		SLLNode node4 = new SLLNode(4);
		SLLNode node5 = new SLLNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		System.out.println("List before delete : ");
		displayList(node1);
		System.out.println("Delete Status : "+deleteNode(node3));
		System.out.println("List after delete : ");
		displayList(node1);
	}
	public static void displayList(SLLNode node){
		if(node == null){
			throw new IllegalArgumentException("List cannot be empty");
		}else{
			SLLNode iterNode = node;
			while(iterNode != null){
				System.out.print("--> "+iterNode.data);
				iterNode = iterNode.next;
			}
			System.out.println();
		}
	}
	public static boolean deleteNode(SLLNode node){
		if(node == null){
			return false;
		}else{
			if(node.next == null){
				System.out.println("Last node");
				node = null;
				return true;
			}else{
				SLLNode nextNode;
				SLLNode nextNextNode;
				nextNode = node.next;
				nextNextNode = nextNode.next;
				node.data = nextNode.data;
				node.next = nextNextNode;
				nextNode = null;
				return true;
			}
		}
	}
}
class SLLNode{
	int data;
	SLLNode next;
	public SLLNode(){
		
	}
	public SLLNode(int data){
		this.data = data;
	}
}
class SLL{
	SLLNode head;
	int size;
}
