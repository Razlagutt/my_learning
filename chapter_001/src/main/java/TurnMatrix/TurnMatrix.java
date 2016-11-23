package TurnMatrix;

/**
 * Created by Z.Turabayev on 23.11.2016.
 */
public class TurnMatrix {




    public int[][] turn(int[][] matrix) {
        int n = matrix.length;
        int n2 = matrix[1].length;
        int tmp;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n2 - 1 - i; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[n2 - j - 1][i];
                matrix[n2 - j - 1][i] = matrix[n - i - 1][n2 - j - 1];
                matrix[n - i - 1][n2 - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    return matrix;
    }
}
