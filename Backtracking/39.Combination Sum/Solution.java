/**
 * 给定数字集合(注意是集合，即candidates中不含重复数)，找到其中组合的和为给定数的所有组合
 * 题目地址：https://leetcode.com/problems/combination-sum/
 * 类似问题：Combination Sum II， Combination Sum III， Letter Combinations of a Phone Number
**/
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);  //先把给定数组排序，因为要求答案中的组合是按升序排列
        dfsHelper(candidates, target, result, cur, 0);
        return result;
    }
    
    /**
     * 深度优先搜索策略来递归查找答案
     * result为结果数组，cur代表当前的潜在答案组合，index代表从哪个数开始组成结果组合
    **/
    private void dfsHelper(int[] candidates, int target, List<List<Integer>> result, List<Integer> cur, int index) {
        if(target == 0) {
            result.add(cur);  //此时组合和正好为给定数字，递归终止，答案加入结果集
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            int newTarget = target - candidates[i];  //减去当前数
            if( newTarget >= 0) {  //当前组合依然有效
                List<Integer> newCur = new ArrayList<>(cur);  //必须使用一个新数组，这样防止递归返回后覆盖原有Cur
                newCur.add(candidates[i]);  //当前数加入当前组合
                dfsHelper(candidates, newTarget, result, newCur, i);  //继续递归查找，注意下一个Index还是i，因为组合中数字可重复
            } else {
                break;  //当前组合的和不符合给定数，跳出循环，结束当前层次的递归
            }
        }
    }
    
}