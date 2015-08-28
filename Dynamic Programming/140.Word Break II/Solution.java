/**
 * 依旧给定字符串和词字典，找出所有字符串可以由字典词组成的组合
 * 题目地址：https://leetcode.com/problems/word-break-ii/
**/
public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        for(int j = s.length() - 1; j >= 0; j--){
            if(dict.contains(s.substring(j))) break;
            else {
                if(j == 0)
                return result;
            }
        }
        for(int i = 1; i < s.length(); i++) {
            if(dict.contains(s.substring(0,i))) {
                List<String> strs = wordBreak(s.substring(i+1,s.length()),dict);
                if(strs.size() != 0) {
                    for(Iterator<String> it = strs.iterator(); it.hasNext(); )
                        result.add(s.substring(0,i)+" "+it.next());
                }
            }
        }
        if(dict.contains(s)) result.add(s);
        return result;
    }
}