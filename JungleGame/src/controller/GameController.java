package controller;

import model.GameBoard;
import model.Judge;
import view.InfoBox;
import view.InputBox;
import view.Window;

import java.util.List;
import java.util.Random;

import static view.InputBox.inputBoxForPlayerAName;

public class GameController {
    private Window gameWindow;
    private GameBoard gameBoard;
    private Judge gameJudge;
    private boolean isPlayerARound;
    private String playerAName;
    private String playerBName;
    private ModelController modelController;

    public GameController(){
        gameBoard = GameBoard.getGameBoard();
        gameJudge = Judge.getGameJudge(gameBoard);
        gameWindow = new Window();
        modelController = new ModelController();
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
            if(option.equals("S")||option.equals("Q")){
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

            // Ask for player names
            InputBox.inputBoxForPlayerAName();
            playerAName = KeyboardListener.getNormalInput();
            InputBox.inputBoxForPlayerBName();
            playerBName = KeyboardListener.getNormalInput();

            // Randomly start from player A or B
            InfoBox.startRoundInfo();

            if (isPlayerARound){
                System.out.print(playerAName);
                gameProcess();
            }
            else{
                System.out.print(playerBName);
                gameProcess();
            }
        }
        else {
            System.exit(0);
        }
    }

    public void gameProcess() {
        InputBox.pickAndMovePiece();
        String move = KeyboardListener.getPickAndMove();
        if (move!=null) {
            String[] moveArr = move.split(" ");
            int x = Integer.parseInt(moveArr[0]);
            int y = Integer.parseInt(moveArr[1]);
            String d = moveArr[2];
            if (gameJudge.isLegalMovement(x, y, d, isPlayerARound)) {
               modelController.playerMovePiece(x, y, d);
               toggleRound();


            }
        }
        else{


        }
    }

    public void printGameBoard(){
        gameWindow.showGameBoard(modelController.getUpdateToGameBoard());
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
        gameController.gameStart();
    }


}
