public class Solution {
	/**
		查找给定字符串对应的有效ip地址列表，属于搜索问题。
		可以使用DFS为策略来回溯遍历搜索树
	**/
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        DFS(s, 0, 0, result, "");
        return result;
    }
    
	/**
		使用DFS来递归回溯，参数中index为当前索引，part为当前ip有效部分数。tmp为暂时的一个ip
	**/
    private void DFS(String s, int index, int part, List<String> result, String tmp) {
        if( part > 4) return;
        if( part == 4 && index == s.length()) result.add(tmp);  //分为四部分且索引到底时，tmp为一个有效解
        for(int i = 1; i <=3; i++) {  //i为有效分割点，
            if(index + i > s.length()) break;
            String s1 = s.substring(index,index+i);  //即点分十进制ip地址两个.之间的数
            if(!isValid(s1)) continue;  //如果是无效ip部分，则跳过到下一次循环。
            s1 += (part == 3 ? "" : ".");  //如果是最后一部分，则结尾不需要加"."
            DFS(s, index+i, part+1, result, tmp+s1);  //下一次递归以index+i处开始
        }
    }
    
	/**
		判断给定字符串是否是有效ip地址的一部分：长度在1~3，大小范围0~255。
		以0开头的有效ip部分只能为0,即01,001等这种不是有效的ip部分。
	**/
    private boolean isValid(String s) {
        if( s.length() < 1 || s.length() > 3 || Integer.parseInt(s) > 255 || (s.charAt(0) == '0' && s.length() > 1))
            return false;
        return true;
    }
	
	/**
		迭代搜索,三个循环依次遍历有效分割位
	**/
	 public List<String> restoreIpAddresses2(String s) {
        List<String> result = new ArrayList<String>();
        int len = s.length();
		/**
			i,j,k为3个分割位，把s分割为4部分的点分十进制ip
			把输入字符串分为[0,i),[i,j),[j,k)[k,len)
		**/
        for(int i = 1; i <= 3 && i < len-2; i++) {
            for(int j = i+1; j <= i+3 && j < len-1; j++) {
                for(int k = j+1; k <= j+3 && k < len; k++) {
                    String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        result.add(s1 + '.' + s2 + '.' + s3 + '.' + s4);
                    }
                }
            }
        }
        return result;
    }
}