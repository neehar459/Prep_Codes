public class ReverseLL{

public SList reverseLL(Slist inputList){
SList 
}

public static void main(String [] args){
SList list = new SList();
SNode s1 = new SNode(1);
SNode s2 = new SNode(2);
SNode s3 = new SNode(3);
SNode s4 = new SNode(4);
SNode s5 = new SNode(5);
s1.next = s2;
s2.next = s3;
s3.next = s4;
s4.next = s5;
s5.next = null;
}

public void displayList(SList list){
SNode iterNode = list.head;
if(null==list.head){
throw new IllegalArgumentException("List is Empty");
}else{
do{
System.out.print(iterNode.value+" --> ");
iterNode = iterNode.next;
}while(iterNode!=null);
System.out.println();
}
}
}
class SNode{
int value;
SNode next;
public SNode(){
}
public SNode(int value){
this.value = value;
}
}
class SList{
SNode head;
}