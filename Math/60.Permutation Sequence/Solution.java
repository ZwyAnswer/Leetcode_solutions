/**
 * 给出按字典大小顺序排列的n!中的第k个排列结果
 * 题目地址：https://leetcode.com/problems/permutation-sequence/
**/
public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new LinkedList<>();
        for(int i = 1; i <= n; i++) nums.add(i);  //构造保存了1~n的链表，在遍历中保存排列中还未使用的数字
        StringBuilder result = new StringBuilder();  
        int[] factorial = new int[n];
        factorial[0] = 1;
        for(int i = 1; i < n; i++) factorial[i] = i * factorial[i-1];  //构造n!数组，f[i]保存i!
        k--;  //处理 k%(n-1) == 0，例如找5！中第48个数，此时48 / 4! == 0，为2开头所有排列中最后一个数
        
        for(int i = n; i > 0; i--) {
            int index = k / factorial[i-1];  //计算结果当前首数字在当前全排列中的索引下标
            result.append(nums.get(index));
            nums.remove(index);  //移去已使用的数字
            k %= factorial[i-1];  //更新k
        }
        return result.toString();
    }
}