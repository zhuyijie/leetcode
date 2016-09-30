/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Event[] events = new Event[intervals.size() * 2];
        for (int i = 0; i < intervals.size(); i++) {
            events[2 * i] = new Event();
            events[2 * i + 1] = new Event();
            events[2 * i].setoff = true;
            events[2 * i + 1].setoff = false;
            events[2 * i].value = intervals.get(i).start;
            events[2 * i + 1].value = intervals.get(i).end;
        }
        Arrays.sort(events);
        List<Interval> result = new ArrayList<Interval>();
        int counter = 0;
        int start = 0;
        for (Event e : events) {
            if (e.setoff && counter++ == 0) {
                start = e.value;
            } else if (!e.setoff && --counter == 0) {
                result.add(new Interval(start, e.value));
            }
        }
        return result;
    }
}
class Event implements Comparable<Event> {
    boolean setoff;
    int value;
    public int compareTo(Event e) {
        if (this.value != e.value) {
            return this.value - e.value;
        } else if (this.setoff == e.setoff) {
            return 0;
        } else if (this.setoff) {
            return -1;
        } else {
            return 1;
        }
    }
}
