import java.util.*;

public class HackerlandRadioTransmitters {

    static int hackerlandRadioTransmitters(int[] x, int k) {
        // Complete this function
        Arrays.sort(x);

        int n = x.length;
        int i = 0, hrtNum = 0;

        while (i < n) {
            hrtNum++;
            int loc = x[i] + k;
            while (i < n && x[i] <= loc) i++;
            loc = x[--i] + k;
            while (i < n && x[i] <= loc) i++;
        }

        return hrtNum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i = 0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        int result = hackerlandRadioTransmitters(x, k);
        System.out.println(result);
        in.close();
    }
}


