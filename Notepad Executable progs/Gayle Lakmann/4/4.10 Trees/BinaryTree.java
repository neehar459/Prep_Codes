import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
public class BinaryTree{

	BinaryTreeNode root;
	int size; // this is for counting number of nodes in the tree
	
	public static void main(String[] args){
		BinaryTree binTree = new BinaryTree();
		binTree.insertNode("1");
		binTree.insertNode("2");
		binTree.insertNode("3");
		binTree.insertNode("4");
		binTree.insertNode("5");
		binTree.insertNode("6");
		binTree.insertNode("7");
		binTree.root.levelOrder();
		BinaryTreeNode toFindNode = binTree.find("3");
		System.out.println("Node 4 left child : "+(String)(toFindNode.leftChild.item));
		System.out.println("Height of the binary tree : "+binTree.root.height(binTree.root));
	}
	
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
			this.leftChild.postOrder();
		}
		this.visit();
		if(null!= this.rightChild){
			this.rightChild.postOrder();
		}
	}
	
	
	// This method displays the node content 
	public void visit(){
		if(null==this){
			throw new IllegalArgumentException ("Error");
		}else{
			System.out.print("---> "+(String)this.item);
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
	
	// This method gives the height of the tree
	public int height(BinaryTreeNode node){
		int height =0;
		if(null==node){
			return -1;
		}else{
			return (1 + Math.max(height(node.leftChild),height(node.rightChild)));
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