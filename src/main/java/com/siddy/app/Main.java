package com.siddy.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final Board board = new Board();

    public static void main(String[] args) {

        boolean isPlayerOnesGo = true;
        String player1 = "O";
        String player2 = "X";

        while (true) {
            try {
                board.printBoard();
                takeGo(isPlayerOnesGo ? player1 : player2);
                isPlayerOnesGo = !isPlayerOnesGo;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                // Add y/n to continue here
                if (continuePlaying()){
                    isPlayerOnesGo = true;
                    board.resetBoard();
                } else {
                    System.out.println("Thank you for playing");
                    break;
                }
            }
        }
    }

    private static void takeGo(String player) throws Exception{

        while (true) {
            System.out.print("Your go " + player +": ");
            int[] move = getCMDNumbers();
            if (board.makeMove(move[0], move[1], player)) {
                if (board.hasWon(player)) {
                    throw new Exception("Congratulations " + player + " you are the winner!");
                }
                return;
            } else {
                System.out.println("Space already taken");
            }
        }
    }

    private static String getCommand() {
        String inputString = "";
        try {
            inputString = reader.readLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return inputString;
    }

    private static int[] getCMDNumbers() {
        String size;
        boolean hasSize = false;
        do {
            size = getCommand();
            if (!size.matches("^[0-2]+( [0-2]+)")) System.out.println("Must be two numbers 0-2 separated by a single space.");
            else hasSize = true;
        } while (!hasSize);
        String[] pSize = size.split(" ");
        return new int[]{Integer.parseInt(pSize[0]), Integer.parseInt(pSize[1])};
    }

    private static boolean continuePlaying() {
        String response;
        boolean haveResponse = false;
        do {
            System.out.print("Would you like to play again? y/n: ");
            response = getCommand();
            if (response.matches("^[yn]")) haveResponse = true;
            else System.out.println("Must be either y or n");
        } while (!haveResponse);
        return response.equals("y");
    }
}
