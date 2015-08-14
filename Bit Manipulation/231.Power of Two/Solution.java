/**
 * 给定整型数，判定其是否是2的某次方
 * 题目地址：https://leetcode.com/problems/power-of-two/
**/
public class Solution {
	// n & (n-1) 可以把n二进制表示中最低位的1转成0
    public boolean isPowerOfTwo(int n) {
        return (n >= 1) ? (n & (n-1)) == 0  : false;
    }
}