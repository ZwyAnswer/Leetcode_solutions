/**
 * 二维矩阵，每行每列均按升序排列，查找给定的数
 * 题目地址：https://leetcode.com/problems/search-a-2d-matrix-ii/
**/
public class Solution {
	//二分查找思想，可从右上角或左下角进行查找，每次可以划去一行或一列
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length-1;
        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }
}