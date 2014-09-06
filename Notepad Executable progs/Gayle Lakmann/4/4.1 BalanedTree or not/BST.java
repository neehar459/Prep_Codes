import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BST{

	
	BSTNode root;
	int size;
	
	// Important : In order traversal on BST gives it sorted representation.
	
	public static void main(String[] args){
		BST bst = new BST();
		/* bst.insert(5);
		bst.insert(3);
		bst.insert(7);
		bst.insert(1);
		bst.insert(4);
		bst.insert(6);
		bst.insert(9);
		bst.insert(10);
		bst.insert(2);
		 */
		// Tree for height balanced check
		bst.insert(8);
		bst.insert(5);
		bst.insert(9);
		bst.insert(10);
		bst.insert(4);
		bst.insert(7);
		bst.insert(6);
		System.out.println ("Level Order : ");
		bst.root.levelOrder();
		System.out.println(" ");
		System.out.println("Height of tree : "+bst.height(bst.root));
		/* Map<Integer, Boolean> visitedMap = bst.markVisited(bst.root);
		Map<Integer,Boolean> dfsMap =bst.dfsRecursion(bst.root, visitedMap);
		int[] keyArray = new int[dfsMap.keySet().size()];
		int i=0;
		System.out.println(" Keys : ");
		for (Integer val : dfsMap.keySet()){
			  keyArray[i++] = val;
		  }
		for(int j : keyArray){
			System.out.print(" ---> "+j);	
		}
		System.out.println(" ");
		System.out.println("Collection values ");
		Collection<Boolean> c = dfsMap.values();
		for(Boolean b : c){
			System.out.print("---> "+b);
		}
		System.out.println(" ");
		 */
		 System.out.println("Is tree Balanced : "+bst.isBalancedModified(bst.root));
	}
	
	// This method tells if a tree is balanced or not. This is my implementation
	public boolean isBalancedTree (BSTNode root){
		if(null==root){
			return false;
		}else{
			int leftSTHeight = height(root.leftChild);
			int rightSTHeight = height(root.rightChild);
			System.out.println("LeftST Height : "+leftSTHeight);
			System.out.println("RightST Height : "+rightSTHeight);
			if((leftSTHeight - rightSTHeight == 1) || (leftSTHeight - rightSTHeight == -1) && (isBalancedTree(root.leftChild) && 
																		(isBalancedTree(root.rightChild)))){
				return true;
			}else{
			return false;
			}
		}
	}
	
	// Gayle Lakman code for improvised balanced tree check
	public boolean isBalancedModified(BSTNode root){
		if(findHeight(root) == -1){
			return false;
		}else{
			return true;
		}
	}
	
	// This method marks all nodes in the graph visited
	public Map<Integer,Boolean> markVisited(BSTNode node){
		Map<Integer, Boolean> visitedMap = new HashMap<Integer, Boolean>();
		Queue<BSTNode> myQueue = new LinkedList<BSTNode>();
		myQueue.add(node);
		while(!myQueue.isEmpty()){
			BSTNode polledElement = (BSTNode)myQueue.remove();
			if(null!=polledElement){
				visitedMap.put(polledElement.item, false);	
				myQueue.add(polledElement.leftChild);
				myQueue.add(polledElement.rightChild);
			}
		}
		return visitedMap;
	}
	// This method does the depth first Search of the tree
	public void dfs(BSTNode node){
		Stack<BSTNode> myStack = new Stack<BSTNode>();
		Map<Integer, Boolean> visitedMap = markVisited(node);
		myStack.push(node);
		while(!myStack.isEmpty()){
			BSTNode iterNode = myStack.peek();
			System.out.println("item : "+iterNode.item);
			if(null == iterNode.leftChild && null == iterNode.rightChild){
				myStack.pop();
				continue;
			}
			if(null!=iterNode.leftChild && null!=iterNode.rightChild){
				if((visitedMap.get(iterNode.leftChild.item)==true)&&
						(visitedMap.get(iterNode.rightChild.item)==true)){
				myStack.pop();
				}
				if((null != iterNode.leftChild || null != iterNode.rightChild)){
					if(visitedMap.get(iterNode.leftChild.item)==false){
						myStack.push(iterNode.leftChild);
						visitedMap.put(iterNode.leftChild.item,true);
						continue;
					}
					 if(visitedMap.get(iterNode.rightChild.item)==false){
								myStack.push(iterNode.rightChild);
								visitedMap.put(iterNode.rightChild.item,true);
					}
				}
			} if (null != iterNode.leftChild && null == iterNode.rightChild){
				if(visitedMap.get(iterNode.leftChild.item)==false){
					myStack.push(iterNode.leftChild);
					visitedMap.put(iterNode.leftChild.item,true);
					continue;
				}else{
					myStack.pop();
				}
			}else if (null != iterNode.rightChild && null == iterNode.leftChild){
				if(visitedMap.get(iterNode.rightChild.item)==false){
					myStack.push(iterNode.rightChild);
					visitedMap.put(iterNode.rightChild.item,true);
					continue;
				}else{
					myStack.pop();
				}
			}
		}
	}
	
	// This method returns the children of a corresponding parent node
	public BSTNode[] getChildren(BSTNode parentNode){
		if(null != parentNode.leftChild && null != parentNode.rightChild){
			BSTNode[] toReturn = new BSTNode[2];
			toReturn[0] = parentNode.leftChild;
			toReturn[1] = parentNode.rightChild;
			return toReturn;
		}
		if(null != parentNode.leftChild && null == parentNode.rightChild){
			BSTNode[] toReturn = new BSTNode[1];
			toReturn[0] = parentNode.leftChild;
			return toReturn;
		}
		if(null == parentNode.leftChild && null != parentNode.rightChild){
			BSTNode[] toReturn = new BSTNode[1];
			toReturn[0] = parentNode.rightChild;
			return toReturn;
		}
		return null;
	}
	// This method does DepthFirstSeach using Recursion
	public Map<Integer,Boolean> dfsRecursion(BSTNode source, Map<Integer,Boolean> visitedMap){
		visitedMap.put(source.item,true);
		BSTNode[] childrenArray = null;
		if(null!=getChildren(source)){
			childrenArray = getChildren(source);
			for(BSTNode i : childrenArray){
				if(visitedMap.get(i.item)==false){
					dfsRecursion(i,visitedMap);
				}
			}
		}
		return visitedMap;
	}
	
	// This method gives the height of the tree. My code
	public int height(BSTNode node){
		int height =0;
		if(null==node){
			return 0;
		}else{
			return (1 + Math.max(height(node.leftChild),height(node.rightChild)));
		}
	}
	
	// Gayle Lakman Code. Improvised height finding
	public int findHeight(BSTNode node){
		if(null == node){
			return 0;
		}
		int leftHeight = findHeight(node.leftChild);
		if(leftHeight == -1){
			return -1;
		}
		int rightHeight = findHeight(node.rightChild);
		if(rightHeight == -1){
			return -1;
		}
		int heightDifference = Math.abs(leftHeight - rightHeight);
		if(heightDifference > 1){
			return -1;
		}else{
			return Math.max(leftHeight, rightHeight)+1;
		}
	}
	
	
	// This method finds an item in the BST
	public BSTNode find(int element, BSTNode  node){
		if(null==node || size ==0){
			return null;
		}else{
			BSTNode toReturn = new BSTNode();
			toReturn = node;
			if(compare(element, (toReturn.item))==0){
				return toReturn;
			}else{
				if(compare(element, (toReturn.item))<0){
				return find(element, node.leftChild);
				}else{
				return find(element, node.rightChild);
				}
			}
		}
	}
	
	// This method adds and element to the BST
	public BSTNode insert(int data){
		if(null == root || size ==0){
			BSTNode toReturn = new BSTNode(data);
			root = toReturn;
			size++;
			return toReturn;
		}
		return insert(data,root);
	}
	
	// This method adds element to the BST by taking extra parameter node in addition to data
	public BSTNode insert(int data, BSTNode node){
		if(null==node){
			BSTNode toReturn = new BSTNode(data);
			size++;
			return toReturn;
		}else{
			if(data <= node.item){	
				node.leftChild  = insert(data, node.leftChild);
				node.leftChild.parent = node;
				return node;
			}else{
				node.rightChild =  insert(data, node.rightChild);
				node.rightChild.parent = node;
				return node;
			}
		}
	}
	
	// This method deleted and element from the Binary Search Tree
	public BSTNode delete (int element){
		BSTNode toDeleteNode = find(element, root);
		if(null==toDeleteNode){
			return null;
		}
		BSTNode deleteNodeParent = toDeleteNode.parent;
		boolean flagLeftChild = false;
		if(deleteNodeParent.leftChild == toDeleteNode){
			flagLeftChild = true;
		}
		// If the node to be deleted is a leaf node
		if(null==toDeleteNode.leftChild && null == toDeleteNode.rightChild){
			if(deleteNodeParent.leftChild.item == element){
				deleteNodeParent.leftChild = null;
				size--;
				return toDeleteNode;
			}else if(deleteNodeParent.rightChild.item == element){
				deleteNodeParent.rightChild = null;
				size--;
				return toDeleteNode;
			}
		} // If the node to be deleted is a degree 1 node
		else if(null == toDeleteNode.leftChild || null == toDeleteNode.rightChild){
			BSTNode toDeleteNodeChild = null;
			if(null == toDeleteNode.leftChild){
				toDeleteNodeChild = toDeleteNode.rightChild;
			}else if (null == toDeleteNode.rightChild){
				toDeleteNodeChild = toDeleteNode.leftChild;
			}
			if(flagLeftChild){
				deleteNodeParent.leftChild = toDeleteNodeChild;
				toDeleteNodeChild.parent = deleteNodeParent;
				size--;
				return toDeleteNode;
			}else{
				deleteNodeParent.rightChild = toDeleteNodeChild;
				toDeleteNodeChild.parent = deleteNodeParent;
				size--;
				return toDeleteNode;
			}
		} // If the node to be deleted is a degree 2 node
		else{
			// Find the smallest node for the right subtree of tree rooted at deleted node.
			BSTNode toIter = toDeleteNode.rightChild;
			BSTNode min = new BSTNode();
			while(null!=toIter){
				min = toIter;
				toIter = toIter.leftChild;
			}
			if(null==min.rightChild && null == min.leftChild){
				BSTNode tempReturn = toDeleteNode;
				toDeleteNode.item = min.item;
				if(min.parent.leftChild == min){
					min.parent.leftChild = null;
				}else{
					min.parent.rightChild = null;
				}
				size--;
				return tempReturn;
			}else if(null!=min.rightChild){
				BSTNode tempReturn = toDeleteNode;
				toDeleteNode.item = min.item;
				min.parent.leftChild = min.rightChild;
				min.rightChild.parent = min.parent;
				size--;
				return tempReturn;
			}
		}
		return toDeleteNode;
	}
	
	
	// This method compares two integers and gives the result
	public int compare (Integer x, Integer y){
		return x-y;
	}

}

class BSTNode {

	int item;
	BSTNode  parent;
	BSTNode  leftChild;
	BSTNode  rightChild;

	public BSTNode(){
	}
	
	public BSTNode(int item){
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
		//System.out.println(" ");
	}
	
	// This method displays elements in level Order
	public void levelOrder(){
		Queue<BSTNode> q = new LinkedList<BSTNode>();
		q.add(this);
		while(!q.isEmpty()){
			BSTNode polledElement = (BSTNode)q.remove();
			if(null!=polledElement){
				polledElement.visit();
				q.add(polledElement.leftChild);
				q.add(polledElement.rightChild);
			}
		}
		System.out.println(" ");
	}
	
	// This method returns a positionNode where we can insert a mew Node
	public BSTNode findNodeToInsert(){
		if(null!=this){
			BSTNode toReturn = new BSTNode();
			Queue<BSTNode> q = new LinkedList<BSTNode>();
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

 final class MyEntry<K,V> implements Map.Entry<K,V>{
	
	private final K key;
	private V value;
	
	public MyEntry(K key, V value){
		this.key = key;
		this.value = value;
	}
	
	public K getKey(){
		return key;
	}
	
	public V getValue(){
		return value;
	}
	
	public V setValue(V value){
		V oldValue = this.value;
		this.value = value;
		return oldValue;
	}
	
}