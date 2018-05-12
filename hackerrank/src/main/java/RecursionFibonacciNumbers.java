import java.util.*;

public class RecursionFibonacciNumbers {
	static long[] mem;
	private static long fibonacci(int f) {
		if (f < 2) {
			return f;
		}
		else if (mem[f] != 0) {
			return mem[f];
		}
		mem[f] = fibonacci(f-1) + fibonacci(f-2);
		return mem[f];
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		mem = new long[n+1];
		System.out.println(fibonacci(n));
	}
}
