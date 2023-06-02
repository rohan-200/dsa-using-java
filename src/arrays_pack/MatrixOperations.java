package arrays_pack;

public class MatrixOperations {

    // Method to check if a matrix is orthogonal
    public boolean isOrthogonal(int[][] matrix) {
        int n = matrix.length;
        int[][] product = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int dotProduct = 0;
                for (int k = 0; k < n; k++) {
                    dotProduct += matrix[i][k] * matrix[j][k];
                }
                product[i][j] = dotProduct;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j && Math.abs(product[i][j] - 1) > 1e-6) {
                    return false;
                } else if (i != j && Math.abs(product[i][j]) > 1e-6) {
                    return false;
                }
            }
        }
        return true;
    }

    // Method to calculate the 1-norm of a matrix
    public int norm1(int[][] matrix) {
        int n = matrix.length;
        int maxSum = 0;
        for (int j = 0; j < n; j++) {
            int colSum = 0;
            for (int i = 0; i < n; i++) {
                colSum += Math.abs(matrix[i][j]);
            }
            if (colSum > maxSum) {
                maxSum = colSum;
            }
        }
        return maxSum;
    }
}