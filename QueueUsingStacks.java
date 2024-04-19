import java.util.Stack;

    class QueueUsingStacks<T> {
        private Stack<T> stack1;
        private Stack<T> stack2;

        public QueueUsingStacks() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void enqueue(T item) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(item);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        public T dequeue() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty.");
            }
            return stack1.pop();
        }

        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty.");
            }
            return stack1.peek();
        }

        public boolean isEmpty() {
            return stack1.isEmpty();
        }

        public int size() {
            return stack1.size();
        }
    }

