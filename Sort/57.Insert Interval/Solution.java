/**
 * 给定已排序的范围和带插入的范围，插入范围并做适当合并
 * 题目地址：https://leetcode.com/problems/insert-interval/
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    //使用了额外空间，依次处理各个范围
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();
        int i = 0, n = intervals.size();
        while(i < n && intervals.get(i).end < newInterval.start) result.add(intervals.get(i++));  //不重合，直接加入
        while(i < n && intervals.get(i).start <= newInterval.end) {  //处理（合并）新插入的重合部分
            newInterval = new Interval(
                Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
            i++;
        }
        result.add(newInterval);  //插入合并后的范围
        while(i < n ) result.add(intervals.get(i++));  //剩余部分
        return result;
    }

    //在原链表上处理，只需处理插入合并部分，其余跳过，空间复杂度O(n)
    public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        int i=0;
        while(i<intervals.size() && intervals.get(i).end<newInterval.start) i++;
        while(i<intervals.size() && intervals.get(i).start<=newInterval.end){
            newInterval = new Interval(Math.min(intervals.get(i).start,newInterval.start), Math.max(intervals.get(i).end,newInterval.end));
            intervals.remove(i);
        }
        intervals.add(i,newInterval);
        return intervals;
    }
}