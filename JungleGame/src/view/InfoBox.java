package view;

public class InfoBox {
    private String infoString;
    public static void startGameInfo() {
        System.out.println("Game Started!");
    }

    public static void EndGameInfo(){
        System.out.println("Game Over!");
    }

    public static void winnerInfo(){
        System.out.print("The Winner is ");
    }

    public static void startRoundInfo(){
        System.out.print("Randomly start from: ");
    }

    public static void wrongOptionInfo(){
        System.out.println("Wrong Option!");
        System.out.print("Please input the option in bracket as [x]: ");
    }
}
