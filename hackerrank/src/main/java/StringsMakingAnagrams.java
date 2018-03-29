import java.util.*;
		
public class StringsMakingAnagrams {
	private static int numberNeeded(String a, String b) {
		int [] freq = new int[26];

		for (char i : a.toCharArray()) {
			freq[i - 'a']++;
		}
		for (char j : b.toCharArray()) {
			freq[j - 'a']--;
		}
		int count = 0;
		for (int ii=0 ; ii < 26; ii++) {
			count += Math.abs(freq[ii]);
		}

		return count;
	}

	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.next();
		String b = scanner.next();
		System.out.println(numberNeeded(a, b));
	}
}
