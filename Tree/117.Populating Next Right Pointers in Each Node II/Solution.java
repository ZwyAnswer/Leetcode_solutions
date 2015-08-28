/**
 * 相较于116题，给定二叉树可以是任意二叉树
 * 题目地址：https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
**/
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode current = root;
        TreeLinkNode levelHead = null;
        TreeLinkNode levelPrev = null;
        
        while(current != null) {
            while(current != null) {
                if(current.left != null) {
                    if(levelPrev != null) {
                        levelPrev.next = current.left;
                    } else {
                        levelHead = current.left;
                    }
                    levelPrev = current.left;
                }
                
                if(current.right != null) {
                    if(levelPrev != null) {
                        levelPrev.next = current.right;
                    } else {
                        levelHead = current.right;
                    }
                    levelPrev = current.right;
                }
                current = current.next;
            }
            current = levelHead;
            levelHead = null;
            levelPrev = null;
        }
    }
}