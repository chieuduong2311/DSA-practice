package algorithm.week1;

import java.util.Stack;

public class QueueUsingStack {
//    issue 232
    static class MyQueue {

        private Stack<Integer> head;
        private Stack<Integer> tail;

        public MyQueue() {
            head = new Stack<>();
            tail = new Stack<>();
        }


        public void push(int x) {
            if (head.empty()) {
                tail.push(x);
            } else {
                while (!head.empty()) {
                    tail.push(head.pop());
                }
                tail.push(x);
            }
        }

        public int pop() {
            if (head.empty()) {
                while (!tail.empty()) {
                    head.push(tail.pop());
                }
            }
            return head.pop();
        }

        public int peek() {
            if (head.empty()) {
                while (!tail.empty()) {
                    head.push(tail.pop());
                }
            }
            return head.peek();
        }

        public boolean empty() {
            return head.empty() && tail.empty();
        }
    }
}
