package view;

public class InfoBox {
    private String infoString;
    public static void startGameInfo() {
        System.out.println("Game Start!");
    }

    public static void EndGameInfo(){
        System.out.println("Game Over!");
    }

    public static void winnerInfo(){
        System.out.println("The Winner is ");
    }

    public static void startRoundInfo(){
        System.out.println("Start from Player ");
    }

    public static void nextRoundInfo(){
        System.out.println("It is turn of ");
    }
}
