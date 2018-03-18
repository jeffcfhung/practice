import java.util.*;

public class BeautifulPairs {

    static int beautifulPairs(int[] A, int[] B) {
        // Complete this function
        int[] counts = new int[1001];

        for (int i=0; i < A.length; i++) {
            counts[A[i]]++;
        }

        int beautifulPairsCount = 0;
        for (int j=0; j < B.length; j++) {
            if (counts[B[j]] > 0) {
                beautifulPairsCount++;
                counts[B[j]]--;
            }
        }

        if (beautifulPairsCount == B.length) {
            beautifulPairsCount--;
        }
        else {
            beautifulPairsCount++;
        }

        return beautifulPairsCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int[] B = new int[n];
        for(int B_i = 0; B_i < n; B_i++){
            B[B_i] = in.nextInt();
        }
        int result = beautifulPairs(A, B);
        System.out.println(result);
        in.close();
    }
}
