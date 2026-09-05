package com.company;

import java.util.Scanner;
import java.util.Random;
public class ChallengesDay3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to my REPL App!");
        String choice;

        // REPL loop
        while (true) {
            // Display menu
            System.out.println("\nadd");
            System.out.println("subtract");
            System.out.println("multiply");
            System.out.println("divide");
            System.out.println("random");
            System.out.println("reverse");
            System.out.println("quit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextLine();

            switch (choice) {
                case "add":
                    System.out.print("First Number: ");
                    int first = scanner.nextInt();
                    System.out.print("Second Number: ");
                    int second = scanner.nextInt();
                    System.out.println("Result: " + (first + second));
                    scanner.nextLine();
                    break;

                case "subtract":
                    System.out.print("First Number: ");
                    int first1 = scanner.nextInt();
                    System.out.print("Second Number: ");
                    int second1 = scanner.nextInt();
                    System.out.println("Result: " + (first1 - second1));
                    scanner.nextLine();
                    break;

                case "multiply":
                    System.out.print("First Number: ");
                    int first2 = scanner.nextInt();
                    System.out.print("Second Number: ");
                    int second2 = scanner.nextInt();
                    System.out.println("Result: " + (first2 * second2));
                    scanner.nextLine();
                    break;

                case "divide":
                    System.out.print("First Number: ");
                    int first3 = scanner.nextInt();
                    System.out.print("Second Number: ");
                    int second3 = scanner.nextInt();
                    if (second3 != 0) {
                        System.out.println("Result: " + (first3 / second3));
                    } else {
                        System.out.println("Cannot divide by zero!");
                    }
                    scanner.nextLine();
                    break;

                case "random":
                    System.out.print("Minimum: ");
                    int min = scanner.nextInt();
                    System.out.print("Maximum: ");
                    int max = scanner.nextInt();
                    Random rand = new Random();
                    // Generate random number between min and max (inclusive)
                    int randomNumber = rand.nextInt(max - min + 1) + min;
                    System.out.println("Random Number: " + randomNumber);
                    scanner.nextLine();
                    break;

                case "reverse":
                    System.out.print("Enter Text: ");
                    String line = scanner.nextLine();
                    String reversed = "";
                    for (int i = 0; i < line.length(); i++) {
                        reversed = line.charAt(i) + reversed;
                    }
                    System.out.println("Reversed: " + reversed);
                    break;

                case "quit":
                    System.out.println("Thank you for using the REPL App!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }


    }
}
