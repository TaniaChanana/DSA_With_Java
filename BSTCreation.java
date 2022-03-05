package programs;

public class BSTCreation {
	public static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data, Node left, Node right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
	}
	Node root;
	BSTCreation(){
		root = null;
	}
	
	public void insert(int key) {
		root = insertion(root,key);
	}
	
	public Node insertion(Node root,int data) {
		if(root==null)
		{
			root = new Node(data,null,null);
			return root;
		}
		
		if(data<root.data) {
			root.left = insertion(root.left, data);
		}
		else if(data>root.data) {
			root.right = insertion(root.right, data);
		}
		
		return root;
	}
	public static void main(String[] args) {
		BSTCreation tree = new BSTCreation();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		// tree.inorder();
		tree.inorderRec(tree.root);
	}

	private void inorder() {
		inorderRec(root);
	}

	private void inorderRec(Node node) {
		if(node == null)
			return;
		inorderRec(node.left);
		System.out.print(node.data+"  ");
		inorderRec(node.right);
		
	}

}
