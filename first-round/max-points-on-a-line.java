public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length <= 2) {
            return points.length;
        }
        int maxNum = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            map.put("self", 1);
            int iMax = 0;
            for (int j = i+1; j < points.length; j++) {
                String slope = getSlope(points[i], points[j]);
                if (!map.containsKey(slope)) {
                    map.put(slope, 0);
                }
                map.put(slope, map.get(slope) + 1);
                if (!slope.equals("self")) {
                    iMax = Math.max(iMax, map.get(slope));
                }
            }
            maxNum = Math.max(maxNum, map.get("self") + iMax);
        }
        return maxNum;
    }

    private String getSlope(Point a, Point b) {
        int dx = a.x - b.x, dy = a.y - b.y;
        if (dx == 0 && dy == 0) {
            return "self";
        }
        if (dx == 0) {
            return "inf";
        }
        if (dy == 0) {
            return "0";
        }
        String sign = dx * dy > 0 ? "+" : "-";
        dx = Math.abs(dx);
        dy = Math.abs(dy);
        int gcd = gcd(dx, dy);
        return sign + ":" + dx / gcd + ":" + dy / gcd;
    }

    private int gcd(int x, int y) {
        if (x > y) {
            return gcd(y, x);
        }
        if (x == 0) {
            return y;
        }
        return gcd(y % x, x);
    }
}
