package za.co.footballassoc.soccertournament.util;

public class Helper {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNullOrEmpty(Object obj) {
        return obj == null;
    }

    public static boolean isValidKitNumber(int kitNumber) {
        return kitNumber >= 1 && kitNumber <= 99;
    }
}
