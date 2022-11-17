package model;

public class GameBoard {
    private final int WIDTH;
    private final int HEIGHT;
    private Square[][] squares;
    private Piece[][] pieces;
    private int alivePieceOfPlayerA;
    private int alivePieceOfPlayerB;
    private static GameBoard gameBoard = new GameBoard();

    /**
     * Private constructor for Singleton Pattern
     * Ensure that only one instance of GameBoard can be created
     * Meaning only one GameBoard can be played at a time
     */
    private GameBoard(){
        WIDTH = 7;
        HEIGHT = 9;
        alivePieceOfPlayerA = 8;
        alivePieceOfPlayerB = 8;
        initializeSquares();
        initializePieces();
    }

    /**
     * Get the only instance of GameBoard
     * @return the instance of GameBoard
     */
    public static GameBoard getGameBoard(){
        return gameBoard;
    }

    // new!!
    /**
     * Reset the GameBoard to a new instance for a new game
     */
    public void resetGameBoard(){
        gameBoard = new GameBoard();
        initializePieces();
        initializeAlivePieceOfPlayer();
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

    /**
     * Get the piece at the given position
     * @param inX the x coordinate of the position
     * @param inY the y coordinate of the position
     * @return the Piece at the given position
     */
    public Piece getPieceFromXY(int inX, int inY) {
        if (inX < 0 || inX >= WIDTH || inY < 0 || inY >= HEIGHT) {
            return null;
        }
        return pieces[inX][inY];
    }

    // new !!
    /**
     * Get the piece at a position after a movement
     * @param inX the x coordinate of the position
     * @param inY the y coordinate of the position
     * @param direction the direction of the movement
     * @return the piece at a position after the movement
     */
    public Piece getPieceAfterMovement(int inX, int inY, String direction) {
        if (inX < 0 || inX >= WIDTH || inY < 0 || inY >= HEIGHT) {
            return null;
        }
        else{
            if (direction.equals("U")){
                return pieces[inX][inY+1];
            }
            else if(direction.equals("D")){
                return pieces[inX][inY-1];
            }
            else if(direction.equals("L")){
                return pieces[inX-1][inY];
            }
            else if(direction.equals("R")){
                return pieces[inX+1][inY];
            }
            else{
                return null;
            }
        }
    }

    /**
     * Get the square at the given position
     * @param inX the x coordinate of the position
     * @param inY the y coordinate of the position
     * @return the Square at the given position
     */
    public Square getSquareFromXY(int inX, int inY) {
        return squares[inX][inY];
    }

    // new !!
    /**
     * Move a piece to a new position
     * @param fromX the x coordinate of the original position
     * @param fromY the y coordinate of the original position
     * @param toX the x coordinate of the new position
     * @param toY the y coordinate of the new position
     */
    public void movePieceToXY(int fromX, int fromY, int toX, int toY) {
        pieces[toX][toY] = pieces[fromX][fromY];
        pieces[fromX][fromY] = null;
        pieces[toX][toY].setPositionType(squares[toX][toY].getSquareType());
    }

    // new 2022.11.10
    /**
     * Get the destination after move up(but no movement happened) a piece at (inX, inY), Lion and Tiger can jump over the water
     * @param inX, inY: a piece at (inX, inY)
     * @return int[] the destination coordinate of the piece
     */
    public int[] getMoveUpDestination(int inX, int inY) {
        if (getPieceFromXY(inX, inY) != null) {
            if ((getPieceFromXY(inX, inY).getRank() == 7 || getPieceFromXY(inX, inY).getRank() == 6)
                    && ((inX == 1 && inY == 2) || (inX == 2 && inY == 2)
                    || (inX == 4 && inY == 2) || (inX == 5 && inY == 2))) {
                return new int[]{inX, inY + 4};
            } else {
                return new int[] {inX,inY+1};
            }
        }
        return null;
    }

    /**
    * move up a piece at (inX, inY), Lion and Tiger can jump over the water
    * @param inX, inY: a piece at (inX, inY)
    */
    public void moveUp(int inX, int inY) {
        if (getPieceFromXY(inX, inY) != null) {
            int[] temp = getMoveUpDestination(inX, inY);
            movePieceToXY(inX, inY, temp[0], temp[1]);
        }
    }

    // new 2022.11.10
    /**
     * Get the destination after move down(but no movement happened) a piece at (inX, inY), Lion and Tiger can jump over the water
     * @param inX, inY: a piece at (inX, inY)
     * @return int[] the destination coordinate of the piece
     */
    public int[] getMoveDownDestination(int inX, int inY){
        if (getPieceFromXY(inX, inY) != null) {
            if ((getPieceFromXY(inX, inY).getRank() == 6 || getPieceFromXY(inX, inY).getRank() == 7) &&
                    (inX == 1 && inY == 6) || (inX == 2 && inY == 6) || (inX == 4 && inY == 6) || (inX == 5 && inY == 6)) {
                return new int[]{inX, inY - 4};
            }
            else {
                return new int[]{inX, inY - 1};
            }
        }
        return null;
    }

    /**
     * @param inX, inY: a piece at (inX, inY)
     * move down a piece at (inX, inY), Lion and Tiger can jump over the water
     */
    public void moveDown(int inX, int inY){
        if (getPieceFromXY(inX, inY) != null) {
            int[] temp = getMoveDownDestination(inX, inY);
            movePieceToXY(inX, inY, temp[0], temp[1]);
        }
    }

    // new 2022.11.10
    /**
     * Get the destination after move left (but no movement happened) a piece at (inX, inY), Lion and Tiger can jump over the water
     * @param inX, inY: a piece at (inX, inY)
     * @return int[] the destination coordinate of the piece
     */
    public int[] getMoveLeftDestination(int inX, int inY) {
        if (getPieceFromXY(inX, inY) != null) {
            if ((getPieceFromXY(inX, inY).getRank() == 6 || getPieceFromXY(inX, inY).getRank() == 7) &&
                    ((inX == 3 && inY == 5) || (inX == 3 && inY == 4) || (inX == 3 && inY == 3)
                            || (inX == 6 && inY == 5) || (inX == 6 && inY == 4) || (inX == 6 && inY == 3))) {
                return new int[]{inX-3, inY};
            }
            else {
                return new int[]{inX-1, inY};
            }
        }
        return null;
    }

    /**
     * @param inX, inY: a piece at (inX, inY)
     * move left a piece at (inX, inY), Lion and Tiger can jump over the water
     */
    public void moveLeft(int inX, int inY) {
        if (getPieceFromXY(inX, inY) != null) {
            int[] temp = getMoveLeftDestination(inX, inY);
            movePieceToXY(inX, inY, temp[0], temp[1]);
        }
    }

    // new 2022.11.10
    /**
     * Get the destination after move right(but no movement happened) a piece at (inX, inY), Lion and Tiger can jump over the water
     * @param inX, inY: a piece at (inX, inY)
     * @return int[] the destination coordinate of the piece
     */
    public int[] getMoveRightDestination(int inX, int inY) {
        if (getPieceFromXY(inX, inY) != null) {
            if ((getPieceFromXY(inX, inY).getRank() == 7 || getPieceFromXY(inX, inY).getRank() == 6)
                    && (inX == 0 && inY == 3 || inX == 0 && inY == 4 || inX == 0 && inY == 5
                    || inX == 3 && inY == 3 || inX == 3 && inY == 4 || inX == 3 && inY == 5)) {
                return new int[]{inX+3, inY};
            }
            else {
                return new int[]{inX+1, inY};
            }
        }
        return null;
    }
    /**
     * @param inX, inY: a piece at (inX, inY)
     * move right a piece at (inX, inY), Lion and Tiger can jump over the water
     */
    public void moveRight(int inX, int inY) {
        if (getPieceFromXY(inX, inY) != null) {
            int[] temp = getMoveRightDestination(inX, inY);
            movePieceToXY(inX, inY, temp[0], temp[1]);
        }
    }

    // new+new 2022.11.03
    /**
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

    /**
     * Get the number of alive pieces of player A
     * @return
     */
    public int getAlivePieceOfPlayerA() {
        return alivePieceOfPlayerA;
    }

    /**
     * Get the number of alive pieces of player B
     * @return
     */
    public int getAlivePieceOfPlayerB() {
        return alivePieceOfPlayerB;
    }

    // new
    /**
     * Initialize the number of alive pieces of player A and player B
     */
    private void initializeAlivePieceOfPlayer(){
        alivePieceOfPlayerA = 8;
        alivePieceOfPlayerB = 8;
    }

    /**
     * Get the updated GameBoard in 2-D String array of Pieces and Squares
     * @return
     */
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