/**
	找出给定数组中，和为给定数的两个数下标。
	题目地址：https://leetcode.com/problems/two-sum/
**/
public class Solution {
	/**
		相较于O(N^2)的暴力破解，额外使用O(N)的Map，可以在O(N)时间内解出
		key: 数值， value：该数值对应的下标index+1 (根据题目要求，要对原始下标加1)
	**/
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<> ();
        for( int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if(map.containsKey(x))
                return new int[] { map.get(x)+1, i+1};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution");  //避免报没有返回值的错误
    }
}