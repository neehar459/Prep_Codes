public class LLPalindrome{
	public static void main(String [] args){
		LLPalindrome llPalindrome = new LLPalindrome();
		SLLNode a1 = new SLLNode(1);
		SLLNode a2 = new SLLNode(3);
		SLLNode a3 = new SLLNode(3);
		SLLNode a4 = new SLLNode(4);
		SLLNode a5 = new SLLNode(3);
		SLLNode a6 = new SLLNode(3);
		SLLNode a7 = new SLLNode(1);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;
		a7.next = null;
		SLL list = new SLL(a1);
		list.size = 7;
		displayList(a1);
		boolean result = llPalindrome.isPalindromeList(a1);
		if(result){
			System.out.println("Given Linked List is Palindrome");
		}else{
			System.out.println("Given Linked List is NOT Palindrome");
		}
	}
	
	public boolean isPalindromeList(SLLNode head){
		// approach1:  create reverse of given LL by iterating over original ll n add elements to front and compare both.
		// approach 2 : push first half elements to stack and compare remaining elements of LL with stack contents
			// We can use direct middle point if we know size of list. If we dont know list size we can use slow and fast nodes.
			// by the time fast reaches end of list, slow will be at mid point. By this we can reach mid of list.
		// approach 3 : use recursion. But cumbersome in java.
		if(null==head){
			return false;
		}else{
			// create reverse Linked List
			SLLNode origListIter = head;
			SLLNode revHead;
			SLL revList=new SLL();
			int counter=0;
			while(null!=origListIter){
				counter++;
				revHead = new SLLNode(origListIter.data);
				if(counter==1){
					revList.head =revHead;
				}else{
					SLLNode tempHead = revList.head;
					revList.head = revHead;
					revHead.next = tempHead;
				}
				origListIter = origListIter.next;
			}
			// check if both the elements are some.
			SLLNode origIter =head;
			SLLNode revIter = revList.head;
			while(null!=origIter&&null!=revIter){
				if(origIter.data!=revIter.data){
					return false;
				}
				origIter = origIter.next;
				revIter = revIter.next;
			}
		}
		return true;
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