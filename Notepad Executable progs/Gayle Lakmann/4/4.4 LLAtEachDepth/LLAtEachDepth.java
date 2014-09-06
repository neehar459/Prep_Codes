import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class LLAtEachDepth{
	public static void main(String[] args){
		BinaryTree binTree = new BinaryTree();
		binTree.insertNode(1);
		binTree.insertNode(2);
		binTree.insertNode(3);
		binTree.insertNode(4);
		binTree.insertNode(5);
		binTree.insertNode(6);
		binTree.insertNode(7);
		binTree.insertNode(8);
		binTree.insertNode(9);
		System.out.println("Height of Binary Tree : "+binTree.root.height(binTree.root));
		binTree.root.levelOrder();
		LLAtEachDepth llEd = new LLAtEachDepth();
		//ArrayList<LinkedList<BinaryTreeNode>> levelLists = llEd.getLLAtEachLevelDepth(binTree.root);
		ArrayList<LinkedList<BinaryTreeNode>> levelLists = llEd.getLLAtEachDeptyRec(binTree.root);
		if(levelLists.size()!=0){
			for(LinkedList<BinaryTreeNode> iterLL : levelLists){
				for(int i =0; i < iterLL.size(); i++){
					System.out.print("Linked List at level ----> "+  iterLL.get(i).item +", ");
				}
				System.out.println(" ");
			}
		}
	}
	
	
	// My Code
	// This method returns an array of LinkedLists of elements present at each level of depth of a binary tree
	public ArrayList<LinkedList<BinaryTreeNode>> getLLAtEachLevelDepth(BinaryTreeNode root){
		if(null == root){
			return null;
		}else{
			ArrayList<LinkedList<BinaryTreeNode>> returnList = new ArrayList<LinkedList<BinaryTreeNode>>();
			LinkedList<BinaryTreeNode> presentLevelList = new LinkedList<BinaryTreeNode>();
			presentLevelList.add(root);
			while(presentLevelList.size()>0){
				returnList.add(presentLevelList);
				LinkedList<BinaryTreeNode> parentLevelList = presentLevelList;
				presentLevelList = new LinkedList<BinaryTreeNode>();
				for(BinaryTreeNode iterNode : parentLevelList){
					if(null != iterNode.leftChild){
						presentLevelList.add(iterNode.leftChild);
					}
					if(null != iterNode.rightChild){
						presentLevelList.add(iterNode.rightChild);
					}
				}
			}
			return returnList;
		}
	}
	
	// Gayle Lakmann Code
	// Recursive approach
	public ArrayList<LinkedList<BinaryTreeNode>> getLLAtEachDeptyRec (BinaryTreeNode root){
		ArrayList<LinkedList<BinaryTreeNode>> listOfLLs = new ArrayList<LinkedList<BinaryTreeNode>>();
		createLLAtEachLevel(root, listOfLLs, 0);
		return listOfLLs;
	}
	
	// This method has the actual implementation of the LinkedList at each level
	public void createLLAtEachLevel(BinaryTreeNode root, ArrayList<LinkedList<BinaryTreeNode>> resultLL, int level){
		if(null == root){
			return ;
		}
		LinkedList<BinaryTreeNode> levelList = null;
		if(resultLL.size() == level){
			levelList = new LinkedList<BinaryTreeNode>();
			resultLL.add(levelList);
		}else{
			levelList = resultLL.get(level);
		}
		levelList.add(root);
		createLLAtEachLevel(root.leftChild, resultLL, level + 1);
		createLLAtEachLevel(root.rightChild, resultLL, level + 1) ;
	}
	// My Code
	// This method gives the children of all the nodes sent
	public BinaryTreeNode[] giveChildNodes(List parentList){
		if(parentList.size() == 0){
			return null;
		}else{
			List toReturnList = new ArrayList();
			for(int i=0; i < parentList.size(); i++){
				BinaryTreeNode iterNode = (BinaryTreeNode)parentList.get(i);
				if(null != iterNode.leftChild){
					toReturnList.add(iterNode.leftChild);
				}
				if(null!=iterNode.rightChild){
				toReturnList.add(iterNode.rightChild);
				}
			}
			BinaryTreeNode[] toReturnArray = (BinaryTreeNode [] ) toReturnList.toArray(new BinaryTreeNode[toReturnList.size()]);
			return toReturnArray;
		}
	}
}
class BinaryTree{

	BinaryTreeNode root;
	int size; // this is for counting number of nodes in the tree
	
	public BinaryTreeNode insertNode(Object item){
		BinaryTreeNode insertedNode = new BinaryTreeNode(item);
		if(null==root || size==0){
			root = insertedNode;
			root.parent = null;
			root.rightChild = null;
			root.leftChild = null;
			size++;
		}else if(size==1){
			root.leftChild = insertedNode;
			insertedNode.parent = root;
			insertedNode.leftChild = null;
			insertedNode.rightChild = null;
			size++;
		}else{
			BinaryTreeNode toPlace = root.findNodeToInsert();
			if(null==toPlace.leftChild){
				toPlace.leftChild = insertedNode;
				insertedNode.parent = toPlace;
				insertedNode.leftChild = null;
				insertedNode.rightChild = null;
				size++;
			}else if(null==toPlace.rightChild){
				toPlace.rightChild = insertedNode;
				insertedNode.parent = toPlace;
				insertedNode.leftChild = null;
				insertedNode.rightChild = null;
				size++;
			}
		}
		return insertedNode;
	}
	
	
	// This method returns the node being searched
	public BinaryTreeNode find(Object item){
		BinaryTreeNode toReturn = new BinaryTreeNode();
		if(null==item){
			return null;
		}else if(size==0){
			return null;
		}else{
			Queue <BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			q.add(root);
			while(!q.isEmpty()){
				if(((String)q.peek().item).equalsIgnoreCase((String)item)){
					toReturn = q.peek();
					break;
				}else{
					q.add(q.peek().leftChild);
					q.add(q.peek().rightChild);
					q.remove();
				}
			}
			return toReturn;
		}
	}
	
}
class BinaryTreeNode{

	Object item;
	BinaryTreeNode parent;
	BinaryTreeNode leftChild;
	BinaryTreeNode rightChild;

	public BinaryTreeNode(){
	}
	
	public BinaryTreeNode(Object item){
		this.item = item;
	}
	
	// This method displays the tree in a pre order.
	public void preOrder(){
		this.visit();
		if(null!=this.leftChild){	
			this.leftChild.preOrder();		
		}if(null!= this.rightChild){
			this.rightChild.preOrder();
		}
	}
	
	// This method displays the tree in a post order. This is general for any trees
	public void postOrder(){
		if(null!=this.leftChild){
			this.leftChild.postOrder();
		}
		
		if(null!= this.rightChild){
			this.rightChild.postOrder();
		}
		this.visit();
	}
	
	// This method displays the tree in a in-order. Specially for Binary trees
	public void inOrder(){
		if(null!=this.leftChild){
			this.leftChild.inOrder();
		}
		this.visit();
		if(null!= this.rightChild){
			this.rightChild.inOrder();
		}
	}
	
	
	// This method displays the node content 
	public void visit(){
		if(null==this){
			throw new IllegalArgumentException ("Error");
		}else{
			System.out.print("---> "+this.item);
		}
	}
	
	// This method gives the height of the tree
	public int height(BinaryTreeNode node){
		int height =0;
		if(null==node){
			return -1;
		}else{
			return (1 + Math.max(height(node.leftChild),height(node.rightChild)));
		}
	}
	
	// This method displays elements in level Order
	public void levelOrder(){
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(this);
		while(!q.isEmpty()){
			BinaryTreeNode polledElement = (BinaryTreeNode)q.remove();
			if(null!=polledElement){
				polledElement.visit();
				q.add(polledElement.leftChild);
				q.add(polledElement.rightChild);
			}
		}
		System.out.println(" ");
	}
	
	// This method returns a positionNode where we can insert a mew Node
	public BinaryTreeNode findNodeToInsert(){
		if(null!=this){
			BinaryTreeNode toReturn = new BinaryTreeNode();
			Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			q.add(this);
			while(!q.isEmpty()){
				if(null==q.peek().leftChild || null== q.peek().rightChild){
					toReturn = q.peek();
					break;
				}else{
					q.add(q.peek().leftChild);
					q.add(q.peek().rightChild);
					q.remove();
				}
			}
			return toReturn;
		}else{
			return null;
		}
		
	}
}