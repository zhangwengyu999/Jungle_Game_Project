package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    private Piece elephantA, elephantB, lionA, lionB, tigerA, tigerB, leopardA, leopardB,
                    wolfA, wolfB, dogA, dogB, catA, catB, ratA, ratB;

    @BeforeEach
    void setUp() {
        elephantA = new Elephant(true);
        elephantB = new Elephant(false);

        lionA = new Lion(true);
        lionB = new Lion(false);

        tigerA = new Tiger(true);
        tigerB = new Tiger(false);

        leopardA = new Leopard(true);
        leopardB = new Leopard(false);

        wolfA = new Wolf(true);
        wolfB = new Wolf(false);

        dogA = new Dog(true);
        dogB = new Dog(false);

        catA = new Cat(true);
        catB = new Cat(false);

        ratA = new Rat(true);
        ratB = new Rat(false);
    }

    @Test
    void elephantConstructorTest() {
        assertEquals("Elephant", elephantA.getName());
        assertNotEquals("Lion", elephantA.getName());
        assertNotEquals("Pig", elephantA.getName());
    }

    @Test
    void lionConstructorTest() {
        assertEquals("Lion", lionA.getName());
        assertNotEquals("Elephant", lionA.getName());
    }

    @Test
    void tigerConstructorTest() {
        assertEquals("Tiger", tigerA.getName());
        assertNotEquals("Leopard", tigerA.getName());
    }

    @Test
    void leopardConstructorTest() {
        assertEquals("Leopard", leopardA.getName());
        assertNotEquals("Wolf", leopardA.getName());
    }

    @Test
    void wolfConstructorTest() {
        assertEquals("Wolf", wolfA.getName());
        assertNotEquals("Dog", wolfA.getName());
    }

    @Test
    void dogConstructorTest() {
        assertEquals("Dog", dogA.getName());
        assertNotEquals("Cal", dogA.getName());
    }

    @Test
    void catConstructorTest() {
        assertEquals("Cat", catA.getName());
        assertNotEquals("Rat", catA.getName());
    }

    @Test
    void ratConstructorTest() {
        assertEquals("Rat", ratA.getName());
        assertNotEquals("Elephant", ratA.getName());
    }

    @Test
    void isAliveTest() {
        assertTrue(elephantA.isAlive());
        elephantA.setDead();
        assertFalse(elephantA.isAlive());
    }

    @Test
    void getRankTest() {
        assertEquals(8, elephantA.getRank());
        assertEquals(7, lionA.getRank());
        assertEquals(6, tigerA.getRank());
        assertEquals(5, leopardA.getRank());
        assertEquals(4, wolfA.getRank());
        assertEquals(3, dogA.getRank());
        assertEquals(2, catA.getRank());
        assertEquals(1, ratA.getRank());
        assertNotEquals(8, ratA.getRank());
        assertNotEquals(100, ratA.getRank());
    }
}