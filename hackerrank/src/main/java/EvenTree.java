import java.util.*;

public class EvenTree {
	static class Node {
		Node parent;
		int descendantCount = 0;

		void setParent(Node parent) {
			this.parent = parent;
			Node ancestor = parent;
			while (ancestor != null) {
				ancestor.descendantCount++;
				ancestor = ancestor.parent;
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int vertexSize = in.nextInt()+1;
		int edgeSize = in.nextInt();

		Node[] nodes = new Node[vertexSize];
		for (int i=0; i<vertexSize; i++) {
			nodes[i] = new Node();
		}

		for (int i=0; i<edgeSize; i++) {
		    nodes[in.nextInt()].setParent(nodes[in.nextInt()]);
		}

		int res = 0;
		// Skip empty(0) and root(1)
		for (int i=2; i<vertexSize; i++) {
			if (nodes[i].descendantCount%2 == 1) {
				res++;
			}
		}

		System.out.println(res);
	}
}
