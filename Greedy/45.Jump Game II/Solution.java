/**
 * 对比55题，要求找出从开始跳到最后的最少跳步
 * 题目地址：https://leetcode.com/problems/jump-game-ii/
**/
public class Solution {
    public int jump(int[] nums) {
        int lastReach = 0, curReach = 0, minStep = 0; //分别代表上一步的最大到达，这一步的最大到达，最少步骤
        for(int i = 0; i < nums.length; i++) {
            if( i > lastReach) {
                lastReach = curReach;  //更新范围
                minStep++;  //超出上一步范围才更新步数
                if( lastReach >= nums.length-1) return minStep;  //即时返回
            }
            curReach = Math.max(nums[i]+i, curReach);  // 
        }
        return minStep;
    }
}