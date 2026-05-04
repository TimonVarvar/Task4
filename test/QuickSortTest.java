import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickSortTest {

    @Test
    @DisplayName("Должен сортировать обычный массив цветов и чисел")
    void testSort_NormalArray() {
        String[] colors = {"green", "blue", "red"};
        int[] numbers = {5, 8, 1};

        // Ожидаемый результат: 1 (red), 5 (green), 8 (blue)
        String[] expectedColors = {"red", "green", "blue"};
        int[] expectedNumbers = {1, 5, 8};

        QuickSort.sort(colors, numbers);

        assertArrayEquals(expectedNumbers, numbers, "Числа отсортированы неверно");
        assertArrayEquals(expectedColors, colors, "Цвета не соответствуют своим числам");
    }

    @Test
    @DisplayName("Должен обрабатывать уже отсортированный массив")
    void testSort_AlreadySorted() {
        String[] colors = {"A", "B", "C"};
        int[] numbers = {1, 2, 3};
        int[] expectedNumbers = {1, 2, 3};

        QuickSort.sort(colors, numbers);

        assertArrayEquals(expectedNumbers, numbers);
    }

    @ParameterizedTest
    @DisplayName("Параметризованный тест: разные входные данные")
    @MethodSource("sortTestData")
    void testSort_Parameterized(int[] inputNumbers, String[] inputColors, int[] expectedNumbers, String[] expectedColors) {
        QuickSort.sort(inputColors, inputNumbers);

        assertArrayEquals(expectedNumbers, inputNumbers);
        assertArrayEquals(expectedColors, inputColors);
    }

    static Stream<Arguments> sortTestData() {
        return Stream.of(
                // Массив в обратном порядке
                Arguments.of(
                        new int[]{10, 5, 0},
                        new String[]{"Black", "Gray", "White"},
                        new int[]{0, 5, 10},
                        new String[]{"White", "Gray", "Black"}
                ),
                // Одинаковые числа
                Arguments.of(
                        new int[]{2, 1, 2},
                        new String[]{"Two1", "One", "Two2"},
                        new int[]{1, 2, 2},
                        new String[]{"One", "Two2", "Two1"}
                ),
                // Один элемент
                Arguments.of(
                        new int[]{42},
                        new String[]{"Only"},
                        new int[]{42},
                        new String[]{"Only"}
                )
        );
    }
}
