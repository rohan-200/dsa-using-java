package arrays_pack;
public class SparseMatrix {
    private int[][] matrix;
    private int rows;
    private int cols;
    private int[] data;
    private int[] row_ind;
    private int[] col_ptr;

    /**
     * Constructor for the SparseMatrix class.
     *
     * @param matrix the input matrix to be compressed.
     */
    public SparseMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.data = new int[0];
        this.row_ind = new int[0];
        this.col_ptr = new int[cols + 1];

        // iterate through each column
        for (int j = 0; j < cols; j++) {
            // iterate through each row in the column
            for (int i = 0; i < rows; i++) {
                // if the element is not zero, add it to the compressed data
                if (matrix[i][j] != 0) {
                    data = append(data, matrix[i][j]);
                    row_ind = append(row_ind, i);
                    col_ptr[j + 1]++;
                }
            }
            // update the column pointer for the next column
            col_ptr[j + 1] += col_ptr[j];
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int[] getData() {
        return data;
    }

    public int[] getRow_ind() {
        return row_ind;
    }

    public int[] getCol_ptr() {
        return col_ptr;
    }

    /**
     * Transposes the sparse matrix and returns a new SparseMatrix object.
     *
     * @return the transposed SparseMatrix.
     */
    public SparseMatrix transpose() {
        int[][] transposedMatrix = new int[cols][rows];

        // iterate through each column
        for (int j = 0; j < cols; j++) {
            // iterate through each element in the column
            for (int k = col_ptr[j]; k < col_ptr[j + 1]; k++) {
                // get the row index and value of the element
                int i = row_ind[k];
                int value = data[k];
                // add the transposed element to the new matrix
                transposedMatrix[j][i] = value;
            }
        }

        return new SparseMatrix(transposedMatrix);
    }

    /**
     * Helper method to append an element to an array.
     *
     * @param arr the array to append to.
     * @param value the value to append to the array.
     * @return the new array with the appended value.
     */
    private int[] append(int[] arr, int value) {
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[arr.length] = value;
        return newArr;
    }
}
