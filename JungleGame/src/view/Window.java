package view;

import model.GameBoard;

public class Window {
    private static final int width = 84; // 7 * 12 = 84
    private static final int height = 45; // 9 * 5 = 45
    private char[][] gameBoardPixels;
    private MenuPage menuPage;

    public Window() {
        gameBoardPixels = new char[height][width];
        menuPage = new MenuPage();
    }

    public void showMenuWindow(){
        menuPage.showMenuPage();
    }

    public void showJGLogo(){
        menuPage.jgGameLogo();
    }

    public void showGameBoard(String[][] inStrArr) {
        this.renderFromModel(inStrArr);
        this.renderCanva();
    }

    private void addSquareToGameBoard(Square square) {
        int x = square.getX();
        int y = square.getY();
        char[][] squarePixels = square.getPixels();
        for (int i = 0; i < square.getHeight(); i++) {
            for (int j = 0; j < square.getWidth(); j++) {
                this.gameBoardPixels[(square.getHeight())*y + i][(square.getWidth())*x + j] = squarePixels[i][j];
            }
        }
    }

    private void renderCanva() {
        int rowNum = 9;
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (j==0) {
                    if ((i==2 || i==7 || i == 12 || i == 17 || i == 22 || i == 27 || i == 32 || i == 37 || i == 42)) {
                        String temp = rowNum+" ";
                        rowNum--;
                        System.out.print(temp+""+this.gameBoardPixels[i][j]);
                    }
                    else if(i==44){
                        System.out.print("Y "+this.gameBoardPixels[i][j]);
                    }
                    else {
                        System.out.print("  "+this.gameBoardPixels[i][j]);
                    }
                }
                else {
                    System.out.print(this.gameBoardPixels[i][j]);
                }
            }
            System.out.println();
        }
        String str = "  X     1           2           3           4           5           6           7     ";
        System.out.println(str);
    }

    private void renderFromModel(String[][] inStrArr) {
        for (int i=0;i<inStrArr.length;i++) {
            for (int j=0;j<inStrArr[i].length;j++) {
                String content = inStrArr[i][j];
                Square temp;
                String type = getType(i,j);
                    if (content.equals("")) {temp = new Square(j, i, type, "  ");}
                    else {temp = new Square(j, i, type, content);}
                    this.addSquareToGameBoard(temp);
            }
        }
    }

    private String getType(int i, int j) {
        if ((i==0 && j ==2) || (i==0 && j ==4) || (i==1 && j ==3) || (i==8 && j ==2) || (i==8 && j ==4) || (i==7 && j ==3)) {
            return "t";
        }
        else if ((i==0 && j ==3) || (i==8 && j ==3)) {
            return  "d";
        }
        else if ((i==3 && j ==1) ||(i==4 && j ==1) ||(i==5 && j ==1) || (i==3 && j ==2) ||(i==4 && j ==2) ||(i==5 && j ==2) ||
                (i==3 && j ==4) ||(i==4 && j ==4) ||(i==5 && j ==4) || (i==3 && j ==5) ||(i==4 && j ==5) ||(i==5 && j ==5)) {
            return  "w";
        }
        else {
            return  "g";
        }
    }
}