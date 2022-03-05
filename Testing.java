package programs;

import java.util.*;

public class Testing {

	public static void main(String[] args) {

		Set<String> list = new HashSet(Arrays.asList("xyz", "xz"));

		char[][] board = { { 'a', 'e', 't', 'w' }, { 'b', 'x', 'z', 'w' }, { 'd', 'e', 'z', 'p' },
				{ 'e', 'f', 'g', 'z' } };

		TrieDS root = new TrieDS();

//		for (String str : list) {
//			root.addWordToTrie(str);
//		}

		List<String> output = new ArrayList();

		getListOfAllWordsInBoard(root, board, output, list);

		System.out.println(output.toString());
	}

	private static void getListOfAllWordsInBoard(TrieDS root, char[][] board, List<String> output, Set<String> list) {

		int row = board.length;
		int col = board[0].length;
		boolean visited[][] = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (!visited[i][j]) {
					String str = new String();
					traverseAllPosition(root, board, i, j, row, col, output, visited, list, str);
				}
			}
		}

	}

	private static void traverseAllPosition(TrieDS root, char[][] board, int row, int col, int R, int C,
			List<String> output, boolean[][] visited, Set<String> list, String str) {

		if(list.contains(str)) {
			output.add(str);
		}
		
		if (!isSafe(row, col, R, C) || visited[row][col]) {
			return;
		}

		visited[row][col] = true;

		str = str + board[row][col];

//		root.getAllString(str, output, list);

		traverseAllPosition(root, board, row + 1, col, R, C, output, visited, list, str);
		traverseAllPosition(root, board, row, col + 1, R, C, output, visited, list, str);
		traverseAllPosition(root, board, row, col - 1, R, C, output, visited, list, str);
		traverseAllPosition(root, board, row - 1, col, R, C, output, visited, list, str);
		traverseAllPosition(root, board, row - 1, col + 1, R, C, output, visited, list, str);
		traverseAllPosition(root, board, row + 1, col + 1, R, C, output, visited, list, str);
		traverseAllPosition(root, board, row + 1, col - 1, R, C, output, visited, list, str);
		traverseAllPosition(root, board, row - 1, col - 1, R, C, output, visited, list, str);
	}

	public static boolean isSafe(int row, int col, int R, int C) {

		if (row < 0 || row >= R || col < 0 || col >= C) {
			return false;
		}

		return true;
	}

}

class TrieN {
	char ch;
	TrieN child[];
	boolean isWord;

	TrieN() {
		child = new TrieN[26];
	}
}

class TrieDS {
	TrieN root;

	TrieDS() {
		root = new TrieN();
	}

	public void getAllString(String str, List<String> output, Set<String> list) {
		TrieN node = root;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int index = ch - 'a';
			if (node.child[index] == null)
				return;

			node = node.child[index];
		}

		traverseATreeUsingNode(node, output, "", list);

	}

	public void traverseATreeUsingNode(TrieN node, List<String> output, String str, Set<String> list) {

		if (node == null) {
			return;
		}

		str += node.ch;

		if (node.isWord && list.contains(str)) {
			output.add(str);
		}

		for (int i = 0; i < 26; i++) {
			TrieN chil = node.child[i];
			if (chil != null) {
				traverseATreeUsingNode(chil, output, str, list);
			}
		}

	}

	public void addWordToTrie(String str) {
		addWord(root, 0, str);
	}

	private void addWord(TrieN node, int index, String str) {

		if (index >= str.length() || node == null || index < 0 || str.isEmpty()) {
			return;
		}

		char ch = str.charAt(index);
		int in = ch - 'a';
		TrieN childern = node.child[in];

		if (childern == null) {
			childern = new TrieN();
			childern.ch = ch;

		}

		if (index == str.length() - 1) {
			childern.isWord = true;
		}

		node.child[in] = childern;

		addWord(childern, index + 1, str);
	}
}
