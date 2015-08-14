
public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int i = nums.length - 2;
        while( i >= 0) {
            if( nums[i] < nums[i+1]) break;
            i--;
        }
        if( i < 0) {
            Arrays.sort(nums);
            return;
        }
        int j = nums.length - 1;
        while( j > i) {
            if(nums[j] > nums[i]) break;
            j--;
        }
        swap(nums, i, j);
        Arrays.sort(nums, i+1, nums.length);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}