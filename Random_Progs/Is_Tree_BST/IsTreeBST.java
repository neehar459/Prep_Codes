import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class IsTreeBST{
	static List<Integer> iList = new ArrayList<Integer>();
	static int lastValue = Integer.MIN_VALUE;
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
		System.out.println("Is Tree BST : "+isBSTInOrderList(n1));
		System.out.println("Is Tree BST Queue : "+isBSTQueue(n1));
		System.out.println("Is Tree BST Queue One Var : "+isBSTOneVar(n1));
		System.out.println("Is Tree BST Queue Min Max : "+isBSTMinMax(n1, Integer.MIN_VALUE, Integer.MAX_VALUE));
		//isBSTMinMax
	}
	public static void inOrderArray(BSTNode node, List<Integer> iList){
		if (node != null) {
			inOrderArray(node.left, iList);
			iList.add(node.data);
			inOrderArray(node.right, iList);	
		}
	}
	public static boolean isBSTInOrderList (BSTNode node){
		if(node == null){
			return false;
		}else{
			inOrderArray(node, iList);
			if(iList != null && iList.size() > 0){
				Integer[] iArray = new Integer[iList.size()];
				iArray = iList.toArray(iArray);
				for(int i=0; i< iArray.length-1; i++){
					if(iArray[i] > iArray[i+1]){
						return false;
					}
				}
				return true;
			}else{
				return false;
			}
		}
	}
	public static boolean isBSTQueue (BSTNode node){
		if (node == null) {
			return false;
		} else { 
			Queue<BSTNode> q = new LinkedList<BSTNode> ();
			q.add(node);
			BSTNode iterNode;
			while(!q.isEmpty()){
				iterNode = q.remove();
				if(iterNode.left != null){
					if(iterNode.left.data > iterNode.data){
						return false;
					} else {
						q.add(iterNode.left);
					}					
				}
				if(iterNode.right != null){
					if(iterNode.right.data < iterNode.data){
						return false;
					} else {
						q.add(iterNode.right);
					}					
				}
			}
			return true;
		}
	}
	public static boolean isBSTOneVar(BSTNode node){
		if(node == null){
			return true;
		}
		if(!isBSTOneVar(node.left)){
			return false;
		}
		if(node.data < lastValue){
			return false;
		}
		lastValue = node.data;
		if(!isBSTOneVar(node.right)){
			return false;
		}
		return true;
	}
	public static boolean isBSTMinMax(BSTNode node, int min, int max){
		if(node == null){
			return true;
		}
		if(node.data < min || node.data > max ){
			return false;
		}
		//if
		return (isBSTMinMax(node.left, min, node.data) && isBSTMinMax(node.right, node.data, max));
		//{
			//return true;
		//}
		//return false;
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