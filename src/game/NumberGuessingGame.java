package game;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int maxAttempts = 5;
        int totalScore = 0;
        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = rand.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("New Round: Guess a number between 1 and 100");

            while (attempts < maxAttempts && !guessedCorrectly) 
            {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) 
                {
                    System.out.println("Congratulations! You guessed correctly in " + attempts + " attempts.");
                    totalScore += (maxAttempts - attempts + 1) * 10; // Points based on attempts
                    guessedCorrectly = true;
                } else if (userGuess < randomNumber) 
                {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) 
            {
                System.out.println("Out of attempts! The correct number was " + randomNumber);
            }

            System.out.println("Your score for this round is: " + totalScore);
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }
        System.out.println("Final score: " + totalScore);
        System.out.println("Thanks for playing!");
    }
}
