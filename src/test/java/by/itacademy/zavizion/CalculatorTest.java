package by.itacademy.zavizion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void createCalculatorInstance() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Проверка метода сложения положительных чисел: 2 + 8 = 10")
    public void testSumPositive() {
        int actual = calculator.sum(2, 8);
        Assertions.assertEquals(actual, 10);
    }

    @Test
    @DisplayName("Проверка метода сложения отрицательных чисел: -12 + (-5) = -17")
    public void testSumNegative() {
        int actual = calculator.sum(-12, -5);
        Assertions.assertEquals(actual, -17);
    }

    @Test
    @DisplayName("Проверка метода сложения положительного с отрицательным чиселом: -33 + 7 = -26")
    public void testSumPositiveAndNegative() {
        int actual = calculator.sum(-33, 7);
        Assertions.assertEquals(actual, -26);
    }

    @Test
    @DisplayName("Проверка метода сложения положительного числа с нулем: 5 + 0 = 5")
    public void testSumPositiveAndZero() {
        int actual = calculator.sum(5, 0);
        Assertions.assertEquals(actual, 5);
    }

    @Test
    @DisplayName("Проверка метода сложения отрицательного числа с нулем: -17 + 0 = -17")
    public void testSumNegativeAndZero() {
        int actual = calculator.sum(-17, 0);
        Assertions.assertEquals(actual, -17);
    }

    @Test
    @DisplayName("Проверка сложения нулей: 0 + 0 = 0")
    public void testSumZeros() {
        int actual = calculator.sum(0, 0);
        Assertions.assertEquals(actual, 0);
    }

    @Test
    @DisplayName("Проверка переполнения при сложении")
    public void testSumOverflowThrowsException() {
        assertThrows(ArithmeticException.class, () -> calculator.sum(Integer.MAX_VALUE, 1));
    }

    @Test
    @DisplayName("Проверка метода вычитания из большего положительного числа меньшее положительное число : 10 - 2 = 8")
    public void testSubtractionSmallPositiveFromBigPositive() {
        int actual = calculator.subtract(10, 2);
        Assertions.assertEquals(actual, 8);
    }

    @Test
    @DisplayName("Проверка метода вычитания из меньшего положительного числа большее положительное число : 5 - 12 = -7")
    public void testSubtractionBigPositiveFromSmallPositive() {
        int actual = calculator.subtract(5, 12);
        Assertions.assertEquals(actual, -7);
    }

    @Test
    @DisplayName("Проверка метода вычитания из положительного числа отрицательное : 6 - (-4) = 20")
    public void testSubtractionNegativeFromPositive() {
        int actual = calculator.subtract(6, -14);
        Assertions.assertEquals(actual, 20);
    }

    @Test
    @DisplayName("Проверка метода вычитания из отрицательного числа положительное : -123 - 15 = -138")
    public void testSubtractionPositiveFromNegative() {
        int actual = calculator.subtract(-123, 15);
        Assertions.assertEquals(actual, -138);
    }

    @Test
    @DisplayName("Проверка метода вычитания из отрицательного числа отрицательное : -33 - (-14) = -19")
    public void testSubtractionNegativeFromNegative() {
        int actual = calculator.subtract(-33, -14);
        Assertions.assertEquals(actual, -19);
    }

    @Test
    @DisplayName("Проверка метода вычитания из положительного числа ноль: 234 - 0 = 234")
    public void testSubtractionZeroFromPositive() {
        int actual = calculator.subtract(234, 0);
        Assertions.assertEquals(actual, 234);
    }

    @Test
    @DisplayName("Проверка метода вычитания из нуля положительного числа: 0 - 17 = -17")
    public void testSubtractionPositiveFromZero() {
        int actual = calculator.subtract(-17, 0);
        Assertions.assertEquals(actual, -17);
    }

    @Test
    @DisplayName("Проверка метода вычитания нуля из нуля: 0 - 0 = 0")
    public void testSubtractionZeroFromZero() {
        int actual = calculator.subtract(0, 0);
        Assertions.assertEquals(actual, 0);
    }

    @Test
    @DisplayName("Проверка переполнения при вычитании")
    public void testSubtractOverflowThrowsException() {
        assertThrows(ArithmeticException.class, () -> calculator.subtract(Integer.MIN_VALUE, 1));
    }

    @Test
    @DisplayName("Проверка метода умножения положительного числа на положительное число: 12 * 3 = 36")
    public void testMultiplicationPositiveOnPositive() {
        int actual = calculator.multiply(12, 3);
        Assertions.assertEquals(actual, 36);
    }

    @Test
    @DisplayName("Проверка метода умножения отрицательного числа на положительное число: -15 * 3 = -45")
    public void testMultiplicationNegativeOnPositive() {
        int actual = calculator.multiply(-15, 3);
        Assertions.assertEquals(actual, -45);
    }

    @Test
    @DisplayName("Проверка метода умножения положительного числа на отрицательное число: 25 * (-4) = -100")
    public void testMultiplicationPositiveOnNegative() {
        int actual = calculator.multiply(25, -4);
        Assertions.assertEquals(actual, -100);
    }

    @Test
    @DisplayName("Проверка метода умножения отрицательного числа на отрицательное число: -100 * (-3) = 300")
    public void testMultiplicationNegativeOnNegative() {
        int actual = calculator.multiply(-100, -3);
        Assertions.assertEquals(actual, 300);
    }

    @Test
    @DisplayName("Проверка метода умножения нуля на отрицательное число: 0 * (-999) = 0")
    public void testMultiplicationPositiveOnZero() {
        int actual = calculator.multiply(0, -999);
        Assertions.assertEquals(actual, 0);
    }

    @Test
    @DisplayName("Проверка метода умножения позитивного числа на единицу: 444 * 1 = 444")
    public void testMultiplicationPositiveOnOne() {
        int actual = calculator.multiply(444, 1);
        Assertions.assertEquals(actual, 444);
    }

    @Test
    @DisplayName("Проверка метода умножения единицы на негативное число: 1 * -678 = -678")
    public void testMultiplicationOneOnNegative() {
        int actual = calculator.multiply(1, -678);
        Assertions.assertEquals(actual, -678);
    }

    @Test
    @DisplayName("Проверка переполнения при умножении")
    public void testMultiplyOverflowThrowsException() {
        assertThrows(ArithmeticException.class, () -> calculator.multiply(Integer.MAX_VALUE, 2));
    }

    @Test
    @DisplayName("Проверка метода деления положительного числа на положительного число: 36 / 5 = 7")
    public void testDividePositiveByPositive() {
        double actual = calculator.divide(36, 5);
        Assertions.assertEquals(actual, 7);
    }

    @Test
    @DisplayName("Проверка метода деления положительного числа на отрицательное число: 100 / (-5) = -20")
    public void testDividePositiveByNegative() {
        double actual = calculator.divide(100, -5);
        Assertions.assertEquals(actual, -20);
    }

    @Test
    @DisplayName("Проверка метода деления отрицательного числа на положительное число: -16 / 4 = -4")
    public void testDivideNegativeByPositive() {
        double actual = calculator.divide(-16, 4);
        Assertions.assertEquals(actual, -4);
    }

    @Test
    @DisplayName("Проверка метода деления отрицательного числа на отрицательное число: -40 / (-6) = 6")
    public void testDivideNegativeByNegative() {
        double actual = calculator.divide(-40, -6);
        Assertions.assertEquals(actual, 6);
    }

    @Test
    @DisplayName("Проверка метода деления положительного числа на единицу: 56 / 1 = 56")
    public void testDividePositiveByOne() {
        double actual = calculator.divide(56, 1);
        Assertions.assertEquals(actual, 56);
    }

    @Test
    @DisplayName("Проверка метода деления отрицательного числа на единицу: -100 / 1 = -100")
    public void testDivideNegativeByOne() {
        double actual = calculator.divide(-100, 1);
        Assertions.assertEquals(actual, -100);
    }

    @Test
    @DisplayName("Проверка метода деления нуля на положительное число: 0 / 99 = 0")
    public void testDivideZeroByPositive() {
        double actual = calculator.divide(0, 99);
        Assertions.assertEquals(actual, 0);
    }

    @Test
    @DisplayName("Проверка метода деления нуля на отрицательное число: 0 / -13 = 0")
    public void testDivideZeroByNegative() {
        double actual = calculator.divide(0, -13);
        Assertions.assertEquals(actual, 0);
    }

    @Test
    @DisplayName("Проверка метода деления на ноль: 567 / 0 = 0")
    public void testExceptionDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(567, 0));
    }
}
