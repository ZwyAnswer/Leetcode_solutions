/**
 * 找到第一个字符包含第二个字符的最小窗口
 * 题目地址：https://leetcode.com/problems/minimum-window-substring/
 * 类似题目：Sliding Window Maximum 
**/
public class Solution {
     public String minWindow(String s, String t) {
        if (s.length()==0 || t.length()==0 || s.length() < t.length()) return "";
        int left = t.length(), start = -1, end = s.length();
        Deque<Integer> queue= new LinkedList<>();
        Map<Character,Integer> map= new HashMap<>();

        for (int i = 0; i < t.length(); i++){
            char c= t.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c)+1 : 1);
        }

        for (int i = 0; i < s.length(); i++){
            char c= s.charAt(i);
            if (!map.containsKey(c)) continue;

            int n = map.get(c);
            map.put(c,n-1);
            queue.add(i);
            if (n>0) left--;

            char head = s.charAt(queue.peek());
            while(map.get(head) <0){
                queue.poll();
                map.put(head, map.get(head)+1);
                head = s.charAt(queue.peek());
            }
            
            if (left==0){
                int newLength = queue.peekLast()-queue.peek()+1;
                if (newLength < end-start) {
                    start = queue.peek();
                    end = queue.peekLast()+1;
                } 
            }
        }
        if (left == 0)  return s.substring(start,end);
        else return "";
    }
}