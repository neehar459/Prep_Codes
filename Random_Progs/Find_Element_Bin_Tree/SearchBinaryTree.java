import java.util.Queue;
import java.util.LinkedList;
public class SearchBinaryTree{
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
		System.out.println("Find Element : "+searchElementRec(n1, 434));
		System.out.println("Find Element Iterative : "+searchElementIter(n1, 434));
	}
	public static boolean searchElementRec(BinaryTreeNode node,  int data){
		if(node == null){
			return false;
		}else{
			if(node.data == data){
				return true;
			}else{
				boolean temp = searchElementRec(node.left, data);
				if(temp == true){
					return temp;
				}else{
					return searchElementRec(node.right, data);
				}
			}
		}
	}
	
	public static boolean searchElementIter(BinaryTreeNode node, int data){
		if(node == null){
			return false;
		}else{
			Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			q.add(node);
			boolean status = false;
			BinaryTreeNode iterNode;
			while(!q.isEmpty()){
				iterNode = q.remove();
				if(iterNode.data == data){
					return true;
				}
				if(iterNode.left != null){
					q.add(iterNode.left);
				}
				if(iterNode.right != null){
					q.add(iterNode.right);
				}
			}
			return status;
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
