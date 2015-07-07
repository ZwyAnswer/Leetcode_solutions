/**
 * 求给定[1...n]的包含k个数的组合
 * 题目地址：https://leetcode.com/problems/combinations/
**/
public class Solution {
	/**
	 * 递归的动态规划解法，分别为含k个数的组合中包含n和不包含n的两种情况
     * 组合数的递推公式：C(n,k) = C(n-1,k-1) + C(n-1, k)
	**/
    public List<List<Integer>> combine(int n, int k) {
        if( k == n || k == 0) {  //递归终止条件，k==0返回空，k=n,返回1..n
            List<Integer> answer = new ArrayList<> ();
            for( int i = 1; i <=k; i++) {
                answer.add(i);
            }
            return new ArrayList<> (Arrays.asList(answer));  //将数组转换为数组列表，如[1,2]-->[[1,2]]
        }
        List<List<Integer>> result = combine(n-1, k);  //k个数组合中不包含n，即从前n-1个数中取k个数
        List<List<Integer>> tmp = combine(n-1, k-1);  //k个数组合中包含n，即从前n-1个数中取k-1个数，再都加入n
        tmp.forEach( e -> e.add(n));  //JDK8的新API,给C(n-1,k-1)的结果集中加入n
        result.addAll(tmp);  //合并两个结果集并返回
        return result;
    }
}