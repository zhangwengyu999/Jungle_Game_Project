package model;

public abstract class Piece {
    private String animalName;
    private int rank;
    private boolean isAlive;
    private boolean isBelongToPlayerA;
    private String positionType;

    public Piece(String inName, int inRank, boolean inIsBelongToPlayerA){
        this.animalName = inName;
        this.isAlive = true;
        this.rank = inRank;
        this.isBelongToPlayerA = inIsBelongToPlayerA;
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

    public String getName(){
        return animalName;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String inPositionType) {
        this.positionType = inPositionType;
    }
}
