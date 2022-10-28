package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {
    private GameBoard gameBoard;

    @BeforeEach
    void setUp() {
        gameBoard = new GameBoard();
    }


    @Test
    void pieceInitialPositionTest() {
        Piece piece1 = gameBoard.getPieceFromXY(0, 0);
        assertEquals("Tiger", piece1.getName());
        assertNotEquals("Cat", piece1.getName());
    }


    @Test
    void squarePositionTest() {
        Square square1 = gameBoard.getSquareFromXY(0,0);
        assertEquals("generalLand", square1.getSquareType());
        assertNotEquals("water", square1.getSquareType());

        Square square20 = gameBoard.getSquareFromXY(2,0);
        Square square21 = gameBoard.getSquareFromXY(4,0);
        Square square22 = gameBoard.getSquareFromXY(3,1);
        assertEquals("trap", square20.getSquareType());
        assertNotEquals("den", square20.getSquareType());
        assertNotEquals("generalLand", square20.getSquareType());
        assertEquals("trap", square21.getSquareType());
        assertNotEquals("den", square21.getSquareType());
        assertNotEquals("generalLand", square21.getSquareType());
        assertEquals("trap", square22.getSquareType());
        assertNotEquals("den", square22.getSquareType());
        assertNotEquals("generalLand", square22.getSquareType());

        Square square23 = gameBoard.getSquareFromXY(2,8);
        Square square24 = gameBoard.getSquareFromXY(4,8);
        Square square25 = gameBoard.getSquareFromXY(3,7);
        assertEquals("trap", square23.getSquareType());
        assertNotEquals("den", square23.getSquareType());
        assertNotEquals("generalLand", square23.getSquareType());
        assertEquals("trap", square24.getSquareType());
        assertNotEquals("den", square24.getSquareType());
        assertNotEquals("generalLand", square24.getSquareType());
        assertEquals("trap", square25.getSquareType());
        assertNotEquals("den", square25.getSquareType());
        assertNotEquals("generalLand", square25.getSquareType());

        Square square30 = gameBoard.getSquareFromXY(3,0);
        Square square31 = gameBoard.getSquareFromXY(3,8);
        assertEquals("den", square30.getSquareType());
        assertNotEquals("trap", square30.getSquareType());
        assertEquals("den", square31.getSquareType());
        assertNotEquals("trap", square31.getSquareType());

        for (int i=1;i<3;i++) {
            for (int j=3;j<6;j++) {
                Square squareTest = gameBoard.getSquareFromXY(i,j);
                assertEquals("water", squareTest.getSquareType());
                assertNotEquals("generalLand", squareTest.getSquareType());
            }
        }
        for (int i=4;i<6;i++) {
            for (int j=3;j<6;j++) {
                Square squareTest = gameBoard.getSquareFromXY(i,j);
                assertEquals("water", squareTest.getSquareType());
                assertNotEquals("generalLand", squareTest.getSquareType());
            }
        }
    }


    @Test
    void moveUp() {
    }

    @Test
    void moveDown() {
    }

    @Test
    void moveLeft() {
    }

    @Test
    void moveRight() {
    }

    @Test
    void getUpdate() {
    }
}