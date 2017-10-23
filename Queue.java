public class Queue {

    LinkedListNode first;
    LinkedListNode last;

    public void enqueue(Object item) {
        LinkedListNode node = new LinkedListNode(item);
        if (first == null) {
            first = node;
            last = first;
        } else {
            last.next = node;
            last = last.next;
        }
    }

    public Object dequeue() {
        if (first != null) {
            Object item = first.data;
            first = first.next;
            return item;
        }
        return null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        for (int i = 0; i < 6; i++) {
            System.out.println(queue.dequeue());
        }
    }
}
