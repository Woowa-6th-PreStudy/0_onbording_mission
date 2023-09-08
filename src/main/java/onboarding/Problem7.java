package onboarding;

import java.util.*;

public class Problem7 {
    public static HashMap<String, Integer> scores = new HashMap<>();

    public static class Person implements Comparable<Person>{
        String name;
        int score;

        public Person(String name, int score){
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Person o) {
            if(o.score == this.score){
                return this.name.compareTo(o.name);
            }

            return o.score - this.score;
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        initializeScores(friends, visitors);

        List<String> userFriends = getUserFriends(user, friends);
        List<String> userNearFriends = getNearFriends(friends, userFriends);

        updateNearFriendScore(userNearFriends);
        updateVisitorScore(visitors);

        removeFriendFromMap(userFriends);
        removeKeyFromMap(user);

        return getAnswer();
    }

    public static void initializeScores(List<List<String>> friends, List<String> visitors){
        for(List<String> friend:friends){
            scores.put(friend.get(0),0);
            scores.put(friend.get(1), 0);
        }

        for(String visitor:visitors){
            scores.put(visitor, 0);
        }
    }

    public static List<String> getUserFriends(String user, List<List<String>> friends){
        // user 친구 리스트 구하기
        List<String> userFriends = new ArrayList<>();

        for(List<String> friend:friends){
            String leftFriend = friend.get(0);
            String rightFriend = friend.get(1);

            if(leftFriend.equals(user)){
                userFriends.add(rightFriend);
            }
            else if(rightFriend.equals(user)){
                userFriends.add(leftFriend);
            }
        }

        return userFriends;
    }

    public static List<String> getNearFriends(List<List<String>> friends, List<String> userFriends) {
        List<String> nearFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            String leftFriend = friend.get(0);
            String rightFriend = friend.get(1);

            if (userFriends.contains(leftFriend)) {
                nearFriends.add(rightFriend);
            } else if (userFriends.contains(rightFriend)) {
                nearFriends.add(leftFriend);
            }
        }

        return nearFriends;
    }

    public static void updateNearFriendScore(List<String> nearFriends){
        for(String nearFriend:nearFriends){
            updateScore(nearFriend, 10);
        }
    }

    public static void updateVisitorScore(List<String> visitors){
        for(String visitor:visitors){
            updateScore(visitor, 1);
        }
    }

    public static void updateScore(String name, int score){
        scores.put(name, scores.get(name)+score);
    }

    public static void removeFriendFromMap(List<String> friends){
        for(String friend:friends){
            removeKeyFromMap(friend);
        }
    }

    public static void removeKeyFromMap(String key){
        scores.keySet().remove(key);
    }

    public static List<String> getAnswer(){
        List<Person> people = new ArrayList<>();

        for(String name:scores.keySet()){
            int score = scores.get(name);

            if(score>0){
                people.add(new Person(name, score));
            }
        }

        Collections.sort(people);

        List<String> answer = new ArrayList<>();
        for(Person person:people){
            answer.add(person.name);

            if(answer.size()==5)
                break;
        }

        return answer;
    }
}
