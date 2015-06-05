/**
	找到输入数组中和为0的三个数组，结果可能有多组，每组答案要求升序排列
	题目地址：https://leetcode.com/problems/3sum/
**/
public class Solution {
	/**
		利用一个下标i从0遍历到数组倒数第三个, 
		然后利用同two Sum中已排序输入两个指针的方法，从i+1到数组末尾来查找答案。
		注意3个下标都要跳过重复值。这样结果集中就不会有重复结果
		时间复杂度：O(N^2)
	**/
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<> ();
        Arrays.sort(nums);
        for( int i = 0; i < nums.length-2; i++) {
            if( i == 0 || ( i > 0 && nums[i] != nums[i-1])) {
                int begin = i+1, end = nums.length-1;
                while(begin < end) {
                    int sum = nums[i] + nums[begin] + nums[end];
                    if( sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[begin], nums[end]));
						//更新begin和end，注意要跳过重复值。
                        while(begin < end && nums[begin] == nums[begin+1]) begin++;
                        while(begin < end && nums[end] == nums[end-1]) end--;
                    }
                    if( sum < 0) begin++;
                    else end--;
                }
            }
        }
        return result;
    }
}