import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class SimpleSortUI {
    static String[] colors = {"green", "blue", "red"};
    static int[] numbers = {5, 8, 1};

    public static void main(String[] args) {
        JFrame frame = new JFrame("QuickSort");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 350);
        frame.setLayout(new FlowLayout());

        JTextArea textArea = new JTextArea(10, 35);
        textArea.setEditable(false);

        JButton randomButton = new JButton("Случайные данные");
        JButton sortButton = new JButton("Отсортировать");

        textArea.setText("Текущие данные:\n" + Arrays.toString(colors) + "\n" + Arrays.toString(numbers));

        randomButton.addActionListener(e -> {
            Random rand = new Random();
            int size = 5;
            colors = new String[size];
            numbers = new int[size];

            String[] pool = {"Yellow", "Pink", "Black", "White", "Orange"};
            for (int i = 0; i < size; i++) {
                numbers[i] = rand.nextInt(100);
                colors[i] = pool[rand.nextInt(pool.length)];
            }

            textArea.setText("Сгенерировано:\n" + Arrays.toString(colors) + "\n" + Arrays.toString(numbers));
            sortButton.setEnabled(true);
        });

        sortButton.addActionListener(e -> {
            QuickSort.sort(colors, numbers);
            textArea.append("\n\nРезультат:\n" + Arrays.toString(colors) + "\n" + Arrays.toString(numbers));
            sortButton.setEnabled(false);
        });


        frame.add(new JScrollPane(textArea));
        frame.add(randomButton);
        frame.add(sortButton);

        frame.setVisible(true);
    }
}
