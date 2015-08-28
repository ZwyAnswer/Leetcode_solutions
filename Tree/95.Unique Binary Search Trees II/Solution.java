/**
 * 给定n，构造出含1-n个结点不同的二叉树
 * 题目地址：https://leetcode.com/problems/unique-binary-search-trees-ii/
 * 类似题目：Different Ways to Add Parentheses
**/
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    //Divide-Combine
    private List<TreeNode> generateTrees(int begin, int end) {
        List<TreeNode> result = new ArrayList<> ();
        if(begin > end) {  //递归结束条件
            result.add(null);
            return result;
        }
        for(int i = begin; i <= end; i++) {
            List<TreeNode> leftSet = generateTrees(begin, i-1);  //分治递归求解
            List<TreeNode> rightSet = generateTrees(i+1, end);
            for( TreeNode left : leftSet) {  //合并结果
                for( TreeNode right : rightSet) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}