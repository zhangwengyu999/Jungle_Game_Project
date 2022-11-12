package model;

import java.util.HashMap;

public class Judge {

    private final int LEGAL_MOVE_STEP = 1;
    private static GameBoard gameBoard;
    private static final Judge gameJudge = new Judge();

    private Judge() {
//        gameBoard = GameBoard.getGameBoard();
    }

    public static Judge getGameJudge(GameBoard inGameBoard) {
        gameBoard = inGameBoard;
        return gameJudge;
    }

    // new
    public boolean isLegalMovement(int inX, int inY, String inDirection, boolean isPlayerARound) {

        // No piece to select
        if (gameBoard.getPieceFromXY(inX, inY) == null) {
            return false;
        }

        if (gameBoard.getPieceFromXY(inX, inY).getIsBelongToPlayerA() != isPlayerARound) {
            return false;
        }

        // Out of the GameBoard boundary
        if (inX == 0 && inDirection.equals("L")) return false;
        if (inX == 6 && inDirection.equals("R")) return false;
        if (inY == 8 && inDirection.equals("U")) return false;
        if (inY == 0 && inDirection.equals("D")) return false;

        // Test for move to the own Den
        // Player A's Piece move to the Den of Player A
        if ((inX == 4 && inY == 0)
                && gameBoard.getPieceFromXY(4, 0).getIsBelongToPlayerA()
                && inDirection.equals("L")) {
            return false;
        } else if ((inX == 2 && inY == 0)
                && gameBoard.getPieceFromXY(2, 0).getIsBelongToPlayerA()
                && inDirection.equals("R")) {
            return false;
        } else if ((inX == 3 && inY == 1)
                && gameBoard.getPieceFromXY(3, 1).getIsBelongToPlayerA()
                && inDirection.equals("D")) {
            return false;
        }

        // Player B's Piece move to the Den of Player B
        if (inX == 4 && inY == 8 && !gameBoard.getPieceFromXY(inX, inY).getIsBelongToPlayerA() && inDirection.equals("L") ||
                inX == 3 && inY == 7 && !gameBoard.getPieceFromXY(inX, inY).getIsBelongToPlayerA() && inDirection.equals("U") ||
                inX == 2 && inY == 8 && !gameBoard.getPieceFromXY(inX, inY).getIsBelongToPlayerA() && inDirection.equals("R")) {
            return false;
        }


        // Test for move up into the Water for piece is not Rat, Tiger or Lion
        if (gameBoard.getPieceFromXY(inX, inY).getRank() != 1 &&
                gameBoard.getPieceFromXY(inX, inY).getRank() != 6 &&
                gameBoard.getPieceFromXY(inX, inY).getRank() != 7 && inDirection.equals("U")) {
            if ((inX == 1 && inY == 2) || (inX == 2 && inY == 2) || (inX == 4 && inY == 2) || (inX == 5 && inY == 2)) {
                return false;
            }
        }

        // Test for move down into the Water
        if (gameBoard.getPieceFromXY(inX, inY).getRank() != 1 &&
                gameBoard.getPieceFromXY(inX, inY).getRank() != 6 &&
                gameBoard.getPieceFromXY(inX, inY).getRank() != 7 && inDirection.equals("D")) {
            if ((inX == 1 && inY == 6) || (inX == 2 && inY == 6) || (inX == 4 && inY == 6) || (inX == 5 && inY == 6)) {
                return false;
            }
        }

        // Test for move left into the Water
        if (gameBoard.getPieceFromXY(inX, inY).getRank() != 1 &&
                gameBoard.getPieceFromXY(inX, inY).getRank() != 6 &&
                gameBoard.getPieceFromXY(inX, inY).getRank() != 7 && inDirection.equals("L")) {
            if ((inX == 3 && inY == 5) || (inX == 3 && inY == 4) || (inX == 3 && inY == 3)
                    || (inX == 6 && inY == 5) || (inX == 6 && inY == 4) || (inX == 6 && inY == 3)) {
                return false;
            }
        }


        // Test for move Right into the Water
        if (gameBoard.getPieceFromXY(inX, inY).getRank() != 1 &&
                gameBoard.getPieceFromXY(inX, inY).getRank() != 6 &&
                gameBoard.getPieceFromXY(inX, inY).getRank() != 7 && inDirection.equals("R")) {
            if ((inX == 0 && inY == 3) || (inX == 0 && inY == 4) || (inX == 0 && inY == 5)
                    || (inX == 3 && inY == 3) || (inX == 3 && inY == 4) || (inX == 3 && inY == 5)) {
                return false;
            }
        }


        // move up with rat in the middle of river
        if (gameBoard.getPieceFromXY(inX, inY).getRank() == 6
                || gameBoard.getPieceFromXY(inX, inY).getRank() == 7) {
            if (((inX == 1 && inY == 3) || (inX == 2 && inY == 3)
                    || (inX == 4 && inY == 3) || (inX == 5 && inY == 3))
                    && inDirection.equals("U")) {
                for (int m = 1; m <= 3; m++) {
                    if (gameBoard.getPieceFromXY(inX, inY + m) != null) {
                        return false;
                    }
                }
            }

            // move down with rat in the middle of river
            else if (((inX == 1 && inY == 6) || (inX == 2 && inY == 6)
                    || (inX == 4 && inY == 6) || (inX == 5 && inY == 6))
                    && inDirection.equals("D")) {
                for (int m = 1; m <= 3; m++) {
                    if (gameBoard.getPieceFromXY(inX, inY - m) != null) {
                        return false;
                    }
                }
            }

            // move right with rat in the middle of river
            else if (((inX == 0 && inY == 3) || (inX == 0 && inY == 4)
                    || (inX == 0 && inY == 5) || (inX == 3 && inY == 3)
                    || (inX == 3 && inY == 4) || (inX == 3 && inY == 5))
                    && inDirection.equals("R")) {
                for (int m = 1; m <= 2; m++) {
                    if (gameBoard.getPieceFromXY(inX + m, inY) != null) {
                        return false;
                    }
                }
            }

            // move left with rat in the middle of river
            else if (((inX == 6 && inY == 3) || (inX == 6 && inY == 4)
                    || (inX == 6 && inY == 5) || (inX == 3 && inY == 3)
                    || (inX == 3 && inY == 4) || (inX == 3 && inY == 5))
                    && inDirection.equals("L")) {
                for (int m = 1; m <= 2; m++) {
                    if (gameBoard.getPieceFromXY(inX - m, inY) != null) {
                        return false;
                    }
                }
            }
        }

        // Test for when the Rat move from the Water to the Land
        // Move up (Water to Land or Land to water), some Piece is in front the Rat
        if (gameBoard.getPieceFromXY(inX, inY).getRank() == 1) {
            if (((inX == 1 && inY == 2) || (inX == 2 && inY == 2)
                    || (inX == 4 && inY == 2) || (inX == 5 && inY == 2)
                    || (inX == 1 && inY == 5) || (inX == 2 && inY == 5)
                    || (inX == 4 && inY == 5) || (inX == 5 && inY == 5))
                    && inDirection.equals("U")) {
                if (gameBoard.getPieceFromXY(inX, inY + 1) != null) {
                    return false;
                }
            }
        }

        // Move down (Water to Land or Land to water), some Piece is in front the Rat
        if (gameBoard.getPieceFromXY(inX, inY).getRank() == 1) {
            if (((inX == 1 && inY == 6) || (inX == 2 && inY == 6)
                    || (inX == 4 && inY == 6) || (inX == 5 && inY == 6)
                    || (inX == 1 && inY == 3) || (inX == 2 && inY == 3)
                    || (inX == 4 && inY == 3) || (inX == 5 && inY == 3))
                    && inDirection.equals("D")) {
                if (gameBoard.getPieceFromXY(inX, inY - 1) != null) {
                    return false;
                }
            }
        }

        // Move left (Water to Land or Land to water), some Piece is in front the Rat
        if (gameBoard.getPieceFromXY(inX, inY).getRank() == 1) {
            if (((inX == 3 && inY == 3) || (inX == 3 && inY == 4)
                    || (inX == 3 && inY == 5) || (inX == 6 && inY == 3)
                    || (inX == 6 && inY == 4) || (inX == 6 && inY == 5)
                    || (inX == 1 && inY == 3) || (inX == 1 && inY == 4)
                    || (inX == 1 && inY == 5) || (inX == 4 && inY == 3)
                    || (inX == 4 && inY == 4) || (inX == 4 && inY == 5))
                    && inDirection.equals("L")) {
                if (gameBoard.getPieceFromXY(inX - 1, inY) != null) {
                    return false;
                }
            }
        }

        // Move right (Water to Land or Land to water), some Piece is in front the Rat
        if (gameBoard.getPieceFromXY(inX, inY).getRank() == 1) {
            if (((inX == 3 && inY == 3) || (inX == 3 && inY == 4)
                    || (inX == 3 && inY == 5) || (inX == 0 && inY == 3)
                    || (inX == 0 && inY == 4) || (inX == 0 && inY == 5)
                    || (inX == 2 && inY == 4) || (inX == 2 && inY == 5)
                    || (inX == 2 && inY == 3) || (inX == 5 && inY == 3)
                    || (inX == 5 && inY == 4) || (inX == 5 && inY == 5)
                    && inDirection.equals("R"))) {
                if (gameBoard.getPieceFromXY(inX + 1, inY) != null) {
                    return false;
                }
            }
        }
        return true;
    }

    // new
    public boolean isAAliveAfterCapture(int aIntX, int aIntY, String inDirection) {
        Piece pieceFrom = gameBoard.getPieceFromXY(aIntX, aIntY);
        int toX=-1;
        int toY=-1;
        if (pieceFrom == null) {
            return false;
        }
        if (pieceFrom.getPositionType().equals("trap")) {
            return false;
        }
        if (inDirection.equals("U")) {
            toX = aIntX;
            toY = aIntY + 1;
        }
        else if (inDirection.equals("D")) {
            toX = aIntX;
            toY = aIntY - 1;
        }
        else if (inDirection.equals("L")) {
            toX = aIntX - 1;
            toY = aIntY;
        }
        else if (inDirection.equals("R")) {
            toX = aIntX + 1;
            toY = aIntY;
        }
        Piece pieceTo = gameBoard.getPieceFromXY(toX, toY);
        if (pieceTo != null) {
            if (pieceTo.getPositionType().equals("trap")){
                return true;
            }
            if (pieceFrom.getRank()==1 && pieceTo.getRank()==8){
                return true;
            }
            return pieceFrom.getRank()>=pieceTo.getRank();
        }
        return true;
    }

    public boolean isAWin(Piece inPiece) {
        if (inPiece != null) {
            if (inPiece.getPositionType().equals("den")) {
                return true;
            }
            // If the piece is PlayerA, and PlayerB's piece number is 0, A win
            else if (gameBoard.getAlivePieceOfPlayerB() == 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean isBWin(Piece inPiece) {
        if (inPiece != null) {
            if (inPiece.getPositionType().equals("den")) {
                return true;
            }
            // If the piece is PlayerA, and PlayerB's piece number is 0, A win
            else if (gameBoard.getAlivePieceOfPlayerA() == 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }


//    public void whoWins(Piece inPiece){
//        if (isWin(inPiece)) {
//            if (inPiece.getIsBelongToPlayerA()) {
//                if (inPiece.isAlive()) {
//                    System.out.println("A is winner!");
//                }
//                else{
//                    System.out.println("B is winner!");
//                }
//            }
//            else{
//                if (inPiece.isAlive()){
//                    System.out.println("B is winner!");
//                }
//                else{
//                    System.out.println("A is winner!");
//                }
//            }
//        }
//    }
}


