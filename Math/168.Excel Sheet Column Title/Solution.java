/**
 * Excel的列号转换为对应字母标题，例如：1 -> A，2 -> B，26 -> Z，27 -> AA
 * 题目地址：https://leetcode.com/problems/excel-sheet-column-title/
 * 类似题目：Excel Sheet Column Number
**/
public class Solution {
	/**
	 * 利用%来取对应A-Z的下标，然后用/更新
	 * 可以分别利用迭代和递归两种方法计算
	**/
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while(n > 0) {
            n--;  //因为1~26分别对应A~Z，而转换为字符是在A基础上加，故减一
            result.insert(0, (char)('A'+ n % 26));  //插入当前字符
            n /= 26;  //更新n
        }
        return result.toString();
    }

    //递归写法
    public String convertToTitle2(int n) {
        return (n== 0) ? "" : convertToTitle(--n / 26) + (char)('A' + n % 26);
    }
}