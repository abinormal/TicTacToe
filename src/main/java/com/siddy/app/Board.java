package com.siddy.app;

public class Board {

    private final String[][] gameBoard;

    public Board() {
        gameBoard = new String[][]{{" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}};
    }

    public boolean makeMove(int x, int y, String player) {
        // Check the move is valid
        if (x > 2 || x < 0 || y > 2 || y < 0) {
            // System.out.println("This move, it is not ready yet!");
            return false;
        }
        if (gameBoard[x][y].equals(" ")) {
            gameBoard[x][y] = player;
            return true;
        }
        return false;
    }

    public boolean hasWon() {
        // Horizontal
        int countXTop = 0;
        int countXMiddle = 0;
        int countXBottom = 0;
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[0][i].equals("X")) {
                countXTop++;
            }
            if (gameBoard[1][i].equals("X")) {
                countXMiddle++;
            }
            if (gameBoard[2][i].equals("X")) {
                countXBottom++;
            }
        }
        // Vertical
        int countXLeft = 0;
        int countXCenter = 0;
        int countXRight = 0;
        for (String[] strings : gameBoard) {
            if (strings[0].equals("X")) {
                countXLeft++;
            }
            if (strings[1].equals("X")) {
                countXCenter++;
            }
            if (strings[2].equals("X")) {
                countXRight++;
            }
        }
        // Diagonal
        if (gameBoard[1][1].equals("X")) {
            if (gameBoard[0][0].equals("X") && gameBoard[2][2].equals("X") ||
                    gameBoard[0][2].equals("X") && gameBoard[2][0].equals("X")) {
                return true;
            }
        }

        return countXTop == 3 || countXMiddle == 3 || countXBottom == 3 ||
                countXLeft == 3 || countXCenter == 3 || countXRight == 3;
    }
}
