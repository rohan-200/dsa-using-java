package arrays_pack;
public class CheckTriangular {

    public  boolean isLowerTriangular(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isUpperTriangular(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isDiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i != j && matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isIdentity(int[][] matrix) {
        if (!isDiagonal(matrix)) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] != 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isTridiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (Math.abs(i - j) > 1 && matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }


}

