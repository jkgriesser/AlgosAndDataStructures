public class Tree {

    static class Node {
        Object data;
        Node[] adjacent = new Node[0];
        boolean visited;

        Node(Object data) {
            this.data = data;
        }
    }

    private static void visit(Node node) {
        System.out.println(node.data);
    }

    public static void depthFirstSearch(Node root) {
        if (root == null) {
            return;
        }

        visit(root);
        root.visited = true;

        for (Node node : root.adjacent) {
            if (!node.visited) {
                depthFirstSearch(node);
            }
        }
    }

    public static void breadthFirstSearch(Node root) {
        if (root == null) {
            return;
        }

        Queue queue = new Queue();
        visit(root);
        root.visited = true;
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Node node = (Node) queue.dequeue();
            for (Node n : node.adjacent) {
                if (!n.visited) {
                    visit(n);
                    n.visited = true;
                    queue.enqueue(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Tree.breadthFirstSearch(setUpSampleTree());
        Tree.depthFirstSearch(setUpSampleTree());
    }

    private static Node setUpSampleTree() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.adjacent = new Node[]{node2, node3};
        node2.adjacent = new Node[]{node4, node5};
        node3.adjacent = new Node[]{node6, node7};
        return node1;
    }
}
