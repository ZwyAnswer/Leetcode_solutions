/**
 * 给定分子和分母，返回其字符串形式的小数表示的分数。如果是无限循环的分数，则用0.(3)这种表示
 * 题目地址：https://leetcode.com/problems/fraction-to-recurring-decimal/
**/
public class Solution {
    /**
     * 根据除法来求小数，主要需要注意处理无限循环小数和分母为0，结果正负等情况。
     * 1.求整数部分
     * 2.循环求小数部分，如果小数部分一个数一旦重复出现，就会陷入无限循环。故使用HashMap来判断。
    **/
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) return "0";  //防止分母为0
        StringBuilder result = new StringBuilder();
        if((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0))
            result.append("-");  //分子分母异号
            
        long n = Math.abs((long)numerator);  //分子分母转换为长整型
        long d = Math.abs((long)denominator);
        result.append(n / d);  //整数部分
        n %= d;
        if(n == 0) return result.toString();  //整除，没有小数部分，只返回整数。
        
        result.append(".");  //以下为小数部分
        Map<Long, Integer> map = new HashMap<> ();  //用map来检查是否循环
        map.put(n, result.length());  //映射关系为数字-位置
        while(n != 0) {
            n *= 10;     
            result.append(n / d);  //循环求小数部分
            n %= d;
            
            if(map.containsKey(n)) {  //是否是无限循环小数
                int index = map.get(n);  
                result.insert(index, "(");  //是则在循环位置加入()后跳出循环返回
                result.append(")");
                break;
            } else {
                map.put(n, result.length());  //否则加入map
            }
        }
        return result.toString();
    }
}