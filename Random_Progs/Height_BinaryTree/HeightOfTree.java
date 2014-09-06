import java.util.Queue;
import java.util.LinkedList;
public class HeightOfTree{
	public static void main(String[] args){
		BinaryTreeNode n1 = new BinaryTreeNode(1);
		BinaryTreeNode n2 = new BinaryTreeNode(2);
		BinaryTreeNode n3 = new BinaryTreeNode(3);
		BinaryTreeNode n4 = new BinaryTreeNode(4);
		BinaryTreeNode n5 = new BinaryTreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n4.right = n5;
		//System.out.println("Size of tree : "+heightOfBinaryTree(n1));
		//System.out.println("Size of tree Iter : "+heightOfBinaryTreeIter(n1));
		System.out.println("Deepest node in tree : "+findDeepestNode(n1));
		
	}
	public static int heightOfBinaryTree(BinaryTreeNode node){
		if(node == null){
			return 0;
		}else{
			int leftHt, rightHt;
			leftHt = heightOfBinaryTree(node.left);
			rightHt = heightOfBinaryTree(node.right);
			if(leftHt > rightHt){
				return leftHt + 1;
			}else{
				return rightHt + 1;
			}
		}
	}
	public static int heightOfBinaryTreeIter(BinaryTreeNode node){
		if(null == node){
			throw new IllegalArgumentException("Tree is empty");
		}else{
			int htOfTree = 0;
			Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			q.add(node);
			q.add(null);
			BinaryTreeNode iter;
			while(!q.isEmpty()){
				iter = q.remove();
				if(iter == null){
					if(!q.isEmpty()){
						q.add(null);
					}
					htOfTree++;
				}else{
					if(iter.left != null){
						q.add(iter.left);
					}
					if(iter.right != null){
						q.add(iter.right);
					}
				}
			}
			return htOfTree;
		}
	}
	public static int findDeepestNode(BinaryTreeNode node){
		if(null == node){
			throw new IllegalArgumentException("Tree cannot be empty");
		}else{
			Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			int toReturn = -1;
			q.add(node);
			BinaryTreeNode iter = new BinaryTreeNode(-1);
			while(!q.isEmpty()){
				iter = q.remove();
				if(iter.left != null){
					q.add(iter.left);
				}
				if(iter.right != null){
					q.add(iter.right);
				}
			}
			toReturn = iter.data;
			return toReturn;
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
