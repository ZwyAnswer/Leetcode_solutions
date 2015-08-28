/**
 * 给定带有next指针域的二叉树，把next指向其同层次右边的结点（给定的为满二叉树）
 * 题目地址：https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 类似题目：Populating Next Right Pointers in Each Node II 
 *
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    //只有O(1)的空间，故不能用常规的层次遍历
    public void connect(TreeLinkNode root) {
        TreeLinkNode leftNode = root;
        while(leftNode != null) {
            TreeLinkNode levelNode = leftNode;
            while(levelNode != null) {  //遍历该层次
                if(levelNode.left != null) {
                    levelNode.left.next = levelNode.right;
                }
                if(levelNode.right != null && levelNode.next != null) {  
                    levelNode.right.next = levelNode.next.left;  //注意此处，右结点的next为其父节点next的左结点
                }
                levelNode = levelNode.next;  //更新父节点
            }
            leftNode = leftNode.left;  //去下一层
        }
    }
}