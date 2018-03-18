import java.util.*;

public class MaximumPerimeterTriangle {

    static int[] maximumPerimeterTriangle(int[] l) {
        // Complete this function
        int[] result = new int[1];
        result[0] = -1;

        if (l.length <= 2) {
            return result;
        }

        Arrays.sort(l);

        for (int i=l.length-1; i>=2; i--) {
            if (l[i-2] + l[i-1] > l[i]) {
                result = new int[3];
                result[0] = l[i-2];
                result[1] = l[i-1];
                result[2] = l[i];
                return result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] l = new int[n];
        for(int l_i = 0; l_i < n; l_i++){
            l[l_i] = in.nextInt();
        }
        int[] result = maximumPerimeterTriangle(l);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}


