import java.util.*;

public class LargestPermutation {

	static int[] largestPermutation(int k, int[] arr, Map<Integer, Integer> hm) {
		// Complete this function

		int N = arr.length;
		int i = 0, count = 0;
		while (i < N && count < k) {
			int hold = hm.get(N - i);
			if (i != hold) {
				hm.put(N - i, i);
				hm.put(arr[i], hold);

				int tmp = arr[i];
				arr[i] = arr[hold];
				arr[hold] = tmp;
				count += 1;
			}
			i += 1;
		}

		return arr;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		Map<Integer, Integer> hm = new HashMap<>();

		for(int arr_i = 0; arr_i < n; arr_i++){
			arr[arr_i] = in.nextInt();
			hm.put(arr[arr_i], arr_i);
		}
		int[] result = largestPermutation(k, arr, hm);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
		}
		System.out.println("");


		in.close();
	}
}
