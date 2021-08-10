package ru.calculator;

public class ExpressionVerifier {

    public boolean isRomanDigitExpression(String firstNumber, String secondNumber) {
        return DigitConverter.isRomanDigit(firstNumber) && DigitConverter.isRomanDigit(secondNumber);
    }

    public boolean isArabicDigitExpression(String firstNumber, String secondNumber) {
        try {
            int f = Integer.parseInt(firstNumber);
            int s = Integer.parseInt(secondNumber);

            if ((f < 1 || f > 10) || (s < 1 || s > 10)) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

}
