import java.util.List;
import java.util.ArrayList;
public class PrintAllAncestors{
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
		printAllAncestors(n1, n5, new ArrayList<BinaryTreeNode>());
		printAllAncestorsNoDFS(n1,n5);
	}
	public static void printAllAncestors(BinaryTreeNode root, BinaryTreeNode search, List<BinaryTreeNode> path){
		if(root == null){
			return ;
		}else{
			path.add(root);
			if(root.left != null){
			printAllAncestors(root.left, search, path);
			}
			if(root.right != null){
			printAllAncestors(root.right, search, path);
			}
			if(root.data == search.data){
			path.remove(root);
				System.out.println("Ancestors Path : ");
				for(BinaryTreeNode node : path){
					System.out.print(node.data + " , ");
				}
				System.out.println();
			}
			path.remove(root);
		}
	}
	public static boolean printAllAncestorsNoDFS(BinaryTreeNode root, BinaryTreeNode search){
		if(root == null){
			return false;
		}else{
			if(root.left == search || root.right == search || printAllAncestorsNoDFS(root.left,search) || printAllAncestorsNoDFS(root.right,search)){
				System.out.print(root.data+" , ");
				return true;
			}
			return false;
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