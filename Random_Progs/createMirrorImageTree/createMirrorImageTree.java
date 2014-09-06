public class createMirrorImageTree{
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
		System.out.println("Inorder before mirror : ");
		inOrderRec(n1);
		BinaryTreeNode mirrorTreeNode = createMirrorImage(n1);
		System.out.println("Inorder after mirror : ");
		inOrderRec(mirrorTreeNode);
		
	}
	public static BinaryTreeNode createMirrorImage(BinaryTreeNode node){
		if(node == null){
			return null;
		}else{
			BinaryTreeNode swapNode;
			createMirrorImage(node.left);
			createMirrorImage(node.right);
			swapNode = node.left;
			node.left = node.right;
			node.right = swapNode;
			return node;
		}
	}
	public static void inOrderRec(BinaryTreeNode node){
		if(node != null){
			inOrderRec(node.left);
			System.out.print(" --> " +node.data);
			inOrderRec(node.right);
		}else{
			return ;
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