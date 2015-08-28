/**
 * 给定mxn矩阵，求从(0,0)到(m,n)的最小路径和，只能向下走或向右走
 * 题目地址：https://leetcode.com/problems/minimum-path-sum/
**/
public class Solution {
    //自顶向下，不用备忘录，直接在原数组上操作（注意与自底向上方法遍历的不同处）
    public int minPathSum(int[][] grid) {
        int m = grid.length;// row
        int n = grid[0].length; // column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {  //处理边界
                    grid[i][j] = grid[i][j] + grid[i][j - 1];  //只能向右走
                } else if (i != 0 && j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];  //只能向下走
                } else if (i == 0 && j == 0) {
                    grid[i][j] = grid[i][j];  //坐标(0,0)
                } else {
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}