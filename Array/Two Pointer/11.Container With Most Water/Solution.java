/**
 * 给定非负数组，代表(i,0)--->(i, height[i])的垂直线段，找出垂直线段之间与x轴组成的最大面积
 * 题目地址：https://leetcode.com/problems/container-with-most-water/
 * 类似题目：Trapping Rain Water
**/
public class Solution {
    /**
     * 用头尾两个索引下标进行遍历
     * 最大的面积一定位于首尾之间，每次遍历更新最大面积变量即可
    **/
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;  //代表遍历到当前的最大面积
        while(left < right) {
            max = Math.max((right - left) * Math.min(height[left], height[right]), max);  //每次更新max
            if(height[left] < height[right]) left++;  //更新左索引
            else right--;
        }
        return max;
    }
}