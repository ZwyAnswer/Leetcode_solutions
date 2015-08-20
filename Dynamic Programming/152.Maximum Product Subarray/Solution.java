/**
 * 找出给定数组的连续子数组最大积
 * 题目地址：https://leetcode.com/problems/maximum-product-subarray/
 * 类似题目：Product of Array Except Self 
**/
public class Solution {
    //依然用DP，但由于和最大和的递推关系不同，故需要加入一个当前最小积的变量
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], maxAns = nums[0];  //因为可能含有负数，故最大积可能是之前最小或最大乘以当前
        for(int i = 1; i < nums.length; i++) {
            int lastMax = max;
            max = Math.max( Math.max(lastMax * nums[i], min * nums[i]), nums[i]);  //更新当前最大
            min = Math.min( Math.min(min * nums[i], lastMax * nums[i]), nums[i]);  //更新当前最小
            maxAns = Math.max( max, maxAns);
        }
        return maxAns;
    }
}