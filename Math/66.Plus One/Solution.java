/**
 * 给一个非负整数，用数组表示。返回数组加一的结果
 * 题目地址：https://leetcode.com/problems/plus-one/
 * 类似题目：Multiply Strings，Add Binary
**/
public class Solution {
	/**
	 *	首先，传入的是int数组，存储是高有效位存在数组低位索引，即12345存成{1,2,3,4,5}
	 *	考虑到如果是全9的数加1会多出一位，那么必须请求一个新数组来作为返回结果。
	 *	从个位依次向前遍历，注意进位。
	**/
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int result[] = new int[len + 1];  //结果数组，长度最多会比原数组多一位。
        digits[len - 1] += 1;  //在原数组基础上加1，开始遍历
        for(int i = len - 1; i >=0; i--) {
            result[i+1] += digits[i];   //把原数组每一位copy到新数组，注意要叠加，而不是赋值
            result[i] += result[i+1] / 10;   //进位处理
            result[i+1] %= 10;  //
        }
        if(result[0] == 1) return result;   //999...的情形，新数组的0索引处为进位1。
        else return Arrays.copyOfRange(result,1,len+1);  //新数组的0位没有进位。返回除去result首位的数组副本
    }


    public int[] plusOne2(int[] digits) {
        int len = digits.length;
        int result[] = new int[len + 1];
        digits[len - 1] += 1;
        int carry = 0;
        for(int i = len - 1; i >=0; i--) {  //定义carry变量，更直观
            result[i+1] = digits[i] + carry;
            carry = result[i+1] / 10;
            result[i+1] %= 10;
        }
        if(carry == 1) {
            result[0] = carry;
            return result;
        }
        else return Arrays.copyOfRange(result,1,len+1);
    }

	
	/**
	 *	如果传入参数是Integer的链表，则不仅可以在原处修改，还可以在原处插入多出的进位
	**/
	public void plusOne(List<Integer> digits) {
		for( int i = digits.size() - 1; i >=0; i--) {
			int digit = digits.get(i);
			if(digit == 9) {    
				digits.set(i,0);   //若遇到数字是9，则此为改为0，
				//digits.set(i-1,digits.get(i-1)+1);  此处不必处理进位，进位和加1处理都在else中
			} else {
				digits.set(i,digit+1);  //若此位数字小于9，则直接加1返回(直接加1或是进位加1)
				return; //注意，此时返回  
			}	
		}
		digits.add(0);   //处理全9的特殊情形
		digits.set(0,1);
	}	
}