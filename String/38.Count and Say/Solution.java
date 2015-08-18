/**
 * 返回“1, 11, 21, 1211, 111221, ...”序列第n个的读法
 * 题目地址：https://leetcode.com/problems/count-and-say/
**/
public class Solution {
    //递归计算
    public String countAndSay(int n) {
        if( n == 1) return "1";
        char[] prev = countAndSay(n-1).toCharArray();  //在前一个的基础上计算
        StringBuilder result = new StringBuilder();
        Integer count = 1;
        int i = 1;
        
        for(i = 1; i < prev.length; i++) {
            if( prev[i] == prev[i-1])  //重复数字个数
                count++;
            else {
                result.append(count.toString() + prev[i-1]);
                count = 1;
            }
        }
        result.append(count.toString() + prev[i-1]);  //处理最后的结尾
        return result.toString();
    }
}