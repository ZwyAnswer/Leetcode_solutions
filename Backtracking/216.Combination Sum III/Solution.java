/**
 * 从[1...9]中找出k个数，使其组合的和为n，不允许重复取数。
 * 题目地址：https://leetcode.com/problems/combination-sum-iii/
**/
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<> ();
        List<Integer> cur = new ArrayList<> ();
        if( k == 0 ) return result;
        dfsHelper(k, n, result, cur, 1);
        return result;
    }
    
    //k, n, index分别代表当前递归查找中，可取数的数目，待查找的数以及从哪个数开始查找。
    private void dfsHelper(int k, int n, List<List<Integer>> result, List<Integer> cur, int index) {
        if(index == 10) return;  //只能从1...9中取数，一旦取到10则终止递归
        if( k == 1) {
            if( n >= index && n <= 9) {  //只剩找最后一个数时，如果当前待查数落在index~9中，
                cur.add(n);
                result.add(cur);  //答案加入结果集，终止递归
            }
            return;
        }
        for(int i = index; i < 10; i++) {
            int newN = n - i;
            if(newN >= 0) {
                List<Integer> newCur = new ArrayList<>(cur);
                newCur.add(i);
                dfsHelper(k-1, newN, result, newCur, i+1);
            } else {
                break;
            }
        }
    }
}