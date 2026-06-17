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
            option = readMenuItemNumber("Choose an option: ");
            switch (option) {
                case 1:
                    handleTemperatureConverter();
                    break;
                case 2:
                    IO.println("You chose 2nd option");
                    break;
                case 3:
                    IO.println("You chose 3rd option");
                    break;
                case 4:
                    IO.println("You chose 4th option");
                    break;
                default:
                    IO.println("Invalid option! Please try again.");
                    break;
            }
        }
    }

    public static void displayMenu() {
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

    private static int readInt(String message) {
        while (true) {
            try {
                IO.print(message);
                int number = scanner.nextInt();
                if (number >= 1 && number <= 2) {
                    return number;
                } else {
                    IO.println("Error: The number is out of range! It must be between 1 and 2. ");
                }
            } catch (InputMismatchException e) {
                IO.println("ERROR: Invalid input! Please enter number only.");
                scanner.nextLine();
            }
        }
    }

    private static double readDouble(String message) {
        while (true) {
            try {
                IO.print(message);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                IO.println("ERROR: Invalid input! Please enter number only.");
                scanner.nextLine();
            }
        }
    }

    public static void handleTemperatureConverter() {
        IO.println("--- Temperature Converter ---");
        IO.println("Convert:");
        IO.println("1. Celsius to Fahrenheit");
        IO.println("2. Fahrenheit to Celsius");
        int choice = readInt("Your choice: ");
        if (choice == 1) {
            double celsius = readDouble("Enter temperature in Celsius: ");
            double fahrenheit = convertCelsiusToFahrenheit(celsius);
            System.out.printf("%-6s : %-8.2f C = %8.2f F%n", "Result", celsius, fahrenheit);
        } else if (choice == 2) {
            double fahrenheit = readDouble("Enter temperature in Fahrenheit: ");
            double celsius = convertFahrenheitToCelsius(fahrenheit);
            System.out.printf("%-6s : %-8.2f F = %8.2f C%n", "Result", fahrenheit, celsius);
        }
    }

    private static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    private static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }
}
