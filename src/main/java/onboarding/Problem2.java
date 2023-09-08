package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {
    public static String solution(String cryptogram) {
        return makeNewPassword(cryptogram);
    }

    public static String makeNewPassword(String cryptogram){
        Deque newChars = removeDuplicatedChar(cryptogram);

        String newPassword = "";
        while(!newChars.isEmpty()){
            newPassword += newChars.pollFirst();
        }

        return newPassword;
    }

    public static Deque<Character> removeDuplicatedChar(String cryptogram){
        Deque<Character> deque = new ArrayDeque<>();

        int cryptogramLength = cryptogram.length();
        for(int i=0;i<cryptogramLength;i++){
            char ch = cryptogram.charAt(i);

            if(deque.isEmpty() || deque.peekLast()!=ch){
                deque.add(ch);
            }
            else if(deque.peekLast() == ch){
                deque.pollLast();
            }
        }

        return deque;
    }
}
