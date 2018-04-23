import java.util.*;

public class StacksBalancedBrackets {
	static String isBalanced(String input) {
		Stack<Character> stack = new Stack<>();
		for (int i=0; i<input.length(); i++) {
			char ch = input.charAt(i);

			if (ch == '{' || ch == '(' || ch == '[') {
				stack.push(ch);
				continue;
			}
			if (stack.size() == 0) {
				return "NO";
			}
			
			char left = stack.pop();
			if (ch == '}') {
				if (left != '{') {
					return "NO";
				}
			}
			else if (ch == ')') {
				if (left != '(') {
					return "NO";
				}
			}
			else if (ch == ']') {
				if (left != '[') {
					return "NO";
				}
			}
		}
		return stack.size() == 0 ? "YES" : "NO";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		for (int i=0; i<n; i++) {
			System.out.println(isBalanced(in.next()));
		}
	}
}
