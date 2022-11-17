package controller;

import java.util.Scanner;

public class KeyboardListener {

    /**
     * Get the input from the keyboard on pick and move
     * @return the input from the keyboard
     */
    public static String getPickAndMove() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toUpperCase();
        if (isValidInputForPickAndMove(str)) {
            return str;
        }
        else {return null;}
    }

    /**
     * Get the input from the keyboard for general input
     * @return the input from the keyboard
     */
    public static String getNormalInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * Check if the input is valid for pick and move
     * @param inStr the input from the keyboard
     * @return true for valid; false for invalid
     */
    private static boolean isValidInputForPickAndMove(String inStr){
        if (inStr.length()!=5){return false;}
        if (inStr.charAt(0)<'0' || inStr.charAt(0)>'7') {return false;}
        else if (inStr.charAt(1)!=' ' || inStr.charAt(3)!=' '){return false;}
        else if (inStr.charAt(2)<'0' || inStr.charAt(2)>'9'){return false;}
        else if (inStr.charAt(4)!='U' && inStr.charAt(4) !='D' && inStr.charAt(4)!='L' && inStr.charAt(4)!='R'){return false;}
        else {return true;}
    }
}
