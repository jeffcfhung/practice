import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Trial {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        int i = 0;
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        int endIndex = n-1;
        for (i=0; i < n/2; i++) {
            swap(a, i, endIndex-i);
        }
        
        for (i=0; i < (n+1-k)/2; i++) {
            swap(a, i, endIndex-k-i);
        }
        
        int j=0;
        for (i=n-k; i < (2*n-k)/2; i++) {
            swap(a, i, endIndex-j);
            j++;
        }

        StringBuffer buf = new StringBuffer();
        buf.append(a[0]);
        for (i=1; i < n; i++) {
            buf.append(" ");
            buf.append(a[i]);
        }
        System.out.println(buf.toString());
    }
    
    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
