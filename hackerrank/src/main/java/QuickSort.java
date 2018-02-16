import java.util.Scanner;

/**
 * Created by jhung on 2/9/18.
 */
public class QuickSort {
    private static void sort(int[] a, int N) {
        sort(a, 0, N-1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j);
        sort(a, j+1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi+1;
        while (true) {
            while (a[++i] < a[lo]) {
                if (i >= hi) break;
            }
            while (a[--j] > a[lo]) {
                if (j <= lo) break;
            }
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int [] a = new int[N];
        int i = 0;
        while (in.hasNext()) {
            a[i++] = in.nextInt();
        }

        sort(a, N);

        System.out.print(a[0]);
        for (int j=1; j<N; j++) {
            System.out.print(" " + a[j]);
        }
    }
}
