/**
 * 题目说明参考题目地址
 * 题目地址：https://leetcode.com/problems/dungeon-game/
 * 类似题目：Unique Paths, Minimum Path Sum
**/
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] health = new int[m][n];  //health[i][j]代表坐标(i,j)的格子处所需最小血量
        health[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);  //最小血量需要1

        for (int i = m - 2; i >= 0; i--)  //初始化第n列血量          
            health[i][n - 1] = Math.max(health[i + 1][n - 1] - dungeon[i][n - 1], 1);
        for (int j = n - 2; j >= 0; j--)  //初始化第m行血量
            health[m - 1][j] = Math.max(health[m - 1][j + 1] - dungeon[m - 1][j], 1);
        //自底向上DP
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(health[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(health[i][j + 1] - dungeon[i][j], 1);
                health[i][j] = Math.min(right, down);
            }
        }
        return health[0][0];
    }
}