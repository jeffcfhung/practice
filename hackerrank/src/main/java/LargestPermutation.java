import java.util.*;

public class LargestPermutation {

    static int[] largestPermutation(int k, int[] arr) {
        // Complete this function
        for (int j=0; j<k; j++) {
            int max = arr[j];
            int maxIndex = j;
            for (int i = j; i < arr.length; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                    maxIndex = i;
                }
            }
            arr[maxIndex] = arr[j];
            arr[j] = max;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int[] result = largestPermutation(k, arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
