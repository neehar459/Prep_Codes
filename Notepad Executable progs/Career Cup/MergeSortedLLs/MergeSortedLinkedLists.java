public class MergeSortedLinkedLists{
	public static void main(String[] args){
		MergeSortedLinkedLists mSLL = new MergeSortedLinkedLists();
		LLNode node4 = new LLNode(4,null);
		LLNode node3 = new LLNode(3,node4);
		LLNode node2 = new LLNode(2,node3);
		LLNode head1 = new LLNode(1,node2);
		LLNode node25 = new LLNode(9,null);
		LLNode node24 = new LLNode(7,node25);
		LLNode node23 = new LLNode(5,node24);
		LLNode node22 = new LLNode(3,node23);
		LLNode head2 = new LLNode(1,node22);
		LLNode mergedHead = mSLL.mergeLists(head1, head2);
		LLNode iterNode = mergedHead;
		while(iterNode!=null){
			System.out.print("---> " + iterNode.value);
			iterNode = iterNode.next;
		}
	}
	public LLNode mergeLists(LLNode head1, LLNode head2){
		LLNode toReturnHead = null;
		LLNode prevNode = null;
		//List 1: 1->2->3->4
//List 2: 1->3->5->7->9
		if( null == head1 && null == head2){
			return null;
		}else if (null == head2 && null!= head1){
			return head1;
		}else if (null == head1 && null!= head2){
			return head2;
		}else{
			LLNode iterNode1 = head1;
			LLNode iterNode2 = head2;
			if(head1.value <= head2.value){
				toReturnHead = new LLNode(head1.value,null);
				iterNode1 = head1.next;
				prevNode = toReturnHead;
			}else{
				toReturnHead = new LLNode(head2.value, null);
				iterNode2 = head2.next;
				prevNode = toReturnHead;
			}
			while(null != iterNode1 && null != iterNode2){
				if(iterNode1.value <= iterNode2.value){
					LLNode tempNode = new LLNode(iterNode1.value,null);
					prevNode.next = tempNode;
					iterNode1 = iterNode1.next;
					prevNode = tempNode;
					System.out.println("InsertedNode loop 1 cond 1 : "+tempNode.value);
				}else{
					LLNode tempNode = new LLNode(iterNode2.value,null);
					prevNode.next = tempNode;
					iterNode2 = iterNode2.next;
					prevNode = tempNode;
					System.out.println("InsertedNode loop1 cond 2: "+tempNode.value);
				}
				
			}
			while(null!=iterNode1){
				// Copy the remaining elements of list 1 in to the return list
				LLNode tempNode = new LLNode(iterNode1.value,null);
				prevNode.next = tempNode;
				iterNode1 = iterNode1.next;
				prevNode = tempNode;
				System.out.println("InsertedNode loop2 : "+tempNode.value);
			}
			while(null!=iterNode2){
				// Copy the remaining elements of list 2 in to the return list 
				LLNode tempNode = new LLNode(iterNode2.value,null);
				prevNode.next = tempNode;
				iterNode2 = iterNode2.next;
				prevNode = tempNode;
				System.out.println("InsertedNode loop3 : "+tempNode.value);
			}
		}
		return toReturnHead;
	}
}
class LLNode{
	public int value;
	public LLNode next;
	
	public LLNode(){
		value =0;
		next = null;
	}
	
	public LLNode(int value, LLNode next){
		this.value = value;
		this.next = next;
	}
}