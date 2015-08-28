public class Solution {
    public int climbStairs(int n) {
        int prev2 = 1, prev1 = 1;
        for(int i = 2; i <= n; i++) {
            int temp = prev1;
            prev1 += prev2;
            prev2 = temp;
        }
        return prev1;
    }

    public int climbStairs2(int n) {
        int[] dp = new int[n+1];
        for(int i = 0; i< dp.length; i++) dp[i] = -1;
        return climbStairs(n,dp);
    }
    
    private int climbStairs(int n, int[] dp) {
        if( n < 0) {
            return 0;
        } else if( n == 0) {
            return 1;
        } else if(dp[n] >= 0) {
            return dp[n];
        } else {
            dp[n] = climbStairs(n-2,dp) + climbStairs(n-1,dp);
            return dp[n];
        }
    }
}