import java.util.*;

public class TriesContacts {
	static public class TrieNode {
		Map<Character, TrieNode> children = new HashMap<>();
		public int count;

		public void putIfAbsent(char ch) {
			children.putIfAbsent(ch, new TrieNode());
		}

		public TrieNode get(char ch) {
			return children.get(ch);
		}
	}

	static public class Trie {
		TrieNode root = new TrieNode();

		public Trie() {};

		public void add(String str) {
			TrieNode curr = root;
			for (int i=0; i<str.length(); i++) {
				char ch = str.charAt(i);
				curr.putIfAbsent(ch);
				curr = curr.get(ch);
				curr.count++;
			}
		}

		public int find(String partial) {
			TrieNode curr = root;
			for (int i=0; i<partial.length(); i++) {
				char ch = partial.charAt(i);
				curr = curr.get(ch);
				if (curr == null) {
					return 0;
				}
			}
			return curr.count;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Trie trie = new Trie();
		for (int i = 0; i < n; i++) {
			String op = in.next();
			String contact = in.next();
			if (op.equals("add")) {
				trie.add(contact);
			}
			else {
				System.out.println(trie.find(contact));
			}
		}
	}
}