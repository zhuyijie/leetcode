package pacific_atlantic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        int m = matrix.length, n = m > 0 ? matrix[0].length : 0;
        if (m == 0 || n == 0) {
            return Collections.emptyList();
        }
        boolean[][] visited = new boolean[m][n];
        boolean[][] pacific = visited;
        PriorityQueue<Point> pQueue = new PriorityQueue<>();
        for (int ni = 0; ni < n; ni++) {
            pQueue.add(new Point(0, ni, matrix[0][ni]));
            visited[0][ni] = true;
        }
        for (int mi = 1; mi < m; mi++) {
            pQueue.add(new Point(mi, 0, matrix[mi][0]));
            visited[mi][0] = true;
        }
        while (!pQueue.isEmpty()) {
            Point p = pQueue.poll();
            if (p.x > 0 && !visited[p.x - 1][p.y] && matrix[p.x - 1][p.y] >= matrix[p.x][p.y]) {
                visited[p.x - 1][p.y] = true;
                pQueue.offer(new Point(p.x-1, p.y, matrix[p.x-1][p.y]));
            }
            if (p.y > 0 && !visited[p.x][p.y-1] && matrix[p.x][p.y-1] >= matrix[p.x][p.y]) {
                visited[p.x][p.y-1] = true;
                pQueue.offer(new Point(p.x, p.y - 1, matrix[p.x][p.y-1]));
            }
            if (p.x < m - 1 && !visited[p.x + 1][p.y] && matrix[p.x + 1][p.y] >= matrix[p.x][p.y]) {
                visited[p.x + 1][p.y] = true;
                pQueue.offer(new Point(p.x+1, p.y, matrix[p.x+1][p.y]));
            }
            if (p.y < n - 1 && !visited[p.x][p.y + 1] && matrix[p.x][p.y + 1] >= matrix[p.x][p.y]) {
                visited[p.x][p.y + 1] = true;
                pQueue.offer(new Point(p.x, p.y + 1, matrix[p.x][p.y + 1]));
            }
        }
        visited = new boolean[m][n];
        boolean[][] atlantic = visited;
        for (int ni = 0; ni < n; ni++) {
            pQueue.add(new Point(m-1, ni, matrix[m-1][ni]));
            visited[m-1][ni] = true;
        }
        for (int mi = 0; mi < m - 1; mi++) {
            pQueue.add(new Point(mi, n-1, matrix[mi][n-1]));
            visited[mi][n-1] = true;
        }
        while (!pQueue.isEmpty()) {
            Point p = pQueue.poll();
            if (p.x > 0 && !visited[p.x - 1][p.y] && matrix[p.x - 1][p.y] >= matrix[p.x][p.y]) {
                visited[p.x - 1][p.y] = true;
                pQueue.offer(new Point(p.x-1, p.y, matrix[p.x-1][p.y]));
            }
            if (p.y > 0 && !visited[p.x][p.y-1] && matrix[p.x][p.y-1] >= matrix[p.x][p.y]) {
                visited[p.x][p.y-1] = true;
                pQueue.offer(new Point(p.x, p.y - 1, matrix[p.x][p.y-1]));
            }
            if (p.x < m - 1 && !visited[p.x + 1][p.y] && matrix[p.x + 1][p.y] >= matrix[p.x][p.y]) {
                visited[p.x + 1][p.y] = true;
                pQueue.offer(new Point(p.x+1, p.y, matrix[p.x+1][p.y]));
            }
            if (p.y < n - 1 && !visited[p.x][p.y + 1] && matrix[p.x][p.y + 1] >= matrix[p.x][p.y]) {
                visited[p.x][p.y + 1] = true;
                pQueue.offer(new Point(p.x, p.y + 1, matrix[p.x][p.y + 1]));
            }
        }
        List<int[]> result = new ArrayList<>();
        for (int mi = 0; mi < m; mi++) {
            for (int ni = 0; ni < n; ni++) {
                if (atlantic[mi][ni] && pacific[mi][ni]) {
                    result.add(new int[]{mi, ni});
                }
            }
        }
        return result;
    }
}

class Point implements Comparable<Point>{
    int x , y, height;

    public Point(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }

    @Override
    public int compareTo(Point point) {
        return this.height = point.height;
    }
}