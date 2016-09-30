public class MinStack {
    public Stack<Integer> data;
    public Stack<Integer> min;
    public MinStack() {
        data = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    public void push(int x) {
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        } 
        data.push(x);
    }

    public void pop() {
        int x = data.pop();
        if (x == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return data.peek(); 
    }

    public int getMin() {
        return min.peek();
    }
}
