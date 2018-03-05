import java.util.*;

public class MaxPriorityQueue {
    static int N = 0;

    static private void maxHeapify(int[] arr, int i) {
        int largest = i;
        int left = 2 * i;
        int right = 2 * i + 1;

        if (left <= N && arr[left] > arr[i]) {
            largest = left;
        }

        if (right <= N && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, largest, i);
            maxHeapify(arr, largest);
        }
    }

    static void buildMaxHeap(int[] arr) {
        for (int i = N/2; i>=1; i--) {
            maxHeapify(arr, i);
        }
    }

    static int extractMax(int[] arr) {
        if (N <= 0) return -1;

        int max = arr[1];
        arr[1] = arr[N];
        N -= 1;
        maxHeapify(arr, 1);
        return max;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCount = scanner.nextInt();
        N = totalCount;

        int[] arr = new int[totalCount+1];

        for (int i = 1; i <= totalCount; i++) {
            arr[i] = scanner.nextInt();
        }

        buildMaxHeap(arr);

        for (int i=1; i<= totalCount; i++) {
            int max = extractMax(arr);
            System.out.println(max);
        }
    }
}
