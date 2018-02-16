import java.util.*;

public class InsertionSort2 {

    static void insertionSort2(int n, int[] arr) {
        // Complete this function
        for (int i=1; i<n; i++) {
            for (int j=i; j>0; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                }
                else {
                    break;
                }
            }
            printArr(n, arr);
        }
    }

    static void printArr(int n, int[] arr) {
        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    static void swap(int[] arr, int i, int j) {
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
        insertionSort2(n, arr);
        in.close();
    }
}

