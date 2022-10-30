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
        generalLandSquare = new Square("generalLand",1,1);
        assertEquals("generalLand", generalLandSquare.getSquareType());
        assertNotEquals("water", generalLandSquare.getSquareType());
        assertNotEquals("PolyU", generalLandSquare.getSquareType());
    }

    @Test
    void waterSquareConstructorTest(){
        waterSquare = new Square("water",1,3);
        assertEquals("water", waterSquare.getSquareType());
        assertNotEquals("trap", waterSquare.getSquareType());
    }

    @Test
    void trapSquareConstructorTest(){
        trapSquare = new Square("trap",2,0);
        assertEquals("trap", trapSquare.getSquareType());
        assertNotEquals("den", trapSquare.getSquareType());
    }

    @Test
    void denSquareConstructorTest(){
        denSquare = new Square("den",3,0);
        assertEquals("den", denSquare.getSquareType());
        assertNotEquals("generalLand", denSquare.getSquareType());
    }

    @Test
    void setPiecePositionTypeTest() {
        generalLandSquare = new Square("generalLand",1,1);
        Piece tigerA = new Tiger(true);
        generalLandSquare.setPiecePositionType(tigerA, "generalLand");
        assertEquals("generalLand",tigerA.getPositionType());
        assertEquals("generalLand", generalLandSquare.getSquareType());
        assertNotEquals("water", generalLandSquare.getSquareType());
        assertNotEquals("hku", generalLandSquare.getSquareType());

    }
}