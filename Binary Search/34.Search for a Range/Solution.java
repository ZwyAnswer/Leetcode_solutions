/**
 * 给定已排序的输入数组，找到给定值在数组中的起始和终止位置(即可重复值)
 * 题目地址：https://leetcode.com/problems/search-for-a-range/
 * 类似题目：Search Insert Position
**/
public class Solution {
    //二分查找变种
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                int begin = mid, end = mid;  //循环查找起始和终止位置，注意循环条件
                while(begin > 0 && nums[begin-1] == target) begin--;  
                while(end < nums.length-1 && nums[end+1] == target) end++;
                return new int[] {begin, end};
            }
            else if(nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return new int[] {-1, -1};
    }
}