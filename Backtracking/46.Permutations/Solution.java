/**
	求给定数的排列(非全排列，每个位置的数不能重复）
	题目地址：
**/
public class Solution {
	/**
		迭代方法
		Runtime: 310 ms
	**/
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<> ();  
        result.add(new ArrayList<Integer> ());
        
        for( int i = 0; i < nums.length; i++) {
            int size = result.size();
            for( ; 0 < size; size--) {
                List<Integer> li = result.poll();  //依次获取当前结果集中的列表
                for( int j = 0; j <= li.size(); j++) {
                    List<Integer> tmp = new ArrayList<> (li);
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
            for( int j = 0; j <= i; j++) {
                for( List<Integer> li : result) {
                    List<Integer> tmp = new ArrayList<> (li);
                    tmp.add(j, nums[i]);
                    tmpRes.add(tmp);
                }
            }
            result = tmpRes;
        }
        return result;
    }
}