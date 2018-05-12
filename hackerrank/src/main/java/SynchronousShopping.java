import java.util.*;

public class SynchronousShopping {
	private static class ShoppingCenter {
		int fishTypeNum;
		List<Integer> fishTypes;
		ShoppingCenter(int fishTypeNum, List<Integer> fishTypes) {
			this.fishTypeNum = fishTypeNum;
			this.fishTypes = fishTypes;
		}
	}

	private static class Pair<T> {
		T p1, p2;
		Pair(T p1, T p2) {
			this.p1 = p1;
			this.p2 = p2;
		}
	}

	private static class Graph {
		int size;
		List<List<Pair<Integer>>> roadList = new ArrayList<>();
		Graph(int size) {
			this.size = size;
			for (int i=0; i<size; i++) {
				roadList.add(new ArrayList<>());
			}
		}
		void addEdge(int first, int second, int weight) {
			roadList.get(first).add(new Pair(second, weight));
			roadList.get(second).add(new Pair(first, weight));
		}
	}

	private static int calcTime(int totalFishTypes, List<ShoppingCenter> shoppingCenters, Graph graph) {
		
		return 0;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int shoppingCenterNum = in.nextInt();
		int roadNum = in.nextInt();
		int totalFishTypes = in.nextInt();
		List<ShoppingCenter> shoppingCenters = new ArrayList<>();
		for (int a0=0; a0 < shoppingCenterNum; a0++) {
			int fishTypeNum = in.nextInt();
			List<Integer> fishTypes = new ArrayList<>();
			for (int a1=0; a1<fishTypeNum; a1++) {
				fishTypes.add(in.nextInt());
			}
			shoppingCenters.add(new ShoppingCenter(fishTypeNum, fishTypes));
		}
		Graph graph = new Graph(roadNum+1);
		for (int a2=0; a2 < roadNum; a2++) {
			graph.addEdge(in.nextInt(), in.nextInt(), in.nextInt());
		}
		int res = calcTime(totalFishTypes, shoppingCenters, graph);
		System.out.println(res);
	}
}
