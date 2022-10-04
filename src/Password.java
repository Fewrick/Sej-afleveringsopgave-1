public class Password {
    public static void main(String[] args) {
    }

    public static boolean checkPWD(String password) {
        /* Checks if the input fits the 6 criteria:
         * at least 8 characters
         * only alpha-numerical characters
         * at least two letters
         * at least two numbers
         * at least one upper case letter
         * at least one lower case letter
         */
        if(password.length()<8) return false; //checks condition 1

        int countLetters = 0, countNumbers = 0, countUpper = 0, countLower = 0;
        for(char c : password.toCharArray()) {
            int ascii = (int)c;
            boolean isUpper = ascii>=65 && ascii<=90;
            boolean isLower = (ascii>=97 && ascii<=122);
            boolean isLetter = isLower || isUpper;
            boolean isNumber = ascii>=48 && ascii<=57;

            if(!isLetter && !isNumber) return false; //checks condtition 2
            if(isLetter) countLetters++; //counts letters
            if(isNumber) countNumbers++; //counts numbers
            if(isUpper) countUpper++; //counts uppercase
            if(isLower) countLower++; // count lowercase
        }
        if(countLetters<2 || countNumbers<2 || countUpper<1 || countLower<1) return false; //checks conditions 2 through 6

        return true; //if no condition fails, return true
    }
}
