package model;

public class Judge {

    private final int LEGAL_MOVE_STEP = 1;

    public boolean isLegalMovement(Piece inPiece, String inDirection){
        // ...
        return true;
    }

    public boolean isLegalCapture(Piece inPieceA, Piece inPieceB){
        // ...
        return true;
    }

    public boolean isAAliveAfterCapture(Piece pieceA, Piece pieceB){
        // ...
        return true;
    }

    public boolean isWin(int inAliveNum, Piece inPiece){
        // ...
        return true;
    }

}
