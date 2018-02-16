import java.util.*;

public class InsertionSort1 {

    static void printArr(int n, int[] arr) {
        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    static void insertionSort1(int n, int[] arr) {
        // Complete this function
        int right = arr[n-1];
        int i;
        for (i=n-1; i>0; i--) {
            if (right < arr[i-1]) {
                copy(arr, i-1, i);
                printArr(n, arr);
            }
            else {
                break;
            }
        }
        arr[i] = right;
        printArr(n, arr);
    }

    static void copy(int[] arr, int i, int j) {
        arr[j] = arr[i];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        insertionSort1(n, arr);
        in.close();
    }
}


