/**
 * Created by Johannes Griesser (127003326) on 30/03/2015.
 *
 * Unordered Max Priority Queue
 *
 */
public class MaxUnorderedPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;

    // create an empty priority pq
    public MaxUnorderedPQ() {
        pq = (Key[]) new Comparable[10];
    }

    // create an empty priority pq with given capacity
    public MaxUnorderedPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
    }

    // create a priority pq with given keys
    public MaxUnorderedPQ(Key[] a) {
        pq = a;
    }

    // insert a key into the priority pq
    public void insert(Key x) {
        pq[N++] = x;
    }

    // return and remove the largest key
    public Key delMax() {
        int max = 0;
        for (int i = 1; i < N; i++) {
            if (less(max, i)) {
                max = i;
            }
        }
        exch(max, N - 1);
        return pq[--N];
    }

    private boolean less(int a, int b) {
        return pq[a].compareTo(pq[b]) < 0;
    }

    private void exch(int a, int b) {
        Key temp = pq[a];
        pq[a] = pq[b];
        pq[b] = temp;
    }

    // is the priority pq empty?
    boolean isEmpty() {
        return N == 0;
    }

    // return the largest key
    public Key max() {
        int max = 0;
        for (int i = 1; i < N; i++) {
            if (less(max, i)) {
                max = i;
            }
        }
        return pq[max];
    }

    // number of entries in the priority pq
    public int size() {
        return N;
    }

    public static void main(String[] args) {

    }
}
