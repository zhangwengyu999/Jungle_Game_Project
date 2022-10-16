package view;

public class Block {
    private final int weight = 10;
    private final int height = 10;
    private char pieceContent;
    private String blockFrame;


    public void setPiece(char inContent) {
        
    }

    public char getPiece(){
        return '$';
    }

    public void setAsDenFrame() {
        blockFrame = "+$$$$$$$$$+";

    }

    public void setAsTrapFrame(){
        blockFrame = "+#########+";

    }

    public void setAsRiverFrame(){
        blockFrame = "+~~~~~~~~+";

    }

    public void setAsGeneralLandFrame(){
        blockFrame = "+--------+";

    }

    public String getBlock(){
        return "";
    }
}
