/**
 * Bubble Sort
 * Time complexity: O(n^2)
 * Space complexity: O(1)
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

/* Alternative version without while loop
import java.util.Arrays;

class BubbleSort {
    private static int[] sort(int[] array) {
        int temp_value;
        boolean swapped = true;

        // For-loop instead of while
        for (int i = array.length - 1; swapped && i >= 0; i--) {
            swapped = false;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) { // Out of order, swap
                    temp_value = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp_value;
                    swapped = true;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = {5, 3, -1, 13, 6, 2, 8};
        // Convert array to string to print out
        System.out.println(Arrays.toString(sort(array)));
    }
}
*/
