package io.awklabs.leetcode;

public class MinStack151 {

    static class MinStack {

        int[] data;
        int[] min;
        int top;

        public MinStack() {
            data = new int[256];
            min = new int[256];
            top = -1;
        }

        public void push(int x) {
            if (top == data.length - 1) {
                doubleTheArray();
            }
            data[++top] = x;
            if (top == 0) {
                min[top] = x;
            } else {
                if (min[top - 1] > x) {
                    min[top] = x;
                } else {
                    min[top] = min[top - 1];
                }
            }
        }

        private void doubleTheArray() {
            int[] newData = new int[data.length * 2];
            int[] newMin = new int[min.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            System.arraycopy(min, 0, newMin, 0, min.length);
            data = newData;
            min = newMin;
        }

        public void pop() {
            top--;
        }

        public int top() {
            return data[top--];
        }

        public int getMin() {
            return min[top];
        }
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
