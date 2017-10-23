/**
 * Created by Johannes on 22/03/2015.
 */
public class MergeSort {

    public static void sort(Comparable[] array) {
        Comparable[] aux = new Comparable[array.length];
        sort(array, aux, 0, array.length - 1);
    }

    public static void sortBottomUp(Comparable[] array) {
        int N = array.length;
        Comparable[] aux = new Comparable[N];

        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(array, aux, lo, lo + sz - 1,
                        Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    private static void sort(Comparable[] array, Comparable[] aux,
                             int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2; // doesn't overflow unlike (hi + lo) / 2
        sort(array, aux, lo, mid);
        sort(array, aux, mid + 1, hi);
        merge(array, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] array, Comparable[] aux,
                              int lo, int mid, int hi) {
        assert isSorted(array, lo, mid); // precondition: a[lo..mid] sorted
        assert isSorted(array, mid + 1, hi); // precondition: a[mid+1..hi] sorted

        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                array[k] = aux[j++];
            } else if (j > hi) {
                array[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                array[k] = aux[j++];
            } else {
                array[k] = aux[i++];
            }
        }

        assert isSorted(array, lo, hi); // postcondition: a[lo..hi] sorted
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] a1 = new Integer[] {76, 66, 20, 14, 67, 10, 80, 57, 65, 90, 99, 79};
        sort(a1);
        for (Integer integer : a1) {
            System.out.print(integer + " ");
        }
        System.out.println();

        String[] a2 = new String[]{"puce", "silk", "fawn", "jade", "flax", "rose", "kobi", "dust", "ecru", "corn", "bone", "cafe"};
        sort(a2);
        for (String string : a2) {
            System.out.print(string + " ");
        }
        System.out.println();

        String[] a3 = new String[]{"puce", "silk", "fawn", "jade", "flax", "rose", "kobi", "dust", "ecru", "corn", "bone", "cafe"};
        sortBottomUp(a3);
        for (String string : a3) {
            System.out.print(string + " ");
        }
    }
}
