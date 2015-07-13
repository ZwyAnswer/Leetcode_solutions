/**
 * 给定两个已排序数组及其大小，把第二个数组合并到第一个数组中(假设第一个数组有足够容量)
 * 题目地址：https://leetcode.com/problems/merge-sorted-array/
 * 类似题目：Merge Two Sorted Lists
**/
public class Solution {
    /**
     * 使用3个下标索引，分别代表当前合并好数组下标，第一个和第二个数组的下标。从后往前合并
     * 只需要把更大的那个数赋值给合并好数组下标处即可。
    **/
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = m+n-1;
        while( i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }
        while(j >= 0) nums1[k--] = nums2[j--];
    }

    /**
     * 从前往后合并，需要向后移动已有数字(费时)。
     * 注意索引下标的条件，否则容易出现ArrayIndexOutOfBoundsException
    **/
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        while( i < (m+j) && j < n) {  //注意此处i< (m+j)，代表当前数组1中的长度
            if(nums1[i] < nums2[j]) i++;
            else {
                int k = m+j-1;  //注意此处k的值，为当前数组1的最后一个数
                while( k >= i) {
                    nums1[k+1] = nums1[k];
                    k--;
                }
                nums1[i++] = nums2[j++];
            }
        } 
        while(j < n) nums1[i++] = nums2[j++];
    }
}