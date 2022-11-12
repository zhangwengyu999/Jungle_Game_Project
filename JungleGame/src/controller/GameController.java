package controller;

import model.GameBoard;
import model.Judge;
import view.InfoBox;
import view.Window;
import java.util.Random;

public class GameController {
    private Window gameWindow;
    private GameBoard gameBoard;
    private Judge gameJudge;
    private boolean isPlayerARound;
    private String playerAName;
    private String playerBName;
    private KeyboardListener keyboardListener;

    public GameController(){
        gameBoard = GameBoard.getGameBoard();
        gameJudge = Judge.getGameJudge(gameBoard);
        gameWindow = new Window();
        isPlayerARound = randomInitialRound();
        playerAName = "Player A";
        playerBName = "Player B";
    }

    public void setPlayerAName(String inName){
        playerAName = inName;
    }

    public void setPlayerBName(String inName){
        playerBName = inName;
    }

    private void toggleRound() {
        isPlayerARound = !isPlayerARound;
    }

    private boolean randomInitialRound(){
        Random rand = new Random();
        return rand.nextBoolean();
    }

    public void gameStart(){
        gameWindow.showMenuWindow();
        if (KeyboardListener.getNormalInput().equals("S")){
            gameBoard.resetGameBoard();
            InfoBox.startGameInfo();
            if (isPlayerARound){
                InfoBox.startRoundInfo();
                System.out.print("A");
            }
            else{
                System.out.print("B");
            }
            //while(!gameJudge.isAWin())
        }

    }


}
