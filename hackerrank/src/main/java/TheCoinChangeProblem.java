import java.util.*;

public class TheCoinChangeProblem {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int amount = in.nextInt();
		int num = in.nextInt();
		long[] coins = new long[num];
		long[][] res = new long[num+1][amount+1];

		for(int c_i=0; c_i < num; c_i++){
			coins[c_i] = in.nextLong();
		}

		// amount is 0 so only one way
		for (int i=0; i<=num; i++) {
			res[i][0] = 1;
		}

		// no coin is given, there is no way
		for (int j=1; j<=amount; j++) {
			res[0][j] = 0;
		}

//		for (int i=0; i<=num; i++) {
//			for (int j=0; j<=amount; j++) {
//				System.out.print(res[i][j] + " ");
//			}
//			System.out.println("");
//		}

		for (int i=1; i<=num; i++) {
			for (int j=1; j<=amount; j++) {
				if (coins[i-1] <= j) {
//					System.out.println("a:" + i + "," + j + ":" + coins[i-1] + " " + res[i][j]);
					res[i][j] = res[i-1][j] + res[i][j-(int)coins[i-1]];
//					System.out.println("b:" + i + "," + j + ":" + coins[i-1] + " " + res[i][j]);
				} else {
					res[i][j] = res[i-1][j];
//					System.out.println("c:" + i + "," + j + ":" + coins[i-1] + " " + res[i][j]);
				}
			}
		}


		for (int i=0; i<=num; i++) {
			for (int j=0; j<=amount; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println("");
		}
		


		// Print the number of ways of making change for 'n' units using coins having the values given by 'c'
		System.out.println(res[num][amount]);
	}
}
