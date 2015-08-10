/**
 * 删除已排序数组中重复数字，返回删除后的数组长度，要求在数组原地删除
 * 题目地址：https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 类似题目：Remove Duplicates from Sorted Array II，Remove Duplicates from Sorted List
**/
public class Solution {
    /**
     * 使用两个指针，题目并不对新数组之后的空间保留什么做要求
     * 最终返回0~slow是不含重复数字的新数组，
    **/
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2) return nums.length;
        int slow = 0, fast = 1;
        while(fast < nums.length) {
            if(nums[fast] != nums[slow]) { //遇到不重复的数
                slow++;
                nums[slow] = nums[fast];  //则复制到前面来
            }
            fast++;
        }
        return ++slow;
    }
}