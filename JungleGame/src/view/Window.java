package view;

import model.GameBoard;

public class Window {
    private static final int width = 84; // 7*12 = 84
    private static final int height = 45; // 9 * 5 = 45
    private Square[][] squares;
    private char[][] gameBoardPixels;
    private InfoBox infoBox;
    private InputBox inputBox;
    private MenuPage menuPage;

    public Window() {
        squares = new Square[height][width];
        gameBoardPixels = new char[height][width];
        infoBox = new InfoBox();
        inputBox = new InputBox();
        menuPage = new MenuPage();
    }

    public void showMenuWindow(){
        menuPage.showMenuPage();
    }

    public void showInfoBoxWindow(){
        // infoBox.showInfo();
    }

    public void showInputBoxWindow(){
        inputBox.showInputBox();
    }

    public void updateWindowFromGameBoard(GameBoard inGameBoard) {
        // ...
    }

    public void clearWindow(){
        // ...
    }


    public void addSquare(Square square) {
        int x = square.getX();
        int y = square.getY();
        char[][] squarePixels = square.getPixels();
        for (int i = 0; i < square.getHeight(); i++) {
            for (int j = 0; j < square.getWidth(); j++) {
                this.gameBoardPixels[y + i][x + j] = squarePixels[i][j];
            }
        }
    }

    public void renderCanva() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print(this.gameBoardPixels[i][j]);
            }
            System.out.println();
        }
    }

    public void renderFromModel(String[][] inStrArr) {
        for (int i=0;i<inStrArr.length;i++) {
            for (int j=0;j<inStrArr[i].length;j++) {
                String content = inStrArr[i][j];
                Square temp;
                if (content.equals("")) {
                    temp = new Square(j, i, "g", "  ");
                } else {
                    temp = new Square(j, i, "g", content);
                }
                this.addSquare(temp);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Window window = new Window();
        String[][] expectedOriginal = new String[][]{
                {"LB","","","","","","TB"},
                {"","DB","","","","CB",""},
                {"RB","","PB","","WB","","EB"},
                {"","","","","","",""},
                {"","","","","","",""},
                {"","","","","","",""},
                {"EA","","WA","","PA","","RA"},
                {"","CA","","","","DA",""},
                {"TA","","","","","","LA"}
        };
        window.renderFromModel(expectedOriginal);
        window.renderCanva();
    }

}