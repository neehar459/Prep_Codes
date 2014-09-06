import java.util.List;
import java.util.ArrayList;
public class InOrderSuccessor {
	public static void main (String[] args) {
		BinTreeNode n1 = new BinTreeNode(1);
		BinTreeNode n2 = new BinTreeNode(2);
		BinTreeNode n3 = new BinTreeNode(3);
		BinTreeNode n4 = new BinTreeNode(4);
		BinTreeNode n5 = new BinTreeNode(5);
		BinTreeNode n6 = new BinTreeNode(6);
		BinTreeNode n7 = new BinTreeNode(7);
		BinTreeNode n8 = new BinTreeNode(8);
		BinTreeNode n9 = new BinTreeNode(9);
		n1.left = n2;n2.parent = n1;n1.right = n3;n3.parent = n1;n2.left = n4;n4.parent = n2;n2.right = n5;n5.parent = n2;
		n3.left = n6;n6.parent = n3;n3.right = n7;n7.parent = n3;n4.left = n8;n8.parent = n4;n7.left = n9;n9.parent = n7;
		BinTreeNode successor = naiveInOrderSuccessor(n1, n5);
		if(successor != null) {
			System.out.println("Successor : "+successor.data);
		}
		BinTreeNode succ = inOrderSucc(n6);
		if(succ != null) {
			System.out.println("Successor New : "+succ.data);
		} else {
			System.out.println("Successor New is NULL ");
		}
		BinTreeNode succ2 = findInSucc2(n6);
		if(succ2 != null) {
			System.out.println("Successor New 2 : "+succ2.data);
		} else {
			System.out.println("Successor New 2 is NULL ");
		}
		
	}
	public static BinTreeNode naiveInOrderSuccessor(BinTreeNode root, BinTreeNode node) {
		if(root == null || node == null) {
			return null;
		} else {
			List<BinTreeNode> iList = new ArrayList<BinTreeNode>();
			inOrderList(root, iList);
			for(int i=0; i< iList.size(); i++) {
				if(i == (iList.size()-1)) {
					return null;
				} else {
					if(node.data == iList.get(i).data){
						return iList.get(i+1);
					}
				}
			}
			return null;
		}
	}
	public static void inOrderList(BinTreeNode root, List<BinTreeNode> iList) {
		if(root != null) {
			inOrderList(root.left, iList);
			iList.add(root);
			inOrderList(root.right, iList);
		}
	}
	public static void displayInOrderList(BinTreeNode root) {
		if(root != null) {
			displayInOrderList(root.left);
			System.out.println(root.data);
			displayInOrderList(root.right);
		}
	}

	public static BinTreeNode inOrderSucc (BinTreeNode n) {
		if(n == null) {
			return null;
		} else {
			BinTreeNode root = findRoot(n);
			if(root == null) {
				return null;
			} else {
				System.out.println("Root of Tree : " + root.data);
				List<BinTreeNode> inList = findInOrderList(root, new ArrayList());
				if(inList != null) {
					for(int i=0;i < inList.size(); i++) {
					if(inList.get(i) != null) {
						if(inList.get(i).data == n.data && i != inList.size()-1) {
							return inList.get(i+1);
						}
					}
				}
				}
				
				return null;
			}
		}
	}

	public static List<BinTreeNode> findInOrderList (BinTreeNode n, List<BinTreeNode> iList) {
		if(n != null) {
			findInOrderList(n.left, iList);
			iList.add(n);
			findInOrderList(n.right,iList);
		}
		return iList;
	}
	public static BinTreeNode findRoot (BinTreeNode n) {
		if(n == null){
			return null;
		} else {
			BinTreeNode par = n;
			while(par != null && par.parent != null) {
					par = par.parent;
			}
			return par;
		}
	}
	
	public static BinTreeNode findInSucc2 (BinTreeNode n){
		if(n == null) {
			return null;
		} else {
			if(n.right != null) {
				return findMinNode(n.right);
			} else {
				BinTreeNode par = n.parent;
				while(n != null && par !=null && n== par.right) {
					n = n.parent;
					if(par != null){
						par = par.parent;
					}
				}
				return par;
			}
		}
	}
	
	public static BinTreeNode findMinNode (BinTreeNode n){
		if(n == null) {
			return null;
		} else {
			while(n != null && n.left != null){
				n = n.left;
			}
			return n;
		}
	}	

}
class BinTreeNode {
	int data;
	BinTreeNode left;
	BinTreeNode right;
	BinTreeNode parent;
	public BinTreeNode() {

	}
	public BinTreeNode(int data) {
		this.data = data;
	}
}