import java.util.Map;
public class RootedTree{

	RootedTreeNode root;
	int size; // this is for counting number of nodes in the tree
	
	public static void main(String[] args){
		RootedTree rTree = new RootedTree();
		rTree.insertNode("~jre");
		rTree.insertNode("lab");
		rTree.insertNode("lab1");
		rTree.insertNode("lab2");
		rTree.insertNode("lab3");
		rTree.insertNode("index.html");
		rTree.insertNode("HW");
		rTree.insertNode("lec");
		rTree.insertNode("HW1");
		rTree.insertNode("HW2");
		rTree.insertNode("HW3");
		rTree.insertNode("lec1");
		rTree.insertNode("lec2");
		rTree.insertNode("lec3");
		rTree.insertNode("lec4");
		System.out.println(" size of tree : "+rTree.size);
		RootedTreeNode jreNode = rTree.find("~jre");
		RootedTreeNode jreFirstChild = jreNode.firstChild;
		//jreNode.visit();
		//System.out.println("jre lastChild : "+(String)(jreFirstChild.nextSibling.nextSibling.nextSibling.item));
		RootedTreeNode lecFirstChild = jreNode.firstChild.nextSibling.nextSibling.nextSibling.firstChild;
		//System.out.println("hw lastChild : "+(String)(lecFirstChild.nextSibling.nextSibling.nextSibling.item));
		System.out.println("Pre Order");
		rTree.root.preOrder();
		System.out.println("==========");
		System.out.println("==========");
		System.out.println("Post Order");
		rTree.root.postOrder();
	}
	
	public RootedTreeNode insertNode(Object item){
		RootedTreeNode insertedNode = new RootedTreeNode(item);
		if(null==root || size==0){
			root = insertedNode;
			root.parent = null;
			root.nextSibling = null;
			root.firstChild = null;
			size++;
		}else if(size==1){
			root.firstChild = insertedNode;
			insertedNode.parent = root;
			insertedNode.firstChild = null;
			insertedNode.nextSibling = null;
			size++;
		}else{
			if(item instanceof String){
				String nodeContent = (String)item;
				if(nodeContent.equalsIgnoreCase("lab")){
					insertedNode.parent = root;
					if(null==root.firstChild){
						root.firstChild = insertedNode;
					}
					insertedNode.nextSibling = null;
					insertedNode.firstChild = null;
					size++;
				}else if (nodeContent.equalsIgnoreCase("index.html")){
					insertedNode.parent = root;
					//root.firstChild.nextSibling = insertedNode;
					RootedTreeNode lastChild = findLastSibling(root.firstChild);
					lastChild.nextSibling = insertedNode;
					insertedNode.nextSibling = null;
					insertedNode.firstChild = null;
					size++;
				}else if (nodeContent.equalsIgnoreCase("HW")){
					insertedNode.parent = root;
					//root.firstChild.nextSibling.nextSibling = insertedNode;
					RootedTreeNode lastChild = findLastSibling(root.firstChild);
					lastChild.nextSibling = insertedNode;
					insertedNode.nextSibling = null;
					insertedNode.firstChild = null;
					size++;
				}else if (nodeContent.equalsIgnoreCase("lec")){
					insertedNode.parent = root;
					//root.firstChild.nextSibling.nextSibling.nextSibling = insertedNode;
					RootedTreeNode lastChild = findLastSibling(root.firstChild);
					lastChild.nextSibling = insertedNode;
					insertedNode.nextSibling = null;
					insertedNode.firstChild = null;
					size++;
				}else if(nodeContent.contains("lab")){
					RootedTreeNode parentNode = find("lab");
					if(null==parentNode.firstChild){
						parentNode.firstChild = insertedNode;
						insertedNode.nextSibling = null;
						insertedNode.firstChild = null;
					}else{
						RootedTreeNode lastSibling = findLastSibling(parentNode.firstChild);
						lastSibling.nextSibling = insertedNode;
						insertedNode.nextSibling = null;
						insertedNode.firstChild = null;
					}
					insertedNode.parent = parentNode;
					size++;
				}else if(nodeContent.contains("HW")){
					RootedTreeNode parentNode = find("HW");
					if(null==parentNode.firstChild){
						parentNode.firstChild = insertedNode;
						insertedNode.nextSibling = null;
						insertedNode.firstChild = null;
					}else{
						RootedTreeNode lastSibling = findLastSibling(parentNode.firstChild);
						lastSibling.nextSibling = insertedNode;
						insertedNode.nextSibling = null;
						insertedNode.firstChild = null;
					}
					insertedNode.parent = parentNode;
					size++;
				}else if(nodeContent.contains("lec")){
					RootedTreeNode parentNode = find("lec");
					if(null==parentNode.firstChild){
						parentNode.firstChild = insertedNode;
						insertedNode.nextSibling = null;
						insertedNode.firstChild = null;
					}else{
						RootedTreeNode lastSibling = findLastSibling(parentNode.firstChild);
						lastSibling.nextSibling = insertedNode;
						insertedNode.nextSibling = null;
						insertedNode.firstChild = null;
					}
					insertedNode.parent = parentNode;
					size++;
				}				
			}
			}
		return insertedNode;
	}
	
	// This method returns the node being searched
	public RootedTreeNode find(Object item){
		RootedTreeNode toReturn = new RootedTreeNode();
		if(null==item){
			return null;
		}else if(size==0){
			return null;
		}else{
			int loopCounter = size;
			RootedTreeNode iterNode = root;
			while(loopCounter!=0){
				if(((String)(iterNode.item)).equalsIgnoreCase((String)item)){
					toReturn = iterNode;
					return toReturn;
				}else{
					
				}
				if(null!=iterNode.nextSibling){
					iterNode = iterNode.nextSibling;
				}else if(null!=iterNode.firstChild){
					iterNode = iterNode.firstChild;
				}
				loopCounter--;
			}
		}
		return null;
	}
	
	// This method returns the previous sibling of a node
	public RootedTreeNode findLastSibling(RootedTreeNode item){
		RootedTreeNode toReturn = new RootedTreeNode();
		if(null==item){
			return null;
		}else if(size==0){
			return null;
		}else{
			RootedTreeNode iterNode = item;
			while(true){
				if(null==iterNode.nextSibling){
					toReturn = iterNode;
					break;
				}
				iterNode = iterNode.nextSibling;
			}
			return toReturn;
		}
	}
	
	
}
class RootedTreeNode{

	Object item;
	RootedTreeNode parent;
	RootedTreeNode firstChild;
	RootedTreeNode nextSibling;

	public RootedTreeNode(){
	}
	
	public RootedTreeNode(Object item){
		this.item = item;
	}
	
	// This method displays the tree in a pre order.
	public void preOrder(){
		this.visit();
		if(null!=this.firstChild){	
			this.firstChild.preOrder();		
		}if(null!= this.nextSibling){
			this.nextSibling.preOrder();
		}
	}
	
	// This method displays the tree in a pre order.
	public void postOrder(){
		if(null!=this.firstChild){
			this.firstChild.postOrder();
		}
		
		if(null!= this.nextSibling){
			this.nextSibling.postOrder();
		}
		this.visit();
	}
	
	// This method displays the node content 
	public void visit(){
		if(null==this){
			throw new IllegalArgumentException ("Error");
		}else{
			System.out.println((String)this.item);
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