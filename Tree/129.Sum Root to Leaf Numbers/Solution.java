public class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int sum) {
        if(node == null) return 0;
        sum = sum * 10 + node.val;
        if( node.left == null && node.right == null) return sum;
        return dfs(node.left, sum) + dfs(node.right, sum);
    }

    public int sumNumbers(TreeNode root) {
        ArrayList<String> result = new ArrayList<> ();
        if(root == null) return 0;
        StringBuilder path = new StringBuilder();
        dfs(root, path, result);
        int sum = 0;
        for( String i : result)
            sum += Integer.valueOf(i);
        return sum;
    }
    
    private void dfs(TreeNode node, StringBuilder path, List<String> result) {
        if(node == null) {
            return;
        }
        path.append(String.valueOf(node.val));
        if(node.left == null && node.right == null) {
            result.add(path.toString());
            return;
        }
        int len = path.length();
        dfs(node.left, path, result);
        if(len < path.length()) path.delete(len, path.length());
        dfs(node.right, path, result);
    }
}