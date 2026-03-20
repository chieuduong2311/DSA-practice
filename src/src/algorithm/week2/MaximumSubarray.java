package algorithm.week2;

public class MaximumSubarray {
//    issue 53
    public int maxSubArray(int[] nums) {
        int globalTotal = nums[0];
        int total = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (total + nums[i] < nums[i]) {
                total = nums[i];
            } else {
                total = total + nums[i];
            }
            if (globalTotal < total) {
                globalTotal = total;
            }
        }

        return globalTotal;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        var m = new MaximumSubarray();
        System.out.println(m.maxSubArray(nums));
    }
}
