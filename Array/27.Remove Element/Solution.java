/**
 * 从数组中删除给定值，并返回新数组的长度。
 * 题目地址：https://leetcode.com/problems/remove-element/
 * 相似题目：Remove Linked List Elements
**/
public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null) return 0;
        ArrayList<Integer> array = new ArrayList<>();  //使用了额外的空间
        for(int i : nums) {
            if( i != val)
                array.add(i);   //复制不被删除的值到额外空间
        }
        int len = array.size();
        for(int i = 0; i < len; i++) {
            nums[i] = array.get(i);  //从额外空间复制回来
        }
        return len;
    }

    //不使用额外空间
    public int removeElement2(int[] nums, int val) {
        int count = 0;   //代表删除值后新数组的长度
        for(int i = 0; i < nums.length; i++) {
            if( nums[i] != val)
                nums[count++] = nums[i];  //把待删除值之外的值复制到前面来
        }
        return count;
    }

}