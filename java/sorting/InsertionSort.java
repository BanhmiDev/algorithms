public class InsertionSort {

    public static <E extends Comparable> void sort(E[] array) {
        E element;
        int j;
        for (int i = 1; i < array.length; i++) {
            element = array[i]; // Current element to be analyzed
            j = i-1;
            while (j >= 0 && element.compareTo(array[j]) < 0) {
                // Check current with values on the left side, swap bigger elements to the right 
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = element; // Swap current saved element where it belongs to
        }
    }
}
