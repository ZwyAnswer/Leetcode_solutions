/**
 * 转换十进制数为罗马数字，输入有效范围为1~3999。
 * 题目地址：https://leetcode.com/problems/integer-to-roman/
 * 类似题目：Roman to Integer(罗马数字表示规则参考此题注释)
**/
public class Solution {
    
    //建立转换中使用的十进制数-罗马数字转换关系(从大到小)
    private static final int[] value = {
        1000, 900, 500, 400,
        100,  90,  50,  40,
        10,   9,   5,   4,
        1
    };
    
    //通过数组下标关联两个数组(1~3999所有可能数均为以下罗马数的拼接组合)
    private static final String[] roman = {
        "M","CM","D","CD",
        "C","XC","L","XL",
        "X","IX","V","IV",
        "I"
    };
    
    /**
     * 罗马数字和十进制数转换关系中，出现逆序(小前大后)均为4,40,400,9,90,900
     * 从大到小对给定int数进行递减和拼接即可，直到余数为0
    **/
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < value.length; i++) {
            while(num >= value[i]) {
                result.append(roman[i]);
                num -= value[i];
            }
        }
        return result.toString();
    }
}