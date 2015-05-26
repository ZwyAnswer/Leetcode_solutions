/**
	类似题：Maximum Subarray, 只不过此题加了一个限制，不能连续取两个数。
	另一个条件变化在于，此题给的数组是都是非负数。
	题目地址：https://leetcode.com/problems/house-robber/
**/
public class Solution {
	/**
		同样使用迭代的dp解法，同样定义dp公式：f(k)为是以k为结束索引的最大劫款数。那么
		对第k家有打劫与否两种情况，于是： f(k) = max( f(k-1), f(k-2) + nums[k] )
		由于此处递推涉及了前两项，故相较maximum题需要额外多定义一个变量。
	**/
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int preMaxEnd = nums[0], maxEnd = Math.max( nums[0], nums[1]);  //dp初始化
        int maxAns = Math.max(preMaxEnd, maxEnd);
        for( int i = 2; i < nums.length; i++) {
            int temp = maxEnd;  //暂存f(k-1)
            maxEnd = Math.max( maxEnd, preMaxEnd + nums[i]);  //依次更新变量
            preMaxEnd = temp;
            maxAns = Math.max( maxAns, maxEnd);
        }
        return maxAns;
    }
}