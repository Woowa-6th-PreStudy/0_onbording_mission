package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i=3;i<=number;i++){
            answer += countSlap(i);
        }

        return answer;
    }

    public static int countSlap(int number){
        int cnt = 0;

        while(number>0){
            int digit = number%10;

            if(digit==3 || digit==6 || digit==9){
                cnt++;
            }

            number /= 10;
        }

        return cnt;
    }
}
