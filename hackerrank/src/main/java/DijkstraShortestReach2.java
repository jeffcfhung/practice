import java.io.*;
import java.util.InputMismatchException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DijkstraShortestReach2 {

	public static class Edge implements Comparable<Edge> {
		int second;
		int weight;
		Edge(int second, int weight) {
			this.second = second;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge b) {
			if (this.weight > b.weight) {
				return 1;
			}
			else if (this.weight < b.weight) {
				return -1;
			}
			else {
				return 0;
			}
		}
	}

	public static class Graph {
		int size;
		List<PriorityQueue<Edge>> adjList;

		Graph(int size) {
			this.size = size;
			adjList = new ArrayList<>();
			for (int a0=0; a0<size; a0++) {
				adjList.add(new PriorityQueue<>());
			}
		}

		void addEdge(int first, int second, int weight) {
			adjList.get(first).add(new Edge(second, weight));
			adjList.get(second).add(new Edge(first, weight));
		}
	}

	public static int[] shortestReach (Graph graph, int start) {
		int[] distTo = new int[graph.size];
		Arrays.fill(distTo, -1);
		distTo[start] = 0;

		Stack<Integer> stack = new Stack<>();
		stack.push(start);

		boolean[] visited = new boolean[graph.size];

		while (!stack.isEmpty()) {
			int curr = stack.pop();
			visited[curr] = true;

			for (Edge edge : graph.adjList.get(curr)) {
				int newWeight = distTo[curr] + edge.weight;
				if (distTo[edge.second] == -1 || distTo[edge.second] >= newWeight) {
					distTo[edge.second] = newWeight;
					stack.push(edge.second);
				}
				else if (visited[edge.second] == false) {
					stack.push(edge.second);
				}
			}
		}

		return distTo;
	}

	private static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1) {
				throw new InputMismatchException();
			}
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}

		public int readInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public String readString() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public double readDouble() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E') {
					return res * Math.pow(10, readInt());
				}
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E') {
						return res * Math.pow(10, readInt());
					}
					if (c < '0' || c > '9') {
						throw new InputMismatchException();
					}
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}

		public long readLong() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public boolean isSpaceChar(int c) {
			if (filter != null) {
				return filter.isSpaceChar(c);
			}
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public String next() {
			return readString();
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}

	public static void main(String[] args) throws Exception {
		InputReader in = new InputReader(System.in);
		int testSize = in.readInt();

		for (int a0=0; a0<testSize; a0++) {
			int vertexSize = in.readInt();
			int edgeSize = in.readInt();

			int[][] edges = new int[edgeSize][3];

			Graph graph = new Graph(vertexSize + 1);
			Set<String> set = new HashSet<>();
			StringBuffer sb = new StringBuffer();

			for (int a1=0; a1 < edgeSize; a1++) {
				sb.setLength(0);
				for (int a2=0; a2<3; a2++) {
					edges[a1][a2] = in.readInt();

					sb.append(edges[a1][a2]);
					sb.append("-");
				}
				String target = sb.toString();
				if (set.contains(target)) continue;
				set.add(target);
				sb.setLength(0);

				sb.append(edges[a1][1]);
				sb.append("-");
				sb.append(edges[a1][0]);
				sb.append("-");
				sb.append(edges[a1][2]);
				sb.append("-");
				target = sb.toString();
				if (set.contains(target)) continue;
				set.add(target);

				graph.addEdge(edges[a1][0], edges[a1][1], edges[a1][2]);
			}

			int start = in.readInt();

			int [] res = shortestReach(graph, start);
			sb.setLength(0);
			
			for (int a2=1; a2 < res.length; a2++) {
				if (a2 == start) continue;
				
				sb.append(res[a2]);
				sb.append(" ");
			}
			sb.deleteCharAt(sb.length()-1);
			System.out.println(sb.toString());
		}
	}
}
