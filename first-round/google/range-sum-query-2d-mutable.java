public class NumMatrix {
    int[][] sums;
    int rows, cols;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        rows = matrix.length; cols = rows == 0 ? 0 : matrix[0].length;
        sums = new int[rows][cols + 1];
        for (int ri = 0; ri < rows; ri++) {
            for (int ci = 1; ci <= cols; ci++) {
                sums[ri][ci] = sums[ri][ci-1] + matrix[ri][ci-1];
            }
        }
    }

    public void update(int row, int col, int val) {
        matrix[row][col] = val;
        for (int ci = col + 1; ci <= cols; ci++) {
            sums[row][ci] = sums[row][ci-1] + matrix[row][ci-1];
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int ri = row1; ri <= row2; ri++) {
            sum += sums[ri][col2+1] - sums[ri][col1];
        }
        return sum;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);
