import java.util.Queue;
import java.util.LinkedList;
public class NodeCounts{
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
		System.out.println("Number of Leaves in Binary Tree : "+findLeaves(n1));
		System.out.println("Number of Full Leaves in Binary Tree : "+findFullNodes(n1));
		System.out.println("Number of Half Leaves in Binary Tree : "+findHalfNodes(n1));
	}
	public static int findLeaves(BinaryTreeNode node){
		if(null == node){
			throw new IllegalArgumentException ("Tree is empty");
		}else{
			Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			q.add(node);
			BinaryTreeNode iter;
			int leavesCount = 0;
			while(!q.isEmpty()){
				iter = q.remove();
				if(iter.left == null && iter.right == null){
					leavesCount++;
				}else{
					if(iter.left != null){
						q.add(iter.left);
					}
					if(iter.right != null){
						q.add(iter.right);
					}
				}
			}
			return leavesCount;
		}
	}
	public static int findFullNodes(BinaryTreeNode node){
		if(null == node){
			throw new IllegalArgumentException ("Tree is empty");
		}else{
			Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			q.add(node);
			BinaryTreeNode iter;
			int fullLeavesCount = 0;
			while(!q.isEmpty()){
				iter = q.remove();
				if(iter.left != null && iter.right != null){
					fullLeavesCount++;
				}
				if(iter.left != null){
					q.add(iter.left);
				}
				if(iter.right != null){
					q.add(iter.right);
				}
			}
			return fullLeavesCount;
		}
	}
	public static int findHalfNodes(BinaryTreeNode node){
		if(null == node){
			throw new IllegalArgumentException ("Tree is empty");
		}else{
			Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			q.add(node);
			BinaryTreeNode iter;
			int halfLeavesCount = 0;
			while(!q.isEmpty()){
				iter = q.remove();
				if((iter.left == null && iter.right!=null) || (iter.right == null && iter.left != null)){
					halfLeavesCount++;
				}
				if(iter.left != null){
					q.add(iter.left);
				}
				if(iter.right != null){
					q.add(iter.right);
				}
			}
			return halfLeavesCount;
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
