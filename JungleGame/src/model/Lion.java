package model;

public class Lion extends Piece {
    public Lion(boolean inIsBelongToPlayA) {
        super(inIsBelongToPlayA?"LA":"LB",7,inIsBelongToPlayA);
    }
}
