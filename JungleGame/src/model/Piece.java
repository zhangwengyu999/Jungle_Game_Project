package model;

public abstract class Piece {
    private String animalName;
    private int rank;
    private boolean isAlive;
    private boolean isBelongToPlayerA;
    private String positionType;

    /**
     * Constructor
     * @param inName name of the piece
     * @param inRank rank of the piece
     * @param inIsBelongToPlayerA true for player A; false for player B
     */
    public Piece(String inName, int inRank, boolean inIsBelongToPlayerA){
        this.animalName = inName;
        this.isAlive = true;
        this.rank = inRank;
        this.isBelongToPlayerA = inIsBelongToPlayerA;
        this.positionType = "generalLand";
    }

    /**
     * Check if the piece is alive
     * @return true for alive; false for dead
     */
    public boolean isAlive(){
        return isAlive;
    }

    /**
     * Set the piece to dead
     */
    public void setDead(){
        isAlive = false;
    }

    /**
     * Get the rank of the piece
     * @return rank of the piece
     */
    public int getRank(){
        return rank;
    }

    /**
     * Get the name of the piece
     * @return name of the piece
     */
    public String getName(){
        return animalName;
    }

    /**
     * Get the position type of the piece
     * @return position type of the piece
     */
    public String getPositionType() {
        return positionType;
    }

    /**
     * Get the player type of the piece
     * @return true for player A; false for player B
     */
    public boolean getIsBelongToPlayerA(){
        return isBelongToPlayerA;
    }

    /**
     * Set the position type of the piece
     */
    public void setPositionType(String inPositionType) {
        this.positionType = inPositionType;
    }
}
