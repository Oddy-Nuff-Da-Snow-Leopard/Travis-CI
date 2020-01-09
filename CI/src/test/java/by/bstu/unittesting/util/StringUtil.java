package by.bstu.unittesting.util;

public class StringUtil {

    private StringUtil() {
    }

    public static String[] splitString(String str, String regex) {
        return str.split(regex);
    }
}
