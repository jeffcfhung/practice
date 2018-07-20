import java.util.*;

public class MagicSquaresInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid==null || grid.length == 0) return 0;

        int res = 0;
        for (int i=0; i<grid.length-2; i++) {
            for (int j=0; j<grid[0].length-2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isMagicSquare(int[][] grid, int row, int col) {
        int[] uniq = new int[10];
        int[] rows = new int[3];
        int[] cols = new int[3];
        int d1 = 0, d2 = 0;

        for (int i=0; i<3; i++) {
            d1 += grid[row+i][col+i];
            d2 += grid[row+2-i][col+i];
            for (int j=0; j<3; j++) {
                int val = grid[row+i][col+j];
                if (val < 1 || val > 9 || uniq[val] == 1) {
                    return false;
                }
                uniq[val] = 1;
                rows[i] += val;
                cols[j] += val;
            }
        }

        for (int i=0; i<3; i++) {
            if (rows[i] != d1 || cols[i] != d1) {
                return false;
            }
        }
        return d1 == d2;
    }
}
