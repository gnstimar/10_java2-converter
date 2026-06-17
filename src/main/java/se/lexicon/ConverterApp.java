package se.lexicon;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConverterApp {
    static Scanner scanner = new Scanner(System.in);
    static String[] converters = {"Temperature Converter", "Weight Converter", "Grade Converter", "Exit"};
    static int option = 0;

    void main() {
        while (option != converters.length) {
            displayMenu();
            option = chooseOption();
        }
    }

    static void displayMenu() {
        IO.println("==============================");
        IO.println("    LEXICON CONVERTER APP");
        IO.println("==============================");
        for (int i = 0; i < converters.length; i++) {
            System.out.printf("%-1d. %-15s%n", i + 1, converters[i]);
        }
        IO.println("==============================");
    }

    public static int readMenuItemNumber(String message) {
        while (true) {
            try {
                IO.print(message);
                int number = scanner.nextInt();
                if (number >= 1 && number <= converters.length) {
                    return number;
                } else {
                    IO.println("Error: The number is out of range! It must be between 1 and " + converters.length + ". ");
                }
            } catch (InputMismatchException e) {
                IO.println("ERROR: Invalid input! Please enter number only.");
                scanner.nextLine();
            }
        }
    }

    private int chooseOption() {
        return readMenuItemNumber("Choose an option: ");
    }
}
