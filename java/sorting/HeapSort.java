public class HeapSort {
    
    public static <E extends Comparable> void sort(E[] array) {
        // Build heap 
        for (int i = array.length/2; i >= 0; i--) {
            reheap(array, i, array.length-1);
        }
        
        // Sorting
        for (int i = array.length-1; i > 0; i--) {
            Swap.index(array, 0, i); // Take maximum from heap and swap to the end of the list
            reheap(array, 0, i-1); // Rebuild heap
        }
    }
 
    private static <E extends Comparable> void reheap(E[] array, int i, int limit) { // limit indicates the index where leaves start to occur
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        int child; // If the parent has both children

        if (leftChild <= limit && rightChild > limit) {
            // Only one (left) child available
            if (array[leftChild].compareTo(array[i]) > 0) {
                // Left child bigger than our node
                Swap.index(array, leftChild, i);
            }
        } else if (rightChild <= limit) {
            // Has left and right child, calculate bigger one
            if (array[leftChild].compareTo(array[rightChild]) > 0) {
                child = leftChild;
            } else {
                child = rightChild;
            }
            if (array[child].compareTo(array[i]) > 0) {
                // Bigger one is also bigger than our node
                Swap.index(array, i, child);
                reheap(array, child, limit);
            }
        }    
    }
}
