/**
	ZigZag的形式进行二叉树层次遍历
	题目地址：https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
**/
public class Solution {
	/**
		BFS进行层次遍历，需要添加一个代表当前层次的变量
		在偶数层，要把当前层次链表反转后再加入结果集（假设root为第一层）
	**/
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<> ();
        if(root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<> ();
        queue.add(root);
        int level = 1;
        
        while(!queue.isEmpty()) {
            int nodeNum = queue.size();
            List<Integer> lastLevel = new ArrayList<> ();
            for(int i = 0; i < nodeNum; i++) {
                TreeNode node = queue.poll();
                lastLevel.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(level % 2 == 0) Collections.reverse(lastLevel);  //反转偶数层的层链表
            level++;  //更新层次变量
            result.add(lastLevel);
        }
        return result;
    }
}