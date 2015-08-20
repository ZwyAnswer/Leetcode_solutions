/**
 * 给定一字符串由单词（大小写均可）和空格组成，返回最后一个单词的长度
 * 题目地址：https://leetcode.com/problems/length-of-last-word/
**/
public class Solution {
	/**
	 * 方法1：直接利用JDK的String API
	 * Runtime: 221 ms
	**/
    public int lengthOfLastWord(String s) {
        String ts = s.trim();  //去除原字符串的首尾空白符
        if( ts.length() == 0) return 0;		
        int index = ts.lastIndexOf(' ');	//找到最后一个空白符的索引
		/**
		 * 最后一个单词的首位字符索引应该是最后一个空白符的下一个字符，即index+1
		 * 最后一个单词的末尾字符索引则是字符串的长度减一，即ts.length() - 1
		 * 那么最后一个单词的长度则为 (ts.length() - 1) - (index + 1) + 1
		**/
        int len = ts.length() - index - 1;
        return len;
    }
	
	/**
	* 方法2：把字符串转化为字符数组进行遍历
	* Runtime: 228 ms
	**/
	public int lengthOfLastWord2(String s) {
        if(s == null) return 0;
        char[] c = s.toCharArray();  //字符串转化为一个新的字符数组
		/**
		 * 找到最后一个单词的最后一个字符的索引j，即相当于去除末尾空白后的最后一个字符。
		 * 此处注意特殊情形，若是一个全由空字符构成的字符串，如'  '，则此时j = -1，应该返回0。
		**/
        int j = c.length - 1;  
        while( j >= 0 && c[j] == ' ') j--;
        if( j < 0) return 0;
        /**
		 * 找到最后一个单词的前一个空白符的索引i，则最后一个单词的长度，即为j - i。
		 * 同样注意特殊情形，若最后一个单词前没有空白字符，如'a',则此时i = -1, 依然可以用j - i计算。
		**/
        int i = j;
        while( i >= 0 && c[i] != ' ') i--;
        return j - i;
    }
}

