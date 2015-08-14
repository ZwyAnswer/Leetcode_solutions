/**
 * 给定n，输出所有合法匹配的左右括号组合
 * 题目地址：https://leetcode.com/problems/generate-parentheses/
 * 类似题目：Letter Combinations of a Phone Number， Valid Parentheses
**/
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<> ();
        dfs(result, n, n, "");
        return result;
    }
    
	/**
	 * dfs回溯搜索的另一种写法
     * left代表左括号数，right代表右括号数，answer代表有效答案
	**/
    private void dfs(List<String> result, int left, int right, String answer) {
        if( left > right) return;   //避免当前左括号数大于右括号数，这样会出现左括号对应右括号)(的逆序
        if( left == 0 && right == 0) {
            result.add(answer);
            return;
        }
		if( left > 0) dfs(result, left-1, right, answer+"(");  //每次处理左括号时，不添加对应右括号数，则需要添加回溯判断条件
        if( right > 0) dfs(result, left, right-1, answer+")"); 
    }
    
    
	/**
	 *	一种动态规划的搜索写法，迭代计算, 自底向上。
	 *	设f(n)为对应n对括号的解，依次计算f(0)...f(i)...f(n)，f(n)可以拆分为其它f(i)的组合
	 *	拆分的递推公式为f(i): (f(j))f(i-j-1)。其中j = 0...j-1
	**/
    public List<String> generateParenthesis2(int n) {
        List<String>[] resultArray = new List[n+1];  //保存f(i)的list数组，0<=i<=n
        resultArray[0] = Arrays.asList("");
        for(int i = 1; i <=n; i++) {  //迭代计算f(1)...f(n)的解
            List<String> tmp = new ArrayList<> ();  
            for(int j = 0; j < i; j++) {   //计算f(i)的解
                for( String s1 : resultArray[j]) {
                    for( String s2 : resultArray[i-j-1]) {
                        tmp.add( "(" + s1 + ")" + s2);
                    }
                }
            }
            resultArray[i] = tmp;
        }
        return resultArray[n];
    }
}