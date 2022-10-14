public class SingleSquare {
    private int x;
    private int y;
    private int width;
    private int height;
    private char[][] pixels;
    private String pixelsString;
    private char content;

    public SingleSquare(int x, int y, char content) {
        this.x = x;
        this.y = y;
        this.width = 9;
        this.height = 5;
        this.content = content;
        this.pixelsString = "+-------+\n" +
                            "|       |\n" +
                            "|   x   |\n" +
                            "|       |\n" +
                            "+-------+";
        render();
    }

    private void render() {
        this.pixels = new char[this.height][this.width];
        int heightPointer = 0;
        int widthPointer = 0;
        for (char c : this.pixelsString.toCharArray()) {
            if (c != '\n') {
                if (heightPointer == 2 && widthPointer == 4) {
                    this.pixels[heightPointer][widthPointer] = content;
                }
                else {
                    this.pixels[heightPointer][widthPointer] = c;
                }
                widthPointer++;
            } else {
                heightPointer++;
                widthPointer = 0;
            }
        }
    }
    public char[][] getPixels() {
        return this.pixels;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
