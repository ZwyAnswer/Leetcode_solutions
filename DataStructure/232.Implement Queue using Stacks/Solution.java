/**
 * 使用2个栈来实现一个队列
 * 题目地址：https://leetcode.com/problems/implement-queue-using-stacks/
**/
class MyQueue {
    // Push element x to the back of queue.
    Stack<Integer> stack1 = new Stack<>(), stack2 = new Stack<>();
    
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.（关键）
    public void pop() {
        int size = stack1.size();
        for(int i = 1; i < size; i++) {
            stack2.push(stack1.pop());   //使用第二个栈来临时缓存
        }
        stack1.pop();
        for(int i = 1; i < size; i++) {
            stack1.push(stack2.pop());
        }
    }

    // Get the front element.
    public int peek() {
        int size = stack1.size();
        for(int i = 1; i < size; i++) {
            stack2.push(stack1.pop());
        }
        int front = stack1.peek();
        for(int i = 1; i < size; i++) {
            stack1.push(stack2.pop());
        }
        return front;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.empty();
    }
}