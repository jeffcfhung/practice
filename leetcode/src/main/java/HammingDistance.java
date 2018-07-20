public class HammingDistance {
    static public int hammingDistance(int x, int y) {
        int xor = x ^ y, dist = 0;

        for (int i=0; i<32; i++) {
            dist += (xor>>i) & 1;
        }
        return dist;
    }
}
