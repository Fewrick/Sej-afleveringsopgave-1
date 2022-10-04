import java.util.*;
public class AccessControl {
    static String username;
    static String password;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        username = createUsername(in);
        password = createPassword(in);
        System.out.println("*** User " + username + " is registered.");
        
        logon(in);

        in.close();
    }

    public static String createUsername(Scanner in) { //checks if input is valid username and return if valid
        boolean validUsername = false;
        String username = ""; //local instance of username

        do {

            System.out.println("Please enter a non-empty username:");
            username = in.nextLine();
            validUsername = validUsername(username);
    
        } while(!validUsername);
        return username;
    }

    public static String createPassword(Scanner in) {//check if password is valid using checkPWD function from 3a and return if valid
        String password = "";
        String passRepeat = "";
        do {
        
            do {
            System.out.println("Please enter a password    :");
            password = in.nextLine();
            } while(!Password.checkPWD(password));
    
            System.out.println("Please repeat the password :");
            passRepeat = in.nextLine();
    
        } while(!passRepeat.equals(password));

        return password;
    }

    public static boolean validUsername (String username) { //checks if first character is letter and username does not contain blanks
        char firstChar = username.charAt(0);
        int ascii = (int)firstChar;
        return Password.isLetter(ascii) && !containsBlank(username) && username.length()>0;
    }

    public static boolean containsBlank (String s) { //simply checks if string contains a blank space character
        for(char c : s.toCharArray()) {
            if(c == ' ') return true;
        }
        return false;
    }

    public static void logon(Scanner in) { //The "logon" page. Check if input username is the current username and the same for password
        String tryUser = "";
        String tryPass = "";
        do {
            System.out.println("To logon enter username:");
            tryUser = in.nextLine();
        } while (!username.equals(tryUser));
        
        do {
        System.out.println("To logon enter password:");
        tryPass = in.nextLine();
        } while (!password.equals(tryPass));
        System.out.println("*** User " + username + " is Logged on.");

        options(in);
    }

    public static void options(Scanner in) { //prompts the user with 3 choices and does accordingly
        System.out.println("You now have the following choices:\n  1 - Change Password\n  2 - Log off\n  3 - Shut down");
        System.out.println("Please select:");
        String selection = in.nextLine();

        switch(selection) {

            case "1":
                password = createPassword(in);
                System.out.println("*** Password changed for user " + username);
                options(in); //recurively calls itself after new password is created
                break;
            case "2":
                System.out.println("*** User "+username+" is logged off");
                logon(in); //go directly to logon page if logged off
                break;
            case "3":
                System.out.println("*** User "+username+" is logged off");
                System.out.println("*** System shutting down.");
                break;
            default:
                options(in); //if input is not one of the options, then prompt user again
                break;
        }
        

    }

    
}
