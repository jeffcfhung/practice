import java.util.*;

public class SortingBubbleSort {
	private static void bubbleSort(int[] arr) {
		if (arr.length <= 1) {
			System.out.println(String.format("Array is sorted in 0 swaps."));
			System.out.println(String.format("First Element: %d", arr[0]));
			System.out.println(String.format("Last Element: %d", arr[0]));
			return;
		}
		
		int swapCount = 0;
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr.length-1; j++) {
				if (arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
					swapCount += 1;
				}
			}
		}

		System.out.println(String.format("Array is sorted in %d swaps.", swapCount));
		System.out.println(String.format("First Element: %d", arr[0]));
		System.out.println(String.format("Last Element: %d", arr[arr.length-1]));
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();

		int[] arr = new int[num];
		for (int i=0; i<num; i++) {
			arr[i] = in.nextInt();
		}
		bubbleSort(arr);
	}
}
