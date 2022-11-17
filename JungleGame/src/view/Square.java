package view;

public class Square {
    private int x;
    private int y;
    private final int width = 12;
    private final int height = 5;
    private char[][] pixels;
    private String pieceContent;
    private String blockFrame;


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

    public void setAsDenFrame() {
        blockFrame =
                    "+$$$$$$$$$$+\n" +
                    "$          $\n" +
                    "$          $\n" +
                    "$          $\n" +
                    "+$$$$$$$$$$+";

    }

    public void setAsTrapFrame(){
        blockFrame =
                    "+#-#-##-#-#+\n" +
                    "#          #\n" +
                    "#          #\n" +
                    "#          #\n" +
                    "+#-#-##-#-#+";

    }

    public void setAsRiverFrame(){
        blockFrame =
                    "+@@@@@@@@@@+\n" +
                    "@          @\n" +
                    "@          @\n" +
                    "@          @\n" +
                    "+@@@@@@@@@@+";

    }

    public void setAsGeneralLandFrame(){
        blockFrame =
                    "+----------+\n" +
                    "-          -\n" +
                    "-          -\n" +
                    "-          -\n" +
                    "+----------+";
    }

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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getPixels() {
        render();
        return this.pixels;
    }

    public char getPiece(){
        return '$';
    }
}
