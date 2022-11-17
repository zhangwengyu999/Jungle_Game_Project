package controller;

import model.GameBoard;
import model.Judge;

public class ModelController {

    private GameBoard gameBoard;
    private Judge gameJudge;

    /**
     * Constructor
     */
    public ModelController() {
        gameBoard = GameBoard.getGameBoard();
        gameJudge = Judge.getGameJudge(gameBoard);
    }

    /**
     * Process user move cmd
     * @param inX x coordinate of Piece
     * @param inY y coordinate of Piece
     * @param inDirection direction of Piece
     * @return true for piece is alive; false for the piece is dead
     */
    public boolean playerMovePiece(int inX, int inY, String inDirection){
        if (gameBoard.getPieceAfterMovement(inX, inY, inDirection)!=null) {
            boolean isALive = gameJudge.isAAliveAfterCapture(inX, inY, inDirection);
            if (isALive) {
                if (inDirection.equals("U")) {
                    gameBoard.setPiecesDeath(inX, gameBoard.getMoveUpDestination(inX, inY)[1]);
                    gameBoard.moveUp(inX, inY);
                } else if (inDirection.equals("D")) {
                    gameBoard.setPiecesDeath(inX, gameBoard.getMoveDownDestination(inX, inY)[1]);
                    gameBoard.moveDown(inX, inY);
                } else if (inDirection.equals("L")) {
                    gameBoard.setPiecesDeath(gameBoard.getMoveLeftDestination(inX, inY)[0], inY);
                    gameBoard.moveLeft(inX, inY);
                } else if (inDirection.equals("R")) {
                    gameBoard.setPiecesDeath(gameBoard.getMoveRightDestination(inX, inY)[0], inY);
                    gameBoard.moveRight(inX, inY);
                }
                return true;
            } else {
                gameBoard.setPiecesDeath(inX, inY);
                return false;
            }
        }
        else{
            if (inDirection.equals("U")) {
                gameBoard.moveUp(inX, inY);
            } else if (inDirection.equals("D")) {
                gameBoard.moveDown(inX, inY);
            } else if (inDirection.equals("L")) {
                gameBoard.moveLeft(inX, inY);
            } else if (inDirection.equals("R")) {
                gameBoard.moveRight(inX, inY);
            }
        }
        return true;
    }

    /**
     * Get the game board update
     * @return
     */
    public String[][] getUpdateToGameBoard() {
        return gameBoard.getUpdate();
    }
}
