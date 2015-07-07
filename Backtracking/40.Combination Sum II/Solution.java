/**
 * 与39题不同的有2点，1是要求答案组合中的数字只能从candidates数组中取一次。
 * 2是给定candidates不再是集合，而是可以有重复数字的数组。
 * 题目地址：https://leetcode.com/problems/combination-sum-ii/
**/
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();  //因为candidates可重复，故用Set避免答案中含重复的组合
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        dfsHelper(candidates, target, result, cur, 0);
        return new ArrayList<List<Integer>>(result);  //转为动态数组返回
    }
    
    private void dfsHelper(int[] candidates, int target, Set<List<Integer>> result, List<Integer> cur, int index) {
        if(target == 0) {
            result.add(cur);
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            int newTarget = target - candidates[i];
            if(newTarget >= 0) {
                List<Integer> newCur = new ArrayList<> (cur);
                newCur.add(candidates[i]);
                dfsHelper(candidates, newTarget, result, newCur, i+1);  //继续递归要从下一个数字开始
            } else {
                break;
            }
        }
    }
    
}