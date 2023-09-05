package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        HashMap<String, Integer> scoreMap = new HashMap<>();
        HashMap<String, ArrayList<String>> relation = new HashMap<>();
        initRelation(friends, relation);

        plusKnowTogether(user, scoreMap, relation);
        plusVisitors(visitors, scoreMap);

        ArrayList<String> peoples = new ArrayList<>(scoreMap.keySet());
        peoples.sort((p1, p2) -> {
            int score1 = scoreMap.get(p1);
            int score2 = scoreMap.get(p2);

            if (score1 == score2)
                return p1.compareTo(p2);
            return score2 - score1;
        });

        return peoples.stream()
                .filter(p -> !p.equals(user)) // 유저가 아니고
                .filter(p -> !relation.get(user).contains(p)) // 유저의 친구가 아니고
                .filter(p -> scoreMap.getOrDefault(p, 0) != 0)
                .limit(5)
                .collect(Collectors.toList());
    }

    private static void plusVisitors(List<String> visitors, HashMap<String, Integer> scoreMap) {
        for (String visitor : visitors) {
            updateScore(scoreMap, visitor, 1);
        }
    }

    private static void plusKnowTogether(String user, HashMap<String, Integer> scoreMap, HashMap<String, ArrayList<String>> relation) {
        for (String userFriend : relation.get(user)) {
            for (String sharedFriend : relation.get(userFriend)) {
                updateScore(scoreMap, sharedFriend, 10);
            }
        }
    }

    private static void updateScore(HashMap<String, Integer> scoreMap, String name, int x) {
        int plusScore = scoreMap.getOrDefault(name, 0) + x;
        scoreMap.put(name, plusScore);
    }

    private static void initRelation(List<List<String>> friends, HashMap<String, ArrayList<String>> relation) {
        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            ArrayList<String> friendRelation1 = relation.getOrDefault(friend1, new ArrayList<>());
            friendRelation1.add(friend2);

            ArrayList<String> friendRelation2 = relation.getOrDefault(friend2, new ArrayList<>());
            friendRelation2.add(friend1);
            
            relation.put(friend1, friendRelation1);
            relation.put(friend2, friendRelation2);
        }
    }
    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = Arrays.asList(
                Arrays.asList("donut", "andole"),
                Arrays.asList("donut", "jun"),
                Arrays.asList("donut", "mrko"),
                Arrays.asList("shakevan", "andole"),
                Arrays.asList("shakevan", "jun"),
                Arrays.asList("shakevan", "mrko")
        );
        List<String> visitors = Arrays.asList("bedi", "bedi", "donut", "bedi", "shakevan");

        List<String> result = Problem7.solution(user, friends, visitors);

        System.out.println("결과:");
        for (String friend : result) {
            System.out.println(friend);
        }
    }
}
