/**
 * 求出能存1-n的二叉查找树的个数
 * 题目地址：https://leetcode.com/problems/unique-binary-search-trees/
 * 类似题目：Unique Binary Search Trees II
**/
public class Solution {
    //DP计算，自顶向下
    public int numTrees(int n) {
        int g[] = new int[n+1];  //g[i]代表含有i个结点的BST的个数
        g[0] = g[1] = 1;
        for(int i = 2; i <= n; i++) {
            for( int j = 1; j <= i; j++) {
                g[i] += g[j-1] * g[i - j];  //左子树乘以右子树
            }
        }
        return g[n];
    }
}