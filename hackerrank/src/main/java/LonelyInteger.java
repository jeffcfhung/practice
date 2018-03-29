import java.util.*;
import java.util.stream.IntStream;

public class LonelyInteger {

	static int lonelyinteger(int[] a) {
		// Complete this function
		return IntStream.of(a).reduce(0, (e, f) -> e^f);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] a = new int[n];
		for(int a_i = 0; a_i < n; a_i++){
			a[a_i] = in.nextInt();
		}
		int result = lonelyinteger(a);
		System.out.println(result);
	}
}
