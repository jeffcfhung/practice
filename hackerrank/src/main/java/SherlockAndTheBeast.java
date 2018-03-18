import java.io.*;
import java.util.*;

public class SherlockAndTheBeast {
    public static void sherlockAndTheBeast(int num) {
        int q = ((3-(num%3))%3) * 5;
        //System.out.println(q);
        StringBuffer sb = new StringBuffer();
        if (num - q < 0) {
            System.out.print("-1");
        }
        else {
            for (int i=0; i<num-q; i++) {
                sb.append("5");
            }
            for (int i=0; i<q; i++) {
                sb.append("3");
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int i=0; i<N ;i++) {
            sherlockAndTheBeast(scanner.nextInt());
        }
    }
}
