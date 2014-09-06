public class FindBSTElement{
	public static void main(String [] args){
		BSTNode n1 = new BSTNode(7);
		BSTNode n2 = new BSTNode(4);
		BSTNode n3 = new BSTNode(9);
		BSTNode n4 = new BSTNode(2);
		BSTNode n5 = new BSTNode(5);
		BSTNode n6 = new BSTNode(8);
		BSTNode n7 = new BSTNode(10);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		BSTNode foundNode = findBSTNodeIter(n1, 10);
		if(foundNode != null){
			System.out.println("Node with value : "+foundNode.data + " is found");
		}else{
			System.out.println("Node is not found in tree");
		}
		BSTNode foundNodeRec = findBSTNodeRecur(n1, 10);
		if(foundNodeRec != null){
			System.out.println("Node with value Rec : "+foundNodeRec.data + " is found");
		}else{
			System.out.println("Node is not found in tree with recur ");
		}
		BSTNode minNode = findMinElementNode(n1);
		if(minNode != null){
			System.out.println(" Min element in BST is : "+minNode.data);
		}
		BSTNode minNodeRecur = findMinRecur(n1);
		if(minNodeRecur != null){
			System.out.println(" Min element in BST Recur is : "+minNodeRecur.data);
		}
		BSTNode maxNode = findMaxElementNode(n1);
		if(maxNode != null){
			System.out.println(" Max element in BST is : "+maxNode.data);
		}
		BSTNode maxNodeRecur = findMaxRecur(n1);
		if(maxNodeRecur != null){
			System.out.println(" Max element in BST Recur is : "+maxNodeRecur.data);
		}
	}
	public static BSTNode findBSTNodeIter(BSTNode node, int element){
		if(node == null){
			return null;
		}else{
			while (node != null){
				if (node.data < element) {
					node = node.right;
				} else if (node.data > element) {
					node = node.left;
				} else {
					return node;
				}
			}
			return null;
		}
	}
	public static BSTNode findBSTNodeRecur(BSTNode node, int element){
		if(node == null) {
			return null;
		}else {
			if (node.data == element) {
				return node;
			} 
			if (node.data < element) {
				return findBSTNodeRecur(node.right, element);
			} else if (node.data > element) {
				return findBSTNodeRecur(node.left, element);
			}
			return node;
		}
	}
	public static BSTNode findMinElementNode(BSTNode node){
		if (node == null) {
			return null;
		} else {
			while (node != null) {
				if (node.left != null) {
					node = node.left;
				} else if (node.left == null) {
					return node;
				}
			}
			return null;
		}
	}
	public static BSTNode findMinRecur(BSTNode node){
		if(node.left == null){
			return node;
		}else{
			return findMinRecur(node.left);
		}
	}
	public static BSTNode findMaxElementNode(BSTNode node){
		if (node == null) {
			return null;
		} else {
			while (node != null) {
				if (node.right != null) {
					node = node.right;
				} else if (node.right == null) {
					return node;
				}
			}
			return null;
		}
	}
	public static BSTNode findMaxRecur(BSTNode node){
		if(node.right == null){
			return node;
		}else{
			return findMaxRecur(node.right);
		}
	}
}
class BSTNode {
	int data;
	BSTNode left;
	BSTNode right;
	public BSTNode(){
		
	}
	public BSTNode(int data){
		this.data = data;
	}
}