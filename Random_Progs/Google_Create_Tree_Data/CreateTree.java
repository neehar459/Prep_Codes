import java.util.Set;
import java.util.HashSet;
public class CreateTree{
	public static void main(String[] args){
		int[][] nodeArray= {{1,2},{2,3},{3,4},{1,5}, {2,7}};
		createTree(nodeArray);
		
	}
	public static BinaryTreeNode createTree(int[][] nArray){
		if(nArray == null || nArray.length == 0){
			return null;
		}else{
			// First find root by traversing all the nodes and check which is the root node.
			// Root node is the node which is not present in any nodes in child position.
			int root = -1;
			int[] parentArray = new int[nArray.length];
			int[] childArray = new int[nArray.length];
			for(int i=0; i< nArray.length; i++){
				parentArray[i] = nArray[i][0];
				childArray[i] = nArray[i][1];
			}
			int falseCount = 0;
			int parentVal = -1;
			outerloop:
			for(int i=0; i <  parentArray.length; i++){
				parentVal = parentArray[i];
				falseCount = 0;
				for(int j=0; j< childArray.length; j++){
					if(parentVal == childArray[j]){
						break;
					}else{
						falseCount++;
					}
				}
				if(falseCount == parentArray.length){
					root = parentVal;
				}
			}
			System.out.println("Root : "+root);
			BinaryTreeNode rootNode ;
			BinaryTreeNode[] nodeArray = new BinaryTreeNode[10];
			BinaryTreeNode parent;
			BinaryTreeNode child;
			int parentData;
			int childData;
			for(int i=0; i < nArray.length; i++){
				parentData = nArray[i][0];
				childData = nArray[i][1];
				if(nodeArray[parentData] == null){
					parent = new BinaryTreeNode(parentData);
					nodeArray[parentData] = parent;
				}else{
					parent = nodeArray[parentData];
				}
				if(nodeArray[childData] == null){
					child = new BinaryTreeNode(childData);
					nodeArray[childData] = child;
				}else{
					child = nodeArray[childData];
				}
				child.parent = parent;
				if(parent.left == null){
					parent.left = child;
				}else{
					parent.right = child;
				}
			}
			rootNode = nodeArray[root];
			System.out.println("InOrder : ");
			inOrder(rootNode);
			System.out.println("PreOrder : ");
			preOrder(rootNode);
			return rootNode;
		}
	}
	public static void inOrder(BinaryTreeNode root){
		if(root != null){
			inOrder(root.left);
			System.out.print(root.data);
			inOrder(root.right);
		}
	}
	public static void preOrder(BinaryTreeNode root){
		if(root != null){
			System.out.print(root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
}
class BinaryTreeNode{
	BinaryTreeNode left;
	BinaryTreeNode right;
	BinaryTreeNode parent;
	int data;
	public BinaryTreeNode(){
	
	}
	public BinaryTreeNode(int data){
		this.data = data;
	}
}
class BinaryTree{
	BinaryTreeNode root;
}