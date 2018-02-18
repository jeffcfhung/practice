import java.util.*;

public class Pairs {

    static int pairs(int k, int[] arr) {
        // Complete this function
        Arrays.sort(arr);

        int i, j=0;
        int nPairs = 0;
        for (i=0; i<arr.length; i++) {
            while (j<arr.length-1 && (arr[j] - arr[i]) < k) {
                j++;
            }
            if (arr[j] - arr[i] == k) {
                nPairs++;
            }
        }
        return nPairs;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = pairs(k, arr);
        System.out.println(result);
        in.close();
    }
}


