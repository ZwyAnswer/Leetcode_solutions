/**
 * 相比于151题，给定字符串的首尾不含空白符，且单词间的分隔符只有一个
 * 题目地址：https://leetcode.com/problems/reverse-words-in-a-string-ii/
**/
public class Solution {
	//利用反转函数，先整体反转，再各个单词依次反转，整个操作in-place
	public void reverseWords(char[] s) {
		reverse(s, 0, s.length);
		for(int i = 0, j = 0; j <= s.length; j++) {
			if(j == s.length || s[j] == ' ') {
				reverse(s, i, j);
				i = j + 1;
			}
		}
	}

	//反转指定范围内的函数
	private void reverse(char[] s, int start, int end) {
		for(int i = 0; i < (end - start) / 2; i++) {
			char temp = s[start+i];
			s[start+i] = s[end-i-1];
			s[end-i-1] = temp;
		}
	}
}