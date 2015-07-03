/**
 * 36题Valid sodoku的进阶，解数独
 * 题目地址：https://leetcode.com/problems/sudoku-solver/
**/
public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) return;
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') {  //对空格填入数字
                    for(char  c = '1'; c <= '9'; c++) {
                        if(isValid(board, i, j, c)) {  //若填入数字不重复
                            board[i][j] = c;
                            if(solve(board)) return true;  //继续深度遍历递归
                            else board[i][j] = '.';   //否则回溯
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    //验证填入的数字是否跟原有数字发生冲突
    private boolean isValid(char[][] board, int i, int j, char c) {
        //验证行
        for(int row = 0; row < 9; row++)
            if(board[row][j] == c)
                return false;

        //验证列
        for(int col = 0; col < 9; col++)
            if(board[i][col] == c)
                return false;

        //验证3x3子块
        for(int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
            for(int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
                if(board[row][col] == c)
                    return false;
        return true;
    }
}