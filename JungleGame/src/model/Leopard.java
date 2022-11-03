package model;

public class Leopard extends Piece{
    public Leopard(boolean inIsBelongToPlayA) {
        super(inIsBelongToPlayA?"PA":"PB",5,inIsBelongToPlayA);
    }
}
