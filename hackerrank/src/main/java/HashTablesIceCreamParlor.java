import java.util.*;

public class HashTablesIceCreamParlor {
	static void solve(int[] arr, int money) {
		// complete this function
		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0; i<arr.length; i++) {
			int another = money - arr[i];
			if (map.containsKey(another)) {
				System.out.println((map.get(another)+1) + " " + (i+1));
			}
			else {
				map.put(arr[i], i);
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int money = in.nextInt();
			int n = in.nextInt();
			int[] arr = new int[n];
			for(int arr_i = 0; arr_i < n; arr_i++){
				arr[arr_i] = in.nextInt();
			}
			solve(arr, money);
		}
		in.close();
	}
}
