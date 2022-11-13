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
        String str = "<x> and <y>: the COORDINATES of a piece\n<d>: the DIRECTION to move (u:up, d:down, l:left, r:right)\n"
                +"Please pick and move a piece with input {x y d}: ";
        System.out.print(str);
    }

    public static void pickAndMovePieceWrongSituation(){
            String str = "You have wrong input issues, please input again!\n";
        System.out.print(str); }


}
