import java.util.*;

class Point {
    int i;
    int j;

    Point(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;

        if (!Point.class.isAssignableFrom(o.getClass())) return false;

        final Point a = (Point) o;
        if (i != a.i || j != a.j) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash += 53*hash + this.i;
        hash += 53*hash + this.j;
        return hash;
    }

    @Override
    public String toString() {
        return "i:" + i + ", j:" + j;
    }
}

class Count {
    int exitCount;
    int deadCount;
    int noOutCount;

    @Override
    public String toString() {
        return exitCount + " " + deadCount + " " + noOutCount;
    }
}

public class FrogInMaze {
    static boolean DEBUG = true;
    static int dfs(String[] map, int n, int m, Map<Point, Point> tunnels, int[] visited, Point a, Count count) {

        if (a.i < 0 || a.i >= n || a.j < 0 || a.j >= m) return 1;
        if (visited[a.i*m + a.j] == 1) return 0;

        visited[a.i*m + a.j] = 1;

        char curr = map[a.i].charAt(a.j);
        if (curr == '%') {
            if (DEBUG) System.out.println("Exit " + a);
            count.exitCount++;
            return 0;
        }
        else if (curr == '*') {
            if (DEBUG) System.out.println("Bomb " + a);
            count.deadCount++;
            return 0;
        }
        else if (curr == '#') {
            if (DEBUG) System.out.println("Obstacle " + a);
            return 1;
        }
        else if (tunnels.containsKey(a)) {
            if (DEBUG) System.out.println("Tunnel " + a);
            a = tunnels.get(a);
            if (DEBUG) System.out.println("Tunnel changed " + a);
        }
        else if (curr == 'O') {
            if (DEBUG) System.out.println("Free cell " + a);
        }

        int res = 0;
        res += dfs(map, n, m, tunnels, visited, new Point(a.i, a.j+1), count);
        res += dfs(map, n, m, tunnels, visited, new Point(a.i+1, a.j), count);
        res += dfs(map, n, m, tunnels, visited, new Point(a.i, a.j-1), count);
        res += dfs(map, n, m, tunnels, visited, new Point(a.i-1, a.j), count);
        if (res >= 3) {
            count.noOutCount++;
        }
        return 0;
    }

    static void findExitPossibility(String[] map, Map<Point, Point> tunnels) {
        int n = map.length;
        int m = map[0].length();
        int[] visited = new int[n * m];

        Point A = null;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i].charAt(j) == 'A') {
                    A = new Point(i, j);
                    if(DEBUG) System.out.println("Start " + A);
                    break;
                }
            }
        }
        Count count = new Count();
        dfs(map, n, m, tunnels, visited, A, count);

        if(DEBUG) System.out.println(count);
        double res = (count.exitCount == 0) ? 0 : count.exitCount*1.0/(count.exitCount+count.deadCount+count.noOutCount);
        System.out.printf("%.10f", res);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        String[] map = new String[n];
        for(int a0 = 0; a0 < n; a0++){
            map[a0] = in.next();
        }

        Map<Point, Point> tunnels = new HashMap<>();
        for(int a0 = 0; a0 < k; a0++){
            int i1 = in.nextInt() - 1;
            int j1 = in.nextInt() - 1;
            int i2 = in.nextInt() - 1;
            int j2 = in.nextInt() - 1;

            tunnels.put(new Point(i1, j1), new Point(i2, j2));
            tunnels.put(new Point(i2, j2), new Point(i1, j1));
        }

        findExitPossibility(map, tunnels);
    }
}
