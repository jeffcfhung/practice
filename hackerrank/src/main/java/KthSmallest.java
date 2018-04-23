import java.util.*;

public class KthSmallest {
	public static int findKthSmallest(int[] arr, int k, int lo, int hi) {
		shuffle(arr);
		
		int pivot = partition(arr, lo, hi);

		if (pivot < k) {
			return findKthSmallest(arr, k, pivot+1, hi);
		}
		else if (pivot > k) {
			return findKthSmallest(arr, k, lo, pivot-1);
		}
		return arr[pivot];
	}

	private static int partition(int[] arr, int lo, int hi) {
		int i = lo, j = hi+1;

		while (true) {
			while (i < hi && arr[++i] < arr[lo]) {}
			while (j > lo && arr[--j] > arr[lo]) {}
			if (i >= j) {
				break;
			}
			swap(arr, i, j);
		}
		swap(arr, lo, j);
		return j;
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	private static void shuffle(int[] arr) {

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int num = in.nextInt();
		int k = in.nextInt();

		int[] arr = new int[num];

		for (int i=0; i<num; i++) {
			arr[i] = in.nextInt();
		}

		System.out.println(findKthSmallest(arr, k-1, 0, arr.length-1));
	}
}
