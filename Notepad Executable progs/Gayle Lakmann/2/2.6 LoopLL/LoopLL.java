public class LoopLL{
	public static void main(String[] args){
		LoopLL loopLL = new LoopLL();
		SLLNode a1 = new SLLNode(1);
		SLLNode a2 = new SLLNode(2);
		SLLNode a3 = new SLLNode(3);
		SLLNode a4 = new SLLNode(4);
		SLLNode a5 = new SLLNode(5);
		SLLNode a6 = new SLLNode(6);
		SLLNode a7 = new SLLNode(7);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;
		a7.next = a3;
		SLL list = new SLL(a1);
		list.size = 7;
		//displayList(a1);
		SLLNode loopNode = loopLL.loopStartNode(a1);
		System.out.println("loop Node Start : "+loopNode.data);
	}
	
	public SLLNode loopStartNode(SLLNode head){
		if(null==head){
			throw new IllegalArgumentException("Head is null. List is not valid");
		}else{
			SLLNode slowNode = head;
			SLLNode fastNode = head;
			// Finding where both slow node and fast node meet.no of iters : loopsize - k
			while(null!=fastNode&&null!=fastNode.next){
				slowNode = slowNode.next;
				fastNode = fastNode.next.next; // 2 steps at a time.
				if(slowNode.data == fastNode.data){
					break;
				}
			}
			System.out.println("Collision Point : "+slowNode.data);
			// If there is no loop.
			if(null== fastNode || null == fastNode.next){
				return null;
			}
			// Move slow node to head of list but keeping fastNode at collision point. each will be k steps far from starting point of loop.
			// Now they move at a same pace and they will meet at loop start.
			slowNode = head;
			while(slowNode!=fastNode){
				slowNode = slowNode.next;
				fastNode = fastNode.next;
			}
			
			// After the above while loop both slow and fast nodes point to the loop start node.
			return slowNode;
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