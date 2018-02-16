import java.util.*;

public class FindTheMedian {
    static int partition(int[] arr, int lo, int hi) {
        int i = lo;
        int j = hi+1;
        while (true) {
            while (arr[++i] < arr[lo]) {
                if (i >= hi) break;
            }
            while (arr[--j] > arr[lo]) {
                if (j <= lo) break;
            }
            if (i >= j) break;

            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static int quickSelect(int[] arr, int lo, int hi, int mid) {
        if (lo >= hi) return arr[lo];

        int pivot = partition(arr, lo, hi);
        if (pivot == mid) {
            return arr[mid];
        }
        else if (pivot > mid) {
            return quickSelect(arr, lo, pivot-1, mid);
        }
        else if (pivot < mid) {
            return quickSelect(arr, pivot+1, hi, mid);
        }
        // Shall not be here
        return -1;
    }

    static int findMedian(int[] arr) {
        // Complete this function
        return quickSelect(arr, 0, arr.length-1, arr.length/2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = findMedian(arr);
        System.out.println(result);
        in.close();
    }
}


