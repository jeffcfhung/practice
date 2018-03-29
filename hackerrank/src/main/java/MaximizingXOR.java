import java.util.*;

public class MaximizingXOR {

	static int maximizingXor(int l, int r) {
		// Complete this function
		int xor = l ^ r;
		int significantBit;
		for (significantBit=0; significantBit<32; significantBit++) {
			if ((xor >> significantBit) == 0) break;
		}
		int res = (1 << (significantBit)) - 1;
		return res;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int l = in.nextInt();
		int r = in.nextInt();
		int result = maximizingXor(l, r);
		System.out.println(result);
		in.close();
	}
}
