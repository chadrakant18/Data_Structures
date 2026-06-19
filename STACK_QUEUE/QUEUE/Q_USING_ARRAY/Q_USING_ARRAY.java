class Queue{
    int[] arr;
    int front;
    int rear;
    int capacity;
    Queue(int size){
        capacity=size;
        arr=new int[capacity];
        front=-1;
        rear=-1;
    }
    public void enqueue(int data){
        if(rear==capacity-1){
            System.out.println("Queue Overflow");
            return;
        }
        if(front==-1){
            front=0;
        }
        arr[++rear]=data;
    }
    public int dequeue(){
        if (front == -1) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int val=arr[front++];
        if(front>rear){
            front=rear=-1;
        }

        return val;
    }
     public int peek() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            return -1;
        }

        return arr[front];
    }
     public boolean isEmpty() {
        return front == -1;
    }
     public int size() {
        if (front == -1) return 0;
        return rear - front + 1;
    }
    public void display() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        }

        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
public class Q_USING_ARRAY {
    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        System.out.println("Front: " + q.peek());

        System.out.println("Dequeued: " + q.dequeue());

        q.display();

        System.out.println("Size: " + q.size());
    }
}