public class CircularQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] queueArray;

    public CircularQueue(int size) {
        maxSize = size;
        front = -1;
        rear = -1;
        queueArray = new int[maxSize];
    }

    public boolean isEmpty() {
        return (front == -1);
    }

    public boolean isFull() {
        return ((front == 0 && rear == maxSize - 1) || (rear == front - 1));
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue element.");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % maxSize;
            queueArray[rear] = value;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1;
        } else {
            int dequeuedElement = queueArray[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % maxSize;
            }
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
        CircularQueue queue = new CircularQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Front of the queue: " + queue.peek());

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());

        queue.enqueue(60);

        System.out.println("Front of the queue: " + queue.peek());
    }
}

