package model;

public class Square {
    String squareType;
//    int x;
//    int y;

    public Square(String squareType) {
        this.squareType = squareType;
//        this.x = inX;
//        this.y = inY;
    }
    public void setPiecePositionType(Piece inPiece, String inPositionType) {
        inPiece.setPositionType(inPositionType);
        //...
    };

    // new
    public String getSquareType() {
        return squareType;
    }
}
