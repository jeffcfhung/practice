import java.util.*;

public class BFSShortestReachInAGraph {
	public static class Graph {
		List<List<Integer>> adjList;
		int size;

		public Graph(int size) {
			adjList = new ArrayList<>();
			this.size = size;
			while (size-- > 0) {
				adjList.add(new ArrayList<>());
			}
		}

		public void addEdge(int first, int second) {
			adjList.get(first).add(second);
			adjList.get(second).add(first);
		}

		public int[] shortestPath(int startIdx) {
			int[] distances = new int[this.size];
			Arrays.fill(distances, -1);

			Queue<Integer> queue = new LinkedList<>();
			distances[startIdx] = 0;
			queue.offer(startIdx);

			boolean[] visited = new boolean[this.size];
			visited[startIdx] = true;

			while (!queue.isEmpty()) {
				int curr = queue.poll();

				for (int adj : this.adjList.get(curr)) {
					if (visited[adj]) continue;

					visited[adj] = true;
					queue.offer(adj);
					distances[adj] = distances[curr] + 6;
				}
			}
			return distances;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int num = in.nextInt();
		for (int i = 0; i < num; i++) {
			int size = in.nextInt()+1;
			Graph graph = new Graph(size);
			int edgeSize = in.nextInt();
			for (int j = 0; j < edgeSize; j++) {
				graph.addEdge(in.nextInt(), in.nextInt());
			}
			int startIdx = in.nextInt();
			int[] sp = graph.shortestPath(startIdx);
			StringBuffer sb = new StringBuffer();
			for (int k = 1; k < sp.length; k++) {
				if (k == startIdx) continue;
				
				sb.append(sp[k]);
				sb.append(" ");
			}
			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb.toString());
		}
	}
}
