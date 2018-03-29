import java.util.*;

public class ConstructTheArray {

	static long countArray(int n, int k, int x) {
		// Return the number of ways to fill in the array.
		long [] dp = new long[2];
		long [] dpNext = new long[2];

		long MOD = (long)1000000007;
		dp[0] = 1;
		dp[1] = 0;
		for (int i=1; i<n; i++) {
			dpNext[0] = (dp[1] * (k-1)) % MOD;
			dpNext[1] = (dp[0] + dp[1] * (k-2)) % MOD;
			dp[0] = dpNext[0];
			dp[1] = dpNext[1];
		}
		return x==1 ? dp[0] : dp[1];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int x = in.nextInt();
		long answer = countArray(n, k, x);
		System.out.println(answer);
		in.close();
	}
}