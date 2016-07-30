/**
 * Selection Sort
 */
import java.util.Arrays;

class SelectionSort {

    public static <E extends Comparable<? super E>> void sort(E[] array) {
        E max;
        int maxIndex;

        for (int i = array.length-1; i > 0; i--) {
            max = array[i];
            maxIndex = i;
            for (int j = 0; j < i; j++) {
                if (array[j].compareTo(max) > 0) {
                    max = array[j];
                    maxIndex = j;
                }
            }
            Swap.index(array, i, maxIndex);
        }
    }           
}
