import java.util.*;

public class KingdomDivision {

	static int kingdomDivision(int n, int[][] roads) {
		// Complete this function
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
