package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        int wordLength = word.length();
        for(int i=0;i<wordLength;i++){
            answer += Character.toString(changeChar(word.charAt(i)));
        }

        return answer;
    }

    public static char changeChar(char originalChar){
        char changedChar = originalChar;

        if('a'<=originalChar && originalChar<='z'){
            changedChar = (char) ('z'-originalChar+'a');
        }
        else if('A'<=originalChar && originalChar<='Z'){
            changedChar = (char) ('Z'-originalChar+'A');
        }

        return changedChar;
    }
}
