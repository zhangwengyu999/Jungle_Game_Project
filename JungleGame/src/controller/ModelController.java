package controller;

import model.GameBoard;
import model.Judge;
import view.Window;

public class ModelController {

    private GameBoard gameBoard;
    private Judge gameJudge;
    private final int MOVE_STEP = 1;

    public ModelController() {
        gameBoard = GameBoard.getGameBoard();
        gameJudge = Judge.getGameJudge(gameBoard);
    }

    // 调用时还需要合法性移动判断

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
    }

    public void resetGame() {
        gameBoard.resetGameBoard();
    }

    public String[][] getUpdateToGameBoard() {
        return gameBoard.getUpdate();
    }
}
