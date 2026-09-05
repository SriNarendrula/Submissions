package com.company;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
public class ChallengesDay4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDate today = LocalDate.now();

        System.out.println("Date: " + today);
        System.out.println("Year: " + today.getYear());
        System.out.println("Month: " + today.getMonth());
        System.out.println("Day: " + today.getDayOfMonth());

        System.out.println();

        System.out.print("Enter your birth date (YYYY-MM-DD): ");
        String birthDateInput = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateInput);

        Period age = Period.between(birthDate, today);
        System.out.println("You are " + age.getYears() + " years old.");

        System.out.println();

        System.out.print("Enter your birthday (YYYY-MM-DD): ");
        String birthdayInput = scanner.nextLine();
        LocalDate birthday = LocalDate.parse(birthdayInput);

        LocalDate nextBirthday = birthday.withYear(today.getYear());

        if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }

        long daysUntilBirthday = ChronoUnit.DAYS.between(today, nextBirthday);
        System.out.println("Days until your next birthday: " + daysUntilBirthday);

        scanner.close();

    }
}
