public class QuickSort {

    private static <E extends Comparable> int partition(E[] a, int begin, int end) {
        E pivot = a[end];
        int i = begin-1;
        int j = begin;

        while (j < end) {
            if (a[j].compareTo(pivot) <= 0) { // Item smaller than pivot
                i++;
                Swap.index(a, i, j);
            }
            j++;
        }

        // Put pivot in correct position
        int pivotIndex = i + 1;
        Swap.index(a, pivotIndex, end);
        return pivotIndex;
    }

    private static <E extends Comparable> void quick(E[] a, int begin, int end) {
        if (end > begin) {
            // Divide and conquer
            int pivotIndex = partition(a, begin, end);
            quick(a, begin, pivotIndex-1);
            quick(a, pivotIndex+1, end);
        }

    }

    public static <E extends Comparable> void sort(E[] a) {
        quick(a, 0, a.length-1);
    }
}
