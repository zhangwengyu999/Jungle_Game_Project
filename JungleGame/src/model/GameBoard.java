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
        initializeSquare();
        initializePiece();
    }

    private initializeSquares() {
        // ...
    }

    private initializePieces(){
        Piece tigerA = new Tiger(true);
        pieces[0][0] = tigerA;

        Piece tigerB = new Tiger(true);
        pieces[6][8] = tigerB;
        //...
    }

    public Piece[][] getPiece(){
        return pieces;
    }

    public Piece getPieceFromXY(int inX, int inY) {
        return pieces[inX][inY];
    }

    public void moveUp(int inX, int inY) {
        // ...
    }

    public void moveDown(int inX, int inY) {
        // ...
    }

    public void moveLeft(int inX, int inY) {
        // ...
    }

    public void moveRight(int inX, int inY) {
        // ...
    }

    public char[][] getUpdate() {
        // ...
        return new char[HEIGHT][WIDTH];
    }
}