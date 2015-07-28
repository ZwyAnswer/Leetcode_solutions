/**
 * 相比Two sum，给定的输入数组nums是递增有序的。
 * 可以继续使用HashMap的方法，但这样会有O(n)的空间复杂度，且没有利用输入有序的条件。
 * 类似题目：3Sum，4Sum。 
**/
public class Solution {
	
	/**
	 *	利用输入有序的条件，依次进行二分查找目标数字。
	 *	时间复杂度O(NlogN), 空间O(1)。
	**/
	public int[] twoSum(int[] nums, int target) {
		for(int i = 0; i < nums.length; i++) {
			int j = binarySearch(nums, target-nums[i], i+1);
			if( j != -1) return new int[] { i+1, j+1 };
		}
		throw new IllegalArgumentException("No solution"); //避免报没有返回值的错误
	}
	
	//迭代式进行二分查找
	private int binarySearch(int[] nums, int num, int start) {
		int end = nums.length - 1;
		while( start < end) {
			int mid = (start + end) / 2;
			if( nums[mid] < num ) start = mid + 1;
			else end = mid;
		}
		return ( start == end && nums[mid] == num ) ? start : -1;
	}
	
	/**
	 *	利用两个标志位 i, j，那么任意 nums[i] + nums[j] 分别可能 < 、= 、 > target
	 *	利用输入数组递增的特点，大于的时候只能减小j, 小于的时候只能增加i。 这样遍历直到找到等于的情况
	 *	时间复杂度O(N),空间O(1)
	**/
	public int[] twoSum(int[] nums, int target) {
		int i = 0, j = nums.length - 1;
		while( i < j ) {
			if( nums[i] + nums[j] == target) return new int[] {i+1, j+1};
			if( nums[i] + nums[j] > target) j--;
			if( nums[i] + nums[j] < target) i++;
		}
		throw new IllegalArgumentException("No solution");
	}
}