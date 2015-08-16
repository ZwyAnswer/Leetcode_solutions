/**
 * 与33题不同的在于，给定数组中有重复的数
 * 题目地址：https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
**/
public class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) return true;
            if(nums[mid] > nums[right]) {
                if(target < nums[mid] && target >= nums[left])
                    right = mid - 1;
                else left = mid + 1;
            } else if(nums[mid] < nums[right]) {
                if(target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else right = mid - 1;
            } else {  //重复的情况
                right--;
            }
        }
        return false;
    }
}