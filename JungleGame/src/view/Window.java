package view;

import model.GameBoard;

public class Window {
    private static final int width = 60;
    private static final int height = 80;
    private Block[][] block;
    private InfoBox infoBox;
    private InputBox inputBox;
    private MenuPage menuPage;

    public Window() {
        block = new Block[height][width];
        infoBox = new InfoBox();
        inputBox = new InputBox();
        menuPage = new MenuPage();
    }

    public void showMenuWindow(){
        menuPage.showMenuPage();
    }

    public void showInfoBoxWindow(){
        infoBox.showInfo();
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

}