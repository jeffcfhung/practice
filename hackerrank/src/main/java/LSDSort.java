import java.util.Scanner;

/**
 * Created by jhung on 2/7/18.
 */
public class LSDSort {
    public static void sort(String [] a, int W) {
        int R = 256;
        int N = a.length;
        String [] aux = new String[N];

        for (int d=W-1; d>=0; d--) {
            int [] count = new int[R+1];

            for (int i=0; i<N; i++) {
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

        for (int i=0; i<a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
