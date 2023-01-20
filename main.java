// Game

import java.util.Random;
import java.util.Scanner;

public class Yahtzee {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] dice = new int[5];
        int rollCount = 0;

        // Game loop
        while (rollCount < 3) {
            System.out.println("Rolling the dice...");
            for (int i = 0; i < dice.length; i++) {
                dice[i] = rand.nextInt(6) + 1;
            }
            rollCount++;

            // Print out the current roll
            for (int die : dice) {
                System.out.print(die + " ");
            }
            System.out.println();

            // Allow the player to select which dice to re-roll
            System.out.println("Which dice would you like to re-roll? (Enter the die numbers separated by spaces)");
            
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");

            for (String token : tokens) {
                int die = Integer.parseInt(token);
                if (die >= 1 && die <= 5) {
                    dice[die - 1] = rand.nextInt(6) + 1;
                }
            }
            // ...
        }

        // Count the number of each value rolled
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }

        // Print out the counts
        for (int i = 0; i < counts.length; i++) {
            System.out.println((i + 1) + ": " + counts[i]);
        }

        // Determine the score
        int score = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] >= 3) {
                score = (i + 1) * 100;
                if (counts[i] == 5) {
                    score += 50;
                }
                break;
            }
        }
        System.out.println("Your score: " + score);
    }
}
