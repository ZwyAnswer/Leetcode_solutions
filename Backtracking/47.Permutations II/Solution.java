/**
	在Permutations的基础上，允许输入数组中有重复数字
	题目地址：https://leetcode.com/problems/permutations-ii/
**/
public class Solution {
	/**
		如果对比SubSet I和SubSet II,仅在ArrayList进行add的时候，判断是否含有，会导致TLE
		那么换个思路，先用不允许重复的HashSet来做结果集合，最后返回把其转换为ArrayList。
	**/
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<> ();  //Set进行add操作的时候会判断是否已有重复元素
        Arrays.sort(nums);
        result.add(new ArrayList<Integer> ());
        
        for( int i : nums) {
            Set<List<Integer>> tmpResult = new HashSet<> ();
            for( List<Integer> li: result) {
                for( int j = 0; j <= li.size(); j++) {
                    List<Integer> tmp = new ArrayList<> (li);
                    tmp.add(j,i);
                    tmpResult.add(tmp); //若相较I中此处判断Contains，会导致TLE
                }
            }
            result = tmpResult;
        }
        return new ArrayList<List<Integer>> (result);
    }
}