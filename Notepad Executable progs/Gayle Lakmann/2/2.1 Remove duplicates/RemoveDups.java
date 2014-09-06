public class RemoveDups{
	public static void main(String[] args){
		SLLNode n1 =new SLLNode(1);
		SLLNode n2 =new SLLNode(2);
		SLLNode n3 =new SLLNode(3);
		SLLNode n4 =new SLLNode(4);
		SLLNode n5 =new SLLNode(5);
		SLLNode n6 =new SLLNode(6);
		SLL sList = new SLL(n1);
		SLLNode a1 =new SLLNode(1);
		SLLNode a2 =new SLLNode(2);
		SLLNode a3 =new SLLNode(3);
		SLLNode a4 =new SLLNode(4);
		SLLNode a5 =new SLLNode(2);
		SLLNode a6 =new SLLNode(6);
		SLL sList2 = new SLL(a1);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = null;
		n1.next=n6;
		n6.next=n2;
		n2.next=n5;
		n5.next=n3;
		n3.next=n4;
		n4.next=null;
		sList.size=6;
		RemoveDups rDups = new RemoveDups();
		//rDups.displaySLL(sList);
		sList2.size=6;
		rDups.removeDups(sList);
		System.out.println("List size : "+sList2.size);
		rDups.displaySLL(sList);
	}
	
	public void removeDups(SLL list){
		if(list.size==0){
			throw new IllegalArgumentException("List is Empty");
		}else if(null==list.head){
			throw new IllegalArgumentException("List Head is null");
		}else if(list.size==1){
			throw new IllegalArgumentException("List has only one element. Cannot find Duplicate");
		}else if (list.size==2){
			if(list.head.data == list.head.next.data){
				list.head.next=null;
			}
		}
		else{ // if list size is > 2
			// brute force solution
			SLLNode firstIter = list.head;
			SLLNode secondIter =null;
			SLLNode prev = null;
			while(null!=firstIter){
				if(null!=firstIter.next){
				prev = firstIter;
				secondIter = firstIter.next;
				}
				while(null!=secondIter){ // dont move prev pointer in case of delete **** to note ***** made mistake
					if(firstIter.data == secondIter.data){
							secondIter = secondIter.next;
							prev.next=secondIter;
							list.size--;
					}
					// if there is no repeat element in the iteration
					else{ // move prev in case of no match
						prev = secondIter;
						secondIter = secondIter.next;
						prev.next = secondIter;
					}
				}
				firstIter = firstIter.next;
			}
		}
	}
	
	public  void displaySLL(SLL list){
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