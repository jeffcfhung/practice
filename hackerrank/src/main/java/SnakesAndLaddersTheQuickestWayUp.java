import java.util.*;

public class SnakesAndLaddersTheQuickestWayUp {

    static class Graph {
        List<List<Integer>> adjList;
        int size;

        Graph(int size) {
            this.size = size;
            adjList = new ArrayList<>();
            for (int i=0; i<size; i++) {
                ArrayList<Integer> adj = new ArrayList<>();
                adj.add(0);
                adjList.add(adj);
            }
        }

        void addEdge(int first, int second) {
            adjList.get(first).add(1, second);
        }

        void replaceEdge(int first, int second, int newSecond) {
            List<Integer> adj = adjList.get(first);
            for (int i=1; i<adj.size(); i++) {
                if (adj.get(i) == second) {
                    adj.set(i, newSecond);
                }
            }
        }

        int bfs(int start) {
            boolean[] visited = new boolean[this.size];
            int[] levels = new int[this.size];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            levels[start] = 0;

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                visited[curr] = true;

                if (curr == this.size-1) {
                    // Done
                    break;
                }

                int currLevel = levels[curr];
                for (int adj : adjList.get(curr)) {
                    if (visited[adj]) continue;
                    if (levels[adj] == 0) {
                        levels[adj] = currLevel + 1;
                    }
                    queue.add(adj);
                }
            }
            return levels[this.size-1] == 0 ? -1 : levels[this.size-1];
        }

        void print() {
            for (int i=1; i<adjList.size(); i++) {
                List<Integer> adj = adjList.get(i);
                System.out.print(i + ":");
                for (int a : adj) {
                    System.out.print(a + ",");
                }
                System.out.println("");
            }
        }
    }

    private static int quickestWayUp(int[][] ladders, int[][] snakes) {
        int vertexSize = 100;
        Graph graph = new Graph(vertexSize + 1);

        for (int i=1; i<=vertexSize; i++) {
            for (int j=1; j<=6 && i+j<=vertexSize; j++) {
                graph.addEdge(i, i + j);
            }
        }

        for (int[] ladder : ladders) {
            int j = ladder[0] - 6;
            if (j < 1) {
                j = 1;
            }
            for (;j < ladder[0]; j++) {
                graph.replaceEdge(j, ladder[0], ladder[1]);
            }
        }

        for (int[] snake : snakes) {
            int j = snake[0] - 6;
            if (j < 1) {
                j = 1;
            }
            for (;j < snake[0]; j++) {
                graph.replaceEdge(j, snake[0], snake[1]);
            }
        }

        //graph.print();
        return graph.bfs(1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int testCount = in.nextInt();
        while (testCount-- > 0) {
            int ladderCount = in.nextInt();

            int[][] ladders = new int[ladderCount][2];
            for (int i = 0; i < ladderCount; i++) {
                ladders[i] = new int[2];
                ladders[i][0] = in.nextInt();
                ladders[i][1] = in.nextInt();
            }

            int snakeCount = in.nextInt();
            int[][] snakes = new int[snakeCount][2];
            for (int i = 0; i < snakeCount; i++) {
                snakes[i] = new int[2];
                snakes[i][0] = in.nextInt();
                snakes[i][1] = in.nextInt();
            }
            System.out.println(quickestWayUp(ladders, snakes));
        }
    }
}
