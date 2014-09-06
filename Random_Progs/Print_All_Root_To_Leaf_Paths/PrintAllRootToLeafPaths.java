import java.util.List;
import java.util.ArrayList;
public class PrintAllRootToLeafPaths{
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
		displayAllRootToLeafPathsEfficient(new ArrayList<BinaryTreeNode>(), n1);
		System.out.println("Does Sum exist in tree : "+doesSumPathExist(n1, 13));
		//List<List<BinaryTreeNode>> allLists = listAllPathsForSum(new ArrayList<List<BinaryTreeNode>>(), 13, n1, new ArrayList<BinaryTreeNode>());
		/* for(int i=0; i < allLists.size(); i++){
			System.out.print("Path : ");
			List<BinaryTreeNode> l = allLists.get(i);
			for(int j=0; j< l.size(); j++){
				System.out.print(l.get(j).data + " , ");
			}
			System.out.println();
		} */
		//System.out.println("Sum of all root to leaf paths : " + sumOfAllRootToLeaves(n1, 0));
	}
	public static void displayAllRootToLeafPaths(List<Integer> path, BinaryTreeNode node){
		if(node == null){
			return ;
		}else{
			path.add(node.data);
			if(node.left != null){
				displayAllRootToLeafPaths(new ArrayList(path), node.left);
			}
			if(node.right != null){
				displayAllRootToLeafPaths(new ArrayList(path), node.right);
			}
			else if(node.left == null && node.right == null){
				// Now Display the list
				System.out.println("Path : "+path);
			}
		}
	}
	public static void displayAllRootToLeafPathsEfficient(List<BinaryTreeNode> path, BinaryTreeNode node){
		if(node == null){
			return ;
		}else{
			path.add(node);
			if(node.left != null){
				displayAllRootToLeafPathsEfficient(path, node.left);
			}
			if(node.right != null){
				displayAllRootToLeafPathsEfficient(path, node.right);
			}
			if(node.left == null && node.right == null){
				// Now Display the list
				System.out.print("Path : ");
				for(int i=0; i< path.size(); i++){
					System.out.print(path.get(i).data+" , ");
				}
				System.out.println();
			}
			path.remove(node);
		}
	}
	public static boolean doesSumPathExist(BinaryTreeNode node, int sum){
		if(node == null){
			return (sum == 0);
		}else{
			sum = sum - node.data;
			return (doesSumPathExist(node.left, sum) || doesSumPathExist(node.right, sum));
		}
	}
	public static List<List<BinaryTreeNode>> listAllPathsForSum(List<List<BinaryTreeNode>> allPaths, int sum, BinaryTreeNode node, List<BinaryTreeNode> path){
		if(node == null){
			return allPaths;
		}else{
			sum = sum - node.data;
			path.add(node);
			if(node.left == null && node.right == null){
				if(sum == 0){
					allPaths.add((new ArrayList(path)));
				}
			}
			if(node.left != null){
				listAllPathsForSum(allPaths,sum, node.left, path);
			}
			if(node.right != null){
				listAllPathsForSum(allPaths, sum, node.right, path);
			}
			path.remove(node);
			return allPaths;
		}
	}
	// Find sum of all root to leaf path node integers : eg : this tree : 127+1345+136
	public static int sumOfAllRootToLeaves(BinaryTreeNode node, int sum){
		if(node == null){
			return 0;
		}else{
			sum = sum * 10 + (node.data);
			if(node.left == null && node.right == null){
				return sum;
			}
			return (sumOfAllRootToLeaves(node.left, sum) + sumOfAllRootToLeaves(node.right, sum));
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