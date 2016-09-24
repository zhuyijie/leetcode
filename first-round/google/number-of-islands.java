public class Solution {
    int[] unionFind;
    int rowNum, colNum;
    public int numIslands(char[][] grid) {
        rowNum = grid.length; colNum = rowNum == 0 ? 0 : grid[0].length;
        if (rowNum == 0 || colNum == 0) {
            return 0;
        }
        unionFind = new int[rowNum * colNum];
        for (int i = 0; i < unionFind.length; i++) {
            unionFind[i] = i;
        }
        int numOfIslands = 0;
        for (int ri = 0; ri < rowNum; ri++) {
            for (int ci = 0; ci < colNum; ci++) {
                if (grid[ri][ci] == '0') {
                    continue;
                }
                int root = getIdx(ri, ci);
                int neighbors = 0;
                if (ri > 0 && grid[ri - 1][ci] == '1') {
                    int upRoot  = getRoot(getIdx(ri-1, ci));
                    setRoot(root, upRoot);
                    root = upRoot;
                    neighbors++;
                } 
                if (ci > 0 && grid[ri][ci - 1] == '1') {
                    int upRoot = getRoot(getIdx(ri, ci - 1));
                    if (root != upRoot) {
                        setRoot(upRoot, root);
                        neighbors++;
                    }
                }
                numOfIslands += 1 - neighbors;
            }
        }
        return numOfIslands;
    }
    int getIdx(int ri, int ci) {
        return ri * colNum + ci;
    }
    int getRoot(int idx) {
        while (unionFind[idx] != idx) {
            idx = unionFind[idx];
        }
        return idx;
    }
    void setRoot(int s, int d) {
        int sRoot = getRoot(s), dRoot = getRoot(d);
        unionFind[sRoot] = dRoot;
    }
}
