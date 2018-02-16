import java.util.*;
import java.math.*;

public class ClosestNumbers {

    static int[] closestNumbers(int[] arr) {
        // Complete this function
        ArrayList<Integer> res = new ArrayList<>();

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for (int i=1; i<arr.length; i++) {
            int diff = Math.abs(arr[i] - arr[i-1]);
            if (min > diff) {
                min = diff;
                res.clear();

                res.add(arr[i-1]);
                res.add(arr[i]);
            }
            else if (min == diff) {
                res.add(arr[i-1]);
                res.add(arr[i]);
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int[] result = closestNumbers(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
