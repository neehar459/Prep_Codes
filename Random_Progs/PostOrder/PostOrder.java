public class PostOrder{
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
		System.out.println("Post Order Recursive : ");
		postOrderRec(n1);
	}
	public static void postOrderRec(BinaryTreeNode node){
		if(node != null){
			postOrderRec(node.left);
			postOrderRec(node.right);
			System.out.print(" --> " +node.data);
		}else{
			return ;
		}
	}
}
class BinaryTreeNode{
	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	public BinaryTreeNode(int data){
		this.data = data;
	}
}
