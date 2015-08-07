/**
 * 实现.和*的正则表达式匹配，分别对应一个任意字符和匹配0个或多个之前的字符
 * 题目示例可参考下列地址中的例子
 * 题目地址：https://leetcode.com/problems/regular-expression-matching/
 * 类似题目：Wildcard Matching
**/
public class Solution {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();  //递归出口
        if(p.length() == 1 || p.charAt(1) != '*') { //pattern长度为1或不包含*,*总是和之前一个字符同时出现
            if(isMatchFirst(s, p)) //第一个字符匹配
                return isMatch(s.substring(1), p.substring(1));  //递归匹配余下的字符
            else 
                return false;
        }
        //p长度大于2且包含*
        while(isMatchFirst(s,p)) { //pattern长度大于1，且包含*
            if(isMatch(s, p.substring(2)))  //此时p中*为匹配0个前字符
                return true;
            s = s.substring(1); //p中*匹配了1个其前字符
        }
        return isMatch(s, p.substring(2));  //此时p中的*为匹配0个前字符，即可以去掉
    }
    
    //第一个字符是否匹配
    private boolean isMatchFirst(String s, String p) {
        if(!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'))
            return true;
        else 
            return false;
    }
}