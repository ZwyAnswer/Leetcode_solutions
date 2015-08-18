/**
 * 给定一个未排序数组，找到其第一个缺失的正数(要求O(n)，故不可排序)
 * https://leetcode.com/problems/first-missing-positive/
**/
public class Solution {
    //基于交换，如果A[i] == i+1则在正确位置上，不在的话则交换到正确的位置上
     public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;  //跳过超出范围的数和已在正确位置的数
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);  //把该在正确位置上的数交换过去
            else i++;
        }
        i = 0;  //交换完成从头遍历
        while(i < A.length && A[i] == i+1) i++;  //跳过在正确位置上的数
        return i+1;  //跳不过的地方即为第一个缺失的正数
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}