package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    // 2글자씩 몇번 존재하는지 map에 저장
    public static HashMap<String,Integer> subNicknameMap = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for(List<String> form:forms){
            String email = form.get(0);
            String nickname = form.get(1);

            if(!isValidNickname(email) || !isValidNickname(nickname)){
                continue;
            }

            // map에 값 채우기
            setSubNicknameMap(nickname);
        }


        for(List<String> form:forms){
            String email = form.get(0);
            String nickname = form.get(1);

            if(!isValidNickname(email) || !isValidNickname(nickname)){
                continue;
            }

            if(isDuplicatedNickname(nickname)){
                answer.add(email);
            }
        }

        Collections.sort(answer);
        return answer;
    }

    public static boolean isValidEmail(String email){
        if(email.length()>=20 || email.length()<11) {
            return false;
        }

        String[] emailParts = email.split("@");

        if(emailParts.length != 2){
            return false;
        }


        if(!emailParts[1].equals("email.com")){
            return false;
        }

        return true;
    }

    public static boolean isValidNickname(String nickname) {
        if (nickname.length() < 1 || nickname.length() >= 20) {
            return false;
        }

        return true;
    }

    public static void setSubNicknameMap(String nickname){
        int nicknameLength = nickname.length();

        for(int i=0;i<nicknameLength-1;i++){
            String subNickname = nickname.substring(i,i+2);

            if(!subNicknameMap.containsKey(subNickname)){
                subNicknameMap.put(subNickname,1);
            }
            else{
                subNicknameMap.put(subNickname,subNicknameMap.get(subNickname)+1);
            }
        }
    }

    public static boolean isDuplicatedNickname(String nickname){
        for(String key: subNicknameMap.keySet()){
            if(subNicknameMap.get(key)==1){
                continue;
            }

            if(nickname.contains(key)){
                return true;
            }
        }

        return false;
    }
}
