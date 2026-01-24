package algorithm.week3;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertInterval {
//    issue 57
    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean isAdded = false;
        ArrayList<int[]> temp = new ArrayList<>();
        if (intervals.length == 0) {
            return new int[][] {{newInterval[0], newInterval[1]}};
        }
        for (int[] interval : intervals) {

            if (isAdded || (interval[0] < newInterval[0] && interval[1] < newInterval[0])) {
                temp.add(interval);
                continue;
            }

            if (interval[0] > newInterval[0] && newInterval[1] < interval[0]) {
                temp.add(newInterval);
                temp.add(interval);

                isAdded = true;
                continue;
            }
//            newInterval = new int[]{Math.min(interval[0], newInterval[0]), Math.max(interval[1], newInterval[1])};
            newInterval[0] = Math.min(interval[0], newInterval[0]);
            newInterval[1] = Math.max(interval[1], newInterval[1]);
        }

        if (!isAdded) {
            temp.add(newInterval);
        }

        int[][] result = new int[temp.size()][2];
        for (int i = 0; i < temp.size() ; i++) {
            result[i] = temp.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        int[][] result = insertInterval.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(result));
    }
}
