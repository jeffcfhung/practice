import java.util.*;

public class CountingSort2 {

    static int[] countingSort(int[] arr) {
        int N = arr.length;
        int[] counts = new int[100];

        for (int i : arr) {
            counts[i]++;
        }

        int[] res = new int[N];
        int k = 0;
        for (int i=0; i<100; i++) {
            for (int j=0; j<counts[i]; j++) {
                res[k++] = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int[] result = countingSort(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
