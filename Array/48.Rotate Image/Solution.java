/**
 * 把给定矩阵顺时针旋转90°
 * 题目地址：https://leetcode.com/problems/rotate-image/
**/
public class Solution {
    //从外向内，一层一层进行交换旋转
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int row = 0; row < n/2; row++) {
            int first = row;   
            int last = n - 1 - row;
            for(int col = first; col < last; col++) {
                int offset = col - first;  //偏移
                int top = matrix[first][col];  //暂时存储上边
                
                matrix[first][col] = matrix[last - offset][first];  //从左到上
                matrix[last - offset][first] = matrix[last][last - offset];  //从下到左
                matrix[last][last - offset] = matrix[col][last];  //从右到下
                matrix[col][last] = top;  //从上到右
            }
        }
    }
}