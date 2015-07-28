/**
 * 给定一个已排序数组和一个值，如果该值存在，则返回其在数组中的下标，否则返回其插入位置。
 * 可以假定数组中没有重复元素
 * 题目地址：https://leetcode.com/problems/search-insert-position/
 * 类似题目：Search for a Range
**/
public class Solution {
    // 二分查找，注意下标的细节
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    public int searchInsert2(int[] A, int target) {
        int l = 0, r = A.length - 1;
        while( l < r) {  //注意此处不可等于
            int m = (l + r) / 2;
            if ( target == A[m]) {
                return m;
            } else if (target < A[m]) {
                r = m;  //注意此处是m而非m-1
            } else {
                l = m + 1;
            }
        }
        return (A[l] >= target) ? l : l+1 ;
    }
}