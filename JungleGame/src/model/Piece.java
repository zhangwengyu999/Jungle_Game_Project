package model;

public abstract class Piece {
    private String animalName;
    private int rank;
    private boolean isAlive;
    private boolean isBelongToPlayerA;
    private int x;
    private int y;
    private String positionType;

    public Piece(String inName, int inRank, boolean inIsBelongToPlayerA, int inX, int inY){
        this.animalName = inName;
        this.isAlive = true;
        this.rank = inRank;
        this.isBelongToPlayerA = inIsBelongToPlayerA;
        this.x = inX;
        this.y = inY;
    }

    public boolean isAlive(){
        return isAlive;
    }

    public void setDead(){
        isAlive = false;
    }

    public int getRank(){
        return rank;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void moveUp(int inStep){
        y+=inStep;
    }

    public void moveDown(int inStep){
        y-= inStep;
    }

    public void moveLeft(int inStep){
        x-= inStep;
    }

    public void moveRight(int inStep){
        x+= inStep;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String inPositionType) {
        this.positionType = inPositionType;
    }
}
