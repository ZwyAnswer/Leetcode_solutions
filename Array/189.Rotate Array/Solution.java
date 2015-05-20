/**
	字符串/数组右旋，有多种解法，可以使用额外的数组，也可以在原数组上操作
	题目地址：https://leetcode.com/problems/rotate-array/
	类似题目：Reverse Words in a String II
**/
public class Solution {
	/**
		按照题目意思，可以把数组按下标划分为两部分X：[0...len-1-k]，Y:[len-k...len-1]
		那么rotate是把XY转化为YX，令X的倒序为X', 那么（X'Y')' = (Y')'(X')'= YX
	**/
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len-1-k);
        reverse(nums, len-k, len-1);
        reverse(nums, 0, len-1);
    }
    
	//反转数组的辅助函数
    private void reverse(int[] nums, int start, int end) {
        while( start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}