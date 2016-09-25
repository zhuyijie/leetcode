import static java.lang.Math.*;
public class Solution {
    public int trapRainWater(int[][] map) {
        int rows = map.length, cols = rows > 0 ? map[0].length : 0;
        Set<String> visited = new HashSet<String>();
        PriorityQueue<Point> heap = new PriorityQueue<Point>();
        for (int ri = 0; ri < rows; ri++) {
            heap.offer(new Point(ri, 0, map[ri][0]));
            heap.offer(new Point(ri, cols - 1, map[ri][cols - 1]));
            visited.add(ri + ":" + 0);
            visited.add(ri + ":" + (cols - 1));
        }
        for (int ci = 1; ci < cols - 1; ci++) {
            heap.offer(new Point(0, ci, map[0][ci]));
            heap.offer(new Point(rows - 1, ci, map[rows - 1][ci]));
            visited.add(0 + ":" + ci);
            visited.add((rows - 1) + ":" + ci);
        }
        int rain = 0;
        while (!heap.isEmpty()) {
            int[][] rank = new int[][] {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
            };
            Point shortest = heap.poll();
            int r = shortest.r, c = shortest.c, h = shortest.h;
            for (int[] ofst : rank) {
                int nr = r + ofst[0], nc = c + ofst[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || visited.contains(nr + ":" + nc)) {
                    continue;
                }
                visited.add(nr + ":" + nc);
                rain += h > map[nr][nc] ? h - map[nr][nc] : 0;
                heap.offer(new Point(nr, nc, max(h, map[nr][nc])));
                
            }
        }
        return rain;
    }
}
class Point implements Comparable<Point> {
    int r, c, h;
    public Point(int r, int c, int h) {
        this.r = r;
        this.c = c;
        this.h = h;
    }
    public int compareTo(Point p) {
        return this.h - p.h;
    }
}
