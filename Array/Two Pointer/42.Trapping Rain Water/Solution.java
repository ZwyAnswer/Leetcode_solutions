/**
 * 题目描述参考题图
 * 题目地址：https://leetcode.com/problems/trapping-rain-water/
**/
public class Solution {
    //使用两个下标索引遍历计算
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int water = 0;  //盛水量
        
        //找到可以盛水的左右边界，要盛水，边界必须比其内部邻居的高度高
        while(left < right && height[left] <= height[left+1]) left++;  
        while(left < right && height[right] <= height[right-1]) right--;
        
        while(left < right) {
            int leftEdge = height[left];
            int rightEdge = height[right];
            if(leftEdge <= rightEdge) { //计算靠左边可盛水区
                while(left < right && leftEdge >= height[++left])
                    water += leftEdge - height[left];
            } else {  //计算靠右边可盛水区
                while(left < right && rightEdge >= height[--right])
                    water += rightEdge - height[right];
            }
        }
        return water;
    }
}