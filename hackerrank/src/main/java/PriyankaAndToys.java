import java.util.*;

public class PriyankaAndToys {

    static int toys(int[] w) {
        // Complete this function
        Arrays.sort(w);

        int cost = 1;
        int p = w[0];
        for (int i=0; i<w.length; i++) {
            if (w[i] > p+4) {
                p = w[i];
                cost++;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] w = new int[n];
        for(int w_i = 0; w_i < n; w_i++){
            w[w_i] = in.nextInt();
        }
        int result = toys(w);
        System.out.println(result);
        in.close();
    }
}
