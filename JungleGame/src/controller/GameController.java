package controller;

import model.GameBoard;
import model.Judge;
import view.InfoBox;
import view.InputBox;
import view.Window;
import java.util.Random;

public class GameController {
    private Window gameWindow;
    private GameBoard gameBoard;
    private Judge gameJudge;
    private boolean isPlayerARound;
    private String playerAName;
    private String playerBName;
    private ModelController modelController;

    /**
     * Constructor
     */
    public GameController(){
        gameBoard = GameBoard.getGameBoard();
        gameJudge = Judge.getGameJudge(gameBoard);
        gameWindow = new Window();
        modelController = new ModelController();
        isPlayerARound = randomInitialRound();
        playerAName = "Player A";
        playerBName = "Player B";
    }

    /**
     * Toggle the round between player A and player B
     */
    private void toggleRound() {
        isPlayerARound = !isPlayerARound;
    }

    /**
     * Randomly generate the initial round between player A and player B
     * @return true for player A; false for player B
     */
    private boolean randomInitialRound(){
        Random rand = new Random();
        return rand.nextBoolean();
    }

    /**
     * Update the view to the welcome page
     */
    public void welcome(){
        gameWindow.showJGLogo();
        System.out.println("Welcome to the JG Game!\n");
        gameStart();
    }

    /**
     * Start the game
     */
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

    /**
     * Process the game
     */
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

    /**
     * Render the game board to the View
     */
    public void printGameBoard(){
        gameWindow.showGameBoard(modelController.getUpdateToGameBoard());
    }

    /**
     * Main entrance of the game
     */
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.welcome();
    }
}
