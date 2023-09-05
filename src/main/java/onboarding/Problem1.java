package onboarding;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.*;

class Problem1 {
    static final int LEFT = 0;
    static final int RIGHT = 1;
    static final int PAGE_SIZE = 2;
    static final int MIN_PAGE = 1;
    static final int MAX_PAGE = 400;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 예외 처리
        if (pobi.size() != PAGE_SIZE || crong.size() != PAGE_SIZE)
            return -1;

        int leftPobi = pobi.get(LEFT);
        int rightPobi = pobi.get(RIGHT);
        int leftCrong = crong.get(LEFT);
        int rightCrong = crong.get(RIGHT);

        if (outOfPage(leftPobi, rightPobi) || !leftOddRightEven(leftPobi, rightPobi) || !isSequence(leftPobi, rightPobi))
            return -1;
        if (outOfPage(leftCrong, rightCrong) || !leftOddRightEven(leftCrong, rightCrong) || !isSequence(leftCrong, rightCrong))
            return -1;

        int maxPobi = getMaxValue(leftPobi, rightPobi);
        int maxCrong = getMaxValue(leftCrong, rightCrong);

        System.out.println("maxPobi = " + maxPobi);
        System.out.println("maxCrong = " + maxCrong);

        return maxPobi == maxCrong ? 0 : (maxPobi > maxCrong ? 1 : 2);
    }

    static int getMaxValue(int left, int right) {
        return max(maxValue(left), maxValue(right));
    }

    static int maxValue(int page) {
        // int -> int[]
        int[] digits = String.valueOf(page).chars().map(c -> c - '0').toArray();

        int sumDigits = Arrays.stream(digits).sum();
        int MultiDigits = Arrays.stream(digits).reduce(1, (a, b) -> a * b);

        return max(sumDigits, MultiDigits);
    }

    static boolean outOfPage(int left, int right) {
        if (left < MIN_PAGE || right < MIN_PAGE || left > MAX_PAGE || right > MAX_PAGE)
            return true;
        return false;
    }

    static boolean leftOddRightEven(int left, int right) {
        return left % 2 == 1 && right % 2 == 0 ? true : false;
    }

    static boolean isSequence(int left, int right) {
        return right - left == 1 ? true : false;
    }
}