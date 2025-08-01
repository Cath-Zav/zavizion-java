package by.itacademy.zavizion;

public class Calculator implements ICalculator {

    @Override
    public int sum(int a, int b) {
        int result = 0;
        try {
            result = Math.addExact(a, b);
        } catch(ArithmeticException e) {
            System.out.println("Ошибка переполнения при сложении");
        }
        return result;
    }

    @Override
    public int subtract(int a, int b) {
        int result = 0;
        try {
            result = Math.subtractExact(a, b);
        } catch (ArithmeticException e){
            System.out.println("Ошибка переполнения при вычитании");
        }
        return result;
    }

    @Override
    public int multiply(int a, int b) {
        int result = 0;
        try {
            result = Math.multiplyExact(a, b);
        } catch(Exception e) {
            System.out.println("Ошибка переполнения при умножении");
        }
        return result;
    }

    @Override
    public double divide(int a, int b) {
        double result = 0;
        try{
            result = a / b;
        } catch(Exception e) {
            System.out.println("Ошибка деления на ноль");
        }
        return result;
    }
}
