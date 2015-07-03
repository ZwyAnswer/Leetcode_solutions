/**
 * 验证给定9x9型矩阵是否满足数独规则
 * 题目地址：https://leetcode.com/problems/valid-sudoku/
**/
public class Solution {
    /**
     * 有效的数独要求9行9列均含有不重复的1-9数字，此外依次3x3的子块，也含有1-9
     * 验证是否重复，适合使用HashMap/ HashSet
     * 若发现不符合规则，及时返回。
    **/
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            if(!isValid(board, i, 0, i, 8)) return false;  //验证0-8行
            if(!isValid(board, 0, i, 8, i)) return false;  //验证0-8列
        }
        
        //依次验证3x3型的子块
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++){
                if(!isValid(board, i*3, j*3, i*3+2, j*3+2))
                    return false;
            }
        }
        return true;
    }
    
    //独立抽象出一个验证给定矩阵是否符合数独规则的函数
    private boolean isValid(char[][] board, int x1, int y1, int x2, int y2) {
        Set<Character> sudokuSet = new HashSet<> ();
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                if(board[i][j] != '.') {  //若是非空，即已填入数字的
                    if(!sudokuSet.add(board[i][j])) return false;  //已经有重复
                }
            }
        }
        return true;
    }

    //也可以使用HashMap，注意HashMap和HashSet的API区别
    private boolean isValid2(char[][] board, int x1, int y1, int x2, int y2) {
        Map<Character, Boolean> map = new HashMap<> ();
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                if(board[i][j] != '.') {
                    if(map.containsKey(board[i][j])) return false;  //duplicates
                    else map.put(board[i][j], true);
                }
            }
        }
        return true;
    }
}