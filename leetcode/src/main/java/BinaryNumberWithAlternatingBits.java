public class BinaryNumberWithAlternatingBits {
    public static boolean hasAlternatingBits(int n) {
        int curr = (n >> 0) & 1;
        for (int i=1; i<32; i++) {
            if (n < 1 << i) break;

            int next = (n >> i) & 1;
            if (curr == next) {
                return false;
            }
            curr = next;
        }

        return true;
    }
}
