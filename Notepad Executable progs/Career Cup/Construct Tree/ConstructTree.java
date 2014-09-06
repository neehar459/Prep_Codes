public class ConstructTree {

	public static void main(String[] args){
		int[] inOrder = {2,1,4,3,5};
		int[] preOrder = {1,2,3,4,5};
		TreeNode newHead = buildTree(preOrder,inOrder);
		newHead.inOrder(newHead);
		System.out.println(" ");
		newHead.preOrder(newHead);
	}
	
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int preleftSubLength = preorder.length;
        int inleftSubLength = inorder.length;
        return buildTree(preorder, 0, preleftSubLength-1, inorder, 0, inleftSubLength-1);
    }
   
    public static TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd){
        if(inStart > inEnd){
            return null;
        }
        int rootVal = pre[preStart];
        int rootIndex = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(in[i] == rootVal){
                rootIndex = i;
                break;
            }
        }
        int leftSubLen = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(pre, preStart+1, preStart+leftSubLen, in, inStart, rootIndex-1);
        root.right = buildTree(pre, preStart+leftSubLen+1, preEnd, in, rootIndex+1, inEnd);
        return root;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
	
	public static void inOrder(TreeNode node){
		if(null != node){
			inOrder(node.left);
			System.out.print(node.val+",");
			inOrder(node.right);
		}
	}
	
	public static void preOrder(TreeNode node){
		if(null != node){
			System.out.print(node.val+",");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
 }
