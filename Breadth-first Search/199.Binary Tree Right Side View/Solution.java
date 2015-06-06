/**
	题目地址：https://leetcode.com/problems/binary-tree-right-side-view/
**/
public class Solution {
	/**
		BFS层次遍历二叉树，但由于是Right Side View，所以压入队列时与应该先右后左
		把每层的第一个节点值加入结果数组
	**/
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<> ();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<> ();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int levelNum = queue.size();
            for(int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                if( i == 0) result.add(node.val);
                if(node.right != null) queue.add(node.right);
                if(node.left != null) queue.add(node.left);
            }
        }
        return result;
    }
}