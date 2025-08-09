package by.itacademy.zavizion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void createCalculatorInstance() {
        calculator = new Calculator();
    }


    @ParameterizedTest
    @CsvSource({
            "2, 8, 10",
            "-12, -5, -17",
            "-33, 7, -26",
            "5, 0, 5",
            "-17, 0, -17",
            "0, 0, 0"
    })
    @DisplayName("Проверка метода сложения")
    public void testSum(int a, int b, int expected) {
        int actual = calculator.sum(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка переполнения при сложении")
    public void testSumOverflowThrowsException() {
        assertThrows(ArithmeticException.class, () -> calculator.sum(Integer.MAX_VALUE, 1));
    }

    @ParameterizedTest
    @CsvSource({
                    "10, 2, 8",
                    "5, 12, -7",
                    "6, -14, 20",
                    "-123, 15, -138",
                    "-33, -14, -19",
                    "234, 0, 234",
                    "0, 17, -17",
                    "0, 0, 0"
            })
    @DisplayName("Проверка метода вычитания")
    public void testSubtractionSmallPositiveFromBigPositive(int a, int b, int expected) {
        int actual = calculator.subtract(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка переполнения при вычитании")
    public void testSubtractOverflowThrowsException() {
        assertThrows(ArithmeticException.class, () -> calculator.subtract(Integer.MIN_VALUE, 1));
    }

    @ParameterizedTest
    @CsvSource({
                    "12, 3, 36",
                    "-15, 3, -45",
                    "25, -4, -100",
                    "100, -3, -300",
                    "0, 999, 0",
                    "444, 1, 444",
                    "1, -678, -678",
            })
    @DisplayName("Проверка метода умножения")
    public void testMultiplicationOneOnNegative(int a, int b, int expected) {
        int actual = calculator.multiply(a, b);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Проверка переполнения при умножении")
    public void testMultiplyOverflowThrowsException() {
        assertThrows(ArithmeticException.class, () -> calculator.multiply(Integer.MAX_VALUE, 2));
    }

    @ParameterizedTest
    @CsvSource({
            "36, 5, 7",
            "100, -5, -20",
            "-16, 4, -4",
            "-40, -6, 6",
            "56, 1, 56",
            "-100, 1, -100",
            "0, 99, 0",
            "0, -13, 0"
    })
    @DisplayName("Проверка метода деления")
    public void testDividePositiveByPositive(int a, int b, int expected) {
        double actual = calculator.divide(a, b);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Проверка метода деления на ноль: 567 / 0 = 0")
    public void testExceptionDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(567, 0));
    }
}
