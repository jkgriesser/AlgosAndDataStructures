/**
 * Created by Johannes on 01/11/2014.
 */
public class Fibonacci {
    public static long fib(int n) {
        if (n <= 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    private static long[] memoisedFibs;

    public static long fibMemo(int n) {
        if (n <= 1) {
            return 1;
        }
        if (memoisedFibs == null || memoisedFibs.length < (n + 1)) {
            memoisedFibs = new long[n + 1];
        }
        if (memoisedFibs[n] != 0) {
            return memoisedFibs[n];
        }
        long fib = fibMemo(n - 1) + fibMemo(n - 2);
        memoisedFibs[n] = fib;
        return fib;

    }

    public static void main(String[] args) {
        System.out.println(fib(16));
        //System.out.println(fib(49));

        System.out.println(fibMemo(49));
        System.out.println(fibMemo(100));
    }
}
