/**
 * 找到右旋后有序数组的最小值
 * 题目地址：https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 类似题目：Find Minimum in Rotated Sorted Array II 
**/
public class Solution {
	// 同33题，二分查找
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right && nums[left] > nums[right]) {  //一旦nums[left] < nums[right]，则left为最小
            int mid = (left + right) / 2;
            if(nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }
}