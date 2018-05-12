import java.util.*;

public class ReallySpecialSubtree {
	static class Edge implements Comparable<Edge> {
		int first, second, weight;
		Edge(int first, int second, int weight) {
			this.first = first;
			this.second = second;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge a) {
			if (this.weight > a.weight) {
				return 1;
			}
			else if (this.weight < a.weight) {
				return -1;
			}
			else {
				int s1 = this.first + this.second + this.weight;
				int s2 = a.first + a.second + a.weight;

				if (s1 > s2) {
					return 1;
				}
				else if (s1 < s2) {
					return -1;
				}
				else {
					return 0;
				}
			}
		}
	}

	static class Graph {
		int V, E;
		PriorityQueue<Edge> edges;

		Graph(int V, int E) {
			this.V = V;
			this.E = E;
			edges = new PriorityQueue<>();
		}

		void addEdge(int first, int second, int weight) {
			edges.add(new Edge(first, second, weight));
		}
	}

	static class UnionFind {
		int[] ids;
		UnionFind(int V) {
			ids = new int[V];
			for (int a0=0; a0<V; a0++) {
				ids[a0] = a0;
			}
		}

		int root(int i) {
			while (i != ids[i]) {
				i = ids[i];
			}
			return i;
		}

		boolean isConnected(int i, int j) {
			return root(i) == root(j);
		}

		void union(int i, int j) {
			int r1 = root(i);
			int r2 = root(j);

			ids[r1] = r2;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int vertexSize = in.nextInt() + 1;
		int edgeSize = in.nextInt();

		Graph graph = new Graph(vertexSize, edgeSize);
		for (int a0=0; a0<edgeSize; a0++) {
			graph.addEdge(in.nextInt(), in.nextInt(), in.nextInt());
		}

		UnionFind uf = new UnionFind(graph.V);

		int sum = 0;
		while (!graph.edges.isEmpty()) {
			Edge edge = graph.edges.poll();
			//System.out.println("a-" + edge.first + " " + edge.second + " " + edge.weight);
			if (! uf.isConnected(edge.first, edge.second)) {
				//System.out.println(edge.first + " " + edge.second + " " + edge.weight);
				sum += edge.weight;
				uf.union(edge.first, edge.second);
			}
		}

		System.out.println(sum);
	}
}
