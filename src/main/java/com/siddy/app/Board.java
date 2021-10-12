package com.siddy.app;

public class Board {

    private final String[][] gameBoard;

    public Board() {
        gameBoard = new String[][]{{" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}};
    }

    public boolean makeMove(int x, int y, String player) {
        if (gameBoard[x][y].equals(" ")) {
            gameBoard[x][y] = player;
            return true;
        }
        return false;
    }

    public boolean hasWon(){
        int countXTop = 0;
        int countXMiddle = 0;
        int countXBottom = 0;
        for (int i = 0 ; i < gameBoard.length; i++){
            if (gameBoard[0][i].equals("X")){
                countXTop++;
            }
            if (gameBoard[1][i].equals("X")){
                countXMiddle++;
            }
            if (gameBoard[2][i].equals("X")){
                countXBottom++;
            }

        }
        return countXTop == 3 || countXMiddle == 3 || countXBottom == 3;
    }
}
