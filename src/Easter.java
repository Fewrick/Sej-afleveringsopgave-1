public class Easter {
    public static void main(String[] args) {
        System.out.println(computeEaster(2022));
    }

    public static String computeEaster(int year) {
        // initialising all variables used for computing
        int a = year % 4;
        int b = year % 7;
        int c = year % 19;
        int d = (19 * c + 24) % 30;
        int e = (2 * a + 4 * b + 6 * d + 5) % 7;
        int f = (c + 11 * d + 22 * e) / 451;
        int days = 22 + d + e - 7 * f;
        String goodFriday = min2Digits((days-2) >= 32 ? (days-2)%32+1 : (days-2)) + "." + min2Digits((days -2) / 32 + 3); // formats days from march 1 to good friday date
        String easterSunday = min2Digits(days >= 32 ? days%32+1 : days) + "." + min2Digits((days) / 32 + 3); // formats days from march 1 to easter sunday date
        String easterMonday = min2Digits((days + 1) >= 32 ? (days+1)%32+1 : (days+1)) + "." + min2Digits((days +1) / 32 + 3); //
        String dato = min4Digits(year) + " " + goodFriday + " " + easterSunday + " " + easterMonday; // formats dates to a readable String format
        // returns the formatted string for each date and year
        return dato;
    }

    // formats days to min 4 digits
    public static String min4Digits(int n) {
        String str = "" + Math.abs(n);
        int mangler = 4 - str.length();

        for (int i = 0; i < mangler; i++) {
            str = "0" + str;
        }
        if (n < 0) {
            str = "-" + str;
        }
        return str;
    }

    // formats months to min 2 digits
    public static String min2Digits(int n) {
        String str = "" + Math.abs(n);
        int mangler = 2 - str.length();

        for (int i = 0; i < mangler; i++) {
            str = "0" + str;
        }
        if (n < 0) {
            str = "-" + str;
        }
        return str;
    }

}
