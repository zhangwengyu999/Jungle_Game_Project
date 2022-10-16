package model;

public class GameBoard extends Judge {
    private final int WIDTH;
    private final int HEIGHT;
    private Square[][] squares;
    private Piece[][] pieces;
    private int alivePieceOfPlayerA;
    private int alivePieceOfPlayerB;


    public GameBoard(){
        WIDTH = 7;
        HEIGHT = 9;
        alivePieceOfPlayerA = 8;
        alivePieceOfPlayerB = 8;
    }

    public Piece[][] getPiece(){
        return pieces;
    }

    public char[][] getUpdate() {
        // ...
        return new char[HEIGHT][WIDTH];
    }
}
