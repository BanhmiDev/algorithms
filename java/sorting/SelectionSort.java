/**
 * Selection Sort
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
import java.util.Arrays;

class SelectionSort {
    private static int[] sort(int[] array) {
        int n = array.length;
        int min, temp_value;

        for (int i = 0; i < n-1; i++) {
            min = i;
            for (int j = i+1; j < n; j++) {
                if (array[j] < array[min])
                    min = j;
            }

            if (min != i) {
                temp_value = array[min];
                array[min] = array[i];
                array[i] = temp_value;
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
