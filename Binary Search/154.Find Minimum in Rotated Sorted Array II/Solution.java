/**
 * 对比153题，允许有重复数
 * 题目地址：https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
**/
public class Solution {
    public int findMin(int[] num) {
        int l = 0, r = num.length - 1;
        while( l < r && num[l] >= num[r]) {
            int m = (l + r) / 2;
            if( num[m] > num[r]) {
                l = m + 1;
            } else if ( num[m] < num[l]) {
                r = m;
            } else {
                l = l + 1;  //重复时，只能一个一个排除，不能减半排除，最坏复杂度为O(n)
            }
        }
        return num[l];
    }
}