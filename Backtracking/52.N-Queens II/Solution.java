/**
 * 只需要计算N皇后的解的个数，把N-Queen I中的解法改一下即可。
 * 题目地址：https://leetcode.com/problems/n-queens-ii/
**/
public class Solution {
    
    private int result = 0;
    
    public int totalNQueens(int n) {
        int[] colByRow = new int[n];
        dfsHelper(0, n, colByRow);
        return result;
    }
    
    public void dfsHelper(int row, int n, int[] colByRow) {
        if(row == n) result++;  //此时解的数加一即可
        for(int col = 0; col < n; col++) {
            if(isValid(colByRow, row, col)) {
                colByRow[row] = col;
                dfsHelper(row+1, n, colByRow);
            }
        }
    }
    
    public boolean isValid(int[] colByRow, int row, int col) {
        for(int i = 0; i < row; i++) {
            if(colByRow[i] == col) return false;
            int colDistance = Math.abs(colByRow[i] - col), rowDistance = row - i;
            if(colDistance == rowDistance) return false;
        }
        return true;
    }
}