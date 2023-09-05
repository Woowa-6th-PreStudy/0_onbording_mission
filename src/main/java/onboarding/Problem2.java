package onboarding;

import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        String result = "";
        do {
            result = cryptogram;
            cryptogram = Pattern.compile("(.)\\1+").matcher(cryptogram).replaceAll("");
        } while (!cryptogram.equals(result));

        return result;
    }
}
