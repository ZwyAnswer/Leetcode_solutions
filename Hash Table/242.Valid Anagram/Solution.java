/**
 * 判断两个数是否是变位词（由相同的单词组成）
 * 可以基于Sort也可以基于HashTable，时间复杂度不同
 * 题目地址：https://leetcode.com/problems/valid-anagram/
**/
public class Solution {
	//基于Sort
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        return sort(s).equals(sort(t));
    }
    
    public String sort(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    //基于HashTable（两个字符串的字符出现次数相同）
    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] letters = new int[256];
        char[] cs = s.toCharArray();
        for(char c : cs) letters[c]++;
        
        for(char c : t.toCharArray()) {
            if(--letters[c] < 0) return false;
        }
        return true;
    }
}