package programs;

public class RootToLeafPathSumEqualToGivenSum {

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(8);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		root.left.left.left = new Node(1);
		root.right.left = new Node(6);
		root.right.left.right = new Node(7);
		int sum = 26;
		boolean result = hasPathSum(root,sum);
		System.out.println(result);

	}

	public static boolean hasPathSum(Node root, int S) {
        boolean res = hasSum(root,S);
        return res;
    }
    
    public static boolean hasSum(Node root,int sum){
        if (root==null)
            return false;
        if (root.left == null && root.right==null){
            if (sum-root.data==0)
                return true;
            else
            return false;
        }
        
        return((hasSum(root.left,sum-root.data)) 
                || (hasSum(root.right,sum-root.data)));
    }
	
}
