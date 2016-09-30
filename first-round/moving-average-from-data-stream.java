public class MovingAverage {
    int i = 0;
    boolean isFull = false;
    int[] data;
    public MovingAverage(int size) {
        data = new int[size];
    }

    public double next(int val) {
        data[i++] = val;
        if (i >= data.length) {
            isFull = true;
            i = i % data.length;
        }
        int count = isFull ? data.length : i;
        int sum = 0;
        for (int j = 0; j < count; j++) {
            sum += data[j];
        }
        return (double) sum / count;
    }
}
