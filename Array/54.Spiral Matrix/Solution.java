/**
 * 给定m x n型矩阵，返回其罗旋顺序的遍历序列
 * 题目地址：https://leetcode.com/problems/spiral-matrix/
 * 类似题目：Spiral Matrix II
**/
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<> ();
        if(matrix == null || matrix.length == 0) return result;
        
        int rowBegin = 0;  //当前遍历行的上界
        int rowEnd = matrix.length - 1;  //当前遍历行下界
        int colBegin = 0;  //当前遍历列的上界
        int colEnd = matrix[0].length - 1;  //当前遍历列的下界
        
        while( rowBegin <= rowEnd && colBegin <= colEnd) {
            //从左向右遍历行
            for(int i = colBegin; i <= colEnd; i++) {
                result.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            
            //从上向下遍历列
            for(int i = rowBegin; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;
            
            //从右向左遍历行
            if(rowBegin <= rowEnd) {
                for(int i = colEnd; i >= colBegin; i--)
                    result.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            
            //从下向上遍历列
            if(colBegin <= colEnd) {
                for(int i = rowEnd; i >= rowBegin; i--)
                    result.add(matrix[i][colBegin]);
            }
            colBegin++;
        }
        return result;
    }
}