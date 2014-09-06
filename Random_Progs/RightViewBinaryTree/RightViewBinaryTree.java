import java.util.Queue;
import java.util.LinkedList;
public class RightViewBinaryTree{
	public static void main(String[] args){
		BinaryTreeNode n1 = new BinaryTreeNode(1);
		BinaryTreeNode n2 = new BinaryTreeNode(2);
		BinaryTreeNode n3 = new BinaryTreeNode(3);
		BinaryTreeNode n4 = new BinaryTreeNode(4);
		BinaryTreeNode n5 = new BinaryTreeNode(5);
		BinaryTreeNode n6 = new BinaryTreeNode(6);
		BinaryTreeNode n7 = new BinaryTreeNode(7);
		BinaryTreeNode n8 = new BinaryTreeNode(8);
		BinaryTreeNode n9 = new BinaryTreeNode(9);
		BinaryTreeNode n10 = new BinaryTreeNode(10);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.right = n7;
		n3.left = n6;
		n7.right = n8;
		n4.right = n9;
		n9.left = n10;
		rightViewOfTree(n1);
		leftViewOfTree(n1);
	}
	public static void rightViewOfTree(BinaryTreeNode node){
		if(node == null){
			return ;
		}else{
			Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			q.add(node);
			q.add(null);
			BinaryTreeNode iterNode;
			System.out.println("Right View : ");
			while(!q.isEmpty()){
				iterNode = q.remove();
				if(q.peek() == null && iterNode != null){
					System.out.print(iterNode.data + " , ");
				}
				if(iterNode == null){
					if(!q.isEmpty()){
						q.add(null);
					}
				}else{
					if(iterNode.left != null){
						q.add(iterNode.left);
					}
					if(iterNode.right != null){
						q.add(iterNode.right);
					}
				}
			}
			System.out.println();
		}
	}
	public static void leftViewOfTree(BinaryTreeNode node){
		if(node == null){
			return ;
		}else{
			Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			q.add(node);
			q.add(null);
			BinaryTreeNode iterNode;
			System.out.print("Left View : " + node.data + " , " );
			while(!q.isEmpty()){
				iterNode = q.remove();
				if(iterNode == null){
					if(q.peek() != null){
						System.out.print(q.peek().data + " , ");
					}
					if(!q.isEmpty()){		
						q.add(null);
					}
				}else{
					if(iterNode.left != null){
						q.add(iterNode.left);
					}
					if(iterNode.right != null){
						q.add(iterNode.right);
					}
				}
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