package se.lexicon;

public class ConverterApp {

    void main() {
        displayMenu();

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
}
