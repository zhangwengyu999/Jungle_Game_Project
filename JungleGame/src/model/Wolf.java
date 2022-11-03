package model;

public class Wolf extends Piece{
    public Wolf(boolean inIsBelongToPlayA) {
        super(inIsBelongToPlayA?"WA":"WB",4,inIsBelongToPlayA);
    }
}
