/**
 * Created by Jberg on 06/09/2014.
 */
public class GenericDoublyLinkedListNode<E> {
    E data;
    GenericDoublyLinkedListNode<E> next;
    GenericDoublyLinkedListNode<E> prev;

    public GenericDoublyLinkedListNode(E data) {
        this.data = data;
    }

    public void appendToTail(E data) {
        GenericDoublyLinkedListNode<E> tail = new GenericDoublyLinkedListNode<>(data);
        GenericDoublyLinkedListNode<E> n = this;

        while (n.next != null) {
            n = n.next;
        }
        n.next = tail;
        tail.prev = n;
    }

    public void insertAtElement(E newData, E element) {
        GenericDoublyLinkedListNode<E> newNode = new GenericDoublyLinkedListNode<>(newData);
        GenericDoublyLinkedListNode<E> n = this;

        while (n.next != null) {
            if (n.data == element) {
                newNode.prev = n;
                newNode.next = n.next;
                n.next.prev = newNode;
                n.next = newNode;
                break;
            }
            n = n.next;
        }
    }

    @Override
    public String toString() {
        if (next == null) {
            return data.toString();
        }
        return data.toString() + "<->" + next.toString();
    }

    public String toReverseString() {
        if (next == null) {
            return data.toString();
        }
        return next.toString() + "<->" + data;
    }

    public static void main(String[] args) {
        GenericDoublyLinkedListNode<Integer> head = new GenericDoublyLinkedListNode<>(1);
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(4);
        head.appendToTail(5);
        head.appendToTail(6);
        System.out.println(head.toString());
        System.out.println(head.toReverseString());
        head.insertAtElement(99, 4);
        System.out.println(head.toString());
    }
}
