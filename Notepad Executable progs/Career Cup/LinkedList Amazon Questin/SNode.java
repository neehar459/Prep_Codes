public class SNode{
	private int value;
	private SNode next;
	public SNode(){
	}
	public SNode(int value){
		this.value = value;
	}
	public void displayList(sList list){
	SNode start = list.start;
	do{
	System.out.print(start.value +"--->");
	start = start.next;
	}while(start!=null);
	System.out.println();
	}
	public sList mergeSortedLists(sList sList){
		SNode firstListLastElement = null;
		sList toReturn = sList;
		SNode temp = null;
		SNode secondStart = null;
		if(null==toReturn.start){
		throw new IllegalArgumentException("List is null");
		}else{
			SNode toIterate = toReturn.start;
			do{
			if(toIterate.value > toIterate.next.value){
			secondStart = toIterate.next;
			break;
			}
			toIterate = toIterate.next;
			}while(true);
			firstListLastElement = toIterate;
		}
		SNode firstPointer = toReturn.start;
		SNode firstPrev = firstPointer;
		SNode secondPointer = secondStart;
		do{
		temp = secondPointer.next;
		if(firstPointer.value < secondPointer.value){
		SNode fNext = firstPointer.next;
		firstPrev = firstPointer;
		firstPointer = fNext;
		}else if(firstPointer.value == secondPointer.value){
		SNode temp1 = firstPointer.next;
		firstPrev = firstPointer;
		firstPrev.next = secondPointer;
		secondPointer.next = temp1;
		firstPointer = firstPrev.next;
		secondPointer = temp;
		}else if(firstPointer.value > secondPointer.value){
		firstPrev.next = secondPointer;
		secondPointer.next = firstPointer;
		firstPrev = secondPointer;
		secondPointer = temp;
		firstListLastElement.next = secondPointer;
		}
	}while(secondPointer!=null);
		
		return toReturn;
	}
	public static void main(String[] args){
	sList list = new sList();
	SNode node = new SNode();
	SNode s1 = new SNode(1);
	SNode s2 = new SNode(5);
	SNode s3 = new SNode(7);
	SNode s4 = new SNode(9);
	SNode s5 = new SNode(11);
	SNode s6 = new SNode(2);
	SNode s7 = new SNode(4);
	SNode s8 = new SNode(6);
	list.start = s1;
	s1.next = s2;
	s2.next = s3;
	s3.next = s4;
	s4.next = s5;
	s5.next = s6;
	s6.next = s7;
	s7.next = s8;
	s8.next = null;
	System.out.println(" Initial List");
	node.displayList(list);
	sList newList = node.mergeSortedLists(list);
	System.out.println(" Merged List");
	node.displayList(newList);
	}
}
class sList{
	public SNode start;
}