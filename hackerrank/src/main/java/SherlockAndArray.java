import java.util.*;

public class SherlockAndArray {

    static String solve(int[] a){
        // Complete this function
        int i=0, j=a.length-1;
        int sum = 0;
        while (i < j) {
            if (sum <= 0) {
                sum += a[i++];
            }
            else {
                sum -= a[j--];
            }
        }

        return sum == 0 ? "YES": "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = solve(a);
            System.out.println(result);
        }
    }
}

