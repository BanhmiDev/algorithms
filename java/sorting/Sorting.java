import java.util.Random;

public class Sorting {

    public static <E extends Comparable> boolean apply(int algorithm, E[] input) {
        boolean success = true;
        switch (algorithm) {
            case 1:
                System.out.println("Using Selection Sort");
                SelectionSort.sort(input);    
                break;
            case 2:
                System.out.println("Using Insertion Sort");
                InsertionSort.sort(input);
                break;
            case 3:
                System.out.println("Using Bubble Sort");
                BubbleSort.sort(input);
                break;
            case 4:
                System.out.println("Using Heap Sort");
                HeapSort.sort(input);
                break;
            case 5:
                System.out.println("Using Merge Sort");
                MergeSort.sort(input);
                break;
            case 6:
                System.out.println("Using Quick Sort");
                QuickSort.sort(input);
                break;
            default:
                success = false;
                break;
        }
        return success;
    }

    public static <E extends Comparable> String read(E[] input) {
        String result = "";
        for (E element : input) {
            result += "[" + element + "]";
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            Random random = new Random();
            int algorithm = Integer.parseInt(args[0]);
            //E[] input = (E[])new Object[15];
            Integer[] input = new Integer[15];

            // TODO: array input
            for (int i = 0; i < 15; i++) {
                input[i] = random.nextInt(200) - 100;
            }

            System.out.println("\nInput: " + read(input));
            if (!apply(algorithm, input)) {
                System.out.println("Wrong algorithm index.");
            }
            System.out.println("Result: " + read(input) + "\n");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }
}
