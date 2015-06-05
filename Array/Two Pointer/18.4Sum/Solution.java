/**
	从3Sum推广到4Sum，方法相同，可以推广到kSum. 
	题目地址：https://leetcode.com/problems/4sum/
	算法时间复杂度：O(N^3)
**/
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<> ();
        Arrays.sort(nums);
        for( int i = 0; i < nums.length - 3; i++) {
            if( i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                for( int j = i+1; j < nums.length -2; j++) {
                    if( j == i+1 || (j > i+1 && nums[j] != nums[j-1])) {
                        int begin = j+1, end = nums.length-1;
                        while(begin < end) {
                            int sum = nums[i] + nums[j] + nums[begin] + nums[end];
                            if( sum == target ) {
                                result.add(Arrays.asList(nums[i], nums[j], nums[begin], nums[end]));
                                while( begin < end && nums[begin] == nums[begin+1]) begin++;
                                while( begin < end && nums[end] == nums[end-1]) end--;
                            }
                            if( sum > target) end--;
                            else begin++;
                        }
                    }
                }
            }
        }
        return result;
    }
}