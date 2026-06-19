class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {

    Node top;
    int size;

    Stack() {
        top = null;
        size = 0;
    }

    // Push
    public void push(int data) {

        Node newNode = new Node(data);

        newNode.next = top;
        top = newNode;

        size++;
    }

    // Pop
    public int pop() {

        if (top == null) {
            System.out.println("Stack Underflow");
            return -1;
        }

        int val = top.data;

        top = top.next;

        size--;

        return val;
    }

    // Peek
    public int peek() {

        if (top == null) {
            System.out.println("Stack Empty");
            return -1;
        }

        return top.data;
    }

    // Is Empty
    public boolean isEmpty() {
        return top == null;
    }

    // Size
    public int size() {
        return size;
    }

    // Display
    public void display() {

        Node temp = top;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }
}

public class ST_USING_LL {

    public static void main(String[] args) {

        Stack st = new Stack();

        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);

        st.display();

        System.out.println("Top: " + st.peek());

        System.out.println("Popped: " + st.pop());

        st.display();

        System.out.println("Size: " + st.size());

        System.out.println("Is Empty: " + st.isEmpty());
    }
}