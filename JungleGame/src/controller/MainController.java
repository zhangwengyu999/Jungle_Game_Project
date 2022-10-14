package controller;

import model.GameBoard;
import model.Judge;
import model.Piece;
import model.Square;
import view.Window;

public class MainController {

    private GameBoard gameBoard;
    private Judge gameJudge;
    private Window gameWindow;
    private final int MOVE_STEP = 1;


    public void MovePiece(int inX, int inY, String inDirection){
        // ...
    }

    public void CapturePiece(int inX, int inY, String inDirection){
        // ...
    }

    public void UpdatePieceLocationType(Piece inPiece, Square inSquare){
        // ...
    }

}
