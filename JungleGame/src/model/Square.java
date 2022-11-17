package model;

public class Square {
    String squareType;

    /**
     * Constructor for Square
     * @param squareType the type of the square
     */
    public Square(String squareType) {
        this.squareType = squareType;
    }

    /**
     * Set the position type of the piece on the square
     * @param inPiece
     * @param inPositionType
     */
    public void setPiecePositionType(Piece inPiece, String inPositionType) {
        inPiece.setPositionType(inPositionType);
    }

    /**
     * Get the type of the square
     * @return the type of the square
     */
    public String getSquareType() {
        return squareType;
    }
}
