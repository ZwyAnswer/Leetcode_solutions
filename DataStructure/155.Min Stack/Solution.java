/**
 * 设计一个除普通栈操作之外还支持取得最小值的栈
 * 题目地址：https://leetcode.com/problems/min-stack/
 * 类似题目：Sliding Window Maximum
**/
class MinStack {
    
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();  //使用一个存最小值的栈来保存当前最小
    
    public void push(int x) {
        stack.push(x);
        if(minStack.empty() || x <= minStack.peek()){  //注意更新最小值栈
            minStack.push(x);
        }
    }

    public void pop() {
        if(stack.pop().equals(minStack.peek())) {  //如果弹出的是当前最小值，则也需更新最小值栈
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
