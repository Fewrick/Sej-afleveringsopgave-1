public class Password {
    public static boolean checkPWD(String password) { 
        /* Checks if the input fits the 6 criteria:
         * at least 8 characters
         * only alpha-numerical characters
         * at least two letters
         * at least two numbers
         * at least one upper case letter
         * at least one lower case letter */
        if(password.length()<8) return false; //checks condition 1

        int countLetters = 0, countNumbers = 0, countUpper = 0, countLower = 0;
        for(char c : password.toCharArray()) {
            
            boolean isUpper = Character.isUpperCase(c);
            boolean isLower = Character.isLowerCase(c);
            boolean isLetter = Character.isLetter(c);
            boolean isNumber = Character.isDigit(c);

            if(!isLetter && !isNumber) return false; //checks condtition 2
            if(isLetter) countLetters++; 
            if(isNumber) countNumbers++; 
            if(isUpper) countUpper++; 
            if(isLower) countLower++; 
        }
        return countLetters>=2 && countNumbers>=2 && countUpper>=1 && countLower>=1; //checks conditions 3 through 6
    }
}
