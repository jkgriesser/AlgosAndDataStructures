import java.util.Iterator;

public class IterableLinkedListNode implements Iterable<IterableLinkedListNode> {
    int data;
    IterableLinkedListNode next;

    public IterableLinkedListNode(int data) {
        this.data = data;
    }

    public void appendToTail(int data) {
        IterableLinkedListNode newNode = new IterableLinkedListNode(data);
        IterableLinkedListNode n = this;

        while (n.next != null) {
            n = n.next;
        }
        n.next = newNode;
    }

    public static IterableLinkedListNode deleteNode(IterableLinkedListNode head, int data) {
        if (head == null) {
            return null;
        }

        if (head.data == data) {
            return head.next;
        }

        IterableLinkedListNode n = head;
        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }

    public String printForward() {
        if (next == null) {
            return String.valueOf(data);
        }
        return data + "->" + next.printForward();
    }

    @Override
    public Iterator<IterableLinkedListNode> iterator() {
        return new Iterator<IterableLinkedListNode>() {
            IterableLinkedListNode pointer = IterableLinkedListNode.this;

            @Override
            public boolean hasNext() {
                return pointer != null;
            }

            @Override
            public IterableLinkedListNode next() {
                IterableLinkedListNode nextNode = pointer;
                pointer = pointer.next;
                return nextNode;
            }

            @Override
            public void remove() {

            }
        };
    }

    public static void main(String[] args) {
        IterableLinkedListNode node1 = new IterableLinkedListNode(1);
        node1.appendToTail(2);
        node1.appendToTail(3);
        node1.appendToTail(4);
        node1.appendToTail(5);
        node1.appendToTail(6);

        System.out.println(node1.printForward());

        for (IterableLinkedListNode iLLNode : node1) {
            System.out.println(iLLNode.data);
        }
        for (IterableLinkedListNode iLLNode : node1) {
            System.out.println(iLLNode.data);
        }
    }
}