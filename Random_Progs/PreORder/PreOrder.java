import java.util.Stack;
public class PreOrder{
	public static void main(String[] args){
		BinaryTreeNode n1 = new BinaryTreeNode(1);
		BinaryTreeNode n2 = new BinaryTreeNode(2);
		BinaryTreeNode n3 = new BinaryTreeNode(3);
		BinaryTreeNode n4 = new BinaryTreeNode(4);
		BinaryTreeNode n5 = new BinaryTreeNode(5);
		n1.leftChild = n2;
		n1.rightChild = n3;
		n3.leftChild = n4;
		n3.rightChild = n5;
		System.out.println("Pre Order Recursive : ");
		preOrderRec(n1);
		System.out.println();
		System.out.println("Pre Order Iterative: ");
		preOrderIterative(n1);
	}
	public static void preOrderRec(BinaryTreeNode node){
		if(node != null){
			System.out.print(" --> " +node.data);
			preOrderRec(node.leftChild);
			preOrderRec(node.rightChild);
		}else{
			return ;
		}
	}
	public static void preOrderIterative(BinaryTreeNode node){
		if(node == null){
			throw new IllegalArgumentException("Root cannot be null");
		}else{
			Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
			while(true){
				while(node != null){
					System.out.print(" --> "+node.data);
					s.push(node);
					node = node.leftChild;
				}
				if(s.isEmpty()){
					break;
				}
				node = s.pop();
				node = node.rightChild;
			}
			return ;
		}
	}
}
class BinaryTreeNode{
	int data;
	BinaryTreeNode leftChild;
	BinaryTreeNode rightChild;
	public BinaryTreeNode(){
		
	}
	public BinaryTreeNode(int data){
		this.data = data;
	}
}
