import java.util.Scanner;

/**
 * Created by jhung on 2/7/18.
 */

public class LSDSort {
    private static final boolean DEBUG = false;
    private static void sort(String [] a, int W)
    {
        int R = 256;
        int N = a.length;
        String [] aux = new String[N];

        for (int d=W-1; d>=0; d--) {
            int [] count = new int[R+1];

            for (int i=0; i<N; i++) {
                // Shift one index to prepare starting point of each type of character
                count[a[i].charAt(d)+1]++;
            }

            for (int r=0; r<R; r++) {
                count[r+1] += count[r];
            }

            for (int i=0; i<N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }

            for (int i=0; i<N; i++) {
                a[i] = aux[i];
            }

            if (DEBUG) {
                printStrings(a);
                System.out.println("-----");
            }
        }
    }

    private static void printStrings(String[] a)
    {
        for (String s : a) {
            System.out.println(s);
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int W = in.nextInt();
        String [] a = new String[N];
        for (int i=0; i<N; i++) {
            a[i] = in.next();
        }
        sort(a, W);

        printStrings(a);
    }
}
