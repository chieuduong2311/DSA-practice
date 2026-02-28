package algorithm.week4;

import java.util.ArrayList;
import java.util.Stack;

public class MinStack {
//    issue 155
//    use Stack to store min
    private Stack<Integer> normalStack;
    int size;
    private ArrayList<Integer> min;
    public MinStack() {
        normalStack = new Stack<>();
        min = new ArrayList<>();
        size = 0;
    }

    public void push(int val) {
        normalStack.push(val);
        if (size == 0) {
            min.add(val);
        } else {
            if (val < min.get(size - 1)) {
                min.add(val);
            } else min.add(min.get(size - 1));
        }
        size++;
    }

    public void pop() {
        normalStack.pop();
        min.remove(size - 1);
        size--;
    }

    public int top() {
        return normalStack.peek();
    }

    public int getMin() {
        return min.get(size - 1);
    }
}

