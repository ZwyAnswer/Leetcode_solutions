/**
 * 给定字符串，分割该字符串，使其所有子串都为回文串。返回所有分割后的结果列表
 * 题目地址：https://leetcode.com/problems/palindrome-partitioning/
 * 类似题目：Palindrome Partitioning II， Word Break
**/
public class Solution {
    /**
     * dfs递归回溯
    **/
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        if(s == null) return result;
        dfsPartition(result, temp, s);
        return result;
    }
    
    private void dfsPartition(List<List<String>> result, List<String> temp, String s) {
        if(s.length() == 0) {
            result.add(new ArrayList<String>(temp));  //分割到字符串尾递归终止
            return;
        }
        for(int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if(isPalindrome(sub)) {
                temp.add(sub);
                dfsPartition(result, temp, s.substring(i));
                temp.remove(temp.size()-1);  //关键，注意
            }
        }
    }
    
    //判断给定字符串是否是回文串（假设字符串都是小写的字母组成）
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}