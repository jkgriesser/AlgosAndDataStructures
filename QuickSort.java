/**
 * Created by Johannes on 22/03/2015.
 */
public class QuickSort {

    public static void sort(Comparable[] array) {
        StdRandom.shuffle(array);
        sort(array, 0, array.length - 1);
    }

    public static void sort3Way(Comparable[] array) {
        StdRandom.shuffle(array);
        sort3Way(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int p = partition(array, lo, hi);
        sort(array, lo, p - 1);
        sort(array, p + 1, hi);
    }

    private static void sort3Way(Comparable[] array, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int lt = lo, gt = hi;
        Comparable v = array[lo];
        int i = lo;

        while (i <= gt) {
            int cmp = array[i].compareTo(v);
            if (cmp < 0) {
                exch(array, lt++, i++);
            } else if (cmp > 0) {
                exch(array, i, gt--);
            } else {
                i++;
            }
        }

        sort3Way(array, lo, lt - 1);
        sort3Way(array, gt + 1, hi);
    }

    private static int partition(Comparable[] array, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        while (true) {
            while (less(array[++i], array[lo])) {
                if (i == hi) {
                    break;
                }
            }
            while (less(array[lo], array[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(array, i, j);
        }

        exch(array, lo, j);
        return j;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] array, int from, int to) {
        Comparable temp = array[to];
        array[to] = array[from];
        array[from] = temp;
    }

    public static Comparable select(Comparable[] array, int k) {
        StdRandom.shuffle(array);
        int lo = 0, hi = array.length - 1;

        while (hi > lo) {
            int j = partition(array, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                return array[k];
            }
        }
        return array[k];
    }

    public static void main(String[] args) {
        Integer[] a1 = new Integer[] {29, 35, 13, 56, 47, 14, 50, 69, 10, 52, 70, 94};
        sort(a1);
        for (Integer integer : a1) {
            System.out.print(integer + " ");
        }
        System.out.println();

        String[] a2 = new String[]{"B", "B", "A", "A", "B", "A", "B", "A", "B", "B", "A", "A"};
        sort(a2);
        for (String string : a2) {
            System.out.print(string + " ");
        }
        System.out.println();

        String[] a3 = new String[]{"puce", "silk", "fawn", "jade", "flax", "rose", "kobi", "dust", "ecru", "corn", "bone", "cafe"};
        sort3Way(a3);
        for (String string : a3) {
            System.out.print(string + " ");
        }
    }
}
