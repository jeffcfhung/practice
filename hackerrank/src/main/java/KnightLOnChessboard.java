import java.util.*;

class Point {
    int x;
    int y;
    int count;

    Point(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point a = (Point) o;
        return x == a.x && y == a.y;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.x;
        hash = 53 * hash + this.y;
        return hash;
    }

    @Override
    public String toString() {
        return "x:" + x + ", y:" + y;
    }
}

public class KnightLOnChessboard {
    static int countMove(int n, int i, int j) {
        // BFS
        Set<Point> visited = new HashSet<>();
        Point start = new Point(0, 0, 0);
        Point target = new Point(n-1, n-1, 0);

        Queue<Point> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            if (visited.contains(curr)) {
                continue;
            }
            visited.add(curr);

            if (Math.abs(curr.x) >= n || Math.abs(curr.y) >= n) {
                continue;
            }
            if (curr.x < 0 || curr.y < 0) {
                continue;
            }
            //System.out.println(curr);

            if (curr.equals(target)) {
                //System.out.println(curr);
                return curr.count;
            }
            int nextCount = curr.count + 1;

            queue.add(new Point(curr.x + i, curr.y + j, nextCount));
            queue.add(new Point(curr.x + i, curr.y - j, nextCount));
            queue.add(new Point(curr.x - i, curr.y + j, nextCount));
            queue.add(new Point(curr.x - i, curr.y - j, nextCount));
            queue.add(new Point(curr.x + j, curr.y + i, nextCount));
            queue.add(new Point(curr.x + j, curr.y - i, nextCount));
            queue.add(new Point(curr.x - j, curr.y + i, nextCount));
            queue.add(new Point(curr.x - j, curr.y - i, nextCount));
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        //System.out.println(countMove(n, 3, 4));

        for (int i=1; i<n; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j=1; j<n; j++) {
                sb.append(countMove(n, i, j));
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }
    }
}


