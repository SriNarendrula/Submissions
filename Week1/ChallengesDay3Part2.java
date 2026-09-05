package com.company;
import java.util.Scanner;

public class ChallengesDay3Part2 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Create a password: ");
        String password = scanner.nextLine();

        boolean hasMinLength = password.length() >= 8;
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }

        if (hasMinLength && hasUppercase && hasLowercase && hasDigit) {
            System.out.println("Password accepted!\n");
        } else {
            System.out.println("Password rejected:");
            if (!hasMinLength) {
                System.out.println("Must be at least 8 characters");
            }
            if (!hasUppercase) {
                System.out.println("Must contain an uppercase letter");
            }
            if (!hasLowercase) {
                System.out.println("Must contain a lowercase letter");
            }
            if (!hasDigit) {
                System.out.println("Must contain a number");
            }
            System.out.println();
        }

        System.out.print("Enter a word or sentence: ");
        String text = scanner.nextLine();

        int characters = text.length();
        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int spaces = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isDigit(ch)) {
                digits++;
            } else if (Character.isWhitespace(ch)) {
                spaces++;
            } else if (Character.isLetter(ch)) {
                char lowerCh = Character.toLowerCase(ch);
                if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' ||
                        lowerCh == 'o' || lowerCh == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Characters: " + characters);
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Spaces: " + spaces);

    }
}
