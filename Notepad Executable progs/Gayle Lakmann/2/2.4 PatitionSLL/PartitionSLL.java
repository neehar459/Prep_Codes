public class PartitionSLL{ // points to note : use "last node" pointers and add elements to the last of list 
	public static void main(String[] args){
		PartitionSLL pSLL = new PartitionSLL();
		//SLL list = pSLL.generateRandomLL(1,5,5);
		SLLNode n1 =new SLLNode(1);
		SLLNode n2 =new SLLNode(2);
		SLLNode n3 =new SLLNode(3);
		SLLNode n4 =new SLLNode(4);
		SLLNode n5 =new SLLNode(5);
		SLLNode n6 =new SLLNode(6);
		SLLNode n7 =new SLLNode(7);
		SLL sList = new SLL(n1);
		sList.size=6;
		n1.next=n6;
		n6.next=n2;
		n2.next=n5;
		n5.next=n3;
		n3.next=n7;
		n7.next=n4;
		n4.next=null;
		pSLL.displaySLL(sList);
		SLL partList = pSLL.partitionList(sList,4);
		pSLL.displaySLL(partList);
	}
	
	public SLL partitionList(SLL list, int centre){
		// Task : Make partition of given list in to list in such a way that all left nodes of centre 
		// are less and all nodes of grater value are on the right side of centre node.
		
		// approach 1: sort the list which does in place. But takes O(nlogn) time.
		// approach 2: Iterate through array once and create 2 linked lists such that one list will have all less values 
		// and other will have all larger values. Finally merge those lists. Time : O(n). But Space O(n).
		
		// Approach 2
			SLLNode temp = list.head;
			SLL smallList = new SLL();
			SLL largeList = new SLL();
			SLL sameList = new SLL();
			SLLNode smallLast = new SLLNode();
			SLLNode largeLast = new SLLNode();
			SLLNode sameLast = new SLLNode();
		if(list.size==0){
			throw new IllegalArgumentException("List is Empty");
		}else if(null==list.head){
			throw new IllegalArgumentException("List Head is null");
		}else{
			while(null!=temp){
				//System.out.println("ll node element : "+temp.data);
				if(temp.data<centre){
					if(smallList.size==0){
						smallList.head = new SLLNode(temp.data);
						smallLast =smallList.head;
						smallLast.next=null;
					}else{ // add new element to end of list and make that as list last element
						smallLast.next = new SLLNode(temp.data);
						smallLast = smallLast.next;
					}
					smallList.size++;
				}else if(temp.data>centre){
					if(largeList.size==0){
						largeList.head = new SLLNode(temp.data);
						largeLast =largeList.head;
						largeLast.next=null;
					}else{ // add new element to end of list and make that as list last element
						largeLast.next = new SLLNode(temp.data);
						largeLast = largeLast.next;
					}
					largeList.size++;
				}else{ // if there are many elements equal to centre element
					if(sameList.size==0){
						sameList.head = new SLLNode(temp.data);
						sameLast =sameList.head;
						sameLast.next=null;
					}else{
						sameLast.next = new SLLNode(temp.data);
						sameLast = sameLast.next;
					}
					sameList.size++;
				}
				temp=temp.next;
			}
			// Merging all the three lists
			// iterating 2 of the lists to find the last elements and then merging the lists by mere pointer changes
			// Merging lists from the end.
			if(((smallList.size)>0)&&((largeList.size)>0)&&((sameList.size)>0)){
				smallLast.next=sameList.head;
				sameLast.next=largeList.head;
			}
		}
		return smallList;
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