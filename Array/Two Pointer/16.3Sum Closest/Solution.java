/**
 * 相比于3Sum,要找到与target相距最近的3元组和，且答案唯一。
 * 题目地址：https://leetcode.com/problems/3sum-closest/
 * 类似题目：3 Sum.
**/
public class Solution {
	/**
	 * 设定一个最接近target的变量，每次遍历更新此变量。遍历方法同3Sum
	**/
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[nums.length-1];
        for(int i = 0; i < nums.length - 2; i++) {
            int begin = i+1, end = nums.length - 1;
            while( begin < end) {
                int sum = nums[i] + nums[begin] + nums[end];
                if( sum == target) return sum;
                if(Math.abs(sum - target) < Math.abs(closest - target))
                    closest = sum;
                if( sum > target) end--;
                else begin++;
            }
        }
        return closest;
    }
}