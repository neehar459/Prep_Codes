public class ReverseLLInPairs{
	public static void main(String[] args){
		SLLNode node1 = new SLLNode(1);
		SLLNode node2 = new SLLNode(2);
		SLLNode node3 = new SLLNode(3);
		SLLNode node4 = new SLLNode(4);
		SLLNode node5 = new SLLNode(5);
		SLLNode node6 = new SLLNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		//node4.next = node5;
		//node5.next = node6;
		System.out.println("List before delete : ");
		displayList(node1);
		SLLNode swappedHead = reverseLLInPairs(node1);
		displayList(swappedHead);
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
	public static SLLNode reverseLLInPairs(SLLNode node){
		if(node == null){
			return null;
		}else{
			if(node.next == null){
				return node;
			}else{
				SLLNode toReturnNode = node.next;
				SLLNode next1,next2,current = node;
				SLLNode fourthNode = new SLLNode(-1);
				if(current.next != null && current.next.next != null){
					while(current.next != null && current.next.next != null){
						next1 = current.next;
						next2 = current.next.next;
						next1.next = current;
						if(next2 != null){
							fourthNode = next2.next;
						}
						if(fourthNode != null){
							current.next = fourthNode;
						}else{
							current.next = next2;
						}
					current = next2;
					}
				}else{
					toReturnNode.next = node;
					node.next = null;
				}				
				if(fourthNode != null){
					fourthNode.next = current;
				}
				current.next = null;
				return toReturnNode;
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
