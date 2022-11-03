package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SquareTest {
    private Square generalLandSquare;
    private Square waterSquare;
    private Square trapSquare;
    private Square denSquare;

    @Test
    void generalLandSquareConstructorTest(){
        // Test for General Land Square with its type name
        generalLandSquare = new Square("generalLand");
        assertEquals("generalLand", generalLandSquare.getSquareType());
        assertNotEquals("water", generalLandSquare.getSquareType());
        assertNotEquals("PolyU", generalLandSquare.getSquareType());
    }

    @Test
    void waterSquareConstructorTest(){
        // Test for Water Square with its type name
        waterSquare = new Square("water");
        assertEquals("water", waterSquare.getSquareType());
        assertNotEquals("trap", waterSquare.getSquareType());
    }

    @Test
    void trapSquareConstructorTest(){
        // Test for Trap Square with its type name
        trapSquare = new Square("trap");
        assertEquals("trap", trapSquare.getSquareType());
        assertNotEquals("den", trapSquare.getSquareType());
    }

    @Test
    void denSquareConstructorTest(){
        // Test for Den Square with its type name
        denSquare = new Square("den");
        assertEquals("den", denSquare.getSquareType());
        assertNotEquals("generalLand", denSquare.getSquareType());
    }

    @Test
    void setPiecePositionTypeTest() {
        // Test for set the position type of the piece on the square
        generalLandSquare = new Square("generalLand");
        Piece tigerA = new Tiger(true);
        generalLandSquare.setPiecePositionType(tigerA, "generalLand");
        assertEquals("generalLand",tigerA.getPositionType());
        assertEquals("generalLand", generalLandSquare.getSquareType());
        assertNotEquals("water", generalLandSquare.getSquareType());
        assertNotEquals("hku", generalLandSquare.getSquareType());
    }
}