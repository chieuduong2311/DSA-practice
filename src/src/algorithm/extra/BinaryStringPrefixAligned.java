package algorithm.extra;

import java.util.HashMap;
import java.util.Map;

public class BinaryStringPrefixAligned {
//    issue 1375
    public int numTimesAllBlue(int[] flips) {
        boolean[] visited = new boolean[flips.length];
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < flips.length; i++) {
            idxMap.put(flips[i], i);
        }
        int r = 0, count = 0;
        for (int i = 0; i < flips.length ; i++) {
            visited[idxMap.get(i+1)] = true;
            while (r <= i) {
                if (!visited[r]) {
                    break;
                }
                if (r == i) {
                    count++;
                    break;
                }
                r++;
            }
        }
        return count;
    }

    public int numTimesAllBlue2(int[] flips) {
        int max = 0, result = 0;
        for (int i = 0; i < flips.length ; i++) {
            max = Math.max(max, flips[i]);
            if (max == i) {
                result++;
            }
        }
        return result;
    }
}
