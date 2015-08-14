/**
 * 求给定数组的排列(非全排列，每个位置的数不能重复）
 * 题目地址：https://leetcode.com/problems/permutations/
 * 类似题目：Permutations II，Next Permutation，Permutation Sequence
**/
public class Solution {
	/**
	 *	迭代构建结果，基于依次插入数字的方法。
	 *	Runtime: 310 ms
	**/
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<> ();  //因为要频繁插入元素，故使用链表
        result.add(new ArrayList<Integer> ());  //基于空列表进行插入
        
        for( int i = 0; i < nums.length; i++) {
            int size = result.size();  //必须提在for循环前进行size初始化，因为要获取之前一次插入的结果数
            for( ; 0 < size; size--) {
                List<Integer> li = result.poll();  //依次获取当前结果集中的列表头
                for( int j = 0; j <= li.size(); j++) {
                    List<Integer> tmp = new ArrayList<> (li);  //注意要重新使用一个列表
                    tmp.add(j, nums[i]);  //在原有长度为n的结果数组基础上，可以在n+1个地方进行插入
                    result.add(tmp);
                }
            }
        }
        return result;
    }
	
	//Runtime: 326 ms
	public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<> ();
        result.add(new ArrayList<Integer> ());
        
        for( int i = 0; i < nums.length; i++) {
            List<List<Integer>> tmpRes = new ArrayList<> ();  //必须用此临时结果，否则会出并发访问的异常
            for( int j = 0; j <= i; j++) { //插第i个数的时候有i+1个地方可以来插入
                for( List<Integer> li : result) {  //取当前结果集中的列表
                    List<Integer> tmp = new ArrayList<> (li);
                    tmp.add(j, nums[i]);
                    tmpRes.add(tmp);
                }
            }
            result = tmpRes;  //插下一个数字之前，把临时结果保存给最终结果
        }
        return result;
    }
}