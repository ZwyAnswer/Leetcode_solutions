/**
 * 给一整型数组，要求组合成一个结果最大的数
 * 题目地址：https://leetcode.com/problems/largest-number/
**/
public class Solution {
    /**
     * 关键在于实现比较器，再排序。
     * 排序中利用到比较器的题目还有CTCI 11.2
     **/
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        StringBuilder result = new StringBuilder();
        List<String> slist = new ArrayList<>(nums.length);
        StringComparator comp = new StringComparator();
        
        for(int i : nums)
            slist.add(String.valueOf(i));  //把整型数组转换为字符串数组
        Collections.sort(slist, comp);  //排序
        for(String s : slist)
            result.append(s);
        
        if(result.length() > 0 && result.charAt(0) == '0') return "0";  //避免[0,0]返回“00”
        return result.toString();
    }
    
    //实现比较器，即[3,30,34,5,9]排列后成[9,5,34,3,30]
    class StringComparator implements Comparator<String> {
        public int compare(String str1, String str2) {
            String s1 = str1 + str2;
            String s2 = str2 + str1;
            return s2.compareTo(s1);  //注意是s2比s1,这样就是sort后就是降序排列
        }
    }
}