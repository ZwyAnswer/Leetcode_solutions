/**
 * 给定m x n型网格，起始点（0，0）只能向下和向右走，问一共多少种走到(m,n)的方法
 * 题目地址：https://leetcode.com/problems/unique-paths/
 * 类似题目：Unique Paths II，Minimum Path Sum，Dungeon Game 
**/
public class Solution {
    //自底向上动态规划
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];  //dp[i][j]表示从(i,j)走到(m, n)的方法数
        for(int i = 0; i <n; i++) dp[m-1][i] = 1;  //初始化m行，只能往右走1种
        for(int j = 0; j < m; j++) dp[j][n-1] = 1;  //初始化n列，只能往下走1种
        for(int i = m-2; i>=0; i--) {
            for(int j = n-2; j >=0; j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];  //
            }
        }
        return dp[0][0];
    }

    //自顶向下备忘录Backtracking（也可视为DP）
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;  //初始化
            }
        }
        return go(0, 0, m, n, dp);
    }
    
    //递归函数，i，j代表当前所在坐标
    private int go(int i, int j, int m, int n, int[][] dp) {
        if( i == m-1 && j == n-1 ) return 1;  //下边界和右边界，只有1种走法
        if( i >= m || j >= n) return 0;  //超出边界，无效走法
        if( dp[i][j] >= 0 ) return dp[i][j];  //当前坐标已有走法
        dp[i][j] = go(i+1, j, m, n, dp) + go(i, j+1, m, n, dp);
        return dp[i][j];
    }
}