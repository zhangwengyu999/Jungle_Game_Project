package view;

/**
 * This class is used to show the view of square and piece of the game board.
 */
public class Square {
    private int x;
    private int y;
    private final int width = 12;
    private final int height = 5;
    private char[][] pixels;
    private String pieceContent;
    private String blockFrame;

    /**
     * Constructor of Square class
     * @param inX x coordinate of the square
     * @param inY y coordinate of the square
     * @param inType type of the square
     * @param inContent the display content of the square
     */
    public Square(int inX, int inY, String inType, String inContent) {
        x = inX;
        y = inY;
        pieceContent = inContent;
        if (inType.equals("g")) {
            setAsGeneralLandFrame();
        }
        else if (inType.equals("d")) {
            setAsDenFrame();
        }
        else if (inType.equals("t")) {
            setAsTrapFrame();
        }
        else if (inType.equals("w")) {
            setAsRiverFrame();
        }
    }

    /**
     * Set the square view as the den square with '$'
     */
    public void setAsDenFrame() {
        blockFrame =
                    "+$$$$$$$$$$+\n" +
                    "$          $\n" +
                    "$          $\n" +
                    "$          $\n" +
                    "+$$$$$$$$$$+";

    }

    /**
     * Set the square view as the trap square with '#'
     */
    public void setAsTrapFrame(){
        blockFrame =
                    "+#-#-##-#-#+\n" +
                    "#          #\n" +
                    "#          #\n" +
                    "#          #\n" +
                    "+#-#-##-#-#+";

    }

    /**
     * Set the square view as the river square with '@'
     */
    public void setAsRiverFrame(){
        blockFrame =
                    "+@@@@@@@@@@+\n" +
                    "@          @\n" +
                    "@          @\n" +
                    "@          @\n" +
                    "+@@@@@@@@@@+";

    }

    /**
     * Set the square view as the general land square with '-'
     */
    public void setAsGeneralLandFrame(){
        blockFrame =
                    "+----------+\n" +
                    "-          -\n" +
                    "-          -\n" +
                    "-          -\n" +
                    "+----------+";
    }

    /**
     * Render the square boundary and content into the 2-D char array (pixels)
     */
    private void render() {
        this.pixels = new char[this.height][this.width];
        int heightPointer = 0;
        int widthPointer = 0;
        for (char c : this.blockFrame.toCharArray()) {
            if (c != '\n') {
                if (heightPointer == 2 && widthPointer == 5) {
                    this.pixels[heightPointer][widthPointer] = pieceContent.charAt(0);
                }
                else if (heightPointer == 2 && widthPointer == 6) {
                    this.pixels[heightPointer][widthPointer] = pieceContent.charAt(1);
                }
                else {
                    this.pixels[heightPointer][widthPointer] = c;
                }
                if (!pieceContent.equals("  ")) {
                    if(pieceContent.charAt(1) == 'A') {
                        this.pixels[2][4] = '[';
                        this.pixels[2][7] = ']';
                    }else {
                        this.pixels[2][4] = '<';
                        this.pixels[2][7] = '>';
                    }
                }
                widthPointer++;
            } else {
                heightPointer++;
                widthPointer = 0;
            }
        }
    }

    /**
     * Get the x coordinate of the square
     * @return x coordinate of the square
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y coordinate of the square
     * @return y coordinate of the square
     */
    public int getY() {
        return y;
    }

    /**
     * Get the width of the square
     * @return width of the square
     */
    public int getWidth() {
        return width;
    }

    /**
     * Get the height of the square
     * @return height of the square
     */
    public int getHeight() {
        return height;
    }

    /**
     * First render and get the 2-D char array of the square as pixels
     * @return
     */
    public char[][] getPixels() {
        render();
        return this.pixels;
    }
}
