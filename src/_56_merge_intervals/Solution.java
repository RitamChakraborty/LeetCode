package _56_merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Two Pointers: Sort the intervals with the first index. Keep a track of the previous end and compare it with
 * the current start
 * Time: O(N * LogN)
 * Space: O(N)
 */
class Solution {
    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<Interval> list = new ArrayList<>();
        List<Interval> result = new ArrayList<>();

        for (int[] i : intervals) {
            list.add(new Interval(i[0], i[1]));
        }

        Interval previousInterval = list.getFirst();
        int previousEnd = previousInterval.end;

        for (int i = 1; i < intervals.length; i++) {
            Interval currentInterval = list.get(i);

            if (currentInterval.start <= previousEnd) {
                previousEnd = Integer.max(previousEnd, currentInterval.end);
                previousInterval.end = previousEnd;
            } else {
                result.add(previousInterval);
                previousInterval = currentInterval;
                previousEnd = previousInterval.end;
            }
        }

        result.add(previousInterval);

        int[][] resultArr = new int[result.size()][2];

        for (int i = 0; i < result.size(); i++) {
            resultArr[i][0] = result.get(i).start;
            resultArr[i][1] = result.get(i).end;
        }

        return resultArr;
    }
}