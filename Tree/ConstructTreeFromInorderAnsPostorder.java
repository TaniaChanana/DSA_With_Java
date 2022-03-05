package programs;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
};

public class ConstructTreeFromInorderAnsPostorder {
	public static TreeNode build(int inorder[], int isi, int iei, int[] postorder, int psi, int pei) {
		if (isi > iei)
			return null;

		TreeNode root = new TreeNode(postorder[pei]);
		int index = isi;

		while (inorder[index] != postorder[pei])
			index++;

		int tne = index - isi;

		root.left = build(inorder, isi, index - 1, postorder, psi, psi + tne - 1);
		root.right = build(inorder, index + 1, iei, postorder, psi + tne, pei - 1);

		return root;
	}

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		int n = inorder.length;
		return build(inorder, 0, n - 1, postorder, 0, n - 1);
	}

	public static void main(String[] args) {
		int[] inorder = { 9, 3, 15, 20, 7 };
		int[] postorder = { 9, 15, 7, 20, 3 };

		TreeNode root = buildTree(inorder, postorder);
		preorder(root);
	}

	private static void preorder(TreeNode root) {
		if (root == null) {
			System.out.print("null  ");
			return;
		}
		System.out.print(root.data + "  ");
		preorder(root.left);
		preorder(root.right);
	}

}
