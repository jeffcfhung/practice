import java.util.*;

public class HeapsFindTheRunningMedian {
	public static int findIndex(List<Integer> list, int value, int lo, int hi) {
		if (lo >= hi) {
			if (list.get(lo) < value) {
				return lo+1;
			}
			else {
				return lo;
			}
		}
		int mid = lo + (hi - lo)/2;
		if (list.get(lo) >= value) {
			return lo;
		}
		else if (list.get(hi) < value) {
			return hi+1;
		}
		else if (list.get(mid) > value) {
			return findIndex(list, value, lo, mid-1);
		}
		else if (list.get(mid) < value) {
			return findIndex(list, value, mid + 1, hi);
		}
		else {
			return mid;
		}
	}
	public static double getMedian(List<Integer> list, int value) {
		if (list.size() == 0) {
			list.add(value);
			return value;
		}
		
		int index = findIndex(list, value, 0, list.size()-1);
		list.add(index, value);
//		for (int i=0; i<list.size(); i++) {
//			System.out.print(list.get(i) + " ");
//		}
//		System.out.println("------");
		if ((list.size() % 2) == 0) {
			int i = list.size() / 2;
			return ((list.get(i-1) + list.get(i))*1.0) / 2.0;
		}
		else {
			return list.get((list.size() - 1)/2) * 1.0;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Integer>list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			System.out.println(getMedian(list, in.nextInt()));
		}
	}
}
