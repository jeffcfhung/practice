import java.util.*;

public class CounterGame {

	static String counterGame(long n) {
		// Complete this function

		int count = 0;
		while (n > 1) {
			if ((n & (n - 1)) == 0) { // power of 2
				n = n / 2;
			} else {
				int mostSignificantBit = 63 - Long.numberOfLeadingZeros(n);
				n = n - (mostSignificantBit << 1);
			}
			count++;
		}

		return (count % 2) == 0 ? "Richard" : "Louise";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			long n = in.nextLong();
			String result = counterGame(n);
			System.out.println(result);
		}
		in.close();
	}
}
