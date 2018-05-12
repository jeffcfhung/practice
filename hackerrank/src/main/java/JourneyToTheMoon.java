import java.util.*;

public class JourneyToTheMoon {
	private static long calcPairCount(int astronautCount, int[][] astronauts) {
		List<List<Integer>> adjLists = new ArrayList<>();
		for (int i=0; i<astronautCount; i++) {
			adjLists.add(new ArrayList<>());
		}
		boolean[] visited = new boolean[astronautCount];

		for (int[] astronaut : astronauts) {
			adjLists.get(astronaut[0]).add(astronaut[1]);
			adjLists.get(astronaut[1]).add(astronaut[0]);
		}

		long res = 0, sum = 0;
		for (int i=0; i<astronautCount; i++) {
			if (visited[i]) continue;
			long count = calcAstronautInSameCountry(i, visited, adjLists);
			res = res + sum*count;
			sum += count;
		}
		return res;
	}

	private static long calcAstronautInSameCountry(int astronaut, boolean[] visited, List<List<Integer>>adjLists) {
		visited[astronaut] = true;
		long count = 1;
		for (int adj : adjLists.get(astronaut)) {
			if (visited[adj]) continue;
			count += calcAstronautInSameCountry(adj, visited, adjLists);
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int astronautCount = in.nextInt();
		int m = in.nextInt();

		int[][] astronauts = new int[m][2];

		for (int i=0; i<m; i++) {
			astronauts[i][0] = in.nextInt();
			astronauts[i][1] = in.nextInt();
		}
	 	long res = calcPairCount(astronautCount, astronauts);
		System.out.println(res);
	}
}
