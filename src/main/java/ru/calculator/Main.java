package ru.calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Calculator calculator = new Calculator(input.split(" "));
        String result = calculator.execute();
        System.out.println(result);
    }

}
