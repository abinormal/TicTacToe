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

    public boolean hasWon(String player) {
        // Horizontal
        int countTop = 0;
        int countMiddle = 0;
        int countBottom = 0;
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[0][i].equals(player)) {
                countTop++;
            }
            if (gameBoard[1][i].equals(player)) {
                countMiddle++;
            }
            if (gameBoard[2][i].equals(player)) {
                countBottom++;
            }
        }
        // Vertical
        int countLeft = 0;
        int countCenter = 0;
        int countRight = 0;
        for (String[] strings : gameBoard) {
            if (strings[0].equals(player)) {
                countLeft++;
            }
            if (strings[1].equals(player)) {
                countCenter++;
            }
            if (strings[2].equals(player)) {
                countRight++;
            }
        }
        // Diagonal
        if (gameBoard[1][1].equals(player)) {
            if (gameBoard[0][0].equals(player) && gameBoard[2][2].equals(player) ||
                    gameBoard[0][2].equals(player) && gameBoard[2][0].equals(player)) {
                return true;
            }
        }

        return countTop == 3 || countMiddle == 3 || countBottom == 3 ||
                countLeft == 3 || countCenter == 3 || countRight == 3;
    }
}
