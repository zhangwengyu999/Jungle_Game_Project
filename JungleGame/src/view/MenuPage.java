package view;

/**
 * This class is used to show the menu page and game logo
 */
public class MenuPage {

    public static void showMenuPage() {
        String str = "Please select an option in [x]\n" +
                "   - [S] Start a new game\n" +
                "   - [Q] Quit thw game\n"+
                "Your option is: ";
        System.out.print(str);
    }

    public static void jgGameLogo() {
        String str =
                    "\n\n    "+"       ##" + "   "+ "#########" + "       "+ "#########" + "   "+ "    #    " + "   "+ "###   ###" + "   "+ "#########\n" +
                    "   "+"       ##" + "   "+ "##       " + "       "+ "##       " + "   "+ "   ###   " + "   "+ "## # # ##" + "   "+ "##       \n" +
                    "  "+"       ##" + "   "+ "##   ####" + "       "+ "##   ####" + "   "+ "  ## ##  " + "   "+ "##  #  ##" + "   "+ "#########\n" +
                    " ##     ##" + "   "+ "##     ##" + "       "+ "##     ##" + "   "+ " ####### " + "   "+ "##     ##" + "   "+ "##       \n" +
                    "#########" + "   "+ "#########" + "       "+ "#########" + "   "+ "##     ##" + "   "+ "##     ##" + "   "+ "#########\n" ;
        System.out.println(str);
    }

}
