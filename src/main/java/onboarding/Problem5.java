package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static int[] prices = {50000,10000,5000,1000,500,100,50,10,1};

    public static List<Integer> solution(int money) {
        return exchangeMoney(money);
    }

    public static List<Integer> exchangeMoney(int money){
        List<Integer> counts = new ArrayList<>();

        for(int i=0;i<prices.length;i++){
            int price = prices[i];
            counts.add(money / price);

            money %= price;
        }

        return counts;
    }
}
