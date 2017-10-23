public class LinkedListNode {
    Object data;
    LinkedListNode next;

    public LinkedListNode(Object data) {
        this.data = data;
    }

    public void appendToTail(Object data) {
        LinkedListNode newNode = new LinkedListNode(data);
        LinkedListNode n = this;

        while (n.next != null) {
            n = n.next;
        }
        n.next = newNode;
    }

    public static LinkedListNode deleteNode(LinkedListNode head, Object data) {
        if (head == null) {
            return null;
        }

        if (head.data == data) {
            return head.next;
        }

        LinkedListNode n = head;
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

    public String printBackward() {
        if (next == null) {
            return String.valueOf(data);
        }
        return next.printBackward() + "->" + data;
    }

    public static String printForward(LinkedListNode node) {
        if (node.next == null) {
            return String.valueOf(node.data);
        }
        return node.data + "->" + printForward(node.next);
    }

    public static void printMe(LinkedListNode node) {
        if (node != null) {
            System.out.println(node.data);
            printMe(node.next);
        }
    }

    public static String printBackward(LinkedListNode node) {
        if (node.next ==null) {
            return String.valueOf(node.data);
        }
        return printBackward(node.next) + "->" + node.data;
    }

    public LinkedListNode appendLastNNodesToHead(int n) {
        if (n <= 0) {
            return null;
        }

        LinkedListNode p1 = this;
        LinkedListNode p2 = this;

        for (int i = 0; i < n - 1; i++) {
            if (p2.next != null) {
                p2 = p2.next;
            } else {
                return null;
            }
        }

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        this.next = p1;
        return this;
    }

    public LinkedListNode reverse() {
        LinkedListNode node = this;
        LinkedListNode previous = null;

        while (node != null) {
            LinkedListNode next = node.next;
            node.next = previous;
            previous = node;
            node = next;
        }
        return previous;
    }

    /**
     *  Recursive reverse with parameter
     *  Note the recursiveReverse(nextNode) call!
     *
     * @param node
     * @return
     */
    public static LinkedListNode recursiveReverse(LinkedListNode node) {
        if (node == null) {
            return null;
        } else if (node.next == null) {
            return node;
        }
        
        LinkedListNode nextNode = node.next;
        node.next = null;
        LinkedListNode rest = recursiveReverse(nextNode);
        nextNode.next = node;
        return rest;
    }

    /**
     *  Recursive reverse without parameter
     *  Note the nextNode.recursiveReverse() call!
     *
     *  Rule (linked list only): no parameter -> next.recursiveFunc()
     *
     * @return
     */
    public LinkedListNode recursiveReverse() {
        if (next == null) {
            return this;
        }

        LinkedListNode nextNode = this.next;
        this.next = null;
        LinkedListNode rest = nextNode.recursiveReverse();
        nextNode.next = this;
        return rest;
    }

    public static void main(String[] args) {
        LinkedListNode node1 = new LinkedListNode(1);
        node1.appendToTail(2);
        node1.appendToTail(3);
        node1.appendToTail(4);
        node1.appendToTail(5);
        node1.appendToTail(6);

        node1 = node1.recursiveReverse();
        System.out.println(node1.printForward());
        System.out.println(node1.printBackward());

        node1.appendLastNNodesToHead(3);
        System.out.println(node1.printForward());

        LinkedListNode node2 = node1.reverse();
        System.out.println(node2.printForward());

        LinkedListNode node3 = LinkedListNode.recursiveReverse(node2);
        System.out.println(node3.printForward());
    }
}