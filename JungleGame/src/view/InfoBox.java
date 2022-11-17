package view;

public class InfoBox {

    public static void startGameInfo() {
        System.out.println("Game Started!");
    }

    public static void EndGameInfo() {
        System.out.println("Game Over!");
    }

    public static void winnerInfo() {
        System.out.print("The Winner is ");
    }

    public static void wrongOptionInfo() {
        System.out.println("Wrong Option!");
        System.out.print("Please input the option in bracket as [x]: ");
    }

    public static void mapRepresents(){
        System.out.println("                           -----------------------------------");
        System.out.println("                           -     Abbreviation for pieces:    -");
        System.out.println("                           -        E(Rank 8): Elephant      -");
        System.out.println("                           -        L(Rank 7): Lion          -");
        System.out.println("                           -        T(Rank 6): Tiger         -");
        System.out.println("                           -        P(Rank 5): Leopard       -");
        System.out.println("                           -        W(Rank 4): Wolf          -");
        System.out.println("                           -        D(Rank 3): Dog           -");
        System.out.println("                           -        C(Rank 2): Cat           -");
        System.out.println("                           -        R(Rank 1): Rat           -");
        System.out.println("                           -     Piece A & [ ]: PlayerA's    -");
        System.out.println("                           -     Piece B & < >: PlayerB's    -");
        System.out.println("                           -----------------------------------");
        System.out.println("                           -        Symbol for Squares:      -");
        System.out.println("                           -       '---': General Land       -");
        System.out.println("                           -       '$$$': Den Land           -");
        System.out.println("                           -       '###': Trap Land          -");
        System.out.println("                           -       '@@@': Water Area         -");
        System.out.println("                           -----------------------------------\n");

    }
}
