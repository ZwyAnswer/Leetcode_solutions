/**
 * 二叉树层次遍历，照例有DFS和BFS两种解法
 * 题目地址：https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 类似题目：Binary Tree Level Order Traversal II，Minimum Depth of Binary Tree
**/
public class Solution {
	/**
	 * DFS递归来层次遍历，对先序遍历略作修改，每次递归调用传入当前层次。
	**/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<> ();
        if(root == null) return result;
        dfsLevelOrder(root, result, 0);
        return result;
    }
    
    private void dfsLevelOrder(TreeNode node, List<List<Integer>> result, int level) {
        if(node == null) return;
        List<Integer> levelList = null;
        if(result.size() <= level) {  //若当前层次还未加入结果集，则加入当前层次
            levelList = new LinkedList<> ();
            result.add(levelList);
        } else {
            levelList = result.get(level); //已有当前层次，则获取对应的层次链表
        }
        levelList.add(node.val);
        dfsLevelOrder(node.left, result, level+1);
        dfsLevelOrder(node.right, result, level+1);
    }
	
	/**
	 * BFS迭代来层次遍历，注意队列的使用。
	**/
	public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<> ();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<> ();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int nodeNum = queue.size();  //上一层的结点数
            List<Integer> lastLevel = new ArrayList<> (); //上一层的结点链表
            for(int i = 0; i < nodeNum; i++) {  //遍历上一层，并把其子节点(本层）加入队列
                TreeNode head = queue.poll();
                if(head.left != null) queue.add(head.left);
                if(head.right != null) queue.add(head.right);
                lastLevel.add(head.val);
            }
            result.add(lastLevel);  
        }
        return result;
    }
}