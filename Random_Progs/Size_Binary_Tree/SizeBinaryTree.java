import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
public class SizeBinaryTree{
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
		System.out.println("Size of tree : "+sizeOfBinaryTree(n1));
		System.out.println("Size of tree Iter : "+sizeOfBinaryTreeIter(n1));
		displayTreeInReverseLevelOrder(n1);
	}
	public static int sizeOfBinaryTree(BinaryTreeNode node){
		if(node == null){
			return 0;
		}else{
			return 1 + sizeOfBinaryTree(node.left) + sizeOfBinaryTree(node.right);
		}
	}
	public static int sizeOfBinaryTreeIter(BinaryTreeNode node){
		if(node == null){
			return -1;
		}else{
			Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			q.add(node);
			BinaryTreeNode iter;
			int counter = 0;
			while(!q.isEmpty()){
				iter = q.remove();
				if(iter != null){
					counter ++;
				}
				if(iter.left != null){
					q.add(iter.left);
				}
				if(iter.right != null){
					q.add(iter.right);
				}
			}
			return counter;
		}
	}
	public static void displayTreeInReverseLevelOrder(BinaryTreeNode node){
		if(null == node){
			throw new IllegalArgumentException("Binary Tree is empty");
		}else{
			Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			Stack<Integer> s = new Stack<Integer>();
			q.add(node);
			BinaryTreeNode iterNode;
			while(!q.isEmpty()){
				iterNode = q.remove();
				if(iterNode != null){
					s.push(iterNode.data);
				}
				if(iterNode.left != null){
					q.add(iterNode.left);
				}
				if(iterNode.right != null){
					q.add(iterNode.right);
				}
			}
			while(!s.isEmpty()){
				System.out.print(" --> "+s.pop());
			}
			System.out.println();
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

