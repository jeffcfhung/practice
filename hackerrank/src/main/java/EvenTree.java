import java.util.*;

public class EvenTree {

	static class Graph {
		int size;
		List<List<Integer>> adjList;

		Graph(int size) {
			this.size = size;
			adjList = new ArrayList<>();

			for (int i=0; i<size; i++) {
				adjList.add(new ArrayList<>());
			}
		}

		void addEdge(int first, int second) {
			adjList.get(first).add(second);
			adjList.get(second).add(first);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int vertexSize = in.nextInt();
		int edgeSize = in.nextInt();

		Graph graph = new Graph(vertexSize + 1);
		for (int i=0; i<edgeSize; i++) {
			graph.addEdge(in.nextInt(), in.nextInt());
		}

		System.out.println(0);
	}
}
