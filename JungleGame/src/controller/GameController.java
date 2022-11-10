package controller;

import model.GameBoard;
import model.Judge;
import view.Window;
import java.util.Random;

public class GameController {
    private Window gameWindow;
    private GameBoard gameBoard;
    private Judge gameJudge;
    private boolean isPlayerARound;
    private KeyboardListener keyboardListener;

    public GameController(){
        gameBoard = GameBoard.getGameBoard();
        gameJudge = Judge.getGameJudge(gameBoard);
        isPlayerARound = randomInitialRound();
    }

    public void roundAction(){

    }

    public void toggleRound() {
        isPlayerARound = !isPlayerARound;
    }

    public void initialRound(){

    }

    private boolean randomInitialRound(){
        Random rand = new Random();
        return rand.nextBoolean();
    }
}
