import java.nio.Buffer;
import java.util.*;

public class GridChallenge {

    static String bubbleSort(String line) {
        char[] chars = line.toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = 0; j < chars.length - 1 - i; j++) {
                if (chars[j] > chars[j+1]) {
                    char tmp = chars[j];
                    chars[j] = chars[j+1];
                    chars[j+1] = tmp;
                }
            }
        }
        return new String(chars);
    }

    static String gridChallenge(String[] grid) {
        // Complete this function

        for (int i = 0; i < grid.length; i++) {
            grid[i] = bubbleSort(grid[i]);
            //System.out.println(grid[i]);
        }

        for (int i = 0; i < grid.length-1; i++) {
            for (int j = 0; j < grid.length-1; j++) {
                if (grid[i].charAt(j) > grid[i].charAt(j+1)) return "NO";
                if (grid[i].charAt(j) > grid[i+1].charAt(j)) return "NO";
                if (grid[i].charAt(j+1) > grid[i+1].charAt(j+1)) return "NO";
                if (grid[i].charAt(j) > grid[i+1].charAt(j)) return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            String[] grid = new String[n];
            for (int grid_i = 0; grid_i < n; grid_i++) {
                grid[grid_i] = in.next();
            }
            String result = gridChallenge(grid);
            System.out.println(result);
        }
        in.close();
    }
}
