/** 
 * 给定整型数，求出其二进制形式中1的个数
 * 题目地址：https://leetcode.com/problems/number-of-1-bits/
 * 类似题目：Power of Two， Reverse Bits
**/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if((n & (1 << i)) != 0)  //整型不超过32位，故依次与每一位进行与操作
                count++;
        }
        return count;
    }
}