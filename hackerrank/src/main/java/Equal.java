import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class Equal {

	static int equal(int[] arr) {
		// Complete this function
		Arrays.sort(arr);

		int sum = Integer.MAX_VALUE;
		for (int base=0; base<3; base++) {
			int current_sum = 0;
			for (int i=0; i<arr.length; i++) {
				int delta = arr[i] - arr[0] + base;
				current_sum += (int)delta/5 + (delta%5)/2 + (delta % 5) % 2;
			}
			sum = Math.min(sum, current_sum);
		}
		return sum;
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
			int result = equal(arr);
			System.out.println(result);
		}
		in.close();
	}
}
