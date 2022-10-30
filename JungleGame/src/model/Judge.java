package model;

public class Judge {

    private final int LEGAL_MOVE_STEP = 1;

    // new
    public boolean isLegalMovement(int inX, int inY, String inDirection){

        // Out of the GameBoard boundary
        if (inX==0 && inDirection.equals("L")) return false;
        if (inX==6 && inDirection.equals("R")) return false;
        if (inY==0 && inDirection.equals("U")) return false;
        if (inY==8 && inDirection.equals("D")) return false;

        // ...
        return true;
    }

    // new
    public boolean isAAliveAfterCapture(int aIntX, int aIntY, String inDirection){
        // ...
        return true;
    }

    public boolean isWin(int inAliveNum, Piece inPiece){
        // ...
        return true;
    }

}
