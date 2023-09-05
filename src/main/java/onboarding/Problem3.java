package onboarding;

import java.util.stream.IntStream;

public class Problem3 {
    // 369 손뼉 횟수
    public static int solution(int number) {
        int cnt = 0;

        for (int i = 1; i <= number; i++) {
            if(i/10 == 3 || i/10 == 6 || i/10 == 9) cnt++;
            if(i%10 == 3 || i%10 == 6 || i%10 == 9) cnt++;
        }

        return cnt;
    }
}
