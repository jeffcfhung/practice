import java.util.*;

public class BitManipulationLonelyInteger {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int res = 0;
		for (int i=0; i<n; i++) {
			res ^= in.nextInt();
		}
		System.out.println(res);
	}
}
