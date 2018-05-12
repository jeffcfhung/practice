import java.util.*;

public class TimeComplexityPrimality {
	private static boolean isPrime(long p) {
		if (p < 2) {
			return false;
		}
		else if (p <= 3) {
			return true;
		}
		else if ((p % 2) == 0|| (p % 3) == 0) {
			return false;
		}
		else {
			for (int i=3; i<=Math.sqrt(p); i=i+2) {
				if ((p % i) == 0) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		for (int i=0; i<n; i++) {
			System.out.println(isPrime(in.nextLong()) ? "Prime" : "Not prime");
		}
	}
}
