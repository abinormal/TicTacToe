package com.siddy.app;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BoardTest {

    Board gameBoard;

    @Before
    public void setup(){
        gameBoard = new Board();
    }

    // Test the makeMove method
    @Test
    public void checkSpaceNotAlreadyTaken(){
        assertTrue(gameBoard.makeMove(1,1,"X"));
    }

    @Test
    public void checkSpaceIsAlreadyTaken(){
        gameBoard.makeMove(0,1,"O");
        assertFalse(gameBoard.makeMove(0,1,"X"));
    }

    @Test
    public void checkBadXMove(){
        assertFalse(gameBoard.makeMove(3,0,"O"));
    }

    @Test
    public void checkBadMinusXMove(){
        assertFalse(gameBoard.makeMove(-1,2,"O"));
    }

    @Test
    public void checkBadYMove(){
        assertFalse(gameBoard.makeMove(2,4,"O"));
    }

    @Test
    public void checkBadMinusYMove(){
        assertFalse(gameBoard.makeMove(2,-2,"O"));
    }

    // Is there a winner?
    @Test
    public void checkWinnerIfRowTaken(){
        gameBoard.makeMove(0,0, "X");
        gameBoard.makeMove(0,1, "X");
        gameBoard.makeMove(0,2, "X");
        assertTrue(gameBoard.hasWon());
    }

    @Test
    public void checkSecondRowTaken(){
        gameBoard.makeMove(1,0,"X");
        gameBoard.makeMove(1,1,"X");
        gameBoard.makeMove(1,2,"X");
        assertTrue(gameBoard.hasWon());
    }

    @Test
    public void checkThirdRowTaken(){
        gameBoard.makeMove(2,0,"X");
        gameBoard.makeMove(2,1,"X");
        gameBoard.makeMove(2,2,"X");
        assertTrue(gameBoard.hasWon());
    }

    @Test
    public void checkXNotWin(){
        gameBoard.makeMove(2,0,"X");
        gameBoard.makeMove(2,1,"X");
        gameBoard.makeMove(2,2,"O");
        assertFalse(gameBoard.hasWon());
    }

    @Test
    public void checkLeftColumnXWin(){
        gameBoard.makeMove(0,0,"X");
        gameBoard.makeMove(1,0,"X");
        gameBoard.makeMove(2,0,"X");
        assertTrue(gameBoard.hasWon());
    }

    @Test
    public void checkCenterColumnXWin(){
        gameBoard.makeMove(0,1,"X");
        gameBoard.makeMove(1,1,"X");
        gameBoard.makeMove(2,1,"X");
        assertTrue(gameBoard.hasWon());
    }

    @Test
    public void checkRightColumnXWin(){
        gameBoard.makeMove(0,2,"X");
        gameBoard.makeMove(1,2,"X");
        gameBoard.makeMove(2,2,"X");
        assertTrue(gameBoard.hasWon());
    }

    @Test
    public void checkBackSlashDiagonal(){
        gameBoard.makeMove(0,0,"X");
        gameBoard.makeMove(1,1,"X");
        gameBoard.makeMove(2,2,"X");
        assertTrue(gameBoard.hasWon());
    }

    @Test
    public void checkForwardSlashDiagonal(){
        gameBoard.makeMove(0,2,"X");
        gameBoard.makeMove(1,1,"X");
        gameBoard.makeMove(2,0,"X");
        assertTrue(gameBoard.hasWon());
    }

}
