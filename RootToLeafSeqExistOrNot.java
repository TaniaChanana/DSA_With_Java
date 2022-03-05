package programs;

import java.io.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class RootToLeafSeqExistOrNot {
	public static boolean existPathUtil(Node root, int arr[], int n, int index) {

		if (root == null || index == n)
			return false;

		if (root.left == null && root.right == null) {
			if (index == n - 1 && arr[index] == root.data)
				return true;
			else
				return false;
		}

		return ((index < n) && (arr[index] == root.data) && (existPathUtil(root.left, arr, n, index + 1))
				|| (existPathUtil(root.right, arr, n, index + 1)));

	}

	static boolean existPath(Node root, int arr[], int n, int index) {
		if (root == null)
			return n == 0;
		return existPathUtil(root, arr, n, 0);

	}

	public static void main(String[] args) {
		int arr[] = { 5, 8, 6, 7 };
		int n = arr.length;
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(8);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		root.left.left.left = new Node(1);
		root.right.left = new Node(6);
		root.right.left.right = new Node(7);

		if (existPath(root, arr, n, 0))
			System.out.println("Path Exists");
		else
			System.out.println("Path does not Exist");

	}
}
