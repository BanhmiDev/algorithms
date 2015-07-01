/**
 * Bubblesort
 * Version: 1
 * Desc: Goes through the list (multiple times) and compares 
 *       adjacent items and swaps those that are out of order.
 */
import java.util.Arrays;

class BubbleSort {
    private static int[] sort(int[] array) {
        int n = array.length;
        boolean swapped = true;
        
        while (swapped) {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i-1] > array[i]) {
                    // Swap
                    int temp_value = array[i-1];
                    array[i-1] = array[i];
                    array[i] = temp_value;
                    swapped = true;
                }
            }
            n--;
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = {5, 3, -1, 13, 6, 2, 8};
        // Convert array to string to print out
        System.out.println(Arrays.toString(sort(array)));
    }
}
