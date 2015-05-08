public class Solution {
    
	//键盘字符数组，相当于number->letter 的字典map。数组下标为number
    private static final String[] letters = {
        "",
        "",    //注意必须添加前两个0，1对应的空字符串，否则会下标越界
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    
	/**
		迭代遍历搜索树
	**/
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String> ();
        if(digits.length() == 0) return result;
        result.add("");  //必须加上空字符串开始，否则无法做字符串拼接。即空字符串为搜索树的根。
		/**
			依次遍历输入数字，以DFS的策略遍历搜索树
			搜索树每一层依次对应输入的数字，树的分支树为数字对应的字母数。
		**/
        for( char d : digits.toCharArray()) {
            String letter = letters[d - '0'];  //获取number对应的letter
            if(letter.length() == 0) continue;  //如果是0,1对应的空字符串，则跳过。
            List<String> tmp = new ArrayList<String> ();  
            for( char l : letter.toCharArray()) {  //遍历每个letter的分支
                for( String s: result)	//取当前阶段之前的有效letter
                    tmp.add(s+l);  //在之前基础上，加上当前分支对应的letter
            }
            result = tmp;  //把当前阶段的结果，赋值给最终结果保存。
        }
        return result;
    }
}