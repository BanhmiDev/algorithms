/**
 * This class is used for simple swapping on generic data types. 
 */
public class Swap {

    /**
    * Swap two values via indices.
    * @param array The array 
    * @param a The first index
    * @param b The second index
    */
    public static <E> void index(E[] array, int a, int b) {
        E temp = array[a];
        array[a] = array[b];
        array[b] = temp; 
    }
}
