//http://www.careercup.com/question?id=5636453975457792
public class AddLLNodes{
	public static void main(String[] args){
		SLL list1 = new SLL();
		SLLNode node1 = new SLLNode(5);
		SLLNode node2 = new SLLNode(4);
		SLLNode node3 = new SLLNode(7);
		list1.head = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = null;
		list1.size = 3;
		SLL list2 = new SLL();
		SLLNode node21 = new SLLNode(8);
		SLLNode node22 = new SLLNode(3);
		//SLLNode node23 = new SLLNode(9);
		list2.head = node21;
		node21.next = node22;
		node22.next = null;
		//node23.next = null;
		list2.size = 2;
		SLL resultList = addLLNodes(list1,list2);
		displaySLL(resultList.head);
		SLL list3 = new SLL();
		list3.size = 0;
		//SLL resultList1 = addLLNodes(list1,list3);
		//displaySLL(resultList1.head);
		//System.out.println("Before reverse : ");
		//displaySLL(list1.head);
		//reverseLL(list1);
		//System.out.println("After reverse head : "+list1.head.data);
		//displaySLL(list1.head);
	}
	
	public static SLL addLLNodes(SLL intList1, SLL intList2){
		SLL returnList = new SLL();
		int carryOn = 0;
		
		SLLNode resultListDumb = null;
		SLLNode resultListHead = null;
		if(intList1.size == 0 && intList2.size == 0){
			return null;
		}else if(intList1.size == 0 || null == intList1.head){
			returnList = intList2;
			return returnList;
		}else if(intList2.size == 0 || null == intList2.head){
			returnList = intList1;
			return returnList;
		}else{
			reverseLL(intList1);
			reverseLL(intList2);
			SLLNode list1Head = intList1.head;
			SLLNode list2Head = intList2.head;
			while(null != list1Head || null != list2Head){
				
				if(null == resultListDumb ){
					resultListDumb = new SLLNode();
					resultListHead = resultListDumb;
				}else{
					resultListDumb.next = new SLLNode();
					resultListDumb = resultListDumb.next;
				}
				if(null == list1Head){
					resultListDumb.data = (list2Head.data + carryOn) % 10;
					carryOn = (carryOn + list2Head.data) / 10;
					list2Head = list2Head.next;
				}else if (null == list2Head){
					resultListDumb.data = (list1Head.data + carryOn) % 10;
					carryOn = (carryOn + list1Head.data) / 10;
					list1Head = list1Head.next;
				}else{
					resultListDumb.data = (list1Head.data +list2Head.data+ carryOn) % 10;
					carryOn = (carryOn + list1Head.data+list2Head.data) / 10;
					list1Head = list1Head.next;
					list2Head = list2Head.next;
					if(list1Head == null && list2Head == null){
						if(carryOn !=0){
							resultListDumb.next = new SLLNode(carryOn);
							resultListDumb = resultListDumb.next;
						}
					}
				}
			}
			returnList.head = resultListHead;
			reverseLL(returnList);
			return returnList;
		}
	}
	
	public static void reverseLL(SLL list){
		if(null == list.head){
			throw new IllegalArgumentException("In valid");
		}else{
			SLLNode listHead  = list.head;
			SLLNode temp = null;
			SLLNode prev = null;
				while( null != listHead){
					temp = listHead.next;
					listHead.next = prev;
					prev = listHead;
					listHead = temp;
				}
				list.head = prev;
		}
	}
	
	public  static void displaySLL(SLLNode head){
		if(null==head){
			throw new IllegalArgumentException("List is Empty");
		}else{
			// temp pointer to copy head node
			SLLNode temp = head;
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