package model;

public class GameBoard {
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
        initializeSquares();
        initializePieces();
    }

    private void initializeSquares() {
        // ...
    }

    private void initializePieces(){

        // Example:
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

    // new
    public Square getSquareFromXY(int inX, int inY) {
        return squares[inX][inY];
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

    // new (先判断移动可行性，再判断能否吃，最后判断吃完的移动)
    public void capturePiece(int inAX, int inAY, int inBX, int inBY) {
        // ...
    }

    // new
    public int getAlivePieceOfPlayerA() {
        return alivePieceOfPlayerA;
    }

    // new
    public int getAlivePieceOfPlayerB() {
        return alivePieceOfPlayerB;
    }

    public String[][] getUpdate() {
        // ...
        return new String[HEIGHT][WIDTH];
    }
}