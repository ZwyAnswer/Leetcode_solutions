/**
 * 给定整型数组，除了一个只出现一次的数其他数均出现3次，找出该数
 * 题目地址：https://leetcode.com/problems/single-number-ii/
 * 可以利用位操作，也可利用Map.
**/
public class Solution {
    public int singleNumber(int[] A) {
        Map<Integer,Integer> map = new HashMap();  //利用Map
        for(int x : A ){
            int times = map.containsKey(x) ? map.get(x) : 0;
            map.put(x,times + 1);
        }
        for(int x: A) {
            if(map.get(x) == 1){
                return x;
            }
        }
        throw new IllegalArgumentException("No such element");
    }
}