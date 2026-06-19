package STACK.ST_USING_QUEUE;

import java.util.LinkedList;
import java.util.Queue;

public class ST_USING_QUEUE {

    Queue<Integer> q = new LinkedList<>();

    // Push element into stack
    public void push(int x) {

        int s = q.size();

        q.add(x);

        for (int i = 0; i < s; i++) {
            q.add(q.remove());
        }
    }

    // Pop element from stack
    public int pop() {

        if (q.isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }

        return q.remove();
    }

    // Return top element
    public int top() {

        if (q.isEmpty()) {
            System.out.println("Stack Empty");
            return -1;
        }

        return q.element();
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return q.isEmpty();
    }

    // Return size
    public int size() {
        return q.size();
    }

    // Display stack
    public void display() {
        System.out.println(q);
    }

    public static void main(String[] args) {

        ST_USING_QUEUE st = new ST_USING_QUEUE();

        st.push(4);
        st.push(8);
        st.push(12);

        st.display();

        System.out.println("Top: " + st.top());

        System.out.println("Pop: " + st.pop());

        st.display();

        System.out.println("Is Empty: " + st.isEmpty());

        System.out.println("Size: " + st.size());
    }
}