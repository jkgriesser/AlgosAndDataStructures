import java.util.NoSuchElementException;

/**
 * Created by Johannes Griesser (127003326) on 30/03/2015.
 *
 * Binary Heap Min Priority Queue
 */
public class MinimumPQ<Key extends Comparable<Key>> {

    // array 1-indexed
    private Key[] pq;
    private int N;

    public MinimumPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public void insert(Key key) {
        pq[++N] = key;
        swim(N);
    }

    public Key delMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }

        Key min = pq[1];
        exch(1, N--);
        sink(1);
        pq[N + 1] = null;
        return min;
    }

    private boolean greater(int a, int b) {
        return pq[a].compareTo(pq[b]) > 0;
    }

    private void exch(int a, int b) {
        Key temp = pq[a];
        pq[a] = pq[b];
        pq[b] = temp;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        return pq[N];
    }

    public int size() {
        return N;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        MinimumPQ<Integer> minPQ  = new MinimumPQ<>(20);
        minPQ.pq = new Integer[]{0, 93, 82, 88, 66, 53, 12, 14, 34, 19, 18, 0, 0, 0};
        minPQ.N = 10;
        minPQ.insert(41);
        minPQ.insert(77);
        minPQ.insert(39);
        for (Integer key : minPQ.pq) {
            System.out.print(key + " ");
        }
        System.out.println();

        minPQ.pq = new Integer[]{0, 93, 88, 73, 49, 87, 45, 53, 30, 24, 81};
        minPQ.N = 10;
        minPQ.delMin();
        minPQ.delMin();
        minPQ.delMin();
        for (Integer key : minPQ.pq) {
            System.out.print(key + " ");
        }
    }
}
