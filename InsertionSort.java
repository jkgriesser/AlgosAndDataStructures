import java.util.Arrays;

public class InsertionSort {
	
	public void insertionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int temp = array[i+1];
			int j;

			for (j = i + 1; j > 0 && temp < array[j - 1]; j--) {
				array[j] = array[j - 1];
			}
			array[j] = temp;
		}
		System.out.println(Arrays.toString(array));
	}

	// better
    public void insertionSort2(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j;

			for (j = i - 1; j >= 0 && temp < array[j]; j--) {
				array[j + 1] = array[j];
			}
			array[j + 1] = temp;
		}
		System.out.println(Arrays.toString(array));
	}

    public void insertionSort(Comparable[] comparable) {
        for (int i = 0; i < comparable.length - 1; i++) {
            Comparable temp = comparable[i+1];
            int j;

            for (j = i + 1; j > 0 && temp.compareTo(comparable[j - 1]) < 0; j--) {
                comparable[j] = comparable[j - 1];
            }
            comparable[j] = temp;
        }
    }

	public static void main(String[] args) {
        int[] array = {5, 2, 8, 7, 1, 9, 3};
        new InsertionSort().insertionSort(array);

        String[] array4 = {"ENYA", "CAKE", "FUEL", "FIXX", "CHER",
                "LIVE", "TUFF", "KORN", "STYX", "BUSH", "BLUR", "MUSE",
                "INXS", "HOLE", "SOAD", "AQUA"};
        new InsertionSort().insertionSort(array4);
    }
}