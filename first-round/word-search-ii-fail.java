public class Solution {
    char[][] board;
    boolean[][] visited;
    int rows, cols;
    public List<String> findWords(char[][] board, String[] words) {
        this.rows = board.length;
        this.cols = rows > 0 ? board[0].length : 0;
        this.board = board;
        List<String> result = new ArrayList<>();
        forWord:
        for (String word : words) {
            for (int ri = 0; ri < rows; ri++) {
                for (int ci = 0; ci < cols; ci++) {
                    this.visited = new boolean[rows][cols];
                    if (search(word, 0, ri, ci)) {
                        result.add(word);
                        continue forWord;
                    }
                }
            }
        }
        return result;
    }

    boolean search(String word, int i, int ri, int ci) {
        if (i == word.length()) {
            return true;
        }
        if (ri < 0 || ri >= rows || ci < 0 || ci >= cols || visited[ri][ci] || board[ri][ci] != word.charAt(i)) {
            return false;
        } 
        int[][] rank = new int[][] {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };
        for (int[] each : rank) {
            int x = each[0] + ri;
            int y = each[1] + ci;
            if (search(word, i + 1, x, y)) {
                return true;
            }
        }
        return false;
    }
}
