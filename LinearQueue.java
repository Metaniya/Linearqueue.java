public class LinearQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] queueArray;

    public LinearQueue(int size) {
        maxSize = size;
        front = -1;
        rear = -1;
        queueArray = new int[maxSize];
    }

    public boolean isEmpty() {
        return (front == -1 && rear == -1);
    }

    public boolean isFull() {
        return (rear == maxSize - 1);
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue element.");
        } else if (isEmpty()) {
            front = 0;
            rear = 0;
            queueArray[rear] = value;
        } else {
            rear++;
            queueArray[rear] = value;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1;
        } else if (front == rear) {
            int dequeuedElement = queueArray[front];
            front = -1;
            rear = -1;
            return dequeuedElement;
        } else {
            int dequeuedElement = queueArray[front];
            front++;
            return dequeuedElement;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek element.");
            return -1;
        } else {
            return queueArray[front];
        }
    }

    public static void main(String[] args) {
        LinearQueue queue = new LinearQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front of the queue: " + queue.peek());

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());

        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Front of the queue: " + queue.peek());
    }
}

