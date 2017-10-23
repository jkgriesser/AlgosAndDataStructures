/**
 * Created by Johannes Griesser (127003326) on 30/03/2015.
 */
public class HeapSort {

    public static void sort(Comparable[] arr) {
        int N = arr.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(arr, k, N);
        }
        while (N > 1) {
            exch(arr, 1, N);
            sink(arr, 1, --N);
        }
    }

    private static void sink(Comparable[] arr, int k, int N) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && less(arr, j, j + 1)) {
                j++;
            }
            if (!less(arr, k, j)) {
                break;
            }
            exch(arr, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] arr, int a, int b) {
        return arr[a - 1].compareTo(arr[b - 1]) < 0;
    }

    private static void exch(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a - 1];
        arr[a - 1] = arr[b - 1];
        arr[b - 1] = temp;
    }
}
