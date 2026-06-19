class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {

    Node front;
    Node rear;
    int size;

    Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Enqueue
    public void add(int data) {

        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    // Dequeue
    public int remove() {

        if (front == null) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int val = front.data;

        front = front.next;

        if (front == null) {
            rear = null;
        }

        size--;

        return val;
    }

    // Front Element
    public int peek() {

        if (front == null) {
            System.out.println("Queue Empty");
            return -1;
        }

        return front.data;
    }

    // Is Empty
    public boolean isEmpty() {
        return front == null;
    }

    // Size
    public int size() {
        return size;
    }

    // Display
    public void display() {

        Node temp = front;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }
}

public class Q_USING_LL {

    public static void main(String[] args) {

        Queue q = new Queue();

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