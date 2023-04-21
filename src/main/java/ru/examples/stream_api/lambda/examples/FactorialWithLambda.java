package ru.examples.stream_api.lambda.examples;

public class FactorialWithLambda {
}

interface NumericFunc {
    int func(int n);
}

class BlockLambdaDemo {
    public static void main(String[] args) {
        NumericFunc numericFunc = n -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = i * result;
            }
            return result;
        };

        System.out.println("Факториал числа 3 равен " + numericFunc.func(3));
        System.out.println("Факториал числа 5 равен " + numericFunc.func(5));
    }
}
