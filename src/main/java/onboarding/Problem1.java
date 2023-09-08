package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!isValidPage(pobi) || !isValidPage(crong)){
            return -1;
        }

        return getAnswer(getScore(pobi), getScore(crong));
    }

    public static boolean isValidPage(List<Integer> pages){
        if(pages.size() != 2){
            return false;
        }

        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        // 왼쪽이 짝수거나 오른쪽이 홀수인 경우
        if(leftPage%2==0 || rightPage%2!=0){
            return false;
        }

        // 연속된 숫자가 아닌 경우
        if(leftPage+1 != rightPage){
            return false;
        }

        // 정상 범위인지
        return 2 <= rightPage && rightPage <= 400;
    }

    public static int getAnswer(int pobiScore, int crongScore){
        if(pobiScore > crongScore)
            return 1;
        else if(pobiScore < crongScore)
            return 2;
        else
            return 0;
    }

    public static int getScore(List<Integer> pages){
        return Math.max(calculateMaxNum(pages.get(0)),calculateMaxNum(pages.get(1)));
    }

    public static int calculateMaxNum(int num){
        // 각 자리 숫자 더한 수, 모두 곱한 수 중 큰 수 구하기
        int plusNum = 0;
        int mulNum = 1;

        while(num>0){
            int tmp = num%10;
            plusNum += tmp;
            mulNum *= tmp;

            num /= 10;
        }

        return Math.max(plusNum,mulNum);
    }


}