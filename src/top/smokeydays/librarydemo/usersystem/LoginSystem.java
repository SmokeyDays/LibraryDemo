package top.smokeydays.librarydemo.usersystem;

import top.smokeydays.librarydemo.librarycore.LibraryConsole;

import java.util.HashMap;
import java.util.Map;

public class LoginSystem {
    private static Map<String, String> userData = new HashMap<>();
    private static String adminPasswd = "admin";

    public static void userRegister(String userName, String userPasswd) {
        userData.put(userName, userPasswd);
        LibraryConsole.userInit((userName));
    }

    public static boolean userLogin(String userName, String userPasswd) {
        if(userData.get(userName).equals(userPasswd)) {
            LibraryConsole.userLogin(userName);
            return true;
        } else {
            return false;
        }
    }

    public static void userLogout(String userName) {
        LibraryConsole.userLogout(userName);
    }

    public static boolean adminLogin(String passwd) {
        if(adminPasswd.equals(passwd)) {
            LibraryConsole.adminLogin();
            return true;
        } else {
            return false;
        }
    }

    public static void adminLogout() {
        LibraryConsole.adminLogout();
    }
}
