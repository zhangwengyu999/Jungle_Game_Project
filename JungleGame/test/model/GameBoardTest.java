package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {
    private GameBoard gameBoard;

    @BeforeEach
    void setUp() {
        gameBoard = new GameBoard();
    }


    @Test
    void pieceInitialPositionTest() {

        // test for initial amount of piece of two players
        assertEquals(gameBoard.getAlivePieceOfPlayerA(),8);
        assertEquals(gameBoard.getAlivePieceOfPlayerB(),8);

        int playerAInitialPiece = 0;
        int playerBInitialPiece = 0;
        for (Piece[] pieceLine: gameBoard.getPiece()) {
            if (pieceLine != null) {
                for (Piece piece: pieceLine) {
                    if (piece != null) {
                        if (piece.getIsBelongToPlayerA()) {
                            playerAInitialPiece++;
                        } else {
                            playerBInitialPiece++;
                        }
                    }
                }
            }
        }
        assertEquals(playerAInitialPiece,8);
        assertEquals(playerBInitialPiece,8);

        // test for initial position of piece of two players
        Piece pieceT1 = gameBoard.getPieceFromXY(0, 0);
        Piece pieceT2 = gameBoard.getPieceFromXY(6, 8);
        assertEquals("Tiger", pieceT1.getName());
        assertEquals("Tiger", pieceT2.getName());
        assertNotEquals("Cat", pieceT1.getName());
        assertNotEquals("Cat", pieceT2.getName());

        Piece pieceC1 = gameBoard.getPieceFromXY(1, 1);
        Piece pieceC2 = gameBoard.getPieceFromXY(5, 7);
        assertEquals("Cat", pieceC1.getName());
        assertEquals("Cat", pieceC2.getName());
        assertNotEquals("Elephant", pieceC1.getName());
        assertNotEquals("Elephant", pieceC2.getName());

        Piece pieceE1 = gameBoard.getPieceFromXY(0, 2);
        Piece pieceE2 = gameBoard.getPieceFromXY(6, 6);
        assertEquals("Elephant", pieceE1.getName());
        assertEquals("Elephant", pieceE2.getName());
        assertNotEquals("Wolf", pieceE1.getName());
        assertNotEquals("Wolf", pieceE2.getName());

        Piece pieceW1 = gameBoard.getPieceFromXY(2, 2);
        Piece pieceW2 = gameBoard.getPieceFromXY(4, 6);
        assertEquals("Wolf", pieceW1.getName());
        assertEquals("Wolf", pieceW2.getName());
        assertNotEquals("Leopard", pieceW1.getName());
        assertNotEquals("Leopard", pieceW2.getName());

        Piece pieceP1 = gameBoard.getPieceFromXY(4, 2);
        Piece pieceP2 = gameBoard.getPieceFromXY(2, 6);
        assertEquals("Leopard", pieceP1.getName());
        assertEquals("Leopard", pieceP2.getName());
        assertNotEquals("Dog", pieceP1.getName());
        assertNotEquals("Dog", pieceP2.getName());

        Piece pieceD1 = gameBoard.getPieceFromXY(5, 1);
        Piece pieceD2 = gameBoard.getPieceFromXY(1, 7);
        assertEquals("Dog", pieceD1.getName());
        assertEquals("Dog", pieceD2.getName());
        assertNotEquals("Rat", pieceD1.getName());
        assertNotEquals("Rat", pieceD2.getName());

        Piece pieceR1 = gameBoard.getPieceFromXY(6, 2);
        Piece pieceR2 = gameBoard.getPieceFromXY(0, 6);
        assertEquals("Rat", pieceR1.getName());
        assertEquals("Rat", pieceR2.getName());
        assertNotEquals("Lion", pieceR1.getName());
        assertNotEquals("Lion", pieceR2.getName());

        Piece pieceL1 = gameBoard.getPieceFromXY(6, 0);
        Piece pieceL2 = gameBoard.getPieceFromXY(0, 8);
        assertEquals("Lion", pieceL1.getName());
        assertEquals("Lion", pieceL2.getName());
        assertNotEquals("Tiger", pieceL1.getName());
        assertNotEquals("Tiger", pieceL2.getName());
    }

    @Test
    void squarePositionTest() {

        // Test for general land
        for(int i = 0; i< 9; i++) {
            Square squareTest = gameBoard.getSquareFromXY(0, i);
            assertEquals("generaLand", squareTest.getSquareType());
        }

        for(int i = 0; i< 9; i++) {
            Square squareTest = gameBoard.getSquareFromXY(6, i);
            assertEquals("generaLand", squareTest.getSquareType());
        }

        for(int i = 0; i< 9; i++) {
            Square squareTest = gameBoard.getSquareFromXY(3, i);
            assertEquals("generaLand", squareTest.getSquareType());
        }

        for(int i = 0; i< 7; i++) {
            Square squareTest = gameBoard.getSquareFromXY(i, 2);
            assertEquals("generaLand", squareTest.getSquareType());
        }

        for(int i = 0; i< 7; i++) {
            Square squareTest = gameBoard.getSquareFromXY(i,6);
            assertEquals("generaLand", squareTest.getSquareType());
        }

        for(int i = 0; i< 3; i++) {
            Square squareTest = gameBoard.getSquareFromXY(i,1);
            assertEquals("generaLand", squareTest.getSquareType());
        }

        for(int i = 4; i< 7; i++) {
            Square squareTest = gameBoard.getSquareFromXY(i,1);
            assertEquals("generaLand", squareTest.getSquareType());
        }

        for(int i = 0; i< 3; i++) {
            Square squareTest = gameBoard.getSquareFromXY(i,7);
            assertEquals("generaLand", squareTest.getSquareType());
        }

        for(int i = 4; i< 7; i++) {
            Square squareTest = gameBoard.getSquareFromXY(i,7);
            assertEquals("generaLand", squareTest.getSquareType());
        }

        for(int i = 0; i< 2; i++) {
            Square squareTest = gameBoard.getSquareFromXY(i,0);
            assertEquals("generaLand", squareTest.getSquareType());
        }

        for(int i = 5; i< 7; i++) {
            Square squareTest = gameBoard.getSquareFromXY(i,0);
            assertEquals("generaLand", squareTest.getSquareType());
        }

        for(int i = 0; i< 2; i++) {
            Square squareTest = gameBoard.getSquareFromXY(i,8);
            assertEquals("generaLand", squareTest.getSquareType());
        }

        for(int i = 5; i< 7; i++) {
            Square squareTest = gameBoard.getSquareFromXY(i, 8);
            assertEquals("generaLand", squareTest.getSquareType());
        }

        Square square11 = gameBoard.getSquareFromXY(1,0);
        assertEquals("generalLand", square11.getSquareType());
        Square square12 = gameBoard.getSquareFromXY(1,1);
        assertEquals("generalLand", square12.getSquareType());
        Square square13 = gameBoard.getSquareFromXY(2,1);
        assertEquals("generalLand", square13.getSquareType());

        Square square14 = gameBoard.getSquareFromXY(5,0);
        assertEquals("generalLand", square14.getSquareType());
        Square square15 = gameBoard.getSquareFromXY(5,1);
        assertEquals("generalLand", square15.getSquareType());
        Square square16 = gameBoard.getSquareFromXY(4,1);
        assertEquals("generalLand", square16.getSquareType());

        Square square17 = gameBoard.getSquareFromXY(1,8);
        assertEquals("generalLand", square17.getSquareType());
        Square square18 = gameBoard.getSquareFromXY(1,7);
        assertEquals("generalLand", square18.getSquareType());
        Square square19 = gameBoard.getSquareFromXY(2,7);
        assertEquals("generalLand", square19.getSquareType());

        Square square110 = gameBoard.getSquareFromXY(5,8);
        assertEquals("generalLand", square110.getSquareType());
        Square square111 = gameBoard.getSquareFromXY(5,7);
        assertEquals("generalLand", square111.getSquareType());
        Square square112 = gameBoard.getSquareFromXY(4,7);
        assertEquals("generalLand", square112.getSquareType());

        // test for den square
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

        // test for trap square
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

        // test for water square
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
    void moveUpTest() {
        String[][] expected = new String[][]{
                                            {"LB","","","","","","TB"},
                                            {"","DB","","","","CB",""},
                                            {"RB","","PB","","WB","","EB"},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"EA","CA","WA","","PA","","RA"},
                                            {"","","","","","DA",""},
                                            {"TA","","","","","","LA"}
        };
        assertFalse(Arrays.equals(expected,gameBoard.getUpdate()));

        String[][] expected2 = new String[][]{
                                            {"LB","","","","","","TB"},
                                            {"","DB","","","","CB",""},
                                            {"RB","","PB","","WB","","EB"},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"EA","CA","WA","","PA","","RA"},
                                            {"","","","","","DA",""},
                                            {"TA","","","","","","LA"}
        };
        gameBoard.moveUp(1,1);
        assertArrayEquals(expected2, gameBoard.getUpdate());
    }

    @Test
    void moveDownTest() {
        String[][] expected = new String[][]{
                                            {"LB","","","","","","TB"},
                                            {"","DB","","","","CB",""},
                                            {"RB","","PB","","WB","","EB"},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"EA","","WA","","PA","","RA"},
                                            {"","","","","","DA",""},
                                            {"TA","CA","","","","","LA"}
        };
        assertFalse(Arrays.equals(expected,gameBoard.getUpdate()));

        String[][] expected2 = new String[][]{
                                            {"LB","","","","","","TB"},
                                            {"","DB","","","","CB",""},
                                            {"RB","","PB","","WB","","EB"},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"EA","","WA","","PA","","RA"},
                                            {"","","","","","DA",""},
                                            {"TA","CA","","","","","LA"}
        };
        gameBoard.moveUp(1,1);
        assertArrayEquals(expected2, gameBoard.getUpdate());
    }

    @Test
    void moveLeftTest() {
        String[][] expected = new String[][]{
                                            {"LB","","","","","","TB"},
                                            {"","DB","","","","CB",""},
                                            {"RB","","PB","","WB","","EB"},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"EA","","WA","","PA","","RA"},
                                            {"CA","","","","","DA",""},
                                            {"TA","","","","","","LA"}
        };
        assertFalse(Arrays.equals(expected,gameBoard.getUpdate()));

        String[][] expected2 = new String[][]{
                                            {"LB","","","","","","TB"},
                                            {"","DB","","","","CB",""},
                                            {"RB","","PB","","WB","","EB"},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"EA","","WA","","PA","","RA"},
                                            {"CA","","","","","DA",""},
                                            {"TA","","","","","","LA"}
        };
        gameBoard.moveUp(1,1);
        assertArrayEquals(expected2, gameBoard.getUpdate());
    }

    @Test
    void moveRightTest() {
        String[][] expected = new String[][]{
                                            {"LB","","","","","","TB"},
                                            {"","DB","","","","CB",""},
                                            {"RB","","PB","","WB","","EB"},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"EA","","WA","","PA","","RA"},
                                            {"","","","CA","","DA",""},
                                            {"TA","","","","","","LA"}
        };
        assertFalse(Arrays.equals(expected,gameBoard.getUpdate()));

        String[][] expected2 = new String[][]{
                                            {"LB","","","","","","TB"},
                                            {"","DB","","","","CB",""},
                                            {"RB","","PB","","WB","","EB"},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"EA","","WA","","PA","","RA"},
                                            {"","","CA","","","DA",""},
                                            {"TA","","","","","","LA"}
        };
        gameBoard.moveUp(1,1);
        assertArrayEquals(expected2, gameBoard.getUpdate());
    }

    @Test
    void specialMoveTest(){

        // Test for Lion Move over Water vertically
        gameBoard.moveLeft(5,1); // Move the Dog to the left
        gameBoard.moveLeft(6,0); // Move the Lion to the left
        gameBoard.moveUp(5,0); // Move the Lion up
        gameBoard.moveUp(5,1); // Move the Lion up
        gameBoard.moveUp(5,2); // Move the Lion up (should jump over the Water and land at (5,6))
        String[][] expected = new String[][]{
                                            {"LB","","","","","","TB"},
                                            {"","DB","","","","CB",""},
                                            {"RB","","PB","","WB","","EB"},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"","","","","","LA",""},
                                            {"EA","","WA","","PA","","RA"},
                                            {"","CA","","","DA","",""},
                                            {"TA","","","","","",""}
        };
        assertFalse(Arrays.equals(expected,gameBoard.getUpdate()));

        String[][] expected2 = new String[][]{
                                            {"LB","","","","","","TB"},
                                            {"","DB","","","","CB",""},
                                            {"RB","","PB","","WB","LA","EB"},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"EA","","WA","","PA","","RA"},
                                            {"","","CA","","DA","",""},
                                            {"TA","","","","","",""}
        };
        assertArrayEquals(expected2, gameBoard.getUpdate());

        // Test for Tiger Move over Water horizontally
        gameBoard.moveUp(0,2); // Move the Elephant to the right
        gameBoard.moveUp(0,3); // Move the Tiger up
        gameBoard.moveUp(0,0); // Move the Tiger up
        gameBoard.moveUp(0,1); // Move the Tiger up
        gameBoard.moveUp(0,2); // Move the Tiger up
        gameBoard.moveRight(0,3);// Move the Tiger to the right (should jump over the Water and land at (3,3))
        String[][] expected3 = new String[][]{
                                            {"LB","","","","","","TB"},
                                            {"","DB","","","","CB",""},
                                            {"RB","","PB","","WB","","EB"},
                                            {"","","","","","",""},
                                            {"EA","","","","","",""},
                                            {"","TA","","","","",""},
                                            {"","","WA","","PA","","RA"},
                                            {"","CA","","","","DA",""},
                                            {"","","","","","","LA"}
        };
        assertFalse(Arrays.equals(expected3,gameBoard.getUpdate()));

        String[][] expected4 = new String[][]{
                                            {"LB","","","","","","TB"},
                                            {"","DB","","","","CB",""},
                                            {"RB","","PB","","WB","","EB"},
                                            {"","","","","","",""},
                                            {"EA","","","","","",""},
                                            {"","","","TA","","",""},
                                            {"","","WA","","PA","","RA"},
                                            {"","CA","","","","DA",""},
                                            {"","","","","","","LA"}
        };
        assertArrayEquals(expected4, gameBoard.getUpdate());

        //Test for Rat get into the water
        gameBoard.moveUp(6,2);
        gameBoard.moveLeft(6,3);
        String[][] expected5 = new String[][]{
                                            {"LB","","","","","","TB"},
                                            {"","DB","","","","CB",""},
                                            {"RB","","PB","","WB","","EB"},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"","","","RA","","",""},
                                            {"EA","","WA","","PA","",""},
                                            {"","CA","","","","DA",""},
                                            {"TA","","","","","","LA"}
        };
        assertFalse(Arrays.equals(expected5,gameBoard.getUpdate()));

        String[][] expected6 = new String[][]{
                                            {"LB","","","","","","TB"},
                                            {"","DB","","","","CB",""},
                                            {"RB","","PB","","WB","","EB"},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"","","","","","RA",""},
                                            {"EA","","WA","","PA","",""},
                                            {"","CA","","","","DA",""},
                                            {"TA","","","","","","LA"}
        };
        assertArrayEquals(expected6, gameBoard.getUpdate());

    }

    @Test
    void getUpdateTest() {
        String[][] expected = new String[][]{
                                            {"LB","","","","","","TB"},
                                            {"","DB","","","","CB",""},
                                            {"RB","","PB","","WB","","EB"},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"EA","","WA","","PA","","RA"},
                                            {"","CA","","","","DA",""},
                                            {"TA","","","","","","LA"}
                                            };
        assertTrue(Arrays.equals(expected,gameBoard.getUpdate()));


        String[][] expected2 = new String[][]{
                                            {"LB","","","","","","TB"},
                                            {"","DB","","","","CB",""},
                                            {"RB","","PB","","WB","","EB"},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"","","","","","","RA"},
                                            {"EA","","WA","","PA","",""},
                                            {"","CA","","","","DA",""},
                                            {"TA","","","","","","LA"}
        };
        assertFalse(Arrays.equals(expected2,gameBoard.getUpdate()));
    }

    @Test
    void capturePieceTest() {
        // Test for capture between two players

        // Before move and capture
        String[][] expectedBeforeCapture = new String[][]{
                                            {"LB","","","","","","TB"},
                                            {"","DB","","","","CB",""},
                                            {"RB","","PB","","WB","","EB"},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"EA","","WA","","PA","","RA"},
                                            {"","CA","","","","DA",""},
                                            {"TA","","","","","","LA"}
        };
        assertTrue(Arrays.equals(expectedBeforeCapture,gameBoard.getUpdate()));

        // Move WolfA(2,2) to (3,6) to capture the WolfB(4,6)
        gameBoard.moveRight(2,2);
        gameBoard.moveUp(3,2);
        gameBoard.moveUp(3,3);
        gameBoard.moveUp(3,4);
        gameBoard.moveUp(3,5);
        gameBoard.capturePiece(3,6,4,6);

        String[][] expectedAfterCapture = new String[][]{
                                            {"LB","","","","","","TB"},
                                            {"","DB","","","","CB",""},
                                            {"RB","","PB","","WA","","EB"},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"","","","","","",""},
                                            {"EA","","","","PA","","RA"},
                                            {"","CA","","","","DA",""},
                                            {"TA","","","","","","LA"}
        };
        assertTrue(Arrays.equals(expectedAfterCapture,gameBoard.getUpdate()));
        assertEquals(gameBoard.getAlivePieceOfPlayerA(),8);
        assertEquals(gameBoard.getAlivePieceOfPlayerB(),7);
    }
}