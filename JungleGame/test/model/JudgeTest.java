package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JudgeTest {
    // prepare the GameBoard and Judge for the test
    private GameBoard gameBoard;
    private Judge judge;

    @BeforeEach
    void setUp() {
        // set up the GameBoard and Judge for the test
        gameBoard = GameBoard.getGameBoard();
        judge = Judge.getGameJudge(gameBoard);
        gameBoard.resetGameBoard();
    }

    @Test
    void isLegalMovementTest() {
        // Tests for the legal movement of the pieces

        // Test for out of the GameBoard boundary
        assertFalse(judge.isLegalMovement(0, 0, "L",true));
        assertFalse(judge.isLegalMovement(0,0,"D",true));

        assertFalse(judge.isLegalMovement(6,0,"D",true));
        assertFalse(judge.isLegalMovement(6,0,"R",true));

        assertFalse(judge.isLegalMovement(6,8,"R",false));
        assertFalse(judge.isLegalMovement(6,8,"U",false));

        assertFalse(judge.isLegalMovement(0,8,"L",false));
        assertFalse(judge.isLegalMovement(0,8,"U",false));

        // Test for the legal movement
        assertTrue(judge.isLegalMovement(0,0,"R",true));
        assertTrue(judge.isLegalMovement(0,0,"U",true));

        assertTrue(judge.isLegalMovement(6,0,"U",true));
        assertTrue(judge.isLegalMovement(6,0,"L",true));

        assertTrue(judge.isLegalMovement(6,8,"L",false));
        assertTrue(judge.isLegalMovement(6,8,"D",false));

        assertTrue(judge.isLegalMovement(0,8,"D",false));
        assertTrue(judge.isLegalMovement(0,8,"R",false));

        // Test for move to the own Den
        gameBoard.moveRight(0,0);
        gameBoard.moveRight(1,0);
        assertFalse(judge.isLegalMovement(2,0,"R",true));

        // Test for move into the Water
        //      Test for illegal Wolf moves into Water
        assertFalse(judge.isLegalMovement(2,2,"U",true));
        //      Test for legal Rat moves into Water
        gameBoard.moveUp(6,2);
        assertTrue(judge.isLegalMovement(6,3,"L",true));

        // No piece to select
        assertFalse(judge.isLegalMovement(1,0,"U",true));
        assertTrue(judge.isLegalMovement(1,1,"U",true));

        // There are Rat in the river when Tiger or Lion jump cross the Water.
        gameBoard.moveLeft(6,3);
        gameBoard.moveLeft(5,3); // rat now is in (4,3) Water
        gameBoard.moveUp(6,0);
        gameBoard.moveUp(6,1);
        gameBoard.moveUp(6,2);
        assertFalse(judge.isLegalMovement(6,3,"L",true));
        gameBoard.moveUp(4,3); // rat is not in the jump over path
        assertTrue(judge.isLegalMovement(6,3,"L",true));

        // Test for when the Rat move from the Water to the Land
        // while another Rat is in front of it.
        gameBoard.moveDown(0,6);
        gameBoard.moveDown(0,5);
        gameBoard.moveRight(0,4);
        gameBoard.moveRight(1,4);
        gameBoard.moveRight(2,4);
        assertFalse(judge.isLegalMovement(3,4,"R",true));
        assertFalse(judge.isLegalMovement(4,4,"L",true));
        gameBoard.moveDown(4,4);
        assertTrue(judge.isLegalMovement(3,4,"R",false));
    }

    @Test
    void isAAliveAfterCaptureTest() {
        // Tests for is Piece A alive after capturing Piece B

        // Normal capture
        gameBoard.moveRight(2,2);
        gameBoard.moveUp(3,2);
        gameBoard.moveUp(3,3);
        gameBoard.moveUp(3,4);
        gameBoard.moveUp(3,5);
        assertFalse(judge.isAAliveAfterCapture(3,6,"L"));
        assertTrue(judge.isAAliveAfterCapture(3,6,"R"));
        assertTrue(judge.isAAliveAfterCapture(2,6,"R"));

        // Capture between the Rat and the Elephant
        gameBoard.moveUp(0,2);
        gameBoard.moveUp(0,3);
        gameBoard.moveUp(0,4);
        assertTrue(judge.isAAliveAfterCapture(0,5,"U"));

        gameBoard.moveUp(6,2);
        gameBoard.moveUp(6,3);
        gameBoard.moveUp(6,4);
        assertTrue(judge.isAAliveAfterCapture(6,5,"U"));

        // Capture between two Rats both in the Water
        gameBoard.moveRight(0,6);
        gameBoard.moveDown(1,6);
        gameBoard.moveLeft(6,5);
        gameBoard.moveLeft(5,5);
        gameBoard.moveLeft(4,5);
        gameBoard.moveLeft(3,5);
        assertTrue(judge.isAAliveAfterCapture(1,5,"R"));

        // Capture the own piece
        gameBoard.moveUp(0,0);
        assertTrue(judge.isAAliveAfterCapture(0,1,"R"));
        gameBoard.moveUp(5,1);
        assertFalse(judge.isAAliveAfterCapture(5,2,"L"));

        // Capture in the Trap and Capture from the Trap
        gameBoard.moveLeft(5,7);
        gameBoard.moveUp(3,6);
        assertTrue(judge.isAAliveAfterCapture(4,7,"L"));
        assertFalse(judge.isAAliveAfterCapture(3,7,"R"));
    }

    @Test
    void isWinTestByInDenTest() {
        // Test for win by entering the opponent's Den

        assertFalse(judge.isAWin(gameBoard.getPieceFromXY(0,0)));
        gameBoard.moveRight(2,2);

        int i=2;
        while(i<=7){
            gameBoard.moveUp(3,i++);
        }
        // The WolfA move to the Den of PlayerB
        assertTrue(judge.isAWin(gameBoard.getPieceFromXY(3,8)));
    }

    @Test
    void isWinTestByCaptureAllTest() {
        // Test for win by capturing all the pieces of the opponent
        gameBoard.setPiecesDeath(0,0);
        assertFalse(judge.isBWin(gameBoard.getPieceFromXY(0,8)));
        gameBoard.setPiecesDeath(0,8);
        assertFalse(judge.isAWin(gameBoard.getPieceFromXY(0,2)));
        gameBoard.setPiecesDeath(0,2);
        gameBoard.setPiecesDeath(1,1);
        gameBoard.setPiecesDeath(2,2);
        gameBoard.setPiecesDeath(4,2);
        gameBoard.setPiecesDeath(5,1);
        gameBoard.setPiecesDeath(6,0);
        gameBoard.setPiecesDeath(6,2);
        assertTrue(judge.isBWin(gameBoard.getPieceFromXY(6,8)));
        assertFalse(judge.isAWin(gameBoard.getPieceFromXY(6,8)));
        assertFalse(judge.isAWin(gameBoard.getPieceFromXY(0,0)));

    }
}