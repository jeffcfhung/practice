import java.util.*;

public class CutOffTreesForGolfEvent {

    private int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) return 0;

        int m = forest.size();
        int n = forest.get(0).size();

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] arr)-> arr[2]));
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int height = forest.get(i).get(j);
                if (height <= 1) continue;

                pq.add(new int[] {i, j, height});
            }
        }

        int[] start = {0, 0};
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] tree = pq.poll();
            int steps = minSteps(forest, start, tree, m, n);
            if (steps < 0) {
                return -1;
            }
            sum += steps;
            start[0] = tree[0];
            start[1] = tree[1];
        }
        return sum;
    }

    private int minSteps(List<List<Integer>> forest, int[] start, int[] tree, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] curr = queue.poll();

                if (curr[0] == tree[0] && curr[1] == tree[1]) {
                    return steps;
                }

                for (int[] d : dirs) {
                    int nx = curr[0] + d[0];
                    int ny = curr[1] + d[1];

                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny] || forest.get(nx).get(ny) == 0) {
                        continue;
                    }

                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
            steps++;
        }
        return -1;
    }
}
