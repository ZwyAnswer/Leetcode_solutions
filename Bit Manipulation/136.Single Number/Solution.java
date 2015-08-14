/**
 * 给定数组，其中数字除了一个只出现1次，其余均出现2次，找到这个只出现1次的数
 * 题目地址：https://leetcode.com/problems/single-number/
 * 类似题目：Single Number II
**/
public class Solution {
	//利用异或性质：0^x=x, x^x=0
    public int singleNumber(int[] A) {
        int num = 0;
        for(int x: A) {
            num ^= x;  //依次异或
        }
        return num;
    }
}