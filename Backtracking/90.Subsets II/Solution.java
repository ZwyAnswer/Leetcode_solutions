/**
	相较Subset题，允许输入数组中有重复，那么只需在添加可行解的时候，进行判断即可
	题目地址： https://leetcode.com/problems/subsets-ii/
**/
public class Solution {
	/**
		迭代版 
		Runtime:380 ms
	**/
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        result.add(new ArrayList<Integer> ());
        
        for( int i = 0; i < nums.length; i++) {
            int size = result.size();
            for( int j = 0; j < size; j++) {
                List<Integer> tmp = new ArrayList<> ();
                tmp.addAll(result.get(j));
                tmp.add(nums[i]);
                if(!result.contains(tmp))  result.add(tmp);  //不重复，则加入
            }
        }
        return result;
    }
	
	/**
		递归版
		Runtime: 543 ms
	**/
	public List<List<Integer>> subsetsWithDup2(int[] nums) {
        if( nums == null) return null;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        result = dfs(nums, nums.length - 1);
        result.add(new ArrayList<Integer> ());
        return result;
    }
    
    private List<List<Integer>> dfs(int[] nums, int index) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        if( index < 0) return result;
        List<List<Integer>> sub = dfs(nums, index-1);  
        result.addAll(sub);  
        for( int i = 0; i < sub.size(); i++ ) {
            List<Integer> tmp = new ArrayList<> ();
            tmp.addAll(sub.get(i));  
            tmp.add(nums[index]);
            if(!result.contains(tmp)) result.add(tmp);  //不重复，则加入
        }
        List<Integer> last = Arrays.asList(nums[index]);
        if(!result.contains(last)) result.add(last);
        return result;
    }
}