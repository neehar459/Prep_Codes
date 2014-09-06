import java.util.List;
 import java.util.ArrayList;
public class FindKthSmallest {
	public static void main(String[] args){
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
		List<Integer> inOrder = inOrderArray(n1, new ArrayList<Integer>());
		for(int i : inOrder){
			System.out.print(i + " , ");
		}
		System.out.println();
		System.out.println("Kth Smallest Element : "+findKthSmallest(n1, 3));
		BSTNode kthSmall = findKthSmallestRecur(n1, 3, 0);
		if(kthSmall != null ){
			System.out.println("kth smallest : " + kthSmall.data);
		}
	}
	public static int findKthSmallest (BSTNode node, int k) {
		if (node == null) {
			return -1;
		} else {
			List<Integer> inArrayList = inOrderArray(node, new ArrayList<Integer>());
			if (inArrayList != null && inArrayList.size() > 0){
				return inArrayList.get(k-1);
			}else{
				return -1;
			}
		}
	}
	public static List<Integer> inOrderArray(BSTNode node, List<Integer> inOrderList) {
		if( node != null ) {
			inOrderArray(node.left, inOrderList);
			inOrderList.add(node.data);
			inOrderArray(node.right, inOrderList);
		}
		return inOrderList;
	}
	public static BSTNode findKthSmallestRecur (BSTNode node, int k, int count) {
		if(node == null) {
			return null;
		}
		BSTNode left = findKthSmallestRecur(node.left, k , count);
		if(left != null){
			return left;
		}
		if(++count == k){
			return node;
		}
		return findKthSmallestRecur(node.right, k , count);
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