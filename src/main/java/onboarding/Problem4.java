package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder result = new StringBuilder();

        int upperSum = 'A' + 'Z';
        int lowerSum = 'a' + 'z';
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (Character.isLowerCase(c))
                result.append(reverseLoserCase(lowerSum, c));

            if (Character.isUpperCase(c))
                result.append(reverseUpperCase(upperSum, c));

            if (c == ' ')
                result.append(c);

        }

        return result.toString();
    }

    private static char reverseUpperCase(int upperSum, char c) {
        return (char) (upperSum - c);
    }

    private static char reverseLoserCase(int lowerSum, char c) {
        return (char) (lowerSum - c);
    }
}
