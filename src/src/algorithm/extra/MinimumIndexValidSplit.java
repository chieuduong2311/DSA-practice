package algorithm.extra;

import java.util.ArrayList;
import java.util.List;

public class MinimumIndexValidSplit {
//    issu 2780
    public int minimumIndex(List<Integer> nums) {
        int element = nums.get(0);
        int count = 1;

        for (int i = 1; i < nums.size() ; i++) {
            if (nums.get(i) == element) {
                count++;
                continue;
            }
            if (count > 0) {
                count--;
            } else {
                element = nums.get(i);
                count = 1;
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < nums.size() ; i++) {
            if (nums.get(i) == element) {
                arr.add(i);
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            int remaining = arr.size() - i - 1;
            if ((i + 1 > (arr.get(i) + 1)/2) && (remaining > (nums.size() - arr.get(i) - 1)/2)) {
                return arr.get(i);
            }
        }
        return -1;
    }
}
