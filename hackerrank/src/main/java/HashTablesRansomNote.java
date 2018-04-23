import java.util.*;

public class HashTablesRansomNote {

	public static void main(String[] argv) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String mw = in.next();
			if (map.containsKey(mw)) {
				map.put(mw, map.get(mw) + 1);
			}
			else {
				map.put(mw, 1);
			}
		}

		for (int j = 0; j < M; j++) {
			String w = in.next();
			if (map.containsKey(w)) {
				Integer v = map.get(w) - 1;
				if (v == 0) {
					map.remove(w);
				}
				else {
					map.put(w, v);
				}
			}
			else {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
		return;
	}
}
