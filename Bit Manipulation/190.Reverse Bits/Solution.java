/**
 * 给定整型数，返回其二进制形式反转后对应的整型
 * 题目地址：https://leetcode.com/problems/reverse-bits/
 * 类似题目：Bitwise AND of Numbers Range
**/
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            if(getBit(n,i))
                result = setBit(result,31-i);  //获取位后设置对应位，注意31-i
        }
        return result;
    }
    
    //获取n中第i位，是1则返回true，是0则返回false
    public boolean getBit(int n, int i) {
        return (n & (1 << i)) != 0;
    }
    
    //设置n中第i位
    public int setBit(int n, int i) {
        return n | (1 << i);
    }
}