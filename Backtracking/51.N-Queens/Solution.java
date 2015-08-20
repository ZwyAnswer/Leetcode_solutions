/**
 * N皇后问题，注意要求皇后不仅是不能同行同列，而且不能在一条对角线上
 * 注意返回的是打印出的棋盘列表，同CTCI的9.9题。
 * 题目地址：https://leetcode.com/problems/n-queens/，
**/
public class Solution {
    
    private List<List<String>> result = new ArrayList<> ();
    
    public List<List<String>> solveNQueens(int n) {
        int[] colByRow = new int[n];  //表盘用矩阵表示太浪费空间，用数组表示即可。把行映射为对应摆皇后的列
        dfsHelper(0, n, colByRow);
        return result;
    }
    
    //深度搜索，row表示当前要摆皇后的行
    public void dfsHelper(int row, int n, int[] colByRow) {
        if(row == n) result.add(printQueen(colByRow, n));  //已完成n行，打印棋盘并添加到结果列表
        for(int col = 0; col < n; col++) {  
            if(isValid(colByRow, row, col)) {  //依次检查当前行摆在8列上是否可行，
                colByRow[row] = col;
                dfsHelper(row+1, n, colByRow);  //可行则摆放皇后，然后继续递归。
            }
        }
    }
    
    //检查是否符合八皇后规则，因为每行是依次摆并检查的，所以只检查列和对角线
    public boolean isValid(int[] colByRow, int row, int col) {
        for(int i = 0; i < row; i++) {
            if(colByRow[i] == col) return false;  //是否同列
            int colDistance = Math.abs(colByRow[i] - col), rowDistance = row - i;
            if(colDistance == rowDistance) return false;  //是否同对角线
        }
        return true;
    }
    
    //把一维数组的表盘打印成字符串列表的表盘
    public List<String> printQueen(int[] colByRow, int n) {
        List<String> nQueen = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for(int j = 0; j < n; j++) s.append('.');
        for(int i = 0; i < n; i++) {
            s.setCharAt(colByRow[i], 'Q');  //把摆皇后的列对应的字符改为Q,其余为.
            nQueen.add(s.toString());
            s.setCharAt(colByRow[i], '.');  //改回来，方便构建下一行对应的字符串。
        }
        return nQueen;
    }
}