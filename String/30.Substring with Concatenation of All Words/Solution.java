/**
 * 给定一字符串以及一词列表，找到所有词列表单词拼接成的词在字符串中的起始下标
 * 题目地址：https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * 类似题目：Minimum Window Substring
**/
public class Solution {
    public static List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        if (S == null || L == null || L.length == 0) return res;
        int len = L[0].length(); // length of each word

        //HashMap
        Map<String, Integer> map = new HashMap<String, Integer>(); // map for L
        for (String w : L) map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);

        // Two pointer
        for (int i = 0; i <= S.length() - len * L.length; i++) {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for (int j = 0; j < L.length; j++) { // checkc if match
                String str = S.substring(i + j*len, i + j*len + len); // next word
                if (copy.containsKey(str)) { // is in remaining words
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count - 1);
                    
                    if (copy.isEmpty()) { // matches
                        res.add(i);
                        break;
                    }
                } else {
                    break; // not in L
                }
            }
        }
        return res;
    }
}