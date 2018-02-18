import java.util.*;

public class MissingNumbers {

    static int[] missingNumbers(int[] arr, int[] brr) {
        // Complete this function

        List<Integer> missing = new ArrayList<>();

        Arrays.sort(arr);
        Arrays.sort(brr);

        for (int i=0, j=0; i<brr.length; i++) {
            if (j < arr.length) {
                if (brr[i] == arr[j]) {
                    j++;
                }
                else if ((missing.size() == 0) ||
                        (missing.size() > 0 && brr[i] != missing.get(missing.size()-1))) {
                     // Only add same number once
                    missing.add(brr[i]);
                }
            }
            else {
                missing.add(brr[i]);
            }
        }
        int[] res = new int[missing.size()];
        for (int i=0; i<res.length; i++) {
            res[i] = missing.get(i);
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
        int m = in.nextInt();
        int[] brr = new int[m];
        for(int brr_i = 0; brr_i < m; brr_i++){
            brr[brr_i] = in.nextInt();
        }
        int[] result = missingNumbers(arr, brr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
