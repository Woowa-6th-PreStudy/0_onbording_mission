package onboarding;


import java.util.*;

public class Problem6 {
    static HashMap<String, String> seperatedNickname = new LinkedHashMap<>();
    static HashMap<String, String> nicknameToEmail = new LinkedHashMap<>();

    static Set<String> result = new HashSet<>();
    static final int startIndexZero = 0;

    public static List<String> solution(List<List<String>> forms) {

        ArrayList<String> nicknameList = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            List<String> friends = forms.get(i);

            String email = getEmail(friends);
            String nickname = getNickname(friends);

            nicknameList.add(nickname);
            nicknameToEmail.put(nickname, email);

            isDuplcatedNickname(nickname, email, startIndexZero);
        }

        return new ArrayList<>(result);
    }
    private static String getEmail(List<String> friends) {
        return friends.get(0);
    }

    private static String getNickname(List<String> friends) {
        return friends.get(1);
    }


    static void isDuplcatedNickname(String nickname, String email, int start) {
        if (nickname.length() <= start)
            return;

        for (int end = start+2; end <= nickname.length(); end++) {
            String seperated = nickname.substring(start, end);

            if (seperatedNickname.containsKey(seperated)) {
                String findNickname = seperatedNickname.get(seperated);
                if (findNickname.equals(nickname))
                    continue;

                // 분리된 문자열이 다른 닉네임의 것이라면, 중복된 닉네임을 가지고 있다는 것
                result.add(nicknameToEmail.get(nickname));
                result.add(nicknameToEmail.get(findNickname));
            }

            seperatedNickname.put(seperated, nickname);

        }

        isDuplcatedNickname(nickname, email, start+1);
    }
}
