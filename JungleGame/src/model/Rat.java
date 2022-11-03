package model;

public class Rat extends Piece{
    public Rat(boolean inIsBelongToPlayA) {
        super(inIsBelongToPlayA?"RA":"RB",1,inIsBelongToPlayA);
    }
}
