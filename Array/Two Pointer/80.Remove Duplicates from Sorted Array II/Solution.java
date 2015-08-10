/**
 * 对比26题，允许数组中数字最多重复一次，其余条件不变，返回新数组及其长度
 * 题目地址：https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
**/
public class Solution {
	/**
	 * 添加一个记录重复次数的count变量
	**/
	public int removeDuplicates(int[] nums) {
        if(nums.length < 3) return nums.length;
        int slow = 0, fast = 1;
        int count = 0;
        while(fast < nums.length) {
            if(nums[fast] == nums[slow]) count++;
            else count = 0; 
            if(count < 2) slow++;  //count超过2时，会直接赋值覆盖掉第3个重复的数字
            nums[slow] = nums[fast];
            fast++;
        }
        return ++slow;
    }

    //简短写法
    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        }
        return i;
    }
}