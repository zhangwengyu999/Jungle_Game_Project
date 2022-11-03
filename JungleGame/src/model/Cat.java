package model;

public class Cat extends Piece{
    public Cat(boolean inIsBelongToPlayA) {
        super(inIsBelongToPlayA?"CA":"CB",2,inIsBelongToPlayA);
    }
}
