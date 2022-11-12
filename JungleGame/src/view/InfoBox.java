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
        System.out.print("The Winner is ");
    }

    public static void startRoundInfo(){
        System.out.print("Start from Player ");
    }

    public static void nextRoundInfo(){
        System.out.print("It is turn of ");
    }

    public static void wrongOptionInfo(){
        System.out.println("Wrong Option!");
        System.out.print("Please input the option in bracket as [x]: ");
    }
}
