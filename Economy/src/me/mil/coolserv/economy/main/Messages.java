package me.mil.coolserv.economy.main;

public class Messages {

    public static String lines = Main.rc("\n&8----------------------------");

    public static String ECONOMY_HELP(){
        char c1 = 'a';
        char c2 = 'e';
        String s1 = lines + "\n "  + "      ";
        String s15 = "&" + c1 + "Economy Help\n" + "";
        String s2 = "&" + c1 + "Balance &" + c2 + "- See your own or other player's balance.\n";
        String s3 = ("&" + c1 + "Add &" + c2 + "- Add money to a players bank account.\n");
        String s4 = ("&" + c1 + "Set &" + c2 + "- Set a players bank account balance.\n");
        String s5 = ("&" + c1 + "Remove &" + c2 + "- Remove money from a players bank account.\n");
        String s6 = ("&" + c1 + "Purchase &" + c2 + "- Used only in Shop GUI's, Plugins and that stuff, Removes money from a players bank account only if they have enough money.\n");
        String s7 = ("&" + c1 + "Help &" + c2 + "- Shows this help text.");
        String s8 = lines + "\n" + "";
        String sf = (Main.rc(s1 + s15 + s2 + s3 + s4 + s5 + s6 + s7 + s8));
        return (sf);
    }

}
