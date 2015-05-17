/**
	找出给出String数组的所有可以组成anagram的词
	关于如何判断两个词是否是anagram，可以参考CrackTheCodingInterview的Question1.3
	题目地址：https://leetcode.com/problems/anagrams/
**/
public class Solution {
	/**
		使用sort来判断anagram，
		使用HashMap，key为Sort后的String，value为sort前的String
		这样所有构成anagram的String均对应同一个key
	**/
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<> ();
        if( strs == null || strs.length == 0) return result;
        Map<String, String> map = new HashMap<> ();
        for( String str: strs) {
            char c[] = str.toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            if(map.containsKey(s)) {  //若已有anagram，则加入当前的和已有的
                result.add(str);
                if(map.get(s) != null) {
                    result.add(map.get(s));
                    map.put(s, null);  //已经取了之前的anagram，则更新value，防止反复取
                }
            } else
                map.put(s, str);  //若不存在，则加入HashMap
        }
        return result;
    }
}