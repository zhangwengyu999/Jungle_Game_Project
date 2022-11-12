package view;

public class InputBox{
     public static void showInputBox() {
        //...
    }

    public static void inputBoxForPlayerAName() {
        String str = "Please input Player A's name:";
        System.out.print(str);
    }

    public static void inputBoxForPlayerBName() {
        String str = "Please input Player B's name:";
        System.out.print(str);
    }

    public static void pickAndMovePiece(){
        String str = "For x and y are coordinate of piece and d is the direction you prefer to move\n"
                +"Please pick and move a piece with input {x y d}: ";
        System.out.print(str);
    }

    public static void pickAndMovePieceWrongSituation(){
            String str = "You have wrong input, please input again!\n"+"For x and y are coordinate of piece and d is the direction you prefer to move\n"
                    +"Please pick and move a piece with input {x y d}: ";
        System.out.print(str); }


}
