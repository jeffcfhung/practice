import java.util.*;

public class ConnectedCellsInAGrid1 {
    static int[] id, sumArr;

    static void cell(int[][] matrix, int n, int m, int i1, int j1, int i2, int j2) {
        if (i2 >= 0 && j2 >= 0 && i2 < n && j2 < m && matrix[i2][j2] == 1) {
            if (!connected(i1*m + j1, i2*m + j2)) {
                union(i1*m + j1, i2*m + j2);
            }
        }
    }

    static int connectedCell(int[][] matrix) {
        // Complete this function
        int n = matrix.length;
        int m = matrix[0].length;

        id = new int[n * m];
        sumArr = new int[n * m];

        for (int i = 0; i < n*m; i++) {
            id[i] = i;
            sumArr[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) continue;
                cell(matrix, n, m, i, j, i-1, j-1);
                cell(matrix, n, m, i, j, i-1, j);
                cell(matrix, n, m, i, j, i-1, j+1);
                cell(matrix, n, m, i, j, i, j-1);
                cell(matrix, n, m, i, j, i, j+1);
                cell(matrix, n, m, i, j, i+1, j-1);
                cell(matrix, n, m, i, j, i+1, j);
                cell(matrix, n, m, i, j, i+1, j+1);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n*m; i++) {
            max = Math.max(max, sumArr[i]);
        }
        return max;
    }

    static int root(int i) {
        while (id[i] != i) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    static boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    static void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (sumArr[i] < sumArr[j]) {
            id[i] = j;
            sumArr[j] += sumArr[i];
        }
        else {
            id[j] = i;
            sumArr[i] += sumArr[j];
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][m];
        for(int matrix_i = 0; matrix_i < n; matrix_i++){
            for(int matrix_j = 0; matrix_j < m; matrix_j++){
                matrix[matrix_i][matrix_j] = in.nextInt();
            }
        }
        int result = connectedCell(matrix);
        System.out.println(result);
        in.close();
    }
}
