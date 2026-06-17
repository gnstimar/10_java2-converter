package se.lexicon;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConverterApp {
    static Scanner scanner = new Scanner(System.in);
    static String[] converters = {"Temperature Converter", "Weight Converter", "Grade Converter", "Exit"};
    static int option = 0;
    static boolean shouldContinue = true;

    void main() {
        while (shouldContinue) {
            displayMenu();
            option = readMenuItemNumber("Choose an option: ");
            IO.println();
            switch (option) {
                case 1:
                    handleTemperatureConverter();
                    break;
                case 2:
                    handleWeightConverter();
                    break;
                case 3:
                    gradeConverter();
                    break;
                case 4:
                    IO.println("Goodbye!");
                    return;
                default:
                    IO.println("Invalid option! Please try again.");
            }
            IO.println();
            shouldContinue = askToContinue("Continue? (yes/no): ");
            IO.println();
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

    public static boolean askToContinue(String message) {
        while (true) {
            IO.print(message);
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("yes")) {
                return true;
            } else if (answer.equalsIgnoreCase("no")) {
                IO.println("Goodbye!");
                return false;
            } else {
                IO.println("Error: Invalid input! Please type 'yes' or 'no'.");
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

    private static double readDouble(String message, boolean isNegativeAllowed) {
        while (true) {
            try {
                IO.print(message);
                double number = scanner.nextDouble();
                if (number < 0 && !isNegativeAllowed) {
                    IO.println("Error: The number is out of range! It must be a positive number. ");
                } else {
                    return number;
                }
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
            double celsius = readDouble("Enter temperature in Celsius: ", true);
            double fahrenheit = convertCelsiusToFahrenheit(celsius);
            System.out.printf("%-6s : %-8.2f C = %7.2f F%n", "Result", celsius, fahrenheit);
        } else if (choice == 2) {
            double fahrenheit = readDouble("Enter temperature in Fahrenheit: ", true);
            double celsius = convertFahrenheitToCelsius(fahrenheit);
            System.out.printf("%-6s : %-8.2f F = %7.2f C%n", "Result", fahrenheit, celsius);
        }
    }

    private static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    private static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    public static void handleWeightConverter() {
        IO.println("--- Weight Converter ---");
        IO.println("Convert:");
        IO.println("1. Kilograms to Grams");
        IO.println("2. Kilograms to Pounds");
        int choice = readInt("Your choice: ");
        double kilogram = readDouble("Enter weight in Kilograms: ", false);
        if (choice == 1) {
            double gram = convertKilogramToGram(kilogram);
            System.out.printf("%-6s : %8.2f kg = %7.2f g%n", "Result", kilogram, gram);
        } else if (choice == 2) {
            double pound = convertKilogramToPound(kilogram);
            System.out.printf("%-6s : %8.2f kg = %7.2f lb%n", "Result", kilogram, pound);
        }
    }

    public static double convertKilogramToGram(double kilogram) {
        return kilogram * 1000;
    }

    public static double convertKilogramToPound(double kilogram) {
        return kilogram * 2.20462;
    }

    private static float readGrade(String message) {
        while (true) {
            try {
                IO.print(message);
                float number = scanner.nextFloat();
                if (number >= 0 && number <= 100) {
                    return number;
                } else {
                    IO.println("Error: The number is out of range! It must be between 0 and 100. ");
                }
            } catch (InputMismatchException e) {
                IO.println("ERROR: Invalid input! Please enter number only.");
                scanner.nextLine();
            }
        }
    }

    public static void gradeConverter() {
        IO.println("--- Grade Converter ---");
        int grade = Math.round(readGrade("Enter grade: "));
        System.out.print("Grade: ");
        if (grade < 60) {
            IO.println("F -> Fail");
        } else if (grade < 70) {
            IO.println("D -> Below average");
        } else if (grade < 80) {
            IO.println("C -> Pass");
        } else if (grade < 90) {
            IO.println("B -> Good");
        } else {
            IO.println("A -> Excellent");
        }
    }
}
