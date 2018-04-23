import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
	}
}

public class TreesIsThisABinarySearchTree {
	private static boolean checkBST(Node root, int max, int min) {
		if (root == null) {
			return true;
		}

		if (root.data <= min || root.data >= max) {
			return false;
		}
		return checkBST(root.left, root.data, min) && checkBST(root.right, max, root.data);
	}

	private static void checkBST(Node root) {
		boolean res = checkBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
		System.out.print(res ? "Yes" : "No");
	}

	public static void main(String [] argv) {
		// FIXME: Read BST in order
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();

		Node root = null;

		while (in.hasNext()) {
			int data = in.nextInt();

			Node p = root, prev = null;
			while (p != null) {
				prev = p;
				if (p.data < data) {
					p = p.right;
				}
				else {
					p = p.left;
				}
			}

			if (root == null) {
				root = new Node(data);
			}
			else if (prev.data < data) {
				prev.right = new Node(data);
			}
			else {
				prev.left = new Node(data);
			}
		}

		checkBST(root);
	}
}
