import java.util.*;

public class MarkAndToys {

	static int maximumToys(int[] prices, int k, PriorityQueue<Integer> pq) {
		// Complete this function

		int count = 0;
		int spent = 0;
		int p = pq.poll();
		while (spent + p < k) {
			spent += p;
			count += 1;
			p = pq.poll();
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] prices = new int[n];
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int prices_i = 0; prices_i < n; prices_i++){
			prices[prices_i] = in.nextInt();
			pq.add(prices[prices_i]);
		}
		int result = maximumToys(prices, k, pq);
		System.out.println(result);
		in.close();
	}
}
