public class ConstructBSTFromSortedArray{
	public static void main(String[] args){
		int[] sortedArray = {1,2,3,4,5,6,7,8};
		BSTNode treeNode = createBST(sortedArray, 0, sortedArray.length-1);
		System.out.println("Node left Child : "+treeNode.right.right.right.data);
	}
	/* public static BSTNode createBST(int[] array, int start, int end){
		BSTNode newNode;
		if(start > end){
			return null;
		}
		newNode = new BSTNode();
		if(newNode == null){
			return null;
		}
		if(start == end){
			newNode.setData(array[start]);
		} else {
			int mid = start + (( end - start) / 2);
			newNode.setData(array[mid]);
			newNode.left = createBST(array, start, mid-1);
			newNode.right = createBST(array, mid +1, end);
		}
		return newNode;
	} */
	public static BSTNode createBST(int[] array, int start, int end){
		BSTNode newNode = new BSTNode();
		if(start > end){
			return null;
		}
		 else {
			int mid = start + (( end - start) / 2);
			newNode.setData(array[mid]);
			newNode.left = createBST(array, start, mid-1);
			newNode.right = createBST(array, mid +1, end);
		}
		return newNode;
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
	public void setData (int data){
		this.data = data;
	}
}