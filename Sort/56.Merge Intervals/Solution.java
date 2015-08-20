/**
 * 合并给定的范围中重叠的部分，范围的数据结构定义如下
 * 题目地址：https://leetcode.com/problems/merge-intervals/
 * 类似题目：Insert Intervals
 *
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<>();
        if(intervals == null || intervals.size() == 0) return result;
        
        class intervalComparator implements Comparator<Interval> {  //实现比较器
            public int compare(Interval i1, Interval i2) {
                return  Integer.compare(i1.start, i2.start);
            }
        }
        Collections.sort(intervals, new intervalComparator()); //对范围的start排序
        int start = intervals.get(0).start, end = intervals.get(0).end;
        for(Interval interval : intervals) {
            if(interval.start <= end) end = Math.max(end, interval.end);  //重叠则只需更新end
            else {
                result.add(new Interval(start, end));  //加入前一个范围并更新start，end
                start = interval.start;
                end = interval.end;
            }
        }
        result.add(new Interval(start, end));  //加入最后一个范围
        return result;
    }
}