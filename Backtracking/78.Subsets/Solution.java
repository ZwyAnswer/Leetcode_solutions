/**
	找出给定整型数组(所有元素不同）对应的子集合，要求子集合不重复，且子集合的元素顺序为升序
	找子集合，属于排列组合型的搜索问题。
	题目地址：https://leetcode.com/problems/subsets/
**/
public class Solution {
	/**
		迭代的方法，依次计算出子集合
	**/
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());  //注意要添加一个空子集
        Arrays.sort(nums);   //先对原数组排序，这样只要取元素的时候注意顺序，即可保证元素升序
		/**
			从数组前到后遍历
			再循环遍历当前解集合，把当前数字添加到子集合后
		**/
        for(int i = 0; i < nums.length; i++){  
            int size = result.size();  //注意必须先设定这个变量。如果直接写在循环的条件判断里，会因每次循环size都增加，导致循环无法结束。
            for(int j = 0; j < size; j++){
                List<Integer> tmp = new ArrayList<>();
                tmp.addAll(result.get(j));
                tmp.add(nums[i]);  //注意当前数字比当前解集合中数字都大，所以后添加以保证升序
                result.add(tmp);
            }
        }
        return result;
    }
	
	/**
		递归的方法，递推关系为：
		在第n-1的基础上，把第n个数依次添加到n-1的后面构成n-1个新的子集合，并单独添加第n个数的子集合。
	**/
	public List<List<Integer>> subsets2(int[] nums) {
        if( nums == null) return null;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        result = dfs(nums, nums.length - 1);
        result.add(new ArrayList<Integer> ());
        return result;
    }
    
	/**
		递归函数，index参数的含义是，当前递归到Nums数组的下标。
	**/
    private List<List<Integer>> dfs(int[] nums, int index) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        if( index < 0) return result;
        List<List<Integer>> sub = dfs(nums, index-1);  //前index-1个数的结果集
        result.addAll(sub);  
		/**
			在index -1的结果集添加到结果中后，扩展到index的结果集
			依次取index -1的子集合，在其后添加index指向的那个数
		**/
        for( int i = 0; i < sub.size(); i++ ) {
            List<Integer> tmp = new ArrayList<> ();
            tmp.addAll(sub.get(i));  
            tmp.add(nums[index]);
            result.add(tmp);
        }
        result.add(Arrays.asList(nums[index]));  //单独添加index所指数的子集合
        return result;
    }
	
}