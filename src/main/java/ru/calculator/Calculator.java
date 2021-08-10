package ru.calculator;

public class Calculator {

    private final String[] args;
    private final ExpressionVerifier verifier;

    public Calculator(String[] args) {
        verifier = new ExpressionVerifier();
        this.args = args;
    }

    public String execute() {
        if (args.length != 3) {
            throw new IllegalArgumentException();
        }

        String firstNumber = args[0];
        String secondNumber = args[2];
        String operation = args[1];

        if (verifier.isArabicDigitExpression(firstNumber, secondNumber)) {
            return String.valueOf(calculate(Integer.parseInt(firstNumber), operation, Integer.parseInt(secondNumber)));
        } else if (verifier.isRomanDigitExpression(firstNumber, secondNumber)) {
            int result = calculate(DigitConverter.romanToArabic(firstNumber), operation, DigitConverter.romanToArabic(secondNumber));
            if (result < 1) {
                throw new IllegalArgumentException();
            }
            return DigitConverter.arabicToRoman(result);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private int calculate(int first, String op, int second) {
        return switch (op) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> throw new UnsupportedOperationException();
        };
    }
}
