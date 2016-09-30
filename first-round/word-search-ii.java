public class Solution {
    int rows, cols;
    char[][] board;
    List<String> result;
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.rows = board.length; this.cols = this.rows > 0 ? board[0].length : 0;
        this.result = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.add(word, 0);
        }
        for (int ri = 0; ri < rows; ri++) {
            for (int ci = 0; ci < cols; ci++) {
                search(root, ri, ci, new boolean[this.rows][this.cols]);
            }
        } 
        return result;
    }
    void search(TrieNode root, int ri, int ci, boolean[][] visited) {
        if (root.value != null) {
            result.add(root.value);
            root.value = null;
        }
        if (ri < 0 || ri >= rows || ci < 0 || ci >= cols || visited[ri][ci] 
                || root.children[board[ri][ci]-'a'] == null) {
            return;
        }
        visited[ri][ci] = true;
        int[][] rank = new int[][] {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };
        for (int[] each : rank) {
            int x = ri + each[0], y = ci + each[1];
            search(root.children[board[ri][ci]-'a'], x, y, visited);
        }
        visited[ri][ci] = false;
    }

}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String value;

    void add(String value, int i) {
        if (i == value.length()) {
            this.value = value;
        } else {
            int idx = value.charAt(i) - 'a';
            if (children[idx] == null) {
                children[idx] = new TrieNode();
            }
            children[idx].add(value, i + 1);
        }
    }
}
