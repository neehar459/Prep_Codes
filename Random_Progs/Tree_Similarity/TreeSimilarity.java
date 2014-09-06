import java.util.Queue;
import java.util.LinkedList;
public class TreeSimilarity{
	static int diameter = Integer.MIN_VALUE;
	public static void main(String[] args){
		BinaryTreeNode n1 = new BinaryTreeNode(1);
		BinaryTreeNode n2 = new BinaryTreeNode(2);
		BinaryTreeNode n3 = new BinaryTreeNode(3);
		BinaryTreeNode n4 = new BinaryTreeNode(4);
		BinaryTreeNode n5 = new BinaryTreeNode(5);
		BinaryTreeNode n6 = new BinaryTreeNode(6);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n6;
		n4.right = n5;
		BinaryTreeNode n11 = new BinaryTreeNode(1);
		BinaryTreeNode n12 = new BinaryTreeNode(2);
		BinaryTreeNode n13 = new BinaryTreeNode(3);
		BinaryTreeNode n14 = new BinaryTreeNode(4);
		BinaryTreeNode n15 = new BinaryTreeNode(5);
		n11.left = n13;
		n11.right = n12;
		n13.right = n14;
		n14.left = n15;
		//System.out.println("Are both trees structurally similar : " + areTreesStructurallySimilar(n1,n11));
		//System.out.println("Are both trees mirror images : " + areTreesMirrorImages(n1,n11));
		//System.out.println("Diameter of tree : " + findDiameter(n1,diameter));
		System.out.println("Max Level with max sum : "+findLevelWithMaxSum(n1));
	}
	public static boolean areTreesStructurallySimilar(BinaryTreeNode n1, BinaryTreeNode n2){
		if(n1 == null && n2 == null){
			return true;
		}
		if(n1 == null || n2 == null){
			return false;
		}
		return (areTreesStructurallySimilar(n1.left,n2.left) && areTreesStructurallySimilar(n1.right,n2.right));
	}
	public static boolean areTreesMirrorImages(BinaryTreeNode n1, BinaryTreeNode n2){
		if(n1 == null && n2 == null){
			return true;
		}
		if(n1 == null || n2 == null){
			return false;
		}
		return ( (n1.data == n2.data) && areTreesMirrorImages(n1.left,n2.right) && 
		areTreesMirrorImages(n1.right,n2.left));
	}
	public static int findDiameter (BinaryTreeNode node, int diameter){
		int leftDia, rightDia;
		if(node == null){
			return 0;
		}
		leftDia = findDiameter(node.left, diameter);
		rightDia = findDiameter(node.right, diameter);
		if(leftDia + rightDia > diameter){
			diameter = leftDia + rightDia;
		}
		return (Math.max(leftDia,rightDia))+1;
	}
	public static int findLevelWithMaxSum(BinaryTreeNode node){
		if(null == node){
			throw new IllegalArgumentException("Tree is empty");
		}else{
			int sum = 0;
			int maxSum = Integer.MIN_VALUE;
			int level = 0;
			int maxLevel = 0;
			if(node.left == null && node.right == null){
				return 1;
			}else{
				BinaryTreeNode iterNode;
				Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
				q.add(node);
				q.add(null);
				while(!q.isEmpty()){
					iterNode = q.remove();
					if(iterNode == null){
						level++;
						if(!q.isEmpty()){
							q.add(null);
							if(maxSum < sum){
								maxSum = sum;
								maxLevel = level;
								sum = 0;
							}
						}
					}else{
						sum = sum + iterNode.data;
						if(iterNode.left != null){
							q.add(iterNode.left);
						}
						if(iterNode.right != null){
							q.add(iterNode.right);
						}
					}
				}
			}
			System.out.println("Max Sum  : "+maxSum + " and level : "+maxLevel);
			return maxLevel;
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
