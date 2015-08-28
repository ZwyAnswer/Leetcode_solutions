/**
 * 在62题的基础上加了障碍物（1代表障碍，0代表可走）
 * 题目地址：https://leetcode.com/problems/unique-paths-ii/
**/
public class Solution {
    //修改递推关系，依然自底向上动态规划
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];  //因为m行n列都有可能有障碍，故不能直接初始化为1
        dp[m-1][n] = 1;
        for(int i = m-1; i >=0; i--) {  //要从第m行n列开始遍历
            for(int j = n-1; j >=0; j--) {
                dp[i][j] = (obstacleGrid[i][j] == 1) ? 0 : dp[i+1][j] + dp[i][j+1];  //有障碍则设为0
            }
        }
        return dp[0][0];
    }
}