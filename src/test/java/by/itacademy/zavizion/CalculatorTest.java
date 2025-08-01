package by.itacademy.zavizion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}
