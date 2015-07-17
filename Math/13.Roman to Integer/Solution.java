/**
 * 转换罗马数字到int数，输入保证位于1~3999之间
 * 题目地址：https://leetcode.com/problems/roman-to-integer/
**/
public class Solution {

    //初始化罗马数字映射map，注意map初始化的写法
    private static final Map<Character,Integer> roman =  
        new HashMap<Character,Integer>() {{
            put('I',1); put('V',5);put('X',10);
            put('L',50); put('C',100);
            put('D',500); put('M',1000);
        }};
    
    /**
     * 罗马数字记数规则：
     * 1.相同的数字连写，所表示的数等于这些数字相加得到的数，如：Ⅲ = 3
     * 2.小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数， 如：Ⅷ = 8；Ⅻ = 12；
     * 3.小的数字，（限于Ⅰ、X 和C）在大的数字的左边，所表示的数等于大数减小数得到的数，如：Ⅳ= 4；Ⅸ= 9；
     * 4.正常使用时，连写的数字重复不得超过三次。
     * 转换为十进制表示的数时，主要注意2,3条的计算方法
    **/
    public int romanToInt(String s) {
        int result = 0, prev = 0;  //当前结果和前一个罗马数字代表的数
        for( char c : s.toCharArray()) {
            int cur = roman.get(c);  //当前罗马数字代表的数
            //默认是累加，但如果是规则3，则需要减去2倍的前一个数(遍历prev时，已经加到result中)
            result += (cur > prev) ? (cur - 2*prev) : cur;  
            prev = cur;
        }
        return result;
    }
}