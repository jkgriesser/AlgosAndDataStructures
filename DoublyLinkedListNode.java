/**
 * Created by Jberg on 06/09/2014.
 */
public class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int data) {
        this.data = data;
    }

    public void appendToTail(int data) {
        DoublyLinkedListNode tail = new DoublyLinkedListNode(data);
        DoublyLinkedListNode n = this;

        while (n.next != null) {
            n = n.next;
        }
        n.next = tail;
        tail.prev = n;
    }

    public void insertAtElement(int newData, int element) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(newData);
        DoublyLinkedListNode n = this;

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
            return data + "";
        }
        return data + "<->" + next.toString();
    }

    public String toReverseString() {
        if (next == null) {
            return data + "";
        }
        return next.toReverseString() + "<->" + data;
    }

    public static void main(String[] args) {
        DoublyLinkedListNode head = new DoublyLinkedListNode(1);
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
