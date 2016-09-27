public class MedianFinder {
    PriorityQueue<Integer> lo = new PriorityQueue<Integer>(Collections.reverseOrder());
    PriorityQueue<Integer> hi = new PriorityQueue<Integer>();

    public void addNum(int num) {
        if (hi.size() == 0 || num < hi.peek()) {
            lo.offer(num);
        } else {
            hi.offer(num);
        }
        if (lo.size() > hi.size() + 1) {
            hi.offer(lo.poll());
        }
        if (lo.size() < hi.size()) {
            lo.offer(hi.poll());
        }
    }

    public double findMedian() {
        if (lo.size() > hi.size()) {
            return (double) lo.peek();
        } else {
            return ((double) lo.peek() + (double) hi.peek()) / 2;
        }
    }
}
