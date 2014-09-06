public class AddNumbersReverseLL{
	public static void main(String [] args){
		AddNumbersReverseLL sLL = new AddNumbersReverseLL();
		SLL randList1 = sLL.generateRandomLL(0,9,5);
		SLL randList2 = sLL.generateRandomLL(0,9,8);
		System.out.println("UnSorted Linked List1 ");
		sLL.displaySLL(randList1);	
		System.out.println("UnSorted Linked List2 ");
		sLL.displaySLL(randList2);
		SLLNode result = sLL.addNumbersReverse(randList1, randList2);
		System.out.println("Resultant Linked List ");
		displayList(result);
	}
	
	public SLLNode addNumbersReverse(SLL list1, SLL list2){
		SLLNode dumbHead=new SLLNode(100);
		SLLNode actualHead = dumbHead;
		if(list1.size==0&&list2.size==0){
			throw new IllegalArgumentException("Lists are empty. Cannot add");
		}else if(list1.size==0 || null==list1.head){
			return list2.head;
		}else if(list2.size==0 || null==list2.head){
			return list1.head;
		}else{
			int carryOver =0;
			int loopCounter = 0;
			SLLNode tempNode1 = list1.head;
			SLLNode tempNode2 = list2.head;
			if(list1.size==list2.size){
				while(null!=tempNode1&&null!=tempNode2){
					loopCounter++;
					int result = tempNode1.data+tempNode2.data+carryOver;
					if(result<10){
					carryOver =0;
					}
					if(loopCounter==list1.size){
						if(result>=10){
							carryOver = result/10;
							result = result-10;
							actualHead.next = new SLLNode(result);
							tempNode1= tempNode1.next;
							tempNode2= tempNode2.next;
							actualHead.next.next = new SLLNode(carryOver);
							actualHead = actualHead.next.next;
						}else{
							actualHead.next = new SLLNode(result);
							tempNode1= tempNode1.next;
							tempNode2= tempNode2.next;
							actualHead = actualHead.next;
						}						
					}else{
						if(result>=10){
						carryOver = result/10;
						result = result-10;
						}
						actualHead.next = new SLLNode(result);
						tempNode1= tempNode1.next;
						tempNode2= tempNode2.next;
						actualHead = actualHead.next;
					}
				}
			}else{// If both lists are of different sizes 
				// approach1 : check from where diff occurs and pad remianing list with zeroes till both are of same size 
				// approach2 : add till we have elements n then just copy rem elements
				// check which list is small
				int diffCounter=0;
				int loopCounter1 =0;
				boolean flagSize = false;
				if(list1.size<list2.size){
					diffCounter = list2.size-list1.size;
					flagSize = true;
				}else{
					diffCounter = list1.size-list2.size;
				}
				if(flagSize){ // implies list1 is small
					while(null!=tempNode2.next){
					if(null==tempNode1.next && list1.size<=list2.size){
						tempNode1.next = new SLLNode(0);
						list1.size++;
					}
					tempNode1 = tempNode1.next;
					tempNode2 = tempNode2.next;
					}
				}else{ // implies list2 is small
					while(null!=tempNode1.next){
					
					if(null==tempNode2.next && list2.size<=list1.size){
						tempNode2.next = new SLLNode(0);
						list2.size++;
					}
					tempNode1 = tempNode1.next;
					tempNode2 = tempNode2.next;
					}
				}
				dumbHead.next=addNumbersReverse(list1,list2);
			}
		}
			return dumbHead.next;
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