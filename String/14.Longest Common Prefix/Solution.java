public class Solution {
	
	/**
		找出给定字符串数组的最长公共前缀
		Brute Force:既然公共前缀每个字符串都有，那干脆取第一个字符串
		再依次用第一个字符串里的字符去对比其他字符串，一旦遇到不匹配的情况，则返回。
		时间复杂度O(nk),n为strs长度，k为字符串的平均长度。Runtime: 300 ms，
	**/
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String first = strs[0];  //首个字符串作为参照
        for(int i = 0; i < first.length(); i++) {  
            for(int j = 1; j < strs.length; j++) {	
			//依次遍历其他字符串的每个字符
                if( strs[j].length() == i || strs[j].charAt(i) != first.charAt(i))
					//一旦遇到其他字符串遍历完或是有不匹配的字符，则立刻返回
                    return first.substring(0,i);  
            }
        }
        return first;  //每个字符串都相同的情形
    }
	
	/**
		这种解法是以String为单位去对比，而前一种解法是以char为单位去对比。
		一旦遇到不匹配的情况，则取参照字符串的子串（每次去掉最后一个字符），然后继续以该子串去匹配。
		但在最坏的情况下,如字符串数组中，只有最后一个字符串不同于其他，但这个方法还是会拿参照字符串去依次比较，
		而前一种解法则会更快的发现不匹配并立即返回，故前一种方法时间复杂度更优。
	**/
	public String longestCommonPrefix2(String[] strs) {
        if( strs.length == 0 ) return "";
        String prefix = strs[0];
        for( int i = 1; i < strs.length; i++ ) {
            while(strs[i].indexOf(prefix) != 0 ) 
				//另一种写法 while(!strs[i].startsWith(prefix)) 
				//发生不匹配的情况，取去掉最后一个字符的子串为当前前缀
                prefix = prefix.substring(0,prefix.length()-1);  
        }
        return prefix;
    }
}