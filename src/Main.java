import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        String[] colors = {"green", "blue", "red"};
        int[] numbers = { 5, 8, 1};
        System.out.println("До:    " + Arrays.toString(colors) + " " + Arrays.toString(numbers));
        quickSort.sort(colors, numbers);
        System.out.println("После: " + Arrays.toString(colors) + " " + Arrays.toString(numbers));
    }
}
