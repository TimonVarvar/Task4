import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SimpleSortUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("QuickSort");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());


        JLabel label = new JLabel("Нажми кнопку, чтобы отсортировать:");
        JTextArea textArea = new JTextArea(5, 30);
        textArea.setEditable(false);
        JButton sortButton = new JButton("Отсортировать");


        String[] colors = {"green", "blue", "red"};
        int[] numbers = {5, 8, 1};

        textArea.setText("До: " + Arrays.toString(colors) + " " + Arrays.toString(numbers));


        sortButton.addActionListener(e -> {
            QuickSort.sort(colors, numbers); // Вызываем твой класс
            textArea.append("\nПосле: " + Arrays.toString(colors) + " " + Arrays.toString(numbers));
            sortButton.setEnabled(false); // Выключаем кнопку после нажатия
        });


        frame.add(textArea);
        frame.add(sortButton);


        frame.setVisible(true);
    }
}
