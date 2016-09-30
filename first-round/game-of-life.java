
public class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length, cols = rows > 0 ? board[0].length : 0; 
        for (int ri = 0; ri < rows; ri++) {
            for (int ci = 0; ci < cols; ci++) {
                int[][] rank = new int[][] {
                    {-1, -1},{-1, 0},
                    {-1, 1},{0, -1},
                    {0, 1},{1, -1},
                    {1, 0},{1, 1}
                };
                int lifeCount = 0;
                for (int[] each : rank) {
                    int x = ri + each[0], y = ci + each[1];
                    if (x < 0 || x >= rows || y < 0 || y >= cols) {
                        continue;
                    }
                    if ((board[x][y] & 1) == 1) {
                        lifeCount++;
                    }
                }
                if (lifeCount == 3 || (lifeCount == 2 && board[ri][ci] == 1)) {
                    board[ri][ci] = board[ri][ci] | 1 << 1;
                }
            }
        }
        for (int ri = 0; ri < rows; ri++) {
            for (int ci = 0; ci < cols; ci++) {
                board[ri][ci] = board[ri][ci] >> 1;
            }
        }
    }
}
