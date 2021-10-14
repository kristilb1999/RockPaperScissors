package com.mthree.assessment1;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        int numRounds;
        int userWins;
        int compWins;
        int tie;

        int compChoice;
        int userChoice;

        String userAnswer;

        boolean stillPlaying = false;

        //always play the first round
        do {

            //reset variables in case of more than one game
            userWins = 0;
            compWins = 0;
            tie = 0;

            //prompt for and save number of rounds
            System.out.print("How many rounds of Rock, Paper, Scissors would you like to play? ");
            numRounds = in.nextInt();

            //check to make sure valid number of rounds or quit program
            if(numRounds >= 1 && numRounds <= 10) {
                System.out.println("Great! Let's play " + numRounds + " games!");
                System.out.println();
            } else {
                System.out.println("ERROR: Invalid number of games. Please choose between 1 and 10 games.");
                System.exit(0);
            }

            //play rock,paper,scissors for desired number of rounds
            for(int i = 0; i < numRounds; i++) {
                System.out.println("1 = Rock, 2 = Paper, or 3 = Scissors");
                System.out.print("Please enter the integer corresponding to your choice: ");
                userChoice = in.nextInt();

                compChoice = rand.nextInt(3) + 1;

                if(compChoice == userChoice) {
                    System.out.println("It's a tie!");
                    tie++;
                } else if(compChoice == 1 && userChoice == 3 || compChoice == 2 && userChoice == 1 || compChoice == 3 && userChoice == 2) {
                    System.out.println("The computer wins! You lost :(");
                    compWins++;
                } else {
                    System.out.println("You win!! The computer lost.");
                    userWins++;
                }
                System.out.println();
            }

            //state the results of the game
            System.out.println("The computer won " + compWins + " time(s), the user won " + userWins + " time(s), and you had " + tie + " tie(s).");
            if(compWins > userWins) {
                System.out.println("The computer won the most!! You lose.");
            } else if(userWins > compWins) {
                System.out.println("You won the most games!! Congratulations!");
            } else {
                System.out.println("In the end, you tied with the computer.");
            }

            //prompt for a new game or quit
            System.out.println();
            System.out.print("Do you want to play again? (y/n) ");
            userAnswer = in.next();

            if(userAnswer.equalsIgnoreCase("n")) {
                System.out.println("Thanks for playing!");
                stillPlaying = false;
            } else if(userAnswer.equalsIgnoreCase("y")) {
                System.out.println("Great! Let's play again.");
                stillPlaying = true;
            }

            System.out.println();


        } while(stillPlaying);



    }

}
