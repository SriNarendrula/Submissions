package com.company;

import java.util.Scanner;

public class ChallengesDay2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] scores = new int[5];

        System.out.println("Enter 5 test scores:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter score " + (i + 1) + ": ");
            scores[i] = scanner.nextInt();
        }

        int total = 0;
        int highest = scores[0];
        int lowest = scores[0];

        for (int i = 0; i < scores.length; i++) {
            total += scores[i];

            if (scores[i] > highest) {
                highest = scores[i];
            }

            if (scores[i] < lowest) {
                lowest = scores[i];
            }
        }

        double average = (double) total / scores.length;

        System.out.println("\nTotal: " + total);
        System.out.println("Average: " + (int) average);
        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);

        System.out.println("\nYour values were:");
        for (int i = 0; i < scores.length; i++) {
            char grade;

            if (scores[i] >= 90) {
                grade = 'A';
            } else if (scores[i] >= 80) {
                grade = 'B';
            } else if (scores[i] >= 70) {
                grade = 'C';
            } else if (scores[i] >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            System.out.println(scores[i] + " – " + grade);
        }

        double balance = 0.0;
        int choice;

        System.out.println("Welcome to Simple Banking System!");

        // REPL loop
        while (true) {
            // Display menu
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            choice = scanner.nextInt();

            if (choice == 1) {
                System.out.printf("Your current balance is: $%.2f\n", balance);

            } else if (choice == 2) {
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();

                if (depositAmount > 0) {
                    balance += depositAmount;
                    System.out.printf("Deposited: $%.2f\n", depositAmount);
                    System.out.printf("New balance: $%.2f\n", balance);
                } else {
                    System.out.println("Invalid amount. Deposit amount must be positive.");
                }

            } else if (choice == 3) {
                System.out.print("Enter withdrawal amount: $");
                double withdrawAmount = scanner.nextDouble();

                if (withdrawAmount > 0) {
                    if (withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        System.out.printf("Withdrew: $%.2f\n", withdrawAmount);
                        System.out.printf("New balance: $%.2f\n", balance);
                    } else {
                        System.out.println("Insufficient funds. Transaction cancelled.");
                        System.out.printf("Your current balance is: $%.2f\n", balance);
                    }
                } else {
                    System.out.println("Invalid amount. Withdrawal amount must be positive.");
                }

            } else if (choice == 4) {
                System.out.println("Thank you for using Simple Banking System!");
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

        scanner.close();


    }



}
