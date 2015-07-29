/**
 * 相比Longest Substring Without Repeating Characters，只允许子串最多含有两种不同字符
 * 可以扩展到子串最多含有k种不同字符
**/
public class Solution {
	/**
	 * 使用数组做map，记录每个字符出现的次数
	 * 添加一个变量，用来记录子串中不同字符的个数
	**/
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int[] count = new int[256];
		int i = 0, distinct = 0, longest = 0;
		for(int j = 0; j < s.length(); j++) {
			if(count[s.charAt(j)] == 0) distinct++；//出现了不同的字符
			count[s.charAt(j)]++;
			while(distinct > 2) {  //不同字符数多于2，则更新i跟相关变量
				count[s.charAt(i)]--;
				i++;
				if(count[s.charAt(i)] == 0) distinct--;  //去掉了一个不同的字符
			}
			longest = Math.max(j-i+1, longest);
		}
		return longest;
	}
}
