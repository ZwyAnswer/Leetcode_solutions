/**
 * 给定一个无符号型整数，返回其二进制形式（32bit)中位为1的个数
 * 题目地址：https://leetcode.com/problems/number-of-1-bits/
 * 类似题目：Reverse Bits，Power of Two。
**/
public class Solution {
	/**
	 * 对32位逐位处理
	 * 利用基本操作，获取第i位n & (1 << i)，如果其结果不为0，则i位为1.
	**/
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if((n & (1 << i)) != 0)
                count++;
        }
        return count;
    }
}