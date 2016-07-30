import java.util.Arrays;
import java.util.LinkedList;

public class MergeSort {

	public static <E extends Comparable> LinkedList<E> merge(LinkedList<E> left, LinkedList<E> right) {
        LinkedList<E> sortedList = new LinkedList<E>();

        // Zipping
        while (left.size() > 0 && right.size() > 0) {
            E leftElement = left.getFirst();
            E rightElement = right.getFirst();
            if (leftElement.compareTo(rightElement) <= 0) {
                sortedList.addLast(leftElement);
                left.removeFirst();
            } else {
                sortedList.addLast(rightElement);
                right.removeFirst();
            }
        }

        // Remaining points
        while (left.size() > 0) {
            sortedList.addLast(left.getFirst());
            left.removeFirst();
        }

        while (right.size() > 0) {
            sortedList.addLast(right.getFirst());
            right.removeFirst();
        }
        return sortedList;
    }

    public static <E extends Comparable> void sort(E[] input) {
        LinkedList<E> list = new LinkedList<E>(Arrays.asList(input));
        LinkedList<E> result = mergeHelper(list); // Actual algorithm
        // Apply to our array
        for (int i = 0; i < input.length; i++) {
            input[i] = result.get(i);
        }
    }

    public static <E extends Comparable> LinkedList<E> mergeHelper(LinkedList<E> list) {
        if (list.size() < 2) {
            return list;
        }

        // Divide and conquer + merge
        int middle = list.size()/2;
        LinkedList<E> left = new LinkedList<E>(list.subList(0, middle));
        LinkedList<E> right = new LinkedList<E>(list.subList(middle, list.size()));
        return merge(mergeHelper(left), mergeHelper(right));
    }
}
