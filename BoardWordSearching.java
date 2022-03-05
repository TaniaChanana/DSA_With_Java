package programs;

import java.util.*;

public class BoardWordSearching {

	public static void main(String[] args) {

		Set<String> list = new HashSet(Arrays.asList("xyz", "xz"));

		char[][] board = { { 'a', 'e', 't', 'w' }, { 'b', 'x', 'z', 'w' }, { 'd', 'e', 'y', 'p' },
				{ 'e', 'f', 'g', 'z' } };

		List<String> output = new ArrayList();

		getListOfAllWordsInBoard(board, output, list);

		System.out.println(output.toString());
	}

	private static void getListOfAllWordsInBoard(char[][] board, List<String> output, Set<String> list) {

		int row = board.length;
		int col = board[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				traverseAllPosition(board, i, j, row, col, output, list, "");
			}
		}

	}

	private static void traverseAllPosition(char[][] board, int row, int col, int R, int C, List<String> output,
			Set<String> list, String str) {

		if (!isSafe(row, col, R, C)) {
			return;
		}
		
		str = str + board[row][col];
		
		if (list.contains(str)) {
			output.add(str);
		}

		if (board[row][col] == '*') {
			return;
		}

		board[row][col] = '*';
		
		traverseAllPosition(board, row + 1, col, R, C, output, list, str);
		traverseAllPosition(board, row, col + 1, R, C, output, list, str);
		traverseAllPosition(board, row, col - 1, R, C, output, list, str);
		traverseAllPosition(board, row - 1, col, R, C, output, list, str);
		traverseAllPosition(board, row - 1, col + 1, R, C, output, list, str);
		traverseAllPosition(board, row + 1, col + 1, R, C, output, list, str);
		traverseAllPosition(board, row + 1, col - 1, R, C, output, list, str);
		traverseAllPosition(board, row - 1, col - 1, R, C, output, list, str);
		
	}

	public static boolean isSafe(int row, int col, int R, int C) {

		if (row < 0 || row >= R || col < 0 || col >= C) {
			return false;
		}

		return true;
	}

}
