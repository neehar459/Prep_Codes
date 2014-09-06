import java.util.Stack;
public class InOrder{
	public static void main(String[] args){
		BinaryTreeNode n1 = new BinaryTreeNode(1);
		BinaryTreeNode n2 = new BinaryTreeNode(2);
		BinaryTreeNode n3 = new BinaryTreeNode(4);
		BinaryTreeNode n4 = new BinaryTreeNode(5);
		BinaryTreeNode n5 = new BinaryTreeNode(6);
		BinaryTreeNode n6 = new BinaryTreeNode(7);
		BinaryTreeNode n7 = new BinaryTreeNode(8);
		n3.left = n2;
		n3.right = n7;
		n7.left = n4;
		n7.right = n1;
		n4.right = n6;
		n6.left = n5;
		System.out.println("In Order Recursive : ");
		inOrderRec(n3);
		System.out.println();
		System.out.println("In Order Iterative: ");
		inOrderIterative(n3);
	}
	public static void inOrderRec(BinaryTreeNode node){
		if(node != null){
			inOrderRec(node.left);
			System.out.print(" --> " +node.data);
			inOrderRec(node.right);
		}else{
			return ;
		}
	}
	public static void inOrderIterative(BinaryTreeNode node){
		if(node == null){
			throw new IllegalArgumentException("Root cannot be epmty");
		}else{
			Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
			while(true){
				while(node != null){
					s.push(node);
					node = node.left;
				}
				if(s.isEmpty()){
					break;
				}
				node = s.pop();
				System.out.print(" --> "+node.data);
				node = node.right;
			}
			return ;
		}
	}
}
class BinaryTreeNode{
	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	public BinaryTreeNode(){
		
	}
	public BinaryTreeNode(int data){
		this.data = data;
	}
}
