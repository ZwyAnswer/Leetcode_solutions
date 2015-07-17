/**
 * 实现求x的n次幂的函数pow(x, n)
 * 题目地址：https://leetcode.com/problems/powx-n/
 * 类似题目：Sqrt(x) 
**/
public class Solution {
    /**
     * 如果直接n次递归，则肯定会TLE，故因使用分治法进行加速
     * 注意幂指数为int型，x和返回值均为double型
    **/
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;  //递归终止条件
        if(n < 0) { //处理幂指数为负的情形
            if( n == Integer.MIN_VALUE) {   //处理幂指数为-2^31的特殊情形
                return 1.0 / myPow(x, Integer.MAX_VALUE)*x;
            }
            n = - n;  //转换为正的幂指数进行计算
            x = 1/x;
        }
        return (n % 2 == 0) ? myPow(x*x, n/2) : x * myPow(x*x, n/2);  //分治递归，分别处理幂指数可能为奇数或偶数
    }
}