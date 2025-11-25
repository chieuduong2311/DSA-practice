package algorithm.week4;

public class ProductOfArrayExceptSelf {
//    issue 238
    public int[] productExceptSelf(int[] nums) {
        int[] answers = new int[nums.length];
        answers[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            answers[i] = nums[i-1] * answers[i-1];
        }

        int t = 1;
        for (int j = nums.length - 2; j >= 0; j--) {
            t = t * nums[j+1];
            answers[j] = answers[j] * t;
        }

        return answers;
    }
}
