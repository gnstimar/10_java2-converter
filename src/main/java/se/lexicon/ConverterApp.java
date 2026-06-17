package se.lexicon;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConverterApp {
    static Scanner scanner = new Scanner(System.in);

    void main() {
        displayMenu();
        chooseOption();
    }

    static void displayMenu() {
        IO.println("==============================");
        IO.println("    LEXICON CONVERTER APP");
        IO.println("==============================");
        System.out.printf("%-1d. %-15s%n", 1, "Temperature Converter");
        System.out.printf("%-1d. %-15s%n", 2, "Weight Converter");
        System.out.printf("%-1d. %-15s%n", 3, "Grade Converter");
        System.out.printf("%-1d. %-15s%n", 4, "Exit");
        IO.println("==============================");
    }

    public static int readMenuItemNumber(String message) {
        while (true) {
            try {
                IO.print(message);
                int number = scanner.nextInt();
                if (number >= 1 && number <= 4) {
                    return number;
                } else {
                    IO.print("Error: The number is out of range! It must be between 1 and 4. ");
                }
            } catch (InputMismatchException e) {
                IO.println("ERROR: Invalid input! Please enter number only.");
                scanner.nextLine();
            }
        }
    }

    private void chooseOption() {
        int option = readMenuItemNumber("Choose an option: ");
        IO.println(option);
    }
}
