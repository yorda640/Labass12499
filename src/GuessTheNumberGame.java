

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {

    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        Scanner scanner = new Scanner(System.in);
        int lowerBound = 1;
        int upperBound = 100;
        int randomNumber = generateRandomNumber(lowerBound, upperBound);
        int numberOfAttempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("Try to guess the number between " + lowerBound + " and " + upperBound);

        while (!hasGuessedCorrectly) {
            try {
                int userGuess = getUserInput(scanner, lowerBound, upperBound);
                numberOfAttempts++;

                if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    hasGuessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the correct number in " + numberOfAttempts + " attempts.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

    private static int generateRandomNumber(int lowerBound, int upperBound) {
        Random random = new Random();
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }

    private static int getUserInput(Scanner scanner, int lowerBound, int upperBound) {
        System.out.print("Enter your guess: ");
        int userGuess = scanner.nextInt();

        if (userGuess < lowerBound || userGuess > upperBound) {
            throw new IllegalArgumentException("Invalid input! Please enter a number between " + lowerBound + " and " + upperBound + ".");
        }

        return userGuess;
    }
}

