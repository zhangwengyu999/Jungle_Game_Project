package model;

public class Dog extends Piece{
    public Dog(boolean inIsBelongToPlayA) {
        super(inIsBelongToPlayA?"DA":"DB",3,inIsBelongToPlayA);
    }
}
