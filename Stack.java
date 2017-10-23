import java.util.Iterator;

public class Stack<E> implements Iterable<E> {

    Node top;

    private class Node {
        E data;
        Node next;
    }

    public void push(E data) {
        Node node = new Node();
        node.data = data;
        node.next = top;
        top = node;
    }

    public E peek() {
        return top.data;
    }

    public E pop() {
        if (top != null) {
            E item = top.data;
            top = top.next;
            return item;
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                Node next = current;
                current = current.next;
                return next.data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(6);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println(stack.peek());

        for (int i = 0; i < 6; i++) {
            System.out.println(stack.pop());
        }
    }
}
