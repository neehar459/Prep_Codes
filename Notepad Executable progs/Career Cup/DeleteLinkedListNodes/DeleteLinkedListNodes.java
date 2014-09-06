public class DeleteLinkedListNodes{

public SList deleteNodes(int value, SList list){
SList toReturn = list;
SNode prevNode = null;
int counter=0;
int noOfDeletions =0;
if(null==toReturn.head){
throw new IllegalArgumentException("List is Empty. Input should be not empty");
}else{
SNode iterNode = toReturn.head;
do{
// case 1 : if value is head
if((iterNode.value == toReturn.head.value) && (iterNode.value == value)){
toReturn.head = iterNode.next;
prevNode = iterNode.next;
//iterNode = iterNode.next;
noOfDeletions++;
}// case 2 : if iterating element is head but not delete value
else if ((iterNode.value == toReturn.head.value) &&(iterNode.value != value)){
prevNode = iterNode;
//iterNode = iterNode.next;
} 
else{ // case 3 : if the value to be deleted is not head 
if(iterNode.value == value){
prevNode.next = iterNode.next;
//iterNode = iterNode.next;
noOfDeletions++;
}else{
prevNode = iterNode;
//iterNode = iterNode.next;
}
}
iterNode = iterNode.next;
}while(iterNode!=null);
}
System.out.println("no of deletions : "+noOfDeletions);
return toReturn;
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
public static void main(String[] args){
SList list = new SList();
SNode s1= new SNode(51);
SNode s2= new SNode(2);
SNode s3= new SNode(5);
SNode s4= new SNode(4);
SNode s5= new SNode(5);
SNode s6 = new SNode(1);

list.head = s1;
s1.next = s2;
s2.next = s3;
s3.next = s4;
s4.next = s5;
s5.next = s6;
s6.next = null; 
DeleteLinkedListNodes dLNode = new DeleteLinkedListNodes();
System.out.println("Initial List : ");
dLNode.displayList(list);
SList modifiedList = dLNode.deleteNodes(5,list);
System.out.println("Modified List : ");
dLNode.displayList(modifiedList);
}
}
class SNode{
int value;
SNode next;
public SNode(){
}
public SNode(int value){
this.value= value;
}
}
class SList{
SNode head;
}