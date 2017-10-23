import java.util.NoSuchElementException;

/**
 * Created by Johannes Griesser (127003326) on 30/03/2015.
 *
 * Binary Heap Max Priority Queue
 */
public class MaxPQ<Key extends Comparable<Key>> {

    // array 1-indexed
    private Key[] pq;
    private int N;

    public MaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public void insert(Key key) {
        pq[++N] = key;
        swim(N);
    }

    public Key delMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }

        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N + 1] = null;
        return max;
    }

    private boolean less(int a, int b) {
        return pq[a].compareTo(pq[b]) < 0;
    }

    private void exch(int a, int b) {
        Key temp = pq[a];
        pq[a] = pq[b];
        pq[b] = temp;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        return pq[N];
    }

    public int size() {
        return N;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    public static <Key extends Comparable<Key>> void main(String[] args) {
        MaxPQ<Integer> maxPQ  = new MaxPQ<>(20);
        maxPQ.pq = new Integer[]{0, 93, 82, 88, 66, 53, 12, 14, 34, 19, 18, 0, 0, 0};
        maxPQ.N = 10;
        maxPQ.insert(41);
        maxPQ.insert(77);
        maxPQ.insert(39);
        for (Integer key : maxPQ.pq) {
            System.out.print(key + " ");
        }
        System.out.println();

        maxPQ.pq = new Integer[]{0, 93, 88, 73, 49, 87, 45, 53, 30, 24, 81};
        maxPQ.N = 10;
        maxPQ.delMax();
        maxPQ.delMax();
        maxPQ.delMax();
        for (Integer key : maxPQ.pq) {
            System.out.print(key + " ");
        }
    }
}
