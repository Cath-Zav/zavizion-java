package by.itacademy.zavizion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
   private Calculator calculator;

    @BeforeEach
    public void createCalculatorInstance(){
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


}
