/**
 * Created by Johannes Griesser (127003326) on 30/03/2015.
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(Key key, Value value) {
        put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value);
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else if (cmp == 0) {
            x.value = value;
        }
        return x;
    }

    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.value;
            }
        }
        return null;
    }

    public void delete(Key key) {

    }

    public Iterable<Key> keys() {
        // should normally be a Queue
        Deque<Key> d = new Deque<>();
        inOrder(d, root);
        return d;
    }

    private void inOrder(Deque d, Node node) {
        if (node == null) {
            return;
        }
        inOrder(d, node.left);
        d.addLast(node.key);
        inOrder(d, node.right);
    }
}
