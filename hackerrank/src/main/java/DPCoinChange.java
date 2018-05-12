import java.util.*;

public class DPCoinChange {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int amount = in.nextInt();
		int count = in.nextInt();
		int[] coins = new int[count+1];
		long[][] res = new long[count+1][amount+1];

		for (int i=1; i<=count; i++) {
			coins[i] = in.nextInt();
		}

		// if there no coin, there is only one way
		for (int i=0; i<=count; i++) {
			res[i][0] = 1;
		}

		// if there is no amount, there is no way
		for (int j=1; j<=amount; j++) {
			res[0][j] = 0;
		}

		for (int i=1; i<=count; i++) {
			for (int j=1; j<=amount; j++) {
				if (coins[i] <= j) {
					res[i][j] = res[i-1][j] + res[i][j-coins[i]];
				}
				else {
					res[i][j] = res[i-1][j];
				}
			}
		}
		System.out.println(res[count][amount]);
	}
}
