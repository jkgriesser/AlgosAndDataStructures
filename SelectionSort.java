import java.util.Arrays;

public class SelectionSort {
	
	public void selectionSort(int[] array) {
		int outerCount = 0, innerCount = 0;
		
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
				innerCount++;
			}					
			outerCount++;
		}
		System.out.println(Arrays.toString(array));
		System.out.println("Outer: " + outerCount);
		System.out.println("Inner: " + innerCount);
	}
	
	public void moreEfficientSelectionSort(int[] array) {
		int outerCount = 0, innerCount = 0;
		
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[minIndex] > array[j]) {
					minIndex = j;
				}
				innerCount++;
			}	
			if (minIndex != i) {
				int temp = array[minIndex];
				array[minIndex] = array[i];
				array[i] = temp;
			}				
			outerCount++;
		}
		System.out.println(Arrays.toString(array));
		System.out.println("Outer: " + outerCount);
		System.out.println("Inner: " + innerCount);
	}
	
	public void sort(int[] data) {
		int outerCount = 0, innerCount = 0;
		for (int i = 0; i < data.length; i++) {
			int current = data[i];
			int j = i - 1;
			while (j >= 0 && data[j] >= current) {
				data[j+1] = data[j];
				j--;
				innerCount++;
			}
			data[j + 1] = current;
			outerCount++;
		}
		System.out.println(Arrays.toString(data));
		System.out.println("Outer: " + outerCount);
		System.out.println("Inner: " + innerCount);
	}

    public void sort(Comparable[] comparable) {
        for (int i = 0; i < comparable.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < comparable.length; j++) {
                if (comparable[minIndex].compareTo(comparable[j]) > 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Comparable temp = comparable[minIndex];
                comparable[minIndex] = comparable[i];
                comparable[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
		int[] array = {5, 2, 8, 7, 1, 9, 3};
		new SelectionSort().selectionSort(array);
		int[] array2 = {58, 47, 10, 45, 65, 40, 28, 92, 85, 19};
		new SelectionSort().moreEfficientSelectionSort(array2);
		int[] array3 = {5, 2, 8, 7, 1, 9, 3};
		new SelectionSort().sort(array3);

        String[] array4 = {"ENYA", "CAKE", "FUEL", "FIXX", "CHER",
                "LIVE", "TUFF", "KORN", "STYX", "BUSH", "BLUR", "MUSE",
                "INXS", "HOLE", "SOAD", "AQUA"};
        new SelectionSort().sort(array4);
	}
}