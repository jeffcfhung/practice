public class BitwiseANDofNumbersRange {
    public static int rangeBitwiseAnd(int m, int n) {
        int res = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            res <<= 1;
        }
        return m*res;
    }
}
