import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    private static final int Max_Attempts= 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;
        int totalRounds = 0;
        int totalScore = 0;

        do {
            totalRounds++;
            int score = playRound(scanner);
            totalScore += score;
            System.out.println("Your score for this round: " + score);
            System.out.println("Do you want to play again? (Yes/No)");
            playAgain = scanner.next().equalsIgnoreCase("Yes");
        } while (playAgain);

        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Total score: " + totalScore);
        scanner.close();
    }

    private static int playRound(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        int userGuess = 0;

        System.out.println("Guess a number between 1 and 100:");

        while (attempts < Max_Attempts) {
            attempts++;
            System.out.print("Attempt " + attempts + ": ");
            userGuess = scanner.nextInt();

            if (userGuess < numberToGuess) {
                System.out.println("Too low!");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Correct! You've guessed the number.");
                break;
            }
        }

        if (userGuess != numberToGuess) {
            System.out.println("Sorry! You've used all attempts. The number was: " + numberToGuess);
        }

        return Max_Attempts - attempts + 1; // Score based on remaining attempts
    }
}


