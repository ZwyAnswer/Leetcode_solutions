/**
 * 给定两个字符串，求出把第一个字符串转化为第二个字符串的最短编辑距离（可插入、删除、替换字符）
 * 题目地址：https://leetcode.com/problems/edit-distance/
**/
public class Solution {
    //符合重叠子问题和最优子结构，使用DP
    public int minDistance(String word1, String word2) {
        int opt[][] = new int[word1.length()+1][word2.length()+1];  //opt[i][j]代表word1前i个字符和word2前j个字符的最短编辑距离
        // base case初始化，此时均代表插入
        for(int i = 0; i <= word1.length(); i++) opt[i][0] = i;
        for(int j = 0; j <= word2.length(); j++) opt[0][j] = j;
        // bottom-up iteration
        for(int i = 1;i <= word1.length();i++)
            for(int j = 1;j <= word2.length();j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)) opt[i][j] = opt[i-1][j-1];   
                else opt[i][j] = Math.min(Math.min(opt[i-1][j],opt[i][j-1]),opt[i-1][j-1]) + 1;  //插入、删除、替换
            }
        return opt[word1.length()][word2.length()];
    }
}