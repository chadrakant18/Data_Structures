class Stack{
    int[] arr;
    int top;
    int capacity;
    Stack(int size){
        arr=new int[size];
        capacity=size;
        top=-1;
    }
    public void push(int data){
        if(top==capacity-1){
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top]=data;
    }
    public int pop(){
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }
       public int peek() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr[top];
    }
     public boolean isEmpty() {
        return top == -1;
    }
     public int size() {
        return top + 1;
    }
    public void display() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return;
        }

        System.out.print("Stack: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class ST_USING_ARRAY{
    public static void main(String[] args) {
        Stack st=new Stack(5);
        
        st.push(10);
        st.push(20);
        st.push(30);

        st.display();

        System.out.println("Top Element: " + st.peek());

        System.out.println("Popped: " + st.pop());

        st.display();

        System.out.println("Size: " + st.size());

        System.out.println("Is Empty: " + st.isEmpty());
    }
}