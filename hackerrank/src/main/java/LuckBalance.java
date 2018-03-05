import java.util.*;

public class LuckBalance {

    static int luckBalance(int n, int k, int[][] contests) {
        // Complete this function
        Arrays.sort(contests, Comparator.comparing((int[] arr) -> arr[0]).reversed());
        //System.out.println(Arrays.deepToString(contests));

        int maxLuck = 0;
        for (int i = 0; i < n; i++) {
            if (k > 0) {
                if (contests[i][1] == 1) {
                    k--;
                }
                maxLuck += contests[i][0];
                //System.out.println(contests[i][0] + "-" + contests[i][1] + ", k=" + k + ",sum=" + maxLuck);
            }
            else {
                if (contests[i][1] == 1) {
                    maxLuck -= contests[i][0];
                    //System.out.println(contests[i][0] + ":" + contests[i][1] + ", k=" + k + ",sum=" + maxLuck);
                }
                else {
                    maxLuck += contests[i][0];
                    //System.out.println(contests[i][0] + "?" + contests[i][1] + ", k=" + k + ",sum=" + maxLuck);
                }
            }
        }

        return maxLuck;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] contests = new int[n][2];
        for(int contests_i = 0; contests_i < n; contests_i++){
            for(int contests_j = 0; contests_j < 2; contests_j++){
                contests[contests_i][contests_j] = in.nextInt();
            }
        }
        int result = luckBalance(n, k, contests);
        System.out.println(result);
        in.close();
    }
}
