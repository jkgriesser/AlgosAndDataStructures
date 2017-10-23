import java.util.Iterator;

public class IterableGenericLinkedList<E> implements Iterable<E> {
    E data;
    IterableGenericLinkedList<E> next;

    public IterableGenericLinkedList(E data) {
        this.data = data;
    }

    public void appendToTail(E data) {
        IterableGenericLinkedList<E> tail = new IterableGenericLinkedList<>(data);
        IterableGenericLinkedList<E> n = this;

        while (n.next != null) {
            n = n.next;
        }
        n.next = tail;
    }

    public static <E> IterableGenericLinkedList<E> deleteNode(IterableGenericLinkedList<E> head, E data) {
        if (head == null) {
            return null;
        }

        if (head.data.equals(data)) {
            return head.next;
        }

        IterableGenericLinkedList<E> n = head;
        while (n.next != null) {
            if (n.next.data.equals(data)) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }

    @Override
    public String toString() {
        if (next == null) {
            return data.toString();
        }
        return data + "->" + next.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            IterableGenericLinkedList<E> pointer = IterableGenericLinkedList.this;

            @Override
            public boolean hasNext() {
                return pointer != null;
            }

            @Override
            public E next() {
                E nextNode = pointer.data;
                pointer = pointer.next;
                return nextNode;
            }

            @Override
            public void remove() {

            }
        };
    }

    public static void main(String[] args) {
        IterableGenericLinkedList<String> node1 = new IterableGenericLinkedList<>("One");
        node1.appendToTail("Two");
        node1.appendToTail("Three");
        node1.appendToTail("Four");
        node1.appendToTail("Five");
        node1.appendToTail("Six");
        System.out.println(node1.toString());

        for (String s : node1) {
            System.out.println(s);
        }
        for (String s : node1) {
            System.out.println(s);
        }
    }
}
