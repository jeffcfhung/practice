import java.util.*;

public class DFSConnectedCellInAGrid {
	private static int dfs(int [][] grid, int i, int j, int n, int m) {
		if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == -1 || grid[i][j] == 0) {
			return 0;
		}
		grid[i][j] = -1;

		int count = dfs(grid, i-1, j-1, n, m) +
				dfs(grid, i-1, j, n, m) +
				dfs(grid, i-1, j+1, n, m) +
				dfs(grid, i, j-1, n, m) +
				dfs(grid, i, j+1, n, m) +
				dfs(grid, i+1, j-1, n, m) +
				dfs(grid, i+1, j, n, m) +
				dfs(grid, i+1, j+1, n, m);

		return count + 1;
	}

	private static void findLargestRegion(int[][] grid, int n, int m) {
		int max = Integer.MIN_VALUE;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				int res = dfs(grid, i, j, n, m);
				max = Math.max(max, res);
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		int [][] grid = new int[n][m];
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				grid[i][j] = in.nextInt();
			}
		}
		findLargestRegion(grid, n, m);
	}
}
