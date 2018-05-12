import java.util.*;

public class RoadsAndLibraries {
	public static long calcCost(int cityCount, int[][] roads, int libCost, int roadCost) {
		boolean[] visited = new boolean[cityCount+1];
		List<List<Integer>> adjLists = new ArrayList<>();

		for (int c=0; c<=cityCount; c++) {
			adjLists.add(new ArrayList<>());
		}


		for (int[] road : roads) {
			adjLists.get(road[0]).add(road[1]);
			adjLists.get(road[1]).add(road[0]);
		}

		long connectedCount = 0;

		for (int c=1; c<=cityCount; c++) {
			if (visited[c]) continue;
			dfs(c, visited, adjLists);
			connectedCount++;
		}

		long totalCost = (long)roadCost * ((long)cityCount - connectedCount) + (long)libCost * connectedCount;
		return totalCost;
	}

	public static void dfs(int city, boolean[] visited, List<List<Integer>> adjLists) {
		visited[city] = true;
		
		for (int adj : adjLists.get(city)) {
			if (visited[adj]) continue;
			dfs(adj, visited, adjLists);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int q = in.nextInt();
		while (q-- > 0) {
			int cityCount = in.nextInt();
			int roadCount = in.nextInt();
			int libCost = in.nextInt();
			int roadCost = in.nextInt();
			int[][] roads = new int[roadCount][2];
			for (int road_i=0; road_i < roadCount; road_i++) {
				for (int road_j=0; road_j < 2; road_j++) {
					roads[road_i][road_j] = in.nextInt();
				}
			}

			long totalCost;
			if (libCost <= roadCost || roadCount == 0) {
				totalCost = (long)libCost * (long)cityCount;
			}
			else {
				totalCost = calcCost(cityCount, roads, libCost, roadCost);
			}
			System.out.println(totalCost);
		}
		in.close();
	}
}