import java.util.Queue;
import java.util.LinkedList;
public class FindMax{
	public static void main(String[] args){
		BinaryTreeNode n1 = new BinaryTreeNode(1);
		BinaryTreeNode n2 = new BinaryTreeNode(2);
		BinaryTreeNode n3 = new BinaryTreeNode(3);
		BinaryTreeNode n4 = new BinaryTreeNode(4);
		BinaryTreeNode n5 = new BinaryTreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;
		System.out.println("Greatest Element : "+findMaxRec(n1));
		levelOrder(n1);
		System.out.println("Greatest Element Iterative : "+findMaxIterative(n1));
	}
	public static int findMaxRec(BinaryTreeNode node){
		int left,right,root,max = Integer.MIN_VALUE;
		if(node != null){
			root = node.data;
			left = findMaxRec(node.left);
			right = findMaxRec(node.right);
			if(left > right){
				max = left;
			} else {
				max = right;
			}
			if(root > max){
				max = root;
			}
		}
		return max;
	}
	
	public static void levelOrder(BinaryTreeNode node){
		if(node == null){
			throw new IllegalArgumentException("Tree cannot be empty");
		}else{
			Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			q.add(node);
			BinaryTreeNode tempNode;
			while(!q.isEmpty()){
				tempNode = q.remove();
				System.out.print("--> "+tempNode.data);
				if(tempNode.left != null){
					q.add(tempNode.left);
				}
				if(tempNode.right != null){
					q.add(tempNode.right);
				}
			}
			System.out.println();
		}
	}
	public static int findMaxIterative(BinaryTreeNode node){
		if(node == null){
			throw new IllegalArgumentException("Tree cannot be empty");
		}else{
			Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			int max = Integer.MIN_VALUE;
			q.add(node);
			BinaryTreeNode tempNode;
			while(!q.isEmpty()){
				tempNode = q.remove();
				if(tempNode != null && tempNode.data > max){
					max = tempNode.data;
				}
				if(tempNode.left != null){
					q.add(tempNode.left);
				}
				if(tempNode.right != null){
					q.add(tempNode.right);
				}
			}
			return max;
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
