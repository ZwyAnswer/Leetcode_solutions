/**
 * 判断一个数是否是2的幂
 * 题目地址：https://leetcode.com/problems/power-of-two/
 * 类似题目：Number of 1 Bits
**/
public class Solution {
	/**
	 * 若n是2的幂，则其二进制表示为最高有效位为1，其余为0
	 * 而n-1的二进制表示为把n的最高有效位的1改为0，其余位改1.
	 * 这样n和n-1做逻辑与，则得到0。如果非0，则n不是2的幂
	 * 注意特殊情况，如n=0，则不是2的幂。此处假设n为非负数
	**/
    public boolean isPowerOfTwo(int n) {
        return (n >= 1) ? (n & (n-1)) == 0  : false;
    }
}