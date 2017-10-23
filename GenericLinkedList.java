/**
 * Created by Jberg on 06/09/2014.
 */
public class GenericLinkedList<E> {
    E data;
    GenericLinkedList<E> next;

    public GenericLinkedList(E data) {
        this.data = data;
    }

    public void appendToTail(E data) {
        GenericLinkedList<E> tail = new GenericLinkedList<>(data);
        GenericLinkedList<E> n = this;

        while (n.next != null) {
            n = n.next;
        }
        n.next = tail;
    }

    public static <E> GenericLinkedList<E> deleteNode(GenericLinkedList<E> head, E data) {
        if (head == null) {
            return null;
        }

        if (head.data.equals(data)) {
            return head.next;
        }

        GenericLinkedList<E> n = head;
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

    public String toReverseString() {
        if (next == null) {
            return data.toString();
        }
        return next.toReverseString() + "->" + data;
    }

    public static void main(String[] args) {
        GenericLinkedList<String> node1 = new GenericLinkedList<>("One");
        node1.appendToTail("Two");
        node1.appendToTail("Three");
        node1.appendToTail("Four");
        node1.appendToTail("Five");
        node1.appendToTail("Six");
        System.out.println(node1.toString());
        System.out.println(node1.toReverseString());

        GenericLinkedList<String> node2 = GenericLinkedList.deleteNode(node1, "One");
        System.out.println(node2.toString());

        node2 = GenericLinkedList.deleteNode(node2, "Four");
        System.out.println(node2.toString());

        node2 = GenericLinkedList.deleteNode(node2, "Six");
        System.out.println(node2.toString());
    }
}
