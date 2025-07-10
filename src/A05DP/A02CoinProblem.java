package src.A05DP;

public class A02CoinProblem {
    public static void main(String[] args) {
        int[] arr = {100, 400, 500};
        int target = 700;

        int[] dp = new int[target+1];

        for (int i = 1; i < target + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int type : arr) {
                if (i-type < 0) continue;
                min = Math.min(min, dp[i-type]);
            }
            dp[i] = min == Integer.MAX_VALUE ? 0: min + 1;
        }

        System.out.println(dp[target]);
    }
}