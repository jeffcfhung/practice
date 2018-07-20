public class ArrangingCoins {
    public static int arrangeCoins(long n) {
//        return (int)((-1 + Math.sqrt(1 + 8 * (long)n))/2);
        long hi = n, lo = 0, mid;
        while (lo <= hi) {
           mid = lo + (hi-lo)/2;

           double val = 0.5*mid*mid + 0.5*mid;
           if (val <= n) {
               lo = mid + 1;
           }
           else {
               hi = mid - 1;
           }
        }
        return (int)(lo - 1);
    }
}
