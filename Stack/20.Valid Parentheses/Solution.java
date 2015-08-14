/**
 * 给定字符串，只包含大、中、小三种括号，决定括号组合是否合法
 * 题目地址：https://leetcode.com/problems/valid-parentheses/
 * 类似题目：Longest Valid Parentheses
**/
public class Solution {
    
    //因为有3种括号，故先初始化一个Map
    private static final Map<Character,Character> map= 
        new HashMap<Character,Character>() {{
            put('(',')');
            put('[',']');
            put('{','}');
        }};
    
    //括号匹配，用栈
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for( char c : s.toCharArray()) {
            if(map.containsKey(c)) {  //碰到左括号，压栈
                stack.push(c);
            } else if (stack.empty() || map.get(stack.pop()) != c) {  //碰到右括号若不匹配则及时返回
                return false;
            }
        }
        return stack.empty();  //最终看栈是否为空
    }
}