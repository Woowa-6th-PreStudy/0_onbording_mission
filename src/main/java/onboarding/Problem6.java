package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Set<String> possibleTotalCase = new HashSet<>();
        forms.forEach(user -> {
            String email = user.get(0);
            String name = user.get(1);
            if (getTotalPossibleCase(name).stream().anyMatch(possibleTotalCase::contains)) {
                // 중복된 경우에 answer 에 메일 주소를 추가한다.
                answer.add(email);
            } else {
                // 중복되지 않은 경우
                List<String> possibleCaseList = getTotalPossibleCase(name);
                possibleTotalCase.addAll(possibleCaseList);
            }
        });

        return answer;
    }

    private static List<String> getTotalPossibleCase(String name) {
        // 주어진 인자에 대해서 조합 가능한 경우의 수를 구한다.
        List<String> possibleTotalCase = new ArrayList<>();
        String[] nameToken = name.split("");
        for (int i = 1; i < nameToken.length; i++) {
            possibleTotalCase.add(nameToken[i-1] + nameToken[i]);
        }
        return possibleTotalCase;
    }
}
