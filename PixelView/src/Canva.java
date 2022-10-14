public class Canva {

    private int width;
    private int height;
    private char[][] canvaPixels;

    public Canva(int width, int height) {
        this.width = width;
        this.height = height;
        this.canvaPixels = new char[height][width];
    }

    public void addSingleSquare(SingleSquare square) {
        int x = square.getX();
        int y = square.getY();
        char[][] squarePixels = square.getPixels();
        for (int i = 0; i < square.getHeight(); i++) {
            for (int j = 0; j < square.getWidth(); j++) {
                this.canvaPixels[y + i][x + j] = squarePixels[i][j];
            }
        }
    }

    public void renderCanva() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (this.canvaPixels[i][j] == '\u0000') {
                    System.out.print(".");
                } else {
                    System.out.print(this.canvaPixels[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Canva canva = new Canva(57, 18);
        SingleSquare Lion = new SingleSquare(0, 0, 'L');
        SingleSquare Dog = new SingleSquare(8, 4, 'D');
        SingleSquare Mouse = new SingleSquare(0, 8, 'M');
        SingleSquare Leopard = new SingleSquare(16, 8, 'P');
        SingleSquare Wolf = new SingleSquare(32, 8, 'W');
        SingleSquare Cat = new SingleSquare(40, 4, 'C');
        SingleSquare Elephant = new SingleSquare(48, 8, 'E');
        SingleSquare Tiger = new SingleSquare(48, 0, 'T');

        canva.addSingleSquare(Lion);
        canva.addSingleSquare(Dog);
        canva.addSingleSquare(Mouse);
        canva.addSingleSquare(Leopard);
        canva.addSingleSquare(Wolf);
        canva.addSingleSquare(Cat);
        canva.addSingleSquare(Elephant);
        canva.addSingleSquare(Tiger);

        canva.renderCanva();
    }
}
