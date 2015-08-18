/**
 * 给定一个未排序数组，从第一个数出发，每个数代表在其可以跳的最大距离，问是否能调到最后一个数
 * 题目地址：https://leetcode.com/problems/jump-game/
**/
public class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0;
        for(int i = 0; i < nums.length && i <= reach; i++) {
            reach = Math.max(i + nums[i], reach);  //迭代更新目前最远可达
            if(reach >= nums.length-1) return true;  //一旦可达最后，即返回
        }
        return reach >= nums.length-1;
    }
}