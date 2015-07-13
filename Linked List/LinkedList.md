## Java中链表结点的表示
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	
## Python中链表结点的表示

	class ListNode:
		def __init__(self, x):
			self.val = x
			self.next = None
			
# 链表题要点

- 链表的基本操作：插入、删除、遍历。
- 伪头结点的使用。

# 典型题

- 反转链表
- 