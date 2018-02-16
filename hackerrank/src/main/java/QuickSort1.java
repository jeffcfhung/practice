import java.util.*;

public class QuickSort1 {

    private static int partition(int[] arr, int lo, int hi) {
        ArrayList<Integer> left = new ArrayList<>(), right = new ArrayList<>();
        int pivot = arr[lo];
        for (int i=lo+1; i<=hi; i++) {
            if (arr[i] > arr[lo]) {
                right.add(arr[i]);
            }
            else {
                left.add(arr[i]);
            }
        }

        for (int i=0; i<left.size(); i++) {
            arr[lo+i] = left.get(i);
        }

        int j = lo+left.size();
        arr[j] = pivot;

        for (int i=0; i<right.size(); i++) {
            arr[j+i+1] = right.get(i);
        }

        return j;
    }

    private static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;

        int j = partition(arr, lo, hi);
        //sort(arr, lo, j);
        //sort(arr, j+1, hi);
    }

    private static int[] quickSort(int[] arr) {
        sort(arr, 0, arr.length-1);
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int[] result = quickSort(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
