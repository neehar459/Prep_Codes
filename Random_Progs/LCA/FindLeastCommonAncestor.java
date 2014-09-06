import java.util.List;
import java.util.ArrayList;
public class FindLeastCommonAncestor{
	public static void main(String[] args){
		BinaryTreeNode n1 = new BinaryTreeNode(9);
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
 		List<Integer> inOrderList = inOrderList(n3, new ArrayList<Integer>());
		System.out.println(inOrderList);
		List<Integer> postOrderList = postOrderList(n3, new ArrayList<Integer>());
		System.out.println(postOrderList); 
		System.out.println("LCA of nodes 6 and 9 is : "+findLCA(n5, n1, n3));
		System.out.println("LCA of nodes 6 and 9 is : "+findLCAForBST(n5, n1, n3));
	}
	public static int findLCA(BinaryTreeNode n1, BinaryTreeNode n2, BinaryTreeNode root){
		List<Integer> inOrderList = inOrderList(root, new ArrayList<Integer>());
		List<Integer> postOrderList = postOrderList(root, new ArrayList<Integer>());
		int startIndex = inOrderList.indexOf(n1.data);
		int endIndex = inOrderList.indexOf(n2.data);
		List<Integer> inSubList = inOrderList.subList(startIndex+1, endIndex);
		System.out.println("sub List : "+inSubList);
		int maxIndex = -1;
		int lca = -1;
		int index =0;
		for(int i=0; i < inSubList.size(); i++){
			index = postOrderList.indexOf(inSubList.get(i));
			if( index > maxIndex){
				maxIndex = index;
				lca = inSubList.get(i);
			}
		}
		return lca;
	}
	public static int findLCAForBST (BinaryTreeNode n1, BinaryTreeNode n2, BinaryTreeNode root) {
		if(root == null) {
			return -1;
		} else {
			while(true) {
				if ((n1.data < root.data && n2.data > root.data) || (n1.data > root.data && n2.data < root.data) ) {
					return root.data;
				}
				if(n1.data < root.data) {
					root = root.left;
				} else {
					root = root.right;
				}
			}
		}
	}
	public static List<Integer> inOrderList(BinaryTreeNode node, List<Integer> inOrderList){
		if(node != null){
			inOrderList(node.left,inOrderList);
			inOrderList.add(node.data);
			inOrderList(node.right,inOrderList);
			return inOrderList;
		}
		return null;
	}
	public static List<Integer> postOrderList(BinaryTreeNode node, List<Integer> postOrderList){
		if(node != null){
			postOrderList(node.left,postOrderList);			
			postOrderList(node.right,postOrderList);
			postOrderList.add(node.data);
			return postOrderList;
		}
		return null;
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