package com.company;

public class Main {

    public static void main(String[] args) {
    //Challenge Hello World
        System.out.println("Hello World");
    //Challenge – Printing output
        int age = 23;
        double height = 5.5;
        String name = "Sri";
        System.out.println("Name:" + name + ",Age:" + age + ",Height:" + height);
    //Challenge – operators
        int a = 20;
        int b = 10;

        int addition = a + b;
        int subtraction = a - b;
        int multiplication = a * b;
        int division = a / b;

        boolean isAGreaterThanB = a > b;

        boolean isAGreaterThanBAndBPositive = (a > b) && (b > 0);

        System.out.println("Addition: " + addition);
        System.out.println("Subtraction: " + subtraction);
        System.out.println("Multiplication: " + multiplication);
        System.out.println("Division: " + division);
        System.out.println("Is a greater than b? " + isAGreaterThanB);
        System.out.println("Is a > b and b > 0? " + isAGreaterThanBAndBPositive);
    //Challenge - Control Flow
        int score = 75;
        char grade = 'B';

        if (score >= 50) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        if (score >= 90) {
            grade = 'A';
        } else if (score >= 75) {
            grade = 'B';
        } else if (score >= 60) {
            grade = 'C';
        } else {
            grade = 'D';
        }

        System.out.println("Grade: " + grade);
    //Challenge – Loops
        System.out.print("For Loop: ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i);
            if (i < 5) {
                System.out.print(" ");
            }
        }
        System.out.println();

        System.out.print("While Loop: ");
        int j = 1;
        while (j <= 5) {
            System.out.print(j);
            if (j < 5) {
                System.out.print(" ");
            }
            j++;
        }
        System.out.println();

        System.out.print("Do-While Loop: ");
        int k = 1;
        do {
            System.out.print(k);
            if (k < 5) {
                System.out.print(" ");
            }
            k++;
        } while (k <= 5);
        System.out.println();
    //Challenge – Calculator
        double num1 = 7;
        double num2 = 3;
        char operator = '+';
        String again = "y";

        while (again.equals("y")) {
            double result = 0;
            boolean validOperation = true;

            if (operator == '+') {
                result = num1 + num2;
            } else if (operator == '-') {
                result = num1 - num2;
            } else if (operator == '*') {
                result = num1 * num2;
            } else if (operator == '/') {
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero.");
                    validOperation = false;
                } else {
                    result = num1 / num2;
                }
            } else {
                System.out.println("Invalid operator.");
                validOperation = false;
            }

            if (validOperation) {
                System.out.println("Result: " + result);
            }

            again = "n";
        }

        System.out.println("Thank you for using the calculator.");
    }
}
