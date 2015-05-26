/**
	在House Robber的基础上，把给定数组条件修改为环形数组，这样nums[0]和nums[length-1]相邻
	把首尾两个元素分开纳入考虑，则可以利用原来的解法。即分别求0...length-2和1...length-1的最大值。
	最终的最大值即为这两个值的较大值
**/
public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max( rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
    }
    
	/**
		相较House Robber中换了一种dp定义，使代码更简洁。其定义及递推公式为：
		设f(k)和g(k)分别代表包含第k个元素和不包含第k个元素情况下的当前最大和
		那么：f(k) = g(k-1) + nums[k], g(k) = max( f(k-1), g(k-1) )
		所以在迭代实现中利用两个变量来实现dp。
	**/
    public int rob(int[] nums, int start, int end) {
        int includeMax = 0, excludeMax = 0;
        for( int i = start; i <= end; i++) {
            int preInc = includeMax, preExc = excludeMax;
            includeMax = excludeMax + nums[i];
            excludeMax = Math.max( preInc, preExc);
        }
        return Math.max(includeMax, excludeMax);
    }
}