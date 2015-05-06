public class Solution {
	/**
		使用栈来处理输入
		".."代表上一层目录，"."代表本层目录，"/"代表根目录
	**/
    public String simplifyPath(String path) {
        String[] dir = path.split("/");  //把输入以"/"为界分割，注意String数组的首位都含有""
        Deque<String> stack = new ArrayDeque<>();  //用双端队列来进行栈操作
        for (String s : dir) {
            if (s.equals("..") && !stack.isEmpty()) stack.pop();  //遇到上层目录则出栈
            if (s.equals("") || s.equals(".") || s.equals("..")) continue;  //这些情形不做处理，注意判断特殊情形要用equals函数，不能用 ==
            stack.push(s);  //若没有以上特殊情形，则把当前目录压栈。
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append("/" + stack.pollLast());  //读取栈内剩下的有效元素，则应该从栈底（队尾）向栈顶（队头）读。
        }
        return result.length() == 0 ? "/" : result.toString();  //有可能栈内为空，此时应当返回"/"
    }
}