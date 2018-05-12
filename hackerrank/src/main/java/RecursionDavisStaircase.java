import java.util.*;

public class RecursionDavisStaircase {
	public static int calcCount(int n) {
		if (n < 1) return 0;
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (n == 3) return 4;

		int [] ways = new int[] {1, 2, 4};
		for (int i=4; i<n; i++) {
			int idx = (i - 1) % 3;
			ways[idx] = ways[0] + ways[1] + ways[2];
		}
		return ways[0] + ways[1] + ways[2];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		for (int i=0; i<n; i++) {
			System.out.println(calcCount(in.nextInt()));
		}
		
	}
}
