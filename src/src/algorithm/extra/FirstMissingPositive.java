package algorithm.extra;

import java.util.HashSet;

public class FirstMissingPositive {
//    issue 41
    public static int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length ; i++) {
            set.add(nums[i]);
        }
        if (!set.contains(1)) {
            return 1;
        }

        int result = Integer.MAX_VALUE;
        for (Integer integer : set){
            if (integer + 1 <= 0) {
                continue;
            }
            if (set.contains(integer + 1)) {
                continue;
            }
            result = Math.min(result, integer + 1);
        }

        return result;
    }
}
