import java.util.Stack;

public class Q_USING_STACK {

    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    public void add(int x) {
        st1.push(x);
    }

    public int remove() {

        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }

        return st2.pop();
    }

    public int peek() {

        if (isEmpty()) {
            System.out.println("Queue Empty");
            return -1;
        }

        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }

        return st2.peek();
    }

    public boolean isEmpty() {
        return st1.isEmpty() && st2.isEmpty();
    }

    public int size() {
        return st1.size() + st2.size();
    }

    public void display() {

        Stack<Integer> temp1 = (Stack<Integer>) st1.clone();
        Stack<Integer> temp2 = (Stack<Integer>) st2.clone();

        while (!temp1.isEmpty()) {
            temp2.push(temp1.pop());
        }

        System.out.print("Queue: ");

        while (!temp2.isEmpty()) {
            System.out.print(temp2.pop() + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Q_USING_STACK q = new Q_USING_STACK();

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);

        q.display();

        System.out.println("Front: " + q.peek());

        System.out.println("Removed: " + q.remove());

        q.display();

        System.out.println("Size: " + q.size());

        System.out.println("Is Empty: " + q.isEmpty());
    }
}