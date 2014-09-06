import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
public class PrintVerticalSum{
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
		printVerticalSum(n1);
	}
	public static void printVerticalSum(BinaryTreeNode n1){
		if(n1 == null){
			return ;
		}else{
			Map<Integer, List<BinaryTreeNode>> mainMap = new HashMap<Integer, List<BinaryTreeNode>>();
			Map<BinaryTreeNode, Integer> subMap = new HashMap<BinaryTreeNode, Integer>();
			Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			q.add(n1);
			List<BinaryTreeNode> l = new ArrayList<BinaryTreeNode>();
			l.add(n1);
			mainMap.put(0,l);
			subMap.put(n1,0);
			BinaryTreeNode iterNode;
			int parentSum = 0;
			int childSum = 0;
			while(!q.isEmpty()){
				iterNode = q.remove();
				parentSum = subMap.get(iterNode);
				if(iterNode.left != null){
					childSum = parentSum - 1;
					subMap.put(iterNode.left, childSum);
					List<BinaryTreeNode> sumList = mainMap.get(childSum);
					if(sumList == null){
						sumList = new ArrayList<BinaryTreeNode>();
						sumList.add(iterNode.left);
					}else{
						System.out.println("sumList");
						sumList.add(iterNode.left);
					}
					mainMap.put(childSum, sumList);
					q.add(iterNode.left);
				}
				if(iterNode.right != null){
					childSum = parentSum + 1;
					subMap.put(iterNode.right, childSum);
					List<BinaryTreeNode> sumList = mainMap.get(childSum);
					if(sumList == null){
						sumList = new ArrayList<BinaryTreeNode>();
						sumList.add(iterNode.right);
					}else{
						sumList.add(iterNode.right);
					}
					mainMap.put(childSum, sumList);
					q.add(iterNode.right);
				}
			}
			Integer[] keyArray = (Integer[])mainMap.keySet().toArray(new Integer[mainMap.keySet().size()]);
			System.out.println();
			int[] sumArray = new int[keyArray.length]; 
			for(int i=0; i< keyArray.length; i++){
				List<BinaryTreeNode> list = mainMap.get(keyArray[i]);
				for(BinaryTreeNode n : list){
					if(n != null){
						sumArray[i] +=   n.data;
					}
				}
				System.out.println();
			}
			 for(Integer i : sumArray){
				System.out.println(i);
			} 
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