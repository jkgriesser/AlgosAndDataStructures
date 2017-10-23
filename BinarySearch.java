/**
 * Created by Jberg on 23/05/15.
 */
public class BinarySearch {
    public static int binarySearch(int[] array, int value) {
        int min = 0;
        int max = array.length - 1;

        while (min <= max) {
            int index = min + (max - min) / 2;
            if (array[index] == value) return index;
            if (array[index] < value) min = index + 1;
            if (array[index] > value) max = index - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        System.out.println(binarySearch(array, 67));
        System.out.println(binarySearch(array, 68));
    }
}
