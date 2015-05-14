/**
	求给定[1...n]的K个组合
	题目地址：https://leetcode.com/problems/combinations/
**/
public class Solution {
	/**
		递归的动态规划解法 C(n,k) = C(n-1,k-1) + C(n-1, k)
	**/
    public List<List<Integer>> combine(int n, int k) {
        if( k == n || k == 0) {
            List<Integer> answer = new ArrayList<> ();
            for( int i = 1; i <=k; i++) {
                answer.add(i);
            }
            return new ArrayList<> (Arrays.asList(answer));
        }
        List<List<Integer>> result = combine(n-1, k);
        List<List<Integer>> tmp = combine(n-1, k-1);
        tmp.forEach( e -> e.add(n));
        result.addAll(tmp);
        return result;
    }
}