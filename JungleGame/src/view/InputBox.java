package view;

public class InputBox{
     public static void showInputBox() {
        //...
    }

    public static void inputBoxForPlayerAName() {
        String str = "Please input Player A's name: ";
        System.out.print(str);
    }

    public static void inputBoxForPlayerBName() {
        String str = "Please input Player B's name: ";
        System.out.print(str);
    }

    public static void pickAndMovePiece(){
        String str = "For <x> and <y> are COORDINATOR of piece and <d> is the DIRECTION you prefer to move\n"
                +"Please pick and move a piece with input {x y d}: ";
        System.out.print(str);
    }

    public static void pickAndMovePieceWrongSituation(){
            String str = "You have wrong input issues, please input again!\n";
        System.out.print(str); }


}
