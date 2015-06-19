 /**
  * 给n个数组成的未排序数组，找出按已升序排序的序列中第K大的元素  
  * 题目地址：https://leetcode.com/problems/kth-largest-element-in-an-array/
 **/
 public class Solution {
 	//维护一个容量为k+1的最小堆，每次堆中元素大于K则移除小堆顶，遍历完数组后最小堆的含有K个数
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<> (k+1);
        for( int i : nums) {
            heap.add(i);
            if( heap.size() > k) heap.poll();
        }
        return heap.poll();  //此时最小堆顶即为第K大，因为小于其的数都被从堆中移除了
    }

    //当然，偷懒的办法可以对数组排序（如果允许）再按索引返回，时间复杂度也为O(nlogn)
    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}