import java.util.*;

public class KingdomDivision {

	static class Graph {
		List<List<Integer>> adjList;
		int size;
		long[][][] dp;
		long[] parent;

		Graph(int size) {
			this.size = size;
			dp = new long[size][2][3];
			initDp();

			parent = new long[size];

			adjList = new ArrayList<>();

			for (int i=0; i<size; i++) {
				adjList.add(new ArrayList<>());
			}
		}

		void addRoad(int first, int second) {
			this.adjList.get(first).add(second);
			this.adjList.get(second).add(first);
		}

		int calcDivision() {
			//long modValue = Math.pow(10, 9) + 7;




			return 0;
		}

		private void dfs() {

		}

		private void initDp() {
			for (int i=0; i<size; i++) {
				for (int j=0; j<3; j++) {
					dp[i][0][j] = dp[i][1][j] = -1;
				}
			}
		}
	}

	static int kingdomDivision(int n, int[][] roads) {
		// Complete this function
		Graph graph = new Graph(n+1);
		for (int[] road : roads) {
			graph.addRoad(road[0], road[1]);
		}

		return graph.calcDivision();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] roads = new int[n-1][2];
		for(int roads_i = 0; roads_i < n-1; roads_i++){
			for(int roads_j = 0; roads_j < 2; roads_j++){
				roads[roads_i][roads_j] = in.nextInt();
			}
		}
		int result = kingdomDivision(n, roads);
		System.out.println(result);
		in.close();
	}
}
