package algorithm.week1;

public class BestTimeBuyAndSellStock {
//    issue 121
    public int maxProfit(int[] prices) {
        int minGlobal = 0;
        int sales = 0;
        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < prices[minGlobal]) {
                minGlobal = i;
            }

            if (sales < prices[i] - prices[minGlobal]) {
                sales = prices[i] - prices[minGlobal];
            }

        }
        return sales;
    }
}
