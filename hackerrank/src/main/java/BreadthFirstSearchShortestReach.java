import java.util.*;

public class BreadthFirstSearchShortestReach {
	static class Graph {
		List<List<Integer>> adjLists = new ArrayList<>();
		int size;

		Graph(int size) {
			this.size = size;
			while (size-- > 0) {
				adjLists.add(new ArrayList<>());
			}
		}

		private void addEdge(int first, int second) {
			this.adjLists.get(first).add(second);
			this.adjLists.get(second).add(first);
		}

		private int[] findShortPaths(int start) {
			int [] distance = new int[size];
			Arrays.fill(distance, -1);
			distance[start] = 0;

			boolean [] visited = new boolean[size];
			visited[start] = true;
			
			Queue<Integer> q = new LinkedList<>();
			q.offer(start);
			while (!q.isEmpty()) {
				int curr = q.poll();
				for (int adj : adjLists.get(curr)) {
					if (visited[adj]) continue;

					visited[adj] = true;
					q.offer(adj);
					distance[adj] = distance[curr] + 6;
				}
			}
			return distance;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int queryNum = in.nextInt();
		while (queryNum -- > 0) {
			int vertexSize = in.nextInt() + 1;
			Graph graph = new Graph(vertexSize);
			int edgeSize = in.nextInt();
			for (int i=0; i<edgeSize; i++) {
				graph.addEdge(in.nextInt(), in.nextInt());
			}
			int start = in.nextInt();
			int[] shortPaths = graph.findShortPaths(start);
			StringBuffer sb = new StringBuffer();
			for (int a1=1; a1<shortPaths.length; a1++) {
				if (a1 == start) continue;
				sb.append(shortPaths[a1]);
				sb.append(" ");
			}
			sb.deleteCharAt(sb.length()-1);
			System.out.println(sb.toString());
		}
	}
}
