/**
 * 给定一个数组，返回的数组每个位置为除了该位置上数的其余数乘积（不允许用除法）
 * 题目地址：https://leetcode.com/problems/product-of-array-except-self/
 * 类似题目：Trapping Rain Water
**/
public class Solution {
    //时间复杂度O(n)， 空间复杂度O(1)
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        //正反两个方向遍历计算
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }
}