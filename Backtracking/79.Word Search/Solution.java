/**
 * 在char矩阵中查找给定单词字符串，可以横向查找也可以纵向查找
 * 题目地址：https://leetcode.com/problems/word-search/
**/ 
public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(dfsCheck(board, w, i, j, 0))  //依次从各个点出发查找
                    return true;
            }
        }
        return false;
    }
    
    //深度优先查找，参数含义：从i行，j列开始查找，目前找到对应第step个字符
    public boolean dfsCheck(char[][] board, char[] word, int i, int j, int step) {
        if(step == word.length) return true;  //查到返回
        if(i < 0 || j < 0 || i >= board.length || j >= board[i].length) return false; //查到矩阵外，终止递归
        if(word[step] != board[i][j]) return false;  //查到不是匹配的字符，终止递归
        board[i][j] = '!';  //标记开始处，防止下面的递归又重复查找起点对应的字符
        //分别向上下左右进行递归
        boolean result = dfsCheck(board, word, i-1, j, step+1) || dfsCheck(board, word, i+1, j, step+1)
            || dfsCheck(board, word, i, j-1, step+1) || dfsCheck(board, word, i, j+1, step+1);
        board[i][j] = word[step];  //把标记改回来
        return result;
    }
}