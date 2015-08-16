/**
 * 给定数组形式的数字排列，求出其全排列顺序中的下一个排列，要求在原处修改
 * 题目地址：https://leetcode.com/problems/next-permutation/
**/
public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int i = nums.length - 2;
        while( i >= 0) {  
            if( nums[i] < nums[i+1]) break;  //保证从i到n-1为从大到小
            i--;
        }
        if( i < 0) {  //如果给定的是全排列顺序中最后一个数，则改为第一个
            Arrays.sort(nums);
            return;
        }
        int j = nums.length - 1;
        while( j > i) {
            if(nums[j] > nums[i]) break;  //找到i+1 ~ n-1中第一个比i大的数
            j--; 
        }
        swap(nums, i, j);
        Arrays.sort(nums, i+1, nums.length);  //将i+1到n-1从小到大排序即可
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}