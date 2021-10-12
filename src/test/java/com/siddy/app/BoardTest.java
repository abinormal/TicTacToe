package com.siddy.app;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BoardTest {

    Board gameBoard;

    @Before
    public void setup(){
        gameBoard = new Board();
    }

    @Test
    public void checkSpaceNotAlreadyTaken(){
        assertEquals(true, gameBoard.makeMove(1,1,"X"));
    }

    @Test
    public void checkSpaceIsAlreadyTaken(){
        gameBoard.makeMove(0,1,"O");
        assertEquals(false, gameBoard.makeMove(0,1,"X"));
    }

    @Test
    public void checkWinnerIfRowTaken(){
        gameBoard.makeMove(0,0, "X");
        gameBoard.makeMove(0,1, "X");
        gameBoard.makeMove(0,2, "X");
        assertEquals(true, gameBoard.hasWon());
    }

    @Test
    public void checkSecondRowTaken(){
        gameBoard.makeMove(1,0,"X");
        gameBoard.makeMove(1,1,"X");
        gameBoard.makeMove(1,2,"X");
        assertEquals(true, gameBoard.hasWon());
    }

}
