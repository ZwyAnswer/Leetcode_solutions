/**
 * 给定数字n，生成1-n^2的螺旋矩阵
 * 题目地址：https://leetcode.com/problems/spiral-matrix-ii/
**/
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if(n == 0) return result;
        
        int rowBegin = 0, rowEnd = n-1, colBegin = 0, colEnd = n-1;
        int index = 1;
        while(rowBegin <= rowEnd && colBegin <= colEnd) {
            for(int i = colBegin; i <= colEnd; i++) {
                result[rowBegin][i] = index++;
            }
            rowBegin++;
            
            for(int i = rowBegin; i <= rowEnd; i++) {
                result[i][colEnd] = index++;
            }
            colEnd--;
            
            if(rowBegin <= rowEnd) {
                for(int i = colEnd; i >= colBegin; i--)
                    result[rowEnd][i] = index++;
            }
            rowEnd--;
            
            if(colBegin <= colEnd) {
                for(int i = rowEnd; i >= rowBegin; i--)
                    result[i][colBegin] = index++;
            }
            colBegin++;
        }
        return result;
    }
}