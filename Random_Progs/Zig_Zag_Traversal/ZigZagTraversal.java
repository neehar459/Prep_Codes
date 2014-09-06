import java.util.Stack;
public class ZigZagTraversal{
	public static void main(String[] args){
		BinaryTreeNode n1 = new BinaryTreeNode(1);
		BinaryTreeNode n2 = new BinaryTreeNode(2);
		BinaryTreeNode n3 = new BinaryTreeNode(3);
		BinaryTreeNode n4 = new BinaryTreeNode(4);
		BinaryTreeNode n5 = new BinaryTreeNode(5);
		BinaryTreeNode n6 = new BinaryTreeNode(6);
		BinaryTreeNode n7 = new BinaryTreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n6;
		n4.right = n5;
		n2.left = n7;
		zigzagTraversal(n1);
	}
	public static void zigzagTraversal(BinaryTreeNode node){
		if(node == null){
			return ;
		}else{
			Stack<BinaryTreeNode> currentStack = new Stack<BinaryTreeNode>();
			Stack<BinaryTreeNode> nextStack = new Stack<BinaryTreeNode>();
			Stack<BinaryTreeNode> swapStack = new Stack<BinaryTreeNode>();
			int leftToRight = 1;
			currentStack.push(node);
			BinaryTreeNode iterNode;
			while(!currentStack.isEmpty()){
				iterNode = currentStack.pop();
				System.out.print(iterNode.data+" , ");
				if(iterNode != null){
					if(leftToRight == 1){
						if(iterNode.left != null){
							nextStack.push(iterNode.left);
						}
						if(iterNode.right != null){
							nextStack.push(iterNode.right);
						}
					}else{
						if(iterNode.right != null){
							nextStack.push(iterNode.right);
						}
						if(iterNode.left != null){
							nextStack.push(iterNode.left);
						}
					}
				}
				if(currentStack.isEmpty()){
					leftToRight = 1- leftToRight;
					swapStack = currentStack;
					currentStack = nextStack;
					nextStack = swapStack;
				}
			}
			System.out.println("");
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