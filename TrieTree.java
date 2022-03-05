package programs;

import java.util.*;

public class TrieTree {

	public static void main(String[] args) {

		List<String> list = new ArrayList(Arrays.asList("ab", "acb", "adcs", "abcd"));
		Trie root = new Trie();

		for (String str : list) {
			root.addWordToTrie(str);
		}

		List<String> output = new ArrayList();

		String prefix = "ab";
		
		root.getAllStringStartsWithPrefix(prefix, output);
		System.out.println(output.toString());
		output = concatenateWithPrefix(prefix, output);

		System.out.println(output.toString());
	}

	private static List<String> concatenateWithPrefix(String prefix, List<String> output) {

		List<String> words = new ArrayList();

		for (String str : output) {
			words.add(prefix.substring(0, prefix.length() - 1) + str);
		}

		return words;
	}

}

class TrieNode {
	char ch;
	TrieNode child[];
	boolean isWord;

	TrieNode() {
		child = new TrieNode[26];
	}
}

class Trie {
	TrieNode root;

	Trie() {
		root = new TrieNode();
	}

	public void getAllStringStartsWithPrefix(String prefix, List<String> output) {
		TrieNode node = root;
		for (int i = 0; i < prefix.length(); i++) {
			int index = prefix.charAt(i) - 'a';
			if (node.child[index] == null)
				return;

			node = node.child[index];
		}

		traverseATreeUsingNode(node, output, "");

	}

	private void traverseATreeUsingNode(TrieNode node, List<String> output, String str) {

		if (node == null) {
			return;
		}

		str += node.ch;

		if (node.isWord) {
			output.add(str);
		}

		for (int i = 0; i < 26; i++) {
			TrieNode chil = node.child[i];
			if (chil != null) {
				traverseATreeUsingNode(chil, output, str);
			}
		}

	}

	public void addWordToTrie(String str) {
		addWord(root, 0, str);
	}

	private void addWord(TrieNode node, int index, String str) {

		if (index >= str.length() || node == null || index < 0 || str.isEmpty()) {
			return;
		}

		char ch = str.charAt(index);
		int in = ch - 'a';
		TrieNode childern = node.child[in];

		if (childern == null) {
			childern = new TrieNode();
			childern.ch = ch;

		}

		if (index == str.length() - 1) {
			childern.isWord = true;
		}

		node.child[in] = childern;

		addWord(childern, index + 1, str);
	}
}