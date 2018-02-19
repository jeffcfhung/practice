import java.util.*;

public class MaximumSubarraySum {
    static long maximumSum(long[] a, long m) {
        // Complete this function
        long maxSum = 0;

        TreeSet<Long> prefix = new TreeSet<>();
        long currSum = 0;

        for (int i=0; i<a.length; i++) {
            currSum = (currSum + a[i] % m) % m;
            SortedSet<Long> set = prefix.tailSet(currSum + 1);
            Iterator<Long> itr = set.iterator();
            if (itr.hasNext()) {
                maxSum = Math.max(maxSum, (currSum - itr.next() + m) %m);
            }

            maxSum = Math.max(maxSum, currSum);
            prefix.add(maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            long m = in.nextLong();
            long[] a = new long[n];
            for(int a_i = 0; a_i < n; a_i++){
                a[a_i] = in.nextLong();
            }
            long result = maximumSum(a, m);
            System.out.println(result);
        }
        in.close();
    }
}