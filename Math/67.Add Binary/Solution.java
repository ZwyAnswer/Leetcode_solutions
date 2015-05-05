public class Solution {
	/**
		实现二进制加法，按照正常的加法进位（逢2进位）规则进行计算。
		从右至左遍历数字，可以参照Plus One的十进制加法。
		runtime:329 ms
	**/
    public String addBinary(String a, String b) {
        if(a == null || a.isEmpty()) return b;
        if(b == null || b.isEmpty()) return a;
        
        int n = Math.max(a.length(), b.length());  
        int[] add = new int[n+1];  //结果数组，至多比a,b中最长的多进一位
        
        for(int i=0; i <n; i++) {
			/**
				分情况做加法：a,b均能取到数字位，a更长时，则只取的到a的数字位。b更长时同理。
				注意结果数组的保存，是先存低位结果。即与取a,b的遍历方向相反。
			**/
            int aIndex = a.length()-1-i, bIndex = b.length()-1-i;  //从低位向高位遍历a,b
            if( aIndex >= 0 && bIndex >= 0 ) {
                add[i] += Character.getNumericValue(a.charAt(aIndex)) + Character.getNumericValue(b.charAt(bIndex));
            } else if( aIndex >= 0 && bIndex < 0) {
                add[i] += Character.getNumericValue(a.charAt(aIndex));
            } else if( aIndex < 0 && bIndex >= 0) {
                add[i] += Character.getNumericValue(b.charAt(bIndex));
            } 
            add[i+1] += add[i] / 2;  //2进制进位
            add[i] %= 2;
        }
        
        StringBuilder result = new StringBuilder();  
        for(int j = 0; j < n; j++ ) {
            result.append(add[j]);  //把int的结果数组转为可变字符串
        }
        
        if( add[n] == 1) {
            result.append(1);  //若结果长度超过a,b的最长值，则最高位一定为1。
        } 
        return result.reverse().toString();  //把可变字符串反转，正好是高位在前，低位在后的正常数字顺序。
    }
	
	/**
		使用异或方法来做二进制运算，设a,b的第i位分别为ai,bi，i位的进位为carry
		ai ^ bi ^ carry 的结果正好符合二进制加法的规则
		runtime: 311 ms (两个方法的时间复杂度均为O(n),n为max(a.length(),b.length())
	**/
	public String addBinary2(String a, String b) {
        if(a == null || a.isEmpty()) return b;
        if(b == null || b.isEmpty()) return a;
        
        int i = a.length() - 1;  //依然是先取二进制的低有效位，即从右向左遍历，这样符合通常的计算习惯
        int j = b.length() - 1;
        int result;  
        int carry = 0;
        int numA;
        int numB;
        StringBuilder sb = new StringBuilder();
        
		/**
			只要能取到a，b的有效位则继续遍历计算
			carry = 1的循环条件，实际上是针对取不到 a,b有效位时，依然有进位的情况，此时结果最高位为1。
		**/
        while( i >= 0 || j >= 0 || carry == 1) {  
            numA = ( i >= 0) ? Character.getNumericValue(a.charAt(i--)) : 0;  //为了统一异或计算式，如果取不到a,b的有效位则补零
            numB = ( j >= 0) ? Character.getNumericValue(b.charAt(j--)) : 0;
            result = numA ^ numB ^ carry;
            carry = ( numA + numB + carry >= 2) ? 1 : 0;  //更新进位
            sb.append(result);
        }
        return sb.reverse().toString();
    }
}