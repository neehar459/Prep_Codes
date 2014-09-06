public class SortSLL{
	public static void main(String[] args){
		SortSLL sLL = new SortSLL();
		SLL randList = sLL.generateRandomLL(0,6,6);
		System.out.println("UnSorted Linked List ");
		sLL.displaySLL(randList);
		SLLNode mergedHead=mergeSortLL(randList.head);
		System.out.println("Sorted Linked List ");
		displayList(mergedHead);
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
	public static void addNode(SLLNode node, SLL list){
		if(list.size==0){
			list.head=node;
			list.size++;
		}else if(list.size>0){
			SLLNode oldHead = list.head;
			list.head =node;
			node.next = oldHead;
			list.size++;
		}
	}
	
	public static SLLNode mergeSortLL(SLLNode head){
		
		 if (null==head || null==head.next){ // base condition
			return head;
		}
			// code to count the size of list
			SLLNode iterNode = head;
			int countSize =0;
			while(null!=iterNode){
				countSize++;
				iterNode = iterNode.next;
			}
			//System.out.println("List size : "+countSize);
			// Dividing the list in to two sublists.
			int mid = (int)Math.ceil(countSize/2.0);
			int leftCounter=0;
			SLLNode LeftNodeToPass  = head;
			SLLNode rightListHead=null;
			SLLNode temp = head;
			while(null!=temp){
				leftCounter++;
				SLLNode tempNext =temp.next;
				if(leftCounter==mid){
					temp.next=null;
					rightListHead = tempNext;
				}
				temp = temp.next;
			}
			SLLNode leftNode = mergeSortLL(LeftNodeToPass);
			SLLNode rightNode = mergeSortLL(rightListHead);
			
		return (merge(leftNode,rightNode));
	}
	
	public static SLLNode merge(SLLNode l, SLLNode r){
		SLLNode leftNode = l;
		SLLNode rightNode = r;
		SLLNode mergedHead = new SLLNode(100); // Dummie Node. Without this it is not easy to make in O(n). Otherwise every insert would be taking O(n).
		// Put this as head. But add elements using another node which initially points to head.
		SLLNode pointerHead = mergedHead;
		while(null!=leftNode || null!=rightNode){
			// this condition checks if first linkedlist ends . In this case we have to copy the contents of other list in to merged list as those
			// values would have been in sorted order already.
			if(null==leftNode){
				pointerHead.next = new SLLNode(rightNode.data);
				pointerHead = pointerHead.next;
				rightNode = rightNode.next;
			}
			// this condition checks if second linkedlist ends . In this case we have to copy the contents of other list in to merged list as those
			// values would have been in sorted order already.
			else if (null==rightNode){
				pointerHead.next= new SLLNode(leftNode.data);
				pointerHead = pointerHead.next;
				leftNode = leftNode.next;
			}
			// this code is till the iterators or pointers are inside the loop condition		
			else{
				if(leftNode.data<rightNode.data){
					pointerHead.next= new SLLNode(leftNode.data);
					leftNode = leftNode.next;
					pointerHead = pointerHead.next;
				}else if(leftNode.data==rightNode.data){
					pointerHead.next= new SLLNode(leftNode.data);
					pointerHead.next.next= new SLLNode(leftNode.data);
					leftNode = leftNode.next;
					rightNode = rightNode.next;
					pointerHead = pointerHead.next.next;
				}else{
					pointerHead.next= new SLLNode(rightNode.data);
					rightNode = rightNode.next;
					pointerHead = pointerHead.next;
				}
			}
		}
		return mergedHead.next;
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