/**
 * 求出从m到n的依次做与运算的结果（直接计算会TLE)
 * 题目地址：https://leetcode.com/problems/bitwise-and-of-numbers-range/
**/
public class Solution {
	//找出m~n的二进制中共同前缀，其余的与后会为0
    public int rangeBitwiseAnd(int m, int n) {
        int left = Integer.MAX_VALUE; //二进制全1
        while((m&left) != (n&left)) left = left << 1;  //等到共同前缀
        return n&left;  //前缀与m或n做与均可
    }
}