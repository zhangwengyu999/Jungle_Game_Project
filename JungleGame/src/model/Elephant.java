package model;

public class Elephant extends Piece{
    public Elephant(boolean inIsBelongToPlayA) {
        super(inIsBelongToPlayA?"EA":"EB",8,inIsBelongToPlayA);
    }
}
