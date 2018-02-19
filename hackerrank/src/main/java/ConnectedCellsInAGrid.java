import java.util.*;

public class ConnectedCellsInAGrid {
    static int n, m;

    static int cell(int[][] matrix, int i, int j) {
        if (i<0 || j<0 || i>=n || j>=m || matrix[i][j]==0 || matrix[i][j]==-1) return 0;

        matrix[i][j] = -1;
        return 1 +
                cell(matrix, i-1, j-1) +
                cell(matrix,i-1, j) +
                cell(matrix,i-1, j+1) +
                cell(matrix,i, j-1) +
                cell(matrix,i, j+1) +
                cell(matrix,i+1, j-1) +
                cell(matrix,i+1, j) +
                cell(matrix,i+1, j+1)
                ;

    }

    static int connectedCell(int[][] matrix) {
        // Complete this function
        n = matrix.length;
        m = matrix[0].length;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, cell(matrix, i, j));
                //System.out.print(matrix[i][j] + " ");
            }
            //System.out.println(" ");
        }
        return max;
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
