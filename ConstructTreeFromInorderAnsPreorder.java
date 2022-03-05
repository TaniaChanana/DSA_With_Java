package programs;

//class TreeNode {
//	int data;
//	TreeNode left, right;
//
//	public TreeNode(int data) {
//		this.data = data;
//		left = null;
//		right = null;
//	}
//};

public class ConstructTreeFromInorderAnsPreorder {
	public static TreeNode build(int inorder[], int isi, int iei, int[] preorder, int psi, int pei) {
		if (isi > iei)
			return null;

		TreeNode root = new TreeNode(preorder[psi]);
		int index = isi;

		while (inorder[index] != preorder[psi])
			index++;

		int tne = index - isi;

		root.left = build(inorder, isi, index - 1, preorder, psi + 1, psi + tne);
		root.right = build(inorder, index + 1, iei, preorder, psi + tne + 1, pei - 1);

		return root;
	}

	public static TreeNode buildTree(int[] inorder, int[] preorder) {
		int n = inorder.length;
		return build(inorder, 0, n - 1, preorder, 0, n - 1);
	}

	public static void main(String[] args) {
		int[] inorder = { 9, 3, 15, 20, 7 };
		int[] preorder = { 3, 9, 20, 15, 7 };

		TreeNode root = buildTree(inorder, preorder);
		postorder(root);
	}

	private static void postorder(TreeNode root) {
		if (root == null) {
//			System.out.print("null  ");
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + "  ");
	}

}
