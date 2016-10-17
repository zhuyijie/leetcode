public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Node> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int len = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                continue;
            }
            set.add(num);
            Node prev = map.get(num-1), next = map.get(num+1);
            if (prev != null && next != null) {
                map.remove(num-1);
                map.remove(num+1);
                if (map.containsKey(prev.begin)) {
                    map.remove(prev.begin);
                }
                if (map.containsKey(next.end)) {
                    map.remove(next.end);
                }
                prev.end = next.end;
                map.put(prev.begin, prev);
                map.put(prev.end, prev);
                len = Math.max(prev.end - prev.begin + 1, len);
            } else if (prev != null) {
                if (prev.begin != prev.end) {
                    map.remove(prev.end);
                }
                prev.end = num;
                map.put(num, prev);
                len = Math.max(prev.end - prev.begin + 1, len);
            } else if (next != null) {
                if (next.begin != next.end) {
                    map.remove(next.begin);
                }
                next.begin = num;
                map.put(num, next);
                len = Math.max(next.end - next.begin + 1, len);
            } else {
                map.put(num, new Node(num, num));
                len = Math.max(1, len);
            }
        }
    return len;
    }
}

class Node {
    int begin, end;
    public Node(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }
}
