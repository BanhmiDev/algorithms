class BubbleSort {

    public static <E extends Comparable> void sort(E[] array) {
        int upper = array.length-1;
        boolean swapped;
        
        do {
            swapped = false;
            for (int i = 0; i < upper; i++) {
                if (array[i].compareTo(array[i+1]) > 0) {
                    Swap.index(array, i, i+1);
                    swapped = true;
                }
            }
            upper--;
        } while (swapped);
    }
}

/* Alternative version without while loop
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
}
*/
