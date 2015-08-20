/**
 * 找到数组的连续子数组的最大和
 * 典型dp问题，拥有最优子结构特征。需要注意的是，最大子序列和必须是连续的子序列构成。
 * 另外注意输入的数组所含数字是可正可负的。
 * 题目地址：https://leetcode.com/problems/maximum-subarray/
 * 类似题目：Best Time to Buy and Sell Stock，Maximum Product Subarray
**/
public class Solution {
	/**
	 * DP问题首先需要定义dp公式。我们定义f(k)为是以k为结束索引的最大子序列和。
	 * 那么根据f(k-1)正负与否，有：f(k) = max( f(k-1) + nums[k], nums[k] )
	 * 由于最终的结果，即一个数组的最大连续子序列和必定是以某个x为结尾索引的。
	 * 使用迭代来实现DP，需要定义两个变量maxEnd和maxAns，分别暂存当前f(k) 和 当前最大和。
	 * 时间复杂度O(n),空间O(1), run time:340 ms
	**/
    public int maxSubArray(int[] nums) {
        int maxEnd = nums[0], maxAns = nums[0];   //dp初始条件
        for(int i = 1; i < nums.length; i++) {
            maxEnd = Math.max( maxEnd + nums[i], nums[i]);  //迭代更新
            maxAns = Math.max( maxAns, maxEnd);
        }
        return maxAns;
    }
	
	/**
	 * 使用分治法，因为把数组分为左右两部分后，数组中的任何连续子数组nums[i...j]必定位于：
	 * 左数组、右数组、或是跨越了中点，而最大子数组则必然是对这三种情况中的最大子数组和再取一次最大。
	 * 对左右数组分别求最大子数组和又成了原问题规模减半的子问题(divide)
	 * 而对跨越了中点的最大子数组和则可以遍历求解（combine），这样原问题就解决了(conquer)
	 * run time:372 ms
	**/
	public int maxSubArray2(int[] nums) {
        return divAndConq(nums, 0, nums.length-1);
    }
    
    private int divAndConq(int[] nums, int start, int end) {
        if( start > end) return Integer.MIN_VALUE;  //递归结束
        int mid = (start + end) / 2;
        int leftSum = divAndConq(nums, start, mid-1);  //递归求解子问题
        int rightSum = divAndConq(nums, mid+1, end);
        
		//对跨越中点的最大子数组求解，也分为中点前后两部分进行求解。
        int sum = 0, preMax = 0;
        for( int i = mid-1; i >=start; i--) {
            sum += nums[i];
            preMax = Math.max( preMax, sum);
        }
        int sufMax = 0;
        sum = 0;
        for( int i = mid+1; i <= end; i++) {
            sum += nums[i];
            sufMax = Math.max( sufMax, sum);
        }
        int midSum = preMax + nums[mid] + sufMax;  .
        return Math.max( Math.max(leftSum, rightSum), midSum);
    }
}