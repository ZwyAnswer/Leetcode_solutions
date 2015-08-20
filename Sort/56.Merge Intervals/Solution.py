# Definition for an interval.
# class Interval:
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution:
    # @param intervals, a list of Interval
    # @return a list of Interval
    def merge(self, intervals):
        if not intervals: return intervals
        intervals.sort(key = lambda x: x.start)
        ans = [intervals[0]]
        for interval in intervals:
            if ans[-1].start <= interval.start <= ans[-1].end:
                if ans[-1].end < interval.end:
                    ans[-1].end = interval.end
            else:
                ans.append(interval)
        return ans