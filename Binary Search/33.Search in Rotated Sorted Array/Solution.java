/**
 * 在给定一个右旋后的已排序数组中查找给定数
 * 题目地址：https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 类似题目：Search in Rotated Sorted Array II，Find Minimum in Rotated Sorted Array
**/
public class Solution {
    /**
     * 分情况进行二分查找（画图分析）
    **/
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            
            if(nums[mid] > nums[right]) {
                if(target >= nums[left] && target < nums[mid])  //落到有序区间
                    right = mid - 1;
                else left = mid + 1;
            } else {
                if(target > nums[mid] && target <= nums[right])  //落到有序区间
                    left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}