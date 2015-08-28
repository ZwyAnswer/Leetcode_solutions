/**
 * 使用队列实现栈
 * 题目地址：https://leetcode.com/problems/implement-stack-using-queues/
 * 类似题目：Implement Queue using Stacks
**/
class MyStack {
    // Push element x onto stack.
    Queue<Integer> queue = new LinkedList<>();
    
    public void push(int x) {
        queue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int size = queue.size();
        for(int i = 1; i < size; i++) {
            queue.add(queue.remove());  //从队头移去再重新队尾插入，注意留最后一个不要加入
        }
        queue.remove();
    }

    // Get the top element.
    public int top() {
        int size = queue.size();
        for(int i = 1; i < size; i++) {
            queue.add(queue.remove());
        }
        int top = queue.remove();
        queue.add(top);
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}