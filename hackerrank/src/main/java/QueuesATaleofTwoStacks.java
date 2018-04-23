import java.util.*;

public class QueuesATaleofTwoStacks {
	public static class MyQueue<T> {
		Stack<T> stackNewestOnTop = new Stack<T>();
		Stack<T> stackOldestOnTop = new Stack<T>();

		public void enqueue(T value) { // Push onto newest stack
			if (stackNewestOnTop.isEmpty()) {
				stackNewestOnTop.push(value);
				return;
			}
			stackOldestOnTop.push(value);
		}

		public T peek() {
			return stackNewestOnTop.peek();
		}

		public T dequeue() {
			T item = stackNewestOnTop.pop();
			if (stackNewestOnTop.isEmpty()) {
				while (!stackOldestOnTop.isEmpty()) {
					stackNewestOnTop.push(stackOldestOnTop.pop());
				}
			}
			return item;
		}
	}


	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.enqueue(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.dequeue();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek());
			}
		}
		scan.close();
	}
}
