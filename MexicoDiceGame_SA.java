package com.company;

import java.util.*;
import java.util.stream.IntStream;

public class MexicoDiceGame_SA {
    static Scanner in = new Scanner(System.in);
    static Random r = new Random();
    final static int[] rollScores = {21, 66, 55, 44, 33, 22, 11, 65, 64, 63, 62, 61, 54, 53, 52, 51, 43, 42, 41, 32, 31};
    static int[] scores = {0, 0, 0}, lives = {6, 6, 6};

    public static int rollDice() {
        return r.nextInt(6) + 1; //returns random number from 1 - 6
    }

    public static int findIndex(int[] a, int t) {
        return IntStream.range(0, a.length).filter(i -> t == a[i]).findFirst().orElse(-1); //finds index of number in array
    }

    public static int initialRoll() {
        int[] rolls = new int[3];

        while (true) {
            for (int i = 0; i < 3; i++) {
                rolls[i] = rollDice(); //assigns dice roll number to each player
                System.out.println("Player " + (i + 1) + " rolls " + rolls[i]);
            }

            if (rolls[0] > rolls[1] && rolls[0] > rolls[2]) { //returns player with the highest roll
                return 0;
            } else if (rolls[1] > rolls[0] && rolls[1] > rolls[2]) {
                return 1;
            } else if (rolls[2] > rolls[1] && rolls[2] > rolls[0]) {
                return 2;
            } else {
                System.out.println("Tied, rolling again"); //rolls again if players are tied for highest roll
            }
        }
    }

    public static int nextPlayer(int turn) {
        return turn == 2 ? 0 : turn + 1; //returns next player in order, goes back to player 1 if player is 3
    }

    public static int roll(int turn, int i) {
        int rolls = rollDice() * 10 + rollDice(); //player rolls two die
        if (rolls / 10 < rolls % 10) {
            rolls = rolls % 10 * 10 + rolls / 10; //reorder roll results so higher number is first
        }
        System.out.println("Player " + (turn + 1) + " rolls " + (rolls / 10) + "-" + (rolls % 10));
        if (rolls == 21 && i == 0) {
            System.out.println("Mexico!"); //outputs mexico if player rolls 2-1 and the player is the first to roll or previous player also rolled mexico
        }
        return findIndex(rollScores, rolls); //returns rank of roll from rollScores array
    }

    public static int playerTurn(int turn, int count, int i) {
        boolean cont = true;
        String choice;
        int rollNum = 1;

        while (cont) {
            scores[turn] = roll(turn, i); //stores rank of roll from rollScores array

            if (rollNum < count && scores[turn] != 0) { //rolls again if player still has roles left and if they didn't score 2-1
                System.out.println("Roll again? (yes or no)");
                choice = in.nextLine(); //inputs choice of whether to roll again
                if (choice.equals("yes")) {
                    rollNum++; //number of rolls increases if rolls again
                } else {
                    cont = false; //turn ends if they don't want to roll again
                }
            } else {
                cont = false; //turn ends if out of rolls or if they scored mexico
            }
        }
        System.out.println();

        return scores[turn] == 0 ? 4 : rollNum; //returns number of rolls for next player, special case if previous players rolled mexico
    }

    public static int Loser(int lowestScore) {
        int loser = findIndex(scores, lowestScore); //losing score is assigned to any player that holds the lowest score

        if (scores[loser] == scores[nextPlayer(loser)] && scores[loser] == scores[nextPlayer(nextPlayer(loser))]) {
            System.out.println("Tie!"); //Tied if all players have the same score
            return r.nextInt(3); //First player in next round is random
        } else if (scores[loser] == scores[nextPlayer(loser)]) {
            System.out.println("Players " + (loser + 1) + " and " + (nextPlayer(loser) + 1) + " lose!"); //Tie between two players who both have the lowest score
            lives[loser]--; //Losers each lose a life
            lives[nextPlayer(loser)]--;
            return r.nextInt(3); //First player in next round is random
        } else if (scores[loser] == scores[nextPlayer(nextPlayer(loser))]) {
            System.out.println("Players " + (loser + 1) + " and " + (nextPlayer(nextPlayer(loser)) + 1) + " lose!"); //Tie between two players who both have the lowest score
            lives[loser]--; //Losers each lose a life
            lives[nextPlayer(nextPlayer(loser))]--;
            return r.nextInt(3); //First player in next round is random
        } else {
            System.out.println("Player " + (loser + 1) + " lost!"); //Only one player has the lowest score
            lives[loser]--; //Loser loses a life
            return loser; //First player in next round is the loser
        }
    }

    public static void main(String[] args) {
        int turn, count = 1, lowestScore = rollScores.length - 1; //lowestScore is currently 3-1

        System.out.println("\nInitial rolls");
        turn = initialRoll(); //determine first player to roll by rolling highest number
        System.out.println("Player " + (turn + 1) + " rolls first\n");

        while (lives[0] > 0 && lives[1] > 0 && lives[2] > 0) { //game continues for as along as all players are alive
            for (int i = 0; i < 3; i++) { //3 players roll
                if (i == 0) {
                    count = playerTurn(turn, 3, 0); //first player has up to 3 rolls and determines number of rolls other players have
                    lowestScore = scores[turn]; //first rolls assigned to lowest score
                } else {
                    turn = nextPlayer(turn); //roll is given to next player in order
                    if (count == 4) {
                        count = playerTurn(turn, 3, 0); //if previous players rolled mexico, next player is assigned role of first player and determines number of rolls for next players
                    } else {
                        playerTurn(turn, count, i); //players are limited to number of rolls set by first player
                    }
                    if (scores[turn] > lowestScore) {
                        lowestScore = scores[turn]; //adjust lowest score every turn
                    }
                }
            }

            turn = Loser(lowestScore); //Determine loser(s), lives lost, and who starts the next round
            System.out.println("Lives: " + lives[0] + ", " + lives[1] + ", " + lives[2] + "\n"); //Update lives of each player
        }

        System.out.println("End of Game");
    }
}