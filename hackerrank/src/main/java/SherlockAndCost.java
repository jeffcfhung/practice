import java.util.*;

public class SherlockAndCost {

	static int cost(int[] arr) {
		// Complete this function

		int hi = 0, low = 0;
		for (int i = 1; i < arr.length; i++) {
			int highToLowDiff = Math.abs(arr[i-1] - 1);
			int lowToHighDiff = Math.abs(arr[i] - 1);
			int highToHighDiff = Math.abs(arr[i] - arr[i-1]);

			int lowNext = Math.max(low, hi + highToLowDiff);
			int hiNext = Math.max(hi + highToHighDiff, low + lowToHighDiff);

			low = lowNext;
			hi = hiNext;
		}
		return Math.max(hi, low);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			int[] arr = new int[n];
			for(int arr_i = 0; arr_i < n; arr_i++){
				arr[arr_i] = in.nextInt();
			}
			int result = cost(arr);
			System.out.println(result);
		}
		in.close();
	}
}
