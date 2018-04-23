import java.util.*;

public class MergeSortCountingInversions {

	private static long merge(int[] arr, int[] aux, int lo, int mid, int hi) {
		int i = lo;
		int j = mid+1;
		int k = lo;

		long count = 0;
		while (i <= mid && j <= hi) {
			if (aux[i] <= aux[j]) {
				arr[k++] = aux[i++];
			}
			else if (aux[i] > aux[j]) {
				arr[k++] = aux[j++];
				count += mid + 1 - i;
			}
		}

		while (i <= mid) {
			arr[k++] = aux[i++];
		}

		while (j <= hi) {
			arr[k++] = aux[j++];
		}
		return count;
	}

	private static long sort(int[] arr, int[] aux, int lo, int hi) {
		if (lo >= hi) return 0;

		long count = 0;
		int mid = lo + (hi-lo)/2;
		count += sort(aux, arr, lo, mid);
		count += sort(aux, arr, mid+1, hi);
		count += merge(arr, aux, lo, mid, hi);
		return count;
	}

	private static void countInversions(int[] arr) {
		int[] aux = arr.clone();

		long count = sort(arr, aux, 0, arr.length-1);
		System.out.println(count);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int size = in.nextInt();
		for (int i=0; i<size; i++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int j=0; j<n; j++) {
				arr[j] = in.nextInt();
			}
			countInversions(arr);
		}
	}
}
