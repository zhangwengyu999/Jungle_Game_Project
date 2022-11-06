package model;

public class GameBoard {
    private final int WIDTH;
    private final int HEIGHT;
    private Square[][] squares;
    private Piece[][] pieces;
    private int alivePieceOfPlayerA;
    private int alivePieceOfPlayerB;
    private static GameBoard gameBoard = new GameBoard();

    private GameBoard(){
        WIDTH = 7;
        HEIGHT = 9;
        alivePieceOfPlayerA = 8;
        alivePieceOfPlayerB = 8;
        initializeSquares();
        initializePieces();
    }

    public static GameBoard getGameBoard(){
        return gameBoard;
    }

    public static void resetGameBoard(){
        gameBoard = new GameBoard();
    }

    /**
     * Initialize all squares of the game board,
     * and put them in the right position.
     */
    private void initializeSquares() {
        // initialize squares 2D array
        squares = new Square[WIDTH][HEIGHT];

        // initialize Den squares
        squares[3][0] = new Square("den");
        squares[3][8] = new Square("den");

        // initialize Trap squares
        squares[2][0] = new Square("trap");
        squares[3][1] = new Square("trap");
        squares[4][0] = new Square("trap");

        squares[2][8] = new Square("trap");
        squares[3][7] = new Square("trap");
        squares[4][8] = new Square("trap");
        
        // initialize Water squares
        for (int i=1;i<=2;i++) {
            for (int j=3;j<=5;j++) {
                squares[i][j] = new Square("water");
            }
        }

        for (int i=4;i<=5;i++) {
            for (int j=3;j<=5;j++) {
                squares[i][j] = new Square("water");
            }
        }

        // initialize General Land squares
        for (int i=0;i<HEIGHT;i++) {
            squares[0][i] = new Square("generalLand");
        }
        for (int i=0;i<HEIGHT;i++) {
            squares[6][i] = new Square("generalLand");
        }
        for (int i=0;i<WIDTH;i++) {
            squares[i][2] = new Square("generalLand");
        }
        for (int i=0;i<WIDTH;i++) {
            squares[i][6] = new Square("generalLand");
        }
        for (int i=2;i<=6;i++) {
            squares[3][i] = new Square("generalLand");
        }
        squares[1][0] = new Square("generalLand");
        squares[1][1] = new Square("generalLand");
        squares[2][1] = new Square("generalLand");
        squares[5][0] = new Square("generalLand");
        squares[5][1] = new Square("generalLand");
        squares[4][1] = new Square("generalLand");

        squares[1][8] = new Square("generalLand");
        squares[1][7] = new Square("generalLand");
        squares[2][7] = new Square("generalLand");
        squares[5][8] = new Square("generalLand");
        squares[5][7] = new Square("generalLand");
        squares[4][7] = new Square("generalLand");
    }

    /**
     * Initialize all pieces of the game board,
     * and put them in the right position.
     */
    private void initializePieces(){
        // initialize pieces 2D array
        pieces = new Piece[WIDTH][HEIGHT];

        // initialize PlayerA's pieces
        Piece ElephantA = new Elephant(true);
        pieces[0][2] = ElephantA;
        Piece LionA = new Lion(true);
        pieces[6][0] = LionA;
        Piece tigerA = new Tiger(true);
        pieces[0][0] = tigerA;
        Piece LeopardA = new Leopard(true);
        pieces[4][2] = LeopardA;
        Piece WolfA = new Wolf(true);
        pieces[2][2] = WolfA;
        Piece DogA = new Dog(true);
        pieces[5][1] = DogA;
        Piece CatA = new Cat(true);
        pieces[1][1] = CatA;
        Piece RatA = new Rat(true);
        pieces[6][2] = RatA;

        // initialize PlayerB's pieces
        Piece ElephantB= new Elephant(false);
        pieces[6][6] = ElephantB;
        Piece LionB = new Lion(false);
        pieces[0][8] = LionB;
        Piece TigerB = new Tiger(false);
        pieces[6][8] = TigerB;
        Piece LeopardB = new Leopard(false);
        pieces[2][6] = LeopardB;
        Piece WolfB = new Wolf(false);
        pieces[4][6] = WolfB;
        Piece DogB = new Dog(false);
        pieces[1][7] = DogB;
        Piece CatB = new Cat(false);
        pieces[5][7] = CatB;
        Piece RatB = new Rat(false);
        pieces[0][6] = RatB;
    }

    /**
     * @return all pieces in the game board in 2D array
     */
    public Piece[][] getPiece(){
        return pieces;
    }

    public Piece getPieceFromXY(int inX, int inY) {
        if (inX < 0 || inX >= WIDTH || inY < 0 || inY >= HEIGHT) {
            return null;
        }
        return pieces[inX][inY];
    }

    // new
    public Square getSquareFromXY(int inX, int inY) {
        return squares[inX][inY];
    }

    // new
    public void movePieceToXY(int fromX, int fromY, int toX, int toY) {
        pieces[toX][toY] = pieces[fromX][fromY];
        pieces[fromX][fromY] = null;
        pieces[toX][toY].setPositionType(squares[toX][toY].getSquareType());
    }

    /*
    * @param inX, inY: a piece at (inX, inY)
    * move up a piece at (inX, inY), Lion and Tiger can jump over the water
    */
    public void moveUp(int inX, int inY) {
        if (getPieceFromXY(inX, inY) != null) {
            if ((getPieceFromXY(inX, inY).getRank() == 7 || getPieceFromXY(inX, inY).getRank() == 6)
                    && ((inX == 1 && inY == 2) || (inX == 2 && inY == 2)
                    || (inX == 4 && inY == 2) || (inX == 5 && inY == 2))) {
                movePieceToXY(inX, inY, inX, inY + 4);
            }
            else {
                movePieceToXY(inX, inY, inX, inY + 1);
            }
        }
    }
    /*
     * @param inX, inY: a piece at (inX, inY)
     * move down a piece at (inX, inY), Lion and Tiger can jump over the water
     */
    public void moveDown(int inX, int inY){
        if (getPieceFromXY(inX, inY) != null) {
            if ((getPieceFromXY(inX, inY).getRank() == 6 || getPieceFromXY(inX, inY).getRank() == 7) &&
                    (inX == 1 && inY == 6) || (inX == 2 && inY == 6) || (inX == 4 && inY == 6) || (inX == 5 && inY == 6)) {
                movePieceToXY(inX, inY, inX, inY - 4);
            }
            else {
                movePieceToXY(inX, inY, inX, inY - 1);
            }
        }
    }


    /*
     * @param inX, inY: a piece at (inX, inY)
     * move left a piece at (inX, inY), Lion and Tiger can jump over the water
     */
    public void moveLeft(int inX, int inY) {
        if (getPieceFromXY(inX, inY) != null) {
            if ((getPieceFromXY(inX, inY).getRank() == 6 || getPieceFromXY(inX, inY).getRank() == 7) &&
                    ((inX == 3 && inY == 5) || (inX == 3 && inY == 4) || (inX == 3 && inY == 3)
                        || (inX == 6 && inY == 5) || (inX == 6 && inY == 4) || (inX == 6 && inY == 3))) {
                    movePieceToXY(inX, inY, inX - 3, inY);
                }
                else {
                    movePieceToXY(inX, inY, inX - 1, inY);
                }
        }
    }
    /*
     * @param inX, inY: a piece at (inX, inY)
     * move right a piece at (inX, inY), Lion and Tiger can jump over the water
     */
    public void moveRight(int inX, int inY) {
        if (getPieceFromXY(inX, inY) != null) {
            if ((getPieceFromXY(inX, inY).getRank() == 7 || getPieceFromXY(inX, inY).getRank() == 6)
                    && (inX == 0 && inY == 3 || inX == 0 && inY == 4 || inX == 0 && inY == 5
                        || inX == 3 && inY == 3 || inX == 3 && inY == 4 || inX == 3 && inY == 5)) {
                    movePieceToXY(inX, inY, inX + 3, inY);
                }
                else {
                    movePieceToXY(inX, inY, inX + 1, inY);
                }
        }

    }


    // new+new 2022.11.03
    /*
    The function of capture was deleted. In model, we did not make judgment, but only set the survival state of chess pieces.
    Therefore, we directly set a function to set the death, and left the judgment to the controller.
    */
    public void setPiecesDeath(int inX, int inY) {
        if (getPieceFromXY(inX, inY) != null) {
            Piece piece = getPieceFromXY(inX, inY);
            if (piece.getIsBelongToPlayerA()) {
                alivePieceOfPlayerA--;
            } else {
                alivePieceOfPlayerB--;
            }
            piece.setDead();
            pieces[inX][inY] = null;
        }
    }

    // new
    public int getAlivePieceOfPlayerA() {
        return alivePieceOfPlayerA;
    }

    // new
    public int getAlivePieceOfPlayerB() {
        return alivePieceOfPlayerB;
    }

    public String[][] getUpdate() {
        String[][] out = new String[HEIGHT][WIDTH];
        for (int h = 0;h<=8;h++){
            for (int w = 0;w<=6;w++){
                Piece piece = getPieceFromXY(w,h);
                if (piece!=null) {
                    out[8-h][w] = getPieceFromXY(w,h).getName();
                }
                else {
                    out[8-h][w] = "";
                }
            }
        }
        return out;
    }
}