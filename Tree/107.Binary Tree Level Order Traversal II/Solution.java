/**
 * 自底向上地返回每层结点
 * 题目地址：https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * 类似题目：Minimum Depth of Binary Tree
**/
public class Solution {
	/**
	 * 依然使用BFS迭代遍历，每次插入层次链表时，使用头插法而非尾插法。
	**/
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<> ();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<> ();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int nodeNum = queue.size();
            List<Integer> lastLevel = new ArrayList<> ();
            for(int i = 0; i < nodeNum; i++) {
                TreeNode node = queue.poll();
                lastLevel.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.addFirst(lastLevel);  //只有此处变动，每次在结果集头部插入上一层级链表。
        }
        return result;
    }
}