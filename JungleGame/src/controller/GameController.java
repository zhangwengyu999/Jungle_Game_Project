package controller;

import model.GameBoard;
import model.Judge;
import view.InfoBox;
import view.InputBox;
import view.Window;

import java.util.List;
import java.util.Random;

public class GameController {
    private Window gameWindow;
    private GameBoard gameBoard;
    private Judge gameJudge;
    private boolean isPlayerARound;
    private String playerAName;
    private String playerBName;
    private KeyboardListener keyboardListener;
    private ModelController modelController;

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
        boolean start = false;
        String option = KeyboardListener.getNormalInput();
        while(!start){
            if(option.equals("S")||option.equals("L")){
                start = true;
            }
            else{
                InfoBox.wrongOptionInfo();
                option = KeyboardListener.getNormalInput();
            }
        }
        if (option.equals("S")){
            InfoBox.startGameInfo();
            gameBoard.resetGameBoard();
            InfoBox.startRoundInfo();
            if (isPlayerARound){
                System.out.print("A");
            }
            else{
                System.out.print("B");
            }
        }
    }

    public void gameEnd() {
        InputBox.pickAndMovePiece();
        String move = KeyboardListener.getPickAndMove();
        if (move!=null) {
            String[] moveArr = move.split(" ");
            int x = Integer.parseInt(moveArr[0]);
            int y = Integer.parseInt(moveArr[1]);
            String d = moveArr[2];
            if (gameJudge.isLegalMovement(x, y, d)) {
               modelController.playerMovePiece(x, y, d);
            } else {
                gameEnd();
            }
        }
        else{
            gameEnd();

        }
    }

//        if (gameJudge.isLegalMovement(move)) {
//            System.out.print("A");
//            InfoBox.EndGameInfo();
//            InfoBox.winnerInfo();
//        } else {
//            System.out.print("B");
//        }
//    }





    public static void main(String[] args) {
        GameController gameController = new GameController();
//        gameController.gameStart();
        gameController.gameEnd();
    }


}
