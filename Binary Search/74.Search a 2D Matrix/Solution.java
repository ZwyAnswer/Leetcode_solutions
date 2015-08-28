/**
 * 二维数组的查找，二维数组排每行升序排列，下一行的首数字大于上一行的末尾数字
 * 题目地址：https://leetcode.com/problems/search-a-2d-matrix/
 * 类似题目：Search a 2D Matrix II
**/
public class Solution {
    //可以将二维数组直接视为一纬升序的数组，进行二分查找。主要注意下标的计算。
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;  //注意此处的最终下标
        while(left <= right) {
            int mid = (left + right) / 2;
            if(matrix[mid / n][mid % n] == target) return true;  //注意此处的下标计算
            else if(matrix[mid / n][ mid % n] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}