package controller;

import model.GameBoard;
import model.Judge;
import view.InfoBox;
import view.InputBox;
import view.MenuPage;
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
    public void welcome(){
        gameWindow.showJGLogo();
        System.out.println("Welcome to the JG Game!\n");
        gameStart();
    }
    public void gameStart(){
        gameWindow.showMenuWindow();
        boolean start = false;
        String option = KeyboardListener.getNormalInput();
        while(!start){
            if(option.equalsIgnoreCase("S")||option.equalsIgnoreCase("Q")){
                start = true;
            }
            else{
                InfoBox.wrongOptionInfo();
                option = KeyboardListener.getNormalInput();
            }
        }
        if (option.equalsIgnoreCase("S")){
            // Ask for player names
            InputBox.inputBoxForPlayerAName();
            playerAName = KeyboardListener.getNormalInput();
            InputBox.inputBoxForPlayerBName();
            playerBName = KeyboardListener.getNormalInput();
            InfoBox.startGameInfo();
            gameBoard.resetGameBoard();
            // Randomly start from player A or B
            printGameBoard();
            InfoBox.mapRepresents();
            System.out.println("---------------------The Game Start randomly from: " + (isPlayerARound ? "PlayerA "+"["+playerAName+"]" : "PlayerB "+"<"+playerBName+">")+"---------------------");
            gameProcess();
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
            int desX = x-1;
            int desY = y-1;
            if (gameJudge.isLegalMovement(desX, desY, d, isPlayerARound)) {
               modelController.playerMovePiece(desX, desY, d);
               toggleRound();
               if (!gameJudge.isAWin(gameBoard.getPieceAfterMovement(desX, desY, d))
                       && !gameJudge.isBWin(gameBoard.getPieceAfterMovement(desX, desY, d))) {
                   printGameBoard();
                   System.out.println("Next round is the turn of " + (isPlayerARound ? "PlayerA "+"["+playerAName+"]" : "PlayerB "+"<"+playerBName+">"));
                   System.out.println("Remaining pieces of A is : "+gameBoard.getAlivePieceOfPlayerA());
                   System.out.println("Remaining pieces of B is : "+gameBoard.getAlivePieceOfPlayerB());
                   gameProcess();
               }
               else {
                   printGameBoard();
                   InfoBox.EndGameInfo();
                   InfoBox.winnerInfo();
                   if (gameJudge.isAWin(gameBoard.getPieceFromXY(desX,desY))) {
                       System.out.print(playerAName+"\n");
                   } else {
                       System.out.print(playerBName+"\n");
                   }
                   gameStart();
               }
            }
            else {
                InputBox.pickAndMovePieceWrongSituation();
                gameProcess();
            }
        }
        else{
            InputBox.pickAndMovePieceWrongSituation();
            gameProcess();
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
        gameController.welcome();
    }


}
