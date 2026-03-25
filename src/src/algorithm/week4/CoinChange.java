package algorithm.week4;

public class CoinChange {
//    issue 322
    public int coinChange(int[] coins, int amount) {
        int[] minPerDenomination = new int[amount+1];
        boolean[] visited = new boolean[amount+1];
        minPerDenomination[0] = 0;
        visited[0] = true;
        return dp(coins, minPerDenomination, visited, amount);
    }

    public int dp(int[] coins, int[] minPerDenomination, boolean[] visited,int amount) {
        if (amount < 0) {
            return -1;
        }
        if (visited[amount]) {
            return minPerDenomination[amount];
        }
        int minPerAmount = -1;
        for (int i = 0; i < coins.length ; i++) {
            int result = dp(coins, minPerDenomination, visited, amount - coins[i]);

            if (result != -1 && (minPerAmount == -1 || minPerAmount > result + 1)) {
                minPerAmount = result + 1;
            }
        }
        minPerDenomination[amount] = minPerAmount;
        visited[amount] =  true;
        return minPerAmount;
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[] {1,2,5}, 11));
    }
}

