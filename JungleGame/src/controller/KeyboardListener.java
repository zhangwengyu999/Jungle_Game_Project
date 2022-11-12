package controller;

import java.util.Scanner;

public class KeyboardListener {


    /**
     * @return char[]{'x','y','d'}: x and y for piece location and d for moving direction.
     */
    public static String[] getPickAndMove() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (isValidInputForPickAndMove(str)) {
            String[] out = str.split(" ");
            out[2] = out[2].toUpperCase();
            return out;
        }
        else {return null;}
    }

    /**
     * @return "": function such as stop and resume etc.
     */
    public static String getNormalInput() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }

    private static boolean isValidInputForPickAndMove(String inStr){
        if (inStr.length()!=5){return false;}
        if (inStr.charAt(0)<'0' || inStr.charAt(0)>'6') {return false;}
        else if (inStr.charAt(1)!=' ' || inStr.charAt(3)!=' '){return false;}
        else if (inStr.charAt(2)<'0' || inStr.charAt(2)>'8'){return false;}
        else if (inStr.charAt(4)!='U' && inStr.charAt(4) !='D' && inStr.charAt(4)!='L' && inStr.charAt(4)!='R'){return false;}
        else if (inStr.charAt(4)!='u' && inStr.charAt(4) !='d' && inStr.charAt(4)!='l' && inStr.charAt(4)!='r'){return false;}
        else {return true;}
    }

    public static boolean isValidInputInRange(String inStr, String[] inStrArr) {
        for (String str: inStrArr) {
            if (str.equals(inStr)) {
                return true;
            }
        }
        return false;
    }
}
