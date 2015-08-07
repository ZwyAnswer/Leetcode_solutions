/**
 * 给定字符串s和字典，判断s是否能由字典中的词串联构成
 * 题目地址：https://leetcode.com/problems/word-break/
 * 类似题目：Palindrome Partitioning， Word Break II
**/
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        boolean[] isWord = new boolean[n+1];  //isWord[i] = true代表s.substring(0,i+1)为wordDict中的有效词
        isWord[0] = true; //初始化
        // top down自顶向下迭代
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                if(isWord[j] && wordDict.contains(s.substring(j,i))) {  //递推关系
                    isWord[i] = true;
                    break;
                }
            }
        }
        return isWord[n];
    }
}