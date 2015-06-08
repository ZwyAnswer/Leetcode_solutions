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
                if( i == 0) result.add(node.val);  //每层第一个节点加入结果数组
                if(node.right != null) queue.add(node.right);
                if(node.left != null) queue.add(node.left);
            }
        }
        return result;
    }
	
	/**
		DFS实现版本，参考层次遍历的DFS版本
	**/
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<> ();
        if(root == null) return result;
        dfs(root, result, 0);
        return result;
    }
    
    private void dfs(TreeNode node, List<Integer> result, int level) {
        if(node == null) return;
        if(result.size() <= level) {  //只需在第一次遍历到某层的时候，加入第一个结点值
            result.add(node.val);    
        }
        dfs(node.right, result, level+1);
        dfs(node.left, result, level+1);
    }
}