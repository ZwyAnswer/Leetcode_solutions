/**
 * 实现整数开平方根函数，sqrt(x)，x为int型，返回根也为int型。
 * 题目地址：https://leetcode.com/problems/sqrtx/
 * 类似题目：Pow(x, n)
**/
public class Solution {
    /**
     * 因为x的平方根向下取整后必然位于1~x之间，故可以转换为查找问题
     * 利用二分查找来寻找平方根
    **/
    public int mySqrt(int x) {
        if( x == 0 || x == 1) return x;
        int begin = 1, end = x, result = 1;
        while(begin <= end) {
            int mid = (begin + end) / 2;
            if( mid == x / mid) return mid;  //正好找到平方根(x为完全平方数)
            if( mid > x / mid) end = mid - 1;  //根在上半区
            else {
                begin = mid + 1;  //根在下半区
                result = mid;  //向下取整(即mid^2 < x)，mid此时为其平方最接近x的数
            }
        }
        return result;  //x不是完全平方数，则返回其向下取整的根
    }
}