import java.util.Arrays;

public class BubbleSort {
	
	public void bubbleSort(int[] array) {
		int outerCount = 0, innerCount = 0;
		
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
				innerCount++;
			}
			outerCount++;
		}
		System.out.println(Arrays.toString(array));
		System.out.println("Outer: " + outerCount);
		System.out.println("Inner: " + innerCount);
	}
	
	public static void main(String[] args) {
		int[] array = {5, 2, 8, 7, 1, 9, 3};
		new BubbleSort().bubbleSort(array);
	}
}