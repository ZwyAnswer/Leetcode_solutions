/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

/**
 * 复制一个带有random指针域的链表，链表定义如上
 * 题目地址：https://leetcode.com/problems/copy-list-with-random-pointer/
 * 类似题目：Clone Graph
**/
public class Solution {
    /**
     * 直接遍历复制，只能复制next指针域，而random无法复制。故应使用hashmap分两步复制。
     * 1. 生成新链表结点，并复制next域，同时建立新链表结点与原链表结点的映射关系。
     * 2. 利用map再一次遍历，来复制random域。
    **/
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode p = head, pHead = new RandomListNode(0), q = pHead;
        Map<RandomListNode, RandomListNode> map = new HashMap<> ();  //原结点与新结点的HashMap
        while(p != null) {    //生成新链表结点，复制next域，建立新链表结点与原结点的map关系
            q.next = new RandomListNode(p.label);
            map.put(p, q.next);
            p = p.next;
            q = q.next;
        }
        p = head;
        q = pHead;
        while(p != null) {
            q.next.random = map.get(p.random);  //利用map来复制random域
            p = p.next;
            q = q.next;
        }
        return pHead.next;
    }
}