import java.util.*;

public class MinimumAbsoluteDifferenceInAnArray {

    static int minimumAbsoluteDifference(int n, int[] arr) {
        // Complete this function
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i-1];
            if (min > diff) {
                min = diff;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = minimumAbsoluteDifference(n, arr);
        System.out.println(result);
        in.close();
    }
}

